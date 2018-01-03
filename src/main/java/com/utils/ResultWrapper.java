package com.utils;

import java.io.Serializable;

public class ResultWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected T result;						// 返回结果
    protected int errorCode;				// 错误码
    protected String errorMsg;				// 错误消息
    protected boolean successful = true;	// 是否成功，失败时应检查错误码作出相应处理

    public ResultWrapper() {
        super() ;
    }

    public ResultWrapper(T result) {
        this.result = result ;
    }

    /**
     * 使用枚举传入预设错误码
     * @param error
     * @return
     */
    public ResultWrapper<T> setError(ErrorCode error) {
        this.successful = false ;
        if(error != null) {
            this.errorCode = error.getValue() ;
            this.errorMsg = error.getMessage() ;
        }
        return this ;
    }

    /**
     * 自定义错误码
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public ResultWrapper<T> setError(int errorCode ,String errorMsg) {
        this.successful = false ;
        this.errorCode = errorCode ;
        this.errorMsg = errorMsg ;
        return this ;
    }

    public T getResult() {
        return result;
    }

    public ResultWrapper<T> setResult(T result) {
        this.result = result;
        return this ;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ResultWrapper<T> setErrorCode(int errorCode) {
        this.successful = false ;
        this.errorCode = errorCode ;
        return this ;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ResultWrapper<T> setErrorMsg(String errorMsg) {
        this.successful = false ;
        this.errorMsg = errorMsg;
        return this ;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public ResultWrapper<T> setSuccessful(boolean successful) {
        this.successful = successful;
        return this ;
    }

}
