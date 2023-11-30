package com.prueba.spring.security.login.payload.response;

import java.util.Collection;
import java.util.List;

import com.prueba.spring.security.login.models.Phone;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String name;
	private String email;
	private Collection<Phone> phones;
	private List<String> phones2;
	private List<String> roles;

	public UserInfoResponse(Long id, String username, String name, String email, List<Phone> phones2,
			List<String> roles) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.phones = phones2;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public List<String> getPhones2() {
		return phones2;
	}

	public List<String> getRoles() {
		return roles;
	}
}
