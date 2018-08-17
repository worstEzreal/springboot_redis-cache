package com.worstezreal.rediscache.enums;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:23
 */
public enum CodeEnum {

    SUCCESS(0, "请求成功"),
    WEAK_NET_WORK(-1, "网络异常，请稍后重试"),
    PASSWORD_ERROR(10001, "用户名或密码错误"),
    PARAMETER_ERROR(10101, "参数错误"),
    CODE_ERROR(10002, "验证码错误"),
    OTHER_LOGIN_ERROR(10003, "其它登录异常");

    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}