package top.marchand.sealed.utilities;

public class NotSealedException extends RuntimeException {
  public NotSealedException() {
  }

  public NotSealedException(String message) {
    super(message);
  }

  public NotSealedException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotSealedException(Throwable cause) {
    super(cause);
  }

  public NotSealedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
