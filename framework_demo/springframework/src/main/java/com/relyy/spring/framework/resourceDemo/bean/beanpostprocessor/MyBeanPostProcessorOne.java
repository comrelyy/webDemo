package com.relyy.spring.framework.resourceDemo.bean.beanpostprocessor;

import com.able.re.springResource.bean.factorybean.Student;
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
public class MyBeanPostProcessorOne implements BeanPostProcessor, Ordered {
	@Override
	public int getOrder() {
		return 1;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("BeanPostProcessor第{}次被调用",getOrder());
		if (bean instanceof Student){
			((Student) bean).setName("cc");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student){
			((Student) bean).setAge(6);
		}
		return bean;
	}
}
