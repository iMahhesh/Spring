package com.nit.service;

import com.nit.bo.StudentBO;
import com.nit.dao.StudentDAO;
import com.nit.dto.StudentDTO;

public class StudentOperationServiceImpl implements StudentOperationService {
	private StudentDAO dao;

	public StudentOperationServiceImpl(StudentDAO dao) {
		System.out.println("StudentOperationServiceImpl :: 1- param consructor");
		this.dao = dao;
	}

	@Override
	public String register(StudentDTO dto) throws Exception {
		int total = 0;
		String result = null;
		float avg = 0.0f;
		int count= 0;
		StudentBO bo = null;
		//write b.logic for total, avg, result
		total = dto.getM1()+dto.getM2()+dto.getM3();
		avg = total/3.0f;
		if(dto.getM1()<35 || dto.getM2()<35 || dto.getM3()<35)
			result = "Fail";
		else
			result = "Pass";
		//Prepare BO class object having persistable data	
		bo = new StudentBO();
		
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//use DAO
		count = dao.insert(bo);
		//Process the result
		if(count==0)
			return "Student Registration Failed";
		else
			return "Student Registration is Succeeded Total :"+total+"Average :"+avg+"result :"+result;
		
	
	}

}
