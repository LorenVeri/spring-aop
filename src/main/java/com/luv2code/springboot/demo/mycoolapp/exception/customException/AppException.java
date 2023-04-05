package com.luv2code.springboot.demo.mycoolapp.exception.customException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException {
    private int code;
    private String message;
}
