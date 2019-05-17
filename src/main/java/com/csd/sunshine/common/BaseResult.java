package com.csd.sunshine.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liuqi
 * @description 基础支持类
 * @date 2019/5/17 09:56
 */
@Getter
@Setter
public class BaseResult {
    String code;
    String msg;
    Object data;

    public BaseResult() {
    }

    public BaseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
