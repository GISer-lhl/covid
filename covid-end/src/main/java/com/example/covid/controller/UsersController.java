package com.example.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.covid.entity.Users;
import com.example.covid.service.UsersService;
import com.example.covid.utils.RedisUtils;

import cn.hutool.core.util.ObjectUtil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@ResponseBody
	@RequestMapping("/selectAll")
	public List<Users> selectAll(){
		String strJson=(String) redisUtils.get("allUsers");
		if(strJson==null) {
			System.out.println("从数据库取数据");
			List<Users> users=usersService.selectAll();
			if(ObjectUtil.isNotNull(users)) {
				redisUtils.set("allUsers", JSON.toJSONString(users));
				return users;
			}
		}else {
			System.out.println("从redis获取");
			return JSON.parseArray(strJson,Users.class);
		}
		return null;
	}

}

