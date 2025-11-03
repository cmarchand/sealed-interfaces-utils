package top.marchand.sealed.utilities;

/**
 * An exception that indicates no constructor with same parameters was found.
 */
public class NoMatchingConstructor extends RuntimeException {
  /**
   * Default constructor
   */
  public NoMatchingConstructor() {
    super();
  }

  /**
   * Cosntructor with a message
   * @param message The message
   */
  public NoMatchingConstructor(String message) {
    super(message);
  }

  /**
   * Constructor with a message and a cause
   * @param message The message
   * @param cause The cause
   */
  public NoMatchingConstructor(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Cosntructor with a cause
   * @param cause The cause
   */
  public NoMatchingConstructor(Throwable cause) {
    super(cause);
  }

  /**
   * Complete constructor
   * @param message The message
   * @param cause The cause
   * @param enableSuppression whether or not suppression is enabled or disabled
   * @param writableStackTrace whether or not the stack trace should be writable
   */
  public NoMatchingConstructor(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
