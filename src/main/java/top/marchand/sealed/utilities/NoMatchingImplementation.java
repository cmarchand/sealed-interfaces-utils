package top.marchand.sealed.utilities;

/**
 * An exception that indicates no matching implementation has been found
 */
public class NoMatchingImplementation extends RuntimeException {
  /**
   * Default constructor
   */
  public NoMatchingImplementation() {
    super();
  }

  /**
   * Constructor with a message
   * @param message The message
   */
  public NoMatchingImplementation(String message) {
    super(message);
  }

  /**
   * Cosntructor with a message and a cause
   * @param message The message
   * @param cause The cause
   */
  public NoMatchingImplementation(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructor with a cause
   * @param cause The cause
   */
  public NoMatchingImplementation(Throwable cause) {
    super(cause);
  }

  /**
   * Complete constructor
   * @param message The message
   * @param cause The cause
   * @param enableSuppression whether or not suppression is enabled or disabled
   * @param writableStackTrace whether or not the stack trace should be writable
   */
  public NoMatchingImplementation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
