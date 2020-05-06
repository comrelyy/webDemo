package com.able.re.springResource.bean.beanpostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/4/29
 */
@Slf4j
public class MyBeanFactoryPostProcessorTwo implements BeanFactoryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		log.info("BeanFactoryPostProcessor第{}次被调用",getOrder());
	}

	@Override
	public int getOrder() {
		return 2;
	}
}
