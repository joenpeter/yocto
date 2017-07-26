/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author Joen
 *
 */
@SuppressWarnings("serial")
public class NotInitiatedException extends ApplicationRuntimeException {

	/**
	 * @param string
	 */
	public NotInitiatedException(String string) {
		super(string);
	}

}
