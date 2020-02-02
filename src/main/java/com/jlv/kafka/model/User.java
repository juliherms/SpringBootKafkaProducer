package com.jlv.kafka.model;

/**
 * this class represents model of user.
 * 
 * @author j.a.vasconcelos
 *
 */
public class User {

	private String login;
	private String name;
	private String email;
	private String message;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User(String login, String name, String email, String message) {
		super();
		this.login = login;
		this.name = name;
		this.email = email;
		this.message = message;
	}
}
