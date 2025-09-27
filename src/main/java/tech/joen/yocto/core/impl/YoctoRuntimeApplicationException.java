/**
 * 
 */
package tech.joen.yocto.core.impl;

/**
 * 
 */
public class YoctoRuntimeApplicationException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -3058083769012761104L;
  
  public YoctoRuntimeApplicationException(String message) {
    super(message);
  }
  
  public YoctoRuntimeApplicationException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public Throwable unwrap() {
    return getCause();
  }
  
  public ApplicationException toApplicationException() {
    ApplicationException ae = new ApplicationException(getMessage(), getCause());
    ae.setStackTrace(getStackTrace());
    return ae;
  }
  
  public static YoctoRuntimeApplicationException from(Throwable cause) {
    return from(cause, null);
  }
  
  public static YoctoRuntimeApplicationException from(Throwable cause, String message) {
    if(cause instanceof YoctoRuntimeApplicationException e) {
      return e; 
    } else {
      return new YoctoRuntimeApplicationException(message != null? message : cause.getMessage(), cause);
    }
  }

}
