package com.example.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.utils.RedisUtils;

@RestController
public class RedisController {
	
	@Autowired
	private RedisUtils redisUtils;
	
	@RequestMapping("/redis")
	public String test(String k,String v) {
		redisUtils.set(k, v);
		return (String) redisUtils.get(k);
	}

}
