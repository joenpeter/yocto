/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author jpeter
 *
 */
@SuppressWarnings("serial")
public class InitializationException extends ApplicationException {

	public InitializationException(String string) {
		super(string);
	}

	public InitializationException(String string, Throwable e) {
		super(string, e);
	}

}
