package top.marchand.sealed.utilities;

public class NoMatchingConstructor extends RuntimeException{
  public NoMatchingConstructor() {
  }

  public NoMatchingConstructor(String message) {
    super(message);
  }

  public NoMatchingConstructor(String message, Throwable cause) {
    super(message, cause);
  }

  public NoMatchingConstructor(Throwable cause) {
    super(cause);
  }

  public NoMatchingConstructor(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
