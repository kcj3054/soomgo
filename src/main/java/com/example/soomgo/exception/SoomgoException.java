package com.example.soomgo.exception;

public class SoomgoException extends RuntimeException {

  public SoomgoException() {
  }

  public SoomgoException(String message) {
    super(message);
  }

  public SoomgoException(String message, Throwable cause) {
    super(message, cause);
  }

  public SoomgoException(Throwable cause) {
    super(cause);
  }

  public SoomgoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
