package com.hazelcast.models;

import com.hazelcast.base.BaseResponse;
import com.hazelcast.entities.User;


public class GetUserResponse extends BaseResponse {
	
	private User data;

	public User getData() {
		return data;
	}

	public void setData(User user) {
		this.data = user;
	}

	@Override
	public String toString() {
		return "GetUserResponse [data=" + data + "]";
	}

}
