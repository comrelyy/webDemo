package com.able.re.designMode.Observe;


import javax.jms.Message;

/**
 * @Description 注册中心接口
 * @Created by cairuirui
 * @Date 2020/7/9
 */
public interface Subject {
	void registerObserve(Observer observer);
	void removeObserve(Observer observer);
	void notifyObserve(Message message);
}
