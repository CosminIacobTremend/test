package com.test.exception;

public class BadRequestException extends BaseException {


  public BadRequestException(Integer errorCode, String message) {
    super(errorCode, message);
  }

  public BadRequestException(Integer errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }

  public BadRequestException(Throwable cause) {
    super(cause);
  }
}

