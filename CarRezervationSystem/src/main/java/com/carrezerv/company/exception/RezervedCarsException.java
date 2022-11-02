package com.carrezerv.company.exception;

import com.carrezerv.company.enums.ErrorCodeEnum;
import com.carrezerv.company.enums.RezervedCarsErrorCodeEnum;
import lombok.Getter;

@Getter
public class RezervedCarsException extends RuntimeException {
    private final String message;
    private final int code;

    public RezervedCarsException(RezervedCarsErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }
}
