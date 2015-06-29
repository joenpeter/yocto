/**
 * 
 */
package se.winquman.yocto.error;

/**
 * @author jpeter
 *
 */
public class InitializationException extends ApplicationException {

	public InitializationException(String string) {
		super(string);
	}

	public InitializationException(String string, Throwable e) {
		super(string, e);
	}

}
