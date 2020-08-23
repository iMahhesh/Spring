package com.nit.service;

public class BankService {
	
	//ptr 
	public float calcSimpleIntrestAmount(float pAmt, float rate, float time){
		System.out.println("BankService.calcSimpleIntrestAmount() Target Method-1");
		return (pAmt*rate*time)/100.0f;
		
		
	}
	//p(1+(r/100)^n -p
	public float calcCompoundInterstAmount(float pAmt, float rate, float time) {
		System.out.println("BankService.calcSimpleIntrestAmount() Target Method-2");
		return (float) ((pAmt*Math.pow((1+rate/100), time)))-pAmt;
		
	}

}
