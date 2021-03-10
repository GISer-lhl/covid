package com.example.covid;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.covid.entity.Users;
import com.example.covid.mapper.UsersMapper;

@SpringBootTest
class CovidApplicationTests {
	
	@Autowired
	private UsersMapper usersMapper;

	@Test
	void contextLoads() {
		List<Users> users=usersMapper.selectList(null);
		users.forEach(System.out::println);
	}

}
