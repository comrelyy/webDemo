package com.relyy.designpattern.state_machine;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Description 状态机引擎的处理器注解标识
 * @Created by cairuirui
 * @Date 2021/4/29
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface OrderProcessor {

	/**
	 * 指定状态，state不能同时存在
	 * @return
	 */
	String[] state() default {};

	/**
	 *订单操作事件
	 */
	String event();
	/**
	 * 业务类型
	 * @return
	 */
	String[] bizType() default {};

	/**
	 * 场景
	 */
	String[] sceneId() default {};
}
