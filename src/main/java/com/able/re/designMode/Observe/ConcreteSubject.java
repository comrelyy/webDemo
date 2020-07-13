package com.able.re.designMode.Observe;

import com.google.common.collect.Lists;

import javax.jms.Message;
import java.util.List;

/**
 * @Description 具体的注册中心
 * @Created by cairuirui
 * @Date 2020/7/9
 */
public class ConcreteSubject implements Subject {
	private List<Observer> observerList = Lists.newArrayList();
	@Override
	public void registerObserve(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserve(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObserve(Message message) {
		observerList.forEach(observer ->{
			observer.update(message);
		});
	}
}
