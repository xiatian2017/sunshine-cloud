package com.csd.sunshine.common;


/**
 * 自定义阳光系统异常
 *
 * @author liuqi
 * @date 2019/4/13
 */
public class SunException extends RuntimeException {

    private int code;

    private String msg;


    public SunException() {
        super();
    }

    public SunException(Throwable cause) {
        super(cause);
    }

    public SunException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public SunException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public SunException(BaseExceptionEnum exEnum) {
        this.code = exEnum.getCode();
        this.msg = exEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
