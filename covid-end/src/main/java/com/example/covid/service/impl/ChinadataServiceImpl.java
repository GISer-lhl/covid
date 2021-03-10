package com.example.covid.service.impl;

import com.example.covid.entity.Chinadata;
import com.example.covid.mapper.ChinadataMapper;
import com.example.covid.service.ChinadataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
@Service
public class ChinadataServiceImpl extends ServiceImpl<ChinadataMapper, Chinadata> implements ChinadataService {

	@Autowired
	private ChinadataMapper chinadataMapper;
	
	@Override
	public List<Chinadata> selectAllData() {
		// TODO Auto-generated method stub
		return chinadataMapper.selectAllData();
	}

	@Override
	public List<Chinadata> selectByDate(String date) {
		// TODO Auto-generated method stub
		return chinadataMapper.selectByDate(date);
	}

	@Override
	public List<Chinadata> selectByPName(String pname) {
		// TODO Auto-generated method stub
		return chinadataMapper.selectByPName(pname);
	}

	@Override
	public List<Chinadata> selectByDateAndPName(String date, String pname) {
		// TODO Auto-generated method stub
		return chinadataMapper.selectByDateAndPName(date, pname);
	}

	@Override
	public Integer selectConfirmedNumCovid(String date) {
		// TODO Auto-generated method stub
		return chinadataMapper.selectConfirmedNumCovid(date);
	}

	@Override
	public Integer selectDeathsNumCovid(String date) {
		// TODO Auto-generated method stub
		return chinadataMapper.selectDeathsNumCovid(date);
	}

	@Override
	public Integer selectRecoveredNumCovid(String date) {
		// TODO Auto-generated method stub
		return chinadataMapper.selectRecoveredNumCovid(date);
	}

}
