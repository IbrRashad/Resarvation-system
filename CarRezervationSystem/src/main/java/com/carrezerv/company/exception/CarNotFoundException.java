package com.carrezerv.company.exception;

import com.carrezerv.company.enums.ErrorCarCodeEnum;
import lombok.Getter;

@Getter
public class CarNotFoundException extends  RuntimeException {
    private final String message;
    private final int code;

    public CarNotFoundException(ErrorCarCodeEnum errorCarCodeEnum) {

        super(errorCarCodeEnum.getMessage());
        this.message = errorCarCodeEnum.getMessage();
        this.code = errorCarCodeEnum.getCode();
    }
}
