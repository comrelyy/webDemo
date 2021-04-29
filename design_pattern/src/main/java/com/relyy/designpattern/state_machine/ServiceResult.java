package com.relyy.designpattern.state_machine;

import lombok.Data;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/4/29
 */
@Data
public class ServiceResult<T> {

	private boolean success = true;
	private T data;
	private String code;
	private String msg;

	public ServiceResult() {

	}

	public ServiceResult(boolean success, T data) {
		this.success = success;
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public ServiceResult(boolean success) {
		this.success = success;
	}


}
