package com.hazelcast.models;

import java.util.Map;

import com.hazelcast.base.BaseResponse;
import com.hazelcast.entities.User;

public class GetAllUserResponse extends BaseResponse {
	private Map<String, User> user;

	@Override
	public String toString() {
		return "GetAllUserResponse [user=" + user + "]";
	}

	public Map<String, User> getUser() {
		return user;
	}

	public void setUser(Map<String, User> user) {
		this.user = user;
	}

}
