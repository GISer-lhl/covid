package com.example.covid.service;

import com.example.covid.entity.Chinadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
public interface ChinadataService extends IService<Chinadata> {
	
	public List<Chinadata> selectAllData();
	
	public List<Chinadata> selectByDate(String date);
	
	public List<Chinadata> selectByPName(String pname);
	
	public List<Chinadata> selectByDateAndPName(String date,String pname);
	
	public Integer selectConfirmedNumCovid(String date);
	
	public Integer selectDeathsNumCovid(String date);
	
	public Integer selectRecoveredNumCovid(String date);

}
