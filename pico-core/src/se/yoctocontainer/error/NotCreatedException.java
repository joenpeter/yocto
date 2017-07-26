/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author Joen
 *
 */
@SuppressWarnings("serial")
public class NotCreatedException extends ApplicationRuntimeException {

	/**
	 * @param string 
	 * 
	 */
	public NotCreatedException(String string) {
		super(string);
	}

	public NotCreatedException(String string, Throwable e) {
		super(string, e);
	}

}
