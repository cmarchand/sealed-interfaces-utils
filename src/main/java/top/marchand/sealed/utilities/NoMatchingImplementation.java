package top.marchand.sealed.utilities;

public class NoMatchingImplementation extends RuntimeException {
  public NoMatchingImplementation() {
  }

  public NoMatchingImplementation(String message) {
    super(message);
  }

  public NoMatchingImplementation(String message, Throwable cause) {
    super(message, cause);
  }

  public NoMatchingImplementation(Throwable cause) {
    super(cause);
  }

  public NoMatchingImplementation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
