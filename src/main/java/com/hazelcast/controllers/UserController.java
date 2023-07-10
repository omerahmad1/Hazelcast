package com.hazelcast.controllers;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.entities.User;
import com.hazelcast.map.IMap;
import com.hazelcast.models.GetAllUserResponse;
import com.hazelcast.models.GetUserResponse;
import com.hazelcast.models.UserResponse;
import com.hazelcast.service.UserService;


@RestController
@RequestMapping(path = "/hazel")
public class UserController {
	
		
	@Autowired
	UserService userService;
	
//	@Autowired
//	IMap<String, User> myMap;


	   @PostMapping("/add")
	    public UserResponse addData(@RequestBody User user) {
		   UserResponse response = new UserResponse();
		   userService.addData(user,response);
	        return response;
	    }

	   @GetMapping("/{id}")
	   public GetUserResponse get(@PathVariable String id) {
		   GetUserResponse response = new GetUserResponse();
		   response = userService.getData1(id,response);
		   return response;
	   }
	   

//	    @GetMapping("/entries")
//	    public Map<String, User> getAllEntries() {
//	        return myMap.entrySet().stream()
//	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//	    }

	    @GetMapping("/entries")
	    public GetAllUserResponse getEntries() {
	    	GetAllUserResponse response = new GetAllUserResponse();
	    	response = userService.getAllEntries(response);
	    	return response;
	    }
}

