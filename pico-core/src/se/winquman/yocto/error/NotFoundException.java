/**
 * 
 */
package se.winquman.yocto.error;

/**
 * @author Joen
 *
 */
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
