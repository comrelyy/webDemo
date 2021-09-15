package com.relyy.spring.framework.resourceDemo.CustomBeanParser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/5/9
 */
public class CustomBeanDefinitionParper extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return Alias.class;
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		String beanName = element.getAttribute("c_name");
		Assert.hasText(beanName,"the 'name' in Alias Tag is mmissing !");
		Assert.isTrue(parserContext.getRegistry().containsBeanDefinition(beanName),"No bean name" + beanName + "exist !");
		String c_alias = element.getAttribute("c_alias");
		if (!StringUtils.isEmpty(c_alias)){
			String[] split = c_alias.replaceAll("\\s+", "").split("[,;]");
			for (String ali : split) {
				parserContext.getRegistry().registerAlias(beanName,ali);
			}
		}

	}
}
