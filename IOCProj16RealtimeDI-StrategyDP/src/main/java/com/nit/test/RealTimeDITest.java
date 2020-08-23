package com.nit.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nit.controller.MainController;
import com.nit.vo.StudentVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		BeanFactory factory = null;
		MainController controller = null;
		Scanner sc = null;
		StudentVO vo = null;
		String result = null;
		String sno=null, sname=null, sadd=null, m1=null, m2=null, m3=null;
		factory = new XmlBeanFactory(new ClassPathResource("com/nit/cfgs/ApplicationContext.xml"));
		//get controller class object 
		controller = factory.getBean("controller", MainController.class);
		//read inputs
		sc = new Scanner(System.in);
		System.out.println("Enter Student Number:");
		sno = sc.next();
		System.out.println("Enter Student Name:");
		sname = sc.next();
		System.out.println("Enter Studdent add:");
		sadd = sc.next();
		System.out.println("Enter Student Marks1:");
		m1 = sc.next();
		System.out.println("Enter Student Marks2 :");
		m2 = sc.next();
		System.out.println("Enter Student Marks3:");
		m3 = sc.next();
		//prepare VO class object
		vo = new StudentVO();
		vo.setSno(sno); vo.setSname(sname); vo.setSadd(sadd);
		vo.setM1(m1); vo.setM2(m2);vo.setM3(m3);
		
		//invoke method
		try {
			result = controller.handleStudent(vo);
			System.out.println(result);	
		}catch(Exception e ) {
			e.printStackTrace();
			System.out.println("Student Registration Failed");
			
		}

	}

}
