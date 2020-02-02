package com.jlv.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
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

	/**
	 * Method responsible to send menssage to kafka topic
	 * URL: kafka/publish/{message}
	 * @param message
	 * @return
	 */
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message) {

		//this method is async. I need to get promisse.
		ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(TOPIC,
				new User("juliherms", "Juliherms Vasconcelos", "j.a.vasconcelos@gmail.com"));

		future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {

			@Override
			public void onSuccess(SendResult<String, User> result) {
				System.out.println(
						"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}
		});

		return "Published successfully";
	}

}
