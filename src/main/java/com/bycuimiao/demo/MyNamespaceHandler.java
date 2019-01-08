package com.bycuimiao.demo;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 03 January 2019
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
	}
}
