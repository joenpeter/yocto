/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author Joen
 *
 */
@SuppressWarnings("serial")
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
