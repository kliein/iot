package com.iot.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
    PASS_WORD_ERROR(1,"用户名或密码不正确"),
    USER_ALREADY_EXIST(2,"用户已经存在"),
    AUTHORIZATION_INCORRECT(3,"授权码不正确"),
    REGISTER_SUCCESS(4,"注册成功："),
    SLAVE_IS_EXIST(5,"设备已经存在"),
    SLAVE_NUMBER_ERROR(6,"设备编号不正确"),
    SLAVE_NOT_EXIST(7,"设备不存在"),
    AUTHORIZATION_OVERDUE(8,"授权码过期"),

    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
