package com.iot.exception;

import com.iot.enums.ResultEnum;
import lombok.Getter;

@Getter
public class IotException extends RuntimeException {

    private Integer code;

    public IotException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public IotException( Integer code,String message) {
        super(message);
        this.code = code;
    }
}
