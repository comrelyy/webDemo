package com.relyy.designpattern.Observe;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/7/9
 */
public class ObserveDemo {

	public static void main(String[] args) throws Exception{
		Subject subject = new ConcreteSubject();
		Observer observerOne = new ConcreteObserverOne();
		Observer observerTwo = new ConcreteObserverTwo();
		subject.registerObserve(observerOne);
		subject.registerObserve(observerTwo);
		ObserverMessge mapMessage = new ObserverMessge();
		mapMessage.setString("msg","ok");
		subject.notifyObserve(mapMessage);
	}
}
