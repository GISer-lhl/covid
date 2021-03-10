package com.example.covid.service.impl;

import com.example.covid.entity.Users;
import com.example.covid.mapper.UsersMapper;
import com.example.covid.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public List<Users> selectAll() {
//		return usersMapper.selectList(null);
		return usersMapper.selectAllUsers();
	}

}
