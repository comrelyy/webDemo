package com.relyy.spring.framework.resourceDemo.AspectJDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@Configuration()
public class AspectLogConfiguration {

    @Bean
    public TargetObject targetObject(){
        return new TargetObject();
    }

    @Bean
    public AspectJLog aspectJLog(){
        return new AspectJLog();
    }
}
