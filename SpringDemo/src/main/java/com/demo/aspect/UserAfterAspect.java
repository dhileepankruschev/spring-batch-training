package com.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;



@Aspect
public class UserAfterAspect {
	
	@AfterReturning(pointcut="execution(* getName())", returning="str")
	public void userAfterAdvice(String str){
		System.out.println("Testing After Returning: " + str);
	}

}
