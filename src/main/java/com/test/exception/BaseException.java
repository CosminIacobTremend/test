package com.test.exception;

import lombok.Data;

@Data
public abstract class BaseException extends RuntimeException {

  private Integer errorCode;
  private String message;

  public BaseException(Integer errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
    this.message = message;
  }

  public BaseException(Integer errorCode, String message, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
    this.message = message;
  }

  public BaseException(Throwable cause) {
    super(cause);
    this.errorCode = 500;
    this.message = "Internal Server Error";
  }
}
