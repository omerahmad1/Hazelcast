package com.hazelcast.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String id;
	private String value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public User(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", value=" + value + "]";
	}
	
	
	


}
