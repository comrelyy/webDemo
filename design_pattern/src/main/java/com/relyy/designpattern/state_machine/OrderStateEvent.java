package com.relyy.designpattern.state_machine;

/**
 * @Description 订单状态迁移事件
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public interface OrderStateEvent {

	String getEventType();


	String getOrderId();

	/**
	 * 如果订单状态不为空，则代表只有订单是当前状态才进行迁移
	 * @return
	 */
	default String orderState(){
		return null;
	}

	/**
	 * 是否需要创建新订单
	 * @return
	 */
	boolean newCreate();
}
