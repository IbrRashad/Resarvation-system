package com.carrezerv.company.enums;

import lombok.Getter;

@Getter
public enum ErrorUSerCarsEntityEnum {
    UNKNOWN_ERROR(1000,"Unknown error"),
    USERCARS_NOT_FOUND(1001, "Cannot find car with given id "),
    NOT_ENOUGH_USERSCAR(1002,"Users car not found");
    private final int code;
    private final String message;
    ErrorUSerCarsEntityEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }



}
