package com.bycuimiao.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 03 January 2019
 */
public class UserDemo {
	public static void main(String[] args) {
		ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ct.getBean("testBean");
		System.out.println(user.getUserName());
	}
}
