package com.hazelcast.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.entities.User;
import com.hazelcast.map.IMap;
import com.hazelcast.models.GetAllUserResponse;
import com.hazelcast.models.GetUserResponse;
import com.hazelcast.models.UserResponse;

@Service
@Configuration
public class UserService {

	private static final String CLUSTER_NAME = "my-cluster";
	@Autowired
	private HazelcastInstance hazelcastInstance;

	@Bean
	public IMap<String, User> myMap() {
		return hazelcastInstance.getMap(CLUSTER_NAME);
	}

	public UserResponse addData(User user, UserResponse response) {
		myMap().put(user.getId(), user);
		response.setCode("200");
		response.setMessage("Success");
		return response;
	}

	public GetUserResponse getData1(String id, GetUserResponse response) {
		User user = new User();
		user = myMap().get(id);
		if (user == null) {

			response.setCode("100");
			response.setMessage("not found");
			return response;
		}
		response.setCode("200");
		response.setMessage("success");
		response.setData(user);
		return response;

	}

	public GetAllUserResponse getAllEntries(GetAllUserResponse response) {
		Map<String, User> user = new HashMap<>();
		user = myMap().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		if (user.isEmpty() ) {
			
			response.setCode("100");
			response.setMessage("Not Found");
			return response;
			

		}else {
			response.setCode("200");
			response.setMessage("Success");
			response.setUser(user);
			return response;
		
	}

}}
