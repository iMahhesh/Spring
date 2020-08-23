package com.nit.controller;

import com.nit.dto.StudentDTO;
import com.nit.service.StudentOperationService;
import com.nit.vo.StudentVO;

public class MainController {
	private StudentOperationService service;

	public MainController(StudentOperationService service) {
		System.out.println("MainController :: 1-param constructor");
		this.service = service;
	}
	public String handleStudent(StudentVO vo)throws Exception{
		StudentDTO dto = null;
		String result = null;
		dto = new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use service
		result = service.register(dto);
		return result;
	}
	
}
