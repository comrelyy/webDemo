package com.relyy.spring.framework.resourceDemo.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-18
 */
@Component
public class AppleFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new AppleBean();
    }

    @Override
    public Class<?> getObjectType() {
        return AppleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
