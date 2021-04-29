package com.relyy.designpattern.state_machine;

import lombok.Data;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/4/29
 */
@Data
public class StateContext<C> {

	private OrderStateEvent orderStateEvent;

	private FsmOrder fsmOrder;

	private C context;

	public StateContext(OrderStateEvent orderStateEvent, FsmOrder fsmOrder) {
		this.orderStateEvent = orderStateEvent;
		this.fsmOrder = fsmOrder;
	}
}
