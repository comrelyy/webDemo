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
public class MyBeanFactoryPostProcessorOne implements BeanFactoryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		log.info("BeanFactoryPostProcessor第{}次被调用",getOrder());
		BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("student");
		if (null != bd){
			log.info("student属性值:"+ bd.getPropertyValues().toString());
			MutablePropertyValues pv = bd.getPropertyValues();
			if (pv.contains("name")) {
				log.info("修改dog的name属性值为GUGU");
				pv.addPropertyValue("name","GUGU");
			}
			log.info("修改bean的作用域为prototype\n");
			bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		}
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
