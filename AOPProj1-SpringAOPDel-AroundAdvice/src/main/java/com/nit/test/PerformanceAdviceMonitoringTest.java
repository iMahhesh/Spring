package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.service.BankService;

public class PerformanceAdviceMonitoringTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService proxy = null;
		//create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		//get bean
		proxy  = ctx.getBean("pfb", BankService.class);
		System.out.println("Proxy class name  ::  "+proxy.getClass()+ "Proxy super class ::    "+proxy.getClass().getSuperclass());
		try {
			//invoke method
			System.out.println(proxy.calcSimpleIntrestAmount(20000, 5, 12));
			System.out.println("---------------------------------------");
			System.out.println(proxy.calcCompoundInterstAmount(10000,10,12));
			}
		    catch(Exception e) {
		    	   e.printStackTrace();
		    }
	((AbstractApplicationContext) ctx).close();
	
	}

}
