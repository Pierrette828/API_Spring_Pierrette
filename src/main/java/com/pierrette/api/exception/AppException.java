package com.pierrette.api.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppException extends RuntimeException {
//    private int statusCode;
    private String message;

    public AppException(String message)
    {
        super();
        this.message = message;
    }
}
