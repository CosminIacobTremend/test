package com.test.exception;

public class ExpectationFailedException extends BaseException {

  public ExpectationFailedException(Integer errorCode, String message) {
    super(errorCode, message);
  }

  public ExpectationFailedException(Integer errorCode, String message, Throwable cause) {
    super(errorCode, message, cause);
  }

  public ExpectationFailedException(Throwable cause) {
    super(cause);
  }
}

