/**
 * 
 */
package tech.joen.yocto.core.impl;

/**
 * 
 */
public class ApplicationException extends Exception {

  private static final long serialVersionUID = 4569164427870419460L;
  
  public ApplicationException(String message) {
    super(message);
  }
  
  public ApplicationException(String message, Throwable cause) {
    super(message, cause);
  }
}
