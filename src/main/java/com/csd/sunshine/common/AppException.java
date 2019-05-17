package com.csd.sunshine.common;

/**
 * @author liuqi
 * @description 自定义异常类
 * @date 2019/5/17 10:36
 */
public class AppException extends Exception {

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
