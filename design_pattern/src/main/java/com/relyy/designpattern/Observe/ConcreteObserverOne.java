package com.relyy.designpattern.Observe;

import javax.jms.Message;

/**
 * @Description 具体消费者
 * @Created by cairuirui
 * @Date 2020/7/9
 */
public class ConcreteObserverOne implements Observer {

	@Override
	public void update(Message message) {
		System.out.println("ConcreteObserverOne consumer notify massage:"+message);
	}
}
