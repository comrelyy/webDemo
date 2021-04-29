package com.relyy.designpattern.state_machine;

import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/4/29
 */
public class DefaultOrderFsmEngine implements OrderFsmEngine {

	@Resource
	private DefaultStateProcessRegistry stateProcessRegistry;

	@Override
	public <T> ServiceResult<T> sendEvent(OrderStateEvent orderStateEvent) throws Exception {
		String orderId = orderStateEvent.getOrderId();
		//通过orderId得到FsmOrder
		//return this.sendEvent(orderStateEvent, smOrder)
		return null;
	}

	@Override
	public <T> ServiceResult<T> sendEvent(OrderStateEvent orderStateEvent, FsmOrder fsmOrder) throws Exception {
		StateContext stateContext = this.getStateContext(orderStateEvent,fsmOrder);
		StateProcessor stateProcessor = this.getStateProcessor(stateContext);
		return stateProcessor.action(stateContext);
	}

	private <T> StateProcessor<T,?> getStateProcessor(StateContext<?> stateContext) {
		OrderStateEvent orderStateEvent = stateContext.getOrderStateEvent();
		FsmOrder fsmOrder = stateContext.getFsmOrder();
		List<AbstractStateProcessor> stateProcessors = stateProcessRegistry.acquireStateProcessor(fsmOrder.getOrderState(),
				orderStateEvent.getEventType(), fsmOrder.getBizType(), fsmOrder.getSceneId());

		if (CollectionUtils.isNotEmpty(stateProcessors)) {
			return stateProcessors.get(0);
		}
		return null;
	}

	private StateContext getStateContext(OrderStateEvent orderStateEvent, FsmOrder fsmOrder) {
		StateContext<?> stateContext = new StateContext(orderStateEvent, fsmOrder);
		return stateContext;
	}
}
