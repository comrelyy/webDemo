package com.relyy.designpattern.Observe;

import javax.jms.Message;

/**
 * @Description 消息消费者接口
 * @Created by cairuirui
 * @Date 2020/7/9
 */
public interface Observer {

	void update(Message message);
}
