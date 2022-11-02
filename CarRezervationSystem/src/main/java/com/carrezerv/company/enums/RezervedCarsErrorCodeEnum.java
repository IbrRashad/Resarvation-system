package com.carrezerv.company.enums;

import lombok.Getter;

@Getter
public enum RezervedCarsErrorCodeEnum {
    ALREADY_EXIST(2000,"Already rezerved this car");
    private final int code;
    private final String message;

    RezervedCarsErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
