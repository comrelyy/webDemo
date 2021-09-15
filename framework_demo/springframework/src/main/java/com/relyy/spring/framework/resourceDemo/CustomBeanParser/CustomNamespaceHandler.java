package com.relyy.spring.framework.resourceDemo.CustomBeanParser;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/5/9
 */
public class CustomNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		this.registerBeanDefinitionParser("alias",new CustomBeanDefinitionParper());
	}
}
