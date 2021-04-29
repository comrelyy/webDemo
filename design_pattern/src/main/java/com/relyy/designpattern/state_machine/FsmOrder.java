package com.relyy.designpattern.state_machine;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface FsmOrder {

	String getOrderId();

	String getOrderState();

	String getBizType();

	String getSceneId();
}
