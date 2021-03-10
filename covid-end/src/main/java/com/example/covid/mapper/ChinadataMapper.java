package com.example.covid.mapper;

import com.example.covid.entity.Chinadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
public interface ChinadataMapper extends BaseMapper<Chinadata> {
	
	List<Chinadata> selectAllData();
	
	List<Chinadata> selectByDate(String date);
	
	List<Chinadata> selectByPName(String pname);
	
	List<Chinadata> selectByDateAndPName(String date,String pname);
	
	Integer selectConfirmedNumCovid(String date);
	
	Integer selectDeathsNumCovid(String date);
	
	Integer selectRecoveredNumCovid(String date);

}
