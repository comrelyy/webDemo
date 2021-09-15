package com.relyy.spring.framework.resourceDemo.bean.beanpostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/4/29
 */
@Slf4j
public class MyBeanPostProcessorTwo implements BeanPostProcessor, Ordered {
	@Override
	public int getOrder() {
		return 2;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("BeanPostProcessor第{}次被调用",getOrder());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
