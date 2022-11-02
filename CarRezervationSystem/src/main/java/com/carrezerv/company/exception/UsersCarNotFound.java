package com.carrezerv.company.exception;

import com.carrezerv.company.enums.ErrorCarCodeEnum;
import com.carrezerv.company.enums.ErrorUSerCarsEntityEnum;
import lombok.Getter;

@Getter
public class UsersCarNotFound extends  RuntimeException {
    private final String message;
    private final int code;

    public UsersCarNotFound(ErrorUSerCarsEntityEnum errorUSerCarsEntityEnum) {

        super(errorUSerCarsEntityEnum.getMessage());
        this.message = errorUSerCarsEntityEnum.getMessage();
        this.code = errorUSerCarsEntityEnum.getCode();
    }
}
