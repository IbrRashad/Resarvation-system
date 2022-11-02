package com.carrezerv.company.enums;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    UNKNOWN_ERROR(1000, "Unknown error"),
    USER_NOT_FOUND(1001, "Cannot find user with given id "),
    NOT_ENOUGH_USERS(1002, "Users not found"),
    VALIDATION_ERROR(1003, "Validation error"),
    NOT_ENOUGH_REZERVED_CARS(1004,"Not enough rezerved cars");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
