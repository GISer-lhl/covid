package com.example.covid.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.entity.Chinadata;
import com.example.covid.service.ChinadataService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/data")
public class ChinadataController {
	
	@Autowired
	private ChinadataService chinadataService;
	/*
	 * 查询所有的疫情数据
	 * 
	 */
	@ResponseBody
	@RequestMapping("/select")
	public List<Chinadata> selectAll(){
		return chinadataService.selectAllData();
	}
	/*
	   *  根据日期 查询疫情数据
	 * 
	 */
	@ResponseBody
	@RequestMapping("/selectByDate")
	public List<Chinadata> selectByDate(@RequestParam("date") String date){
		return chinadataService.selectByDate(date);
	}
	/*
	   *  根据省份名称 查询疫情数据
	 * 
	 */
	@ResponseBody
	@RequestMapping("/selectByPName")
	public List<Chinadata> selectByPName(@RequestParam("pname") String pname){
		return chinadataService.selectByPName(pname);
	}
	/*
	   *  根据日期和省份名称 查询疫情数据
	 */
	@ResponseBody
	@RequestMapping("/selectByDateAndPName")
	public List<Chinadata> selectByDateAndPName(@RequestParam("date") String date,@RequestParam("pname") String pname){
		List<Chinadata> datas=chinadataService.selectByDateAndPName(date, pname);
		return datas;
	}
	/*
	   *  根据日期 查询确诊数据
	 */
	@ResponseBody
	@RequestMapping("/selectConfirmedNum")
	public Integer selectConfirmedNumCovid(@RequestParam("date") String date) {
		return chinadataService.selectConfirmedNumCovid(date);
	}
	/*
	   *  根据日期查询死亡数据
	 */
	@ResponseBody
	@RequestMapping("/selectDeathsNum")
	public Integer selectDeathsNumCovid(@RequestParam("date") String date) {
		return chinadataService.selectDeathsNumCovid(date);
	}
	/*
	   *  根据日期查询康复人数数据
	 */
	@ResponseBody
	@RequestMapping("/selectRecoveredNum")
	public Integer selectRecoveredNumCovid(@RequestParam("date") String date) {
		return chinadataService.selectRecoveredNumCovid(date);
	}

}

