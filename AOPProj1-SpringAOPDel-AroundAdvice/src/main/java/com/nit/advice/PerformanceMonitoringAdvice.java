package com.nit.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Performance Monitoring Advice(-)");
		long start = 0, end = 0;
		Object retVal = null;
		start = System.currentTimeMillis(); //Pre-logic
		retVal = invocation.proceed();//invokes target class method
		end = System.currentTimeMillis();//Post-logic
		System.out.println( invocation.getMethod().getClass()+"  with args  "+Arrays.toString(invocation.getClass().getAnnotations())+"  taken  "  +(end-start)+ "   MilliSeconds....");
		
		return retVal;
	}

}
