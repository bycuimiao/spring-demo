package com.bycuimiao.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 24 十二月 2018
 */
public class Hello {
	public static void main(String[] args) {
		ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService helloService = (HelloService)ct.getBean("hello");
		helloService.hello();
	}
}
