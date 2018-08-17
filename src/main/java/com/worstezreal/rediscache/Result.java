package com.worstezreal.rediscache;

import com.worstezreal.rediscache.enums.CodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:22
 */
@Setter
@Getter
public class Result {

    private int code;
    private String msg;
    private Object data;

    public Result(CodeEnum codeEnum, Object data) {
        this(codeEnum);
        this.data = data;
    }

    public Result(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}