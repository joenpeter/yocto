/**
 * 
 */
package se.winquman.yocto.error;

/**
 * @author jpeter
 *
 */
public class ApplicationException extends Exception {

	public ApplicationException(String string) {
		super(string);
	}

	public ApplicationException(String string, Throwable e) {
		super(string, e);
	}

}
