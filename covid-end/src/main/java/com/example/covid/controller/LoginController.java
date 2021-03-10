package com.example.covid.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.utils.JwtTokenUtils;

@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private JwtTokenUtils jwtTokenUtils;

	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
		Map<String, Object> map=new HashMap<>();
		map.put("name", username);
		map.put("password", password);
		return jwtTokenUtils.createToken(map);
	}
}
