package com.example.covid.service;

import com.example.covid.entity.Users;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
public interface UsersService extends IService<Users> {
	
	List<Users> selectAll();

}
