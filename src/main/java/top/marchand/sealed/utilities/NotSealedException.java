package top.marchand.sealed.utilities;

/**
 * An Exception that indicates one tries to get instance of a non-sealed class
 */
public class NotSealedException extends RuntimeException {
  /**
   * Default Constructor
   */
  public NotSealedException() {
    super();
  }

  /**
   * Cosntructor with a message
   * @param message The message
   */
  public NotSealedException(String message) {
    super(message);
  }

  /**
   * Constructor with a message and a cause
   * @param message The message
   * @param cause The cause
   */
  public NotSealedException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Cosntructor with a cause
   * @param cause The cause
   */
  public NotSealedException(Throwable cause) {
    super(cause);
  }

  /**
   * Complete constructor
   * @param message The message
   * @param cause The cause
   * @param enableSuppression whether or not suppression is enabled or disabled
   * @param writableStackTrace whether or not the stack trace should be writable
   */
  public NotSealedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
