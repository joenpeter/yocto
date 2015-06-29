/**
 * 
 */
package se.winquman.yocto.error;

/**
 * @author Joen
 *
 */
public class RuntimeEnvironmentException extends ApplicationRuntimeException {

	/**
	 * @param string
	 */
	public RuntimeEnvironmentException(String string) {
		super(string);
	}

	public RuntimeEnvironmentException(String string, Exception e) {
		super(string,e);
	}

}
