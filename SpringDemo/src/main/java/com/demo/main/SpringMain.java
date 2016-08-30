package com.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.lc.PropertyService;
import com.demo.service.UserService;

public class SpringMain {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		UserService userService = ctx.getBean("userService", UserService.class);

		System.out.println(userService.getUser().getName());
		
		PropertyService propertyService = ctx.getBean("propertyService", PropertyService.class);
		propertyService.printProperty();
	}

}
