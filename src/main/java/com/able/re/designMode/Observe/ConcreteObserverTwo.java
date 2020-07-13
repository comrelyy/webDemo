package com.able.re.designMode.Observe;

import javax.jms.Message;

/**
 * @Description 具体消费者
 * @Created by cairuirui
 * @Date 2020/7/9
 */
public class ConcreteObserverTwo implements Observer {

	@Override
	public void update(Message message) {
		System.out.println("ConcreteObserverTwo consumer notify massage:"+message);
	}
}
