package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nit.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_QUERY_STUDENT = "INSERT INTO SPRING_LAYERED_STUDENT VALUES(?,?,?,?,?)";
	private DataSource ds;

	public StudentDAOImpl(DataSource ds) {
		System.out.println("StudentDAOImpl:: 1-param constructor");
		this.ds = ds;
	}

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		//get JDBC connection object through injected datasource object
		con = ds.getConnection();
		ps = con.prepareStatement(INSERT_QUERY_STUDENT);
		//set values to query params by gathering fromBO class object
		ps.setInt(1,bo.getSno());
		ps.setString(2, bo.getSname());
		ps.setString(3,bo.getSadd());
		ps.setInt(4, bo.getTotal());
		ps.setFloat(5,bo.getAvg());
		
		//execute precompiled SQL query
		count = ps.executeUpdate();
		//close all jdbc connections 
		ps.close();
		con.close();
		return count;
	}
}
