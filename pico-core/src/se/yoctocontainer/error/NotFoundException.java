/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author Joen
 *
 */
@SuppressWarnings("serial")
public class NotFoundException extends ApplicationRuntimeException {

	/**
	 * @param string
	 */
	public NotFoundException(String string) {
		super(string);
	}

	public NotFoundException(String string, Throwable e) {
		super(string, e);
	}

}
