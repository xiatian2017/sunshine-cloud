package com.csd.sunshine.common;

import lombok.Getter;

/**
 * @author liuqi
 * @date 2019/5/17 10:36
 * 基础返回码
 */
@Getter
public enum BaseCode {
    /**
     * 成功
     */
    SUCCESS("200"),
    /**
     * 异常失败
     */
    FAIL("500");

    BaseCode(String code) {
        this.code = code;
    }

    private String code;

    public static void main(String[] args) {
        System.out.println(BaseCode.SUCCESS.getCode());
    }
}
