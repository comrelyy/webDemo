package com.able.re.springResource.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-18
 */
@Configuration
@ComponentScan(basePackageClasses={AppleFactoryBean.class})
public class FactoryBeanConfiguration {
}
