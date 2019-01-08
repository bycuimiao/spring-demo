package com.bycuimiao.demo;


import org.w3c.dom.Element;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 03 January 2019
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	protected Class getBeanClass(Element element){
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");
		if(StringUtils.hasText(userName)){
			bean.addPropertyValue("userName",userName);
		}
		if(StringUtils.hasText(email)){
			bean.addPropertyValue("email",email);
		}
	}
}
