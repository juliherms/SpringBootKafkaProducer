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

	public User(String login, String name, String email) {
		super();
		this.login = login;
		this.name = name;
		this.email = email;
	}
}
