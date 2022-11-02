package com.carrezerv.company.exception;

import com.carrezerv.company.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class CustomNotFoundException extends RuntimeException {
    private final String message;
    private final int code;

    public CustomNotFoundException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message = errorCodeEnum.getMessage();
        this.code = errorCodeEnum.getCode();
    }
}
