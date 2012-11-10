package com.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIAL")
public class CredentialsEntity {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private long id;

	@Column(name = "USERNAME", nullable = false,unique = true)
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	public CredentialsEntity() {
		// TODO Auto-generated constructor stub
	}

	public CredentialsEntity(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public long getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(long id) {
		this.id = id;
	}
}
