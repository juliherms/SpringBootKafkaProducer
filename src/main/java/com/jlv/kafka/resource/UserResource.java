package com.jlv.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlv.kafka.model.User;

/**
 * this class responsible to send messages to zookeeper about user
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "kafka_Example";

	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message) {

		kafkaTemplate.send(TOPIC, new User("juliherms", "Juliherms Vasconcelos", "j.a.vasconcelos@gmail.com"));

		return "Published successfully";
	}

}
