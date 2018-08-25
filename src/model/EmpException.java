package model;

public class EmpException extends RuntimeException {

  public EmpException() {
  }

  public EmpException(String message) {
    super(message);
  }

  public EmpException(String message, Throwable cause) {
    super(message, cause);
  }

  public EmpException(Throwable cause) {
    super(cause);
  }

  public EmpException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
