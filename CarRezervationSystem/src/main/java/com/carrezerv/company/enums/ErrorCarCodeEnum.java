package com.carrezerv.company.enums;

import lombok.Getter;

@Getter
public enum ErrorCarCodeEnum {
    UNKNOWN_ERROR(1000,"Unknown error"),
    CAR_NOT_FOUND(1001, "Cannot find car with given id "),
    NOT_ENOUGH_CAR(1002,"Cars not found");
    private final int code;
    private final String message;
    ErrorCarCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }



}
