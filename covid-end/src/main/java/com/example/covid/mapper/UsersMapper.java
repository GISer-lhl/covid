package com.example.covid.mapper;

import com.example.covid.entity.Users;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
public interface UsersMapper extends BaseMapper<Users> {
	
	List<Users> selectAllUsers();

}
