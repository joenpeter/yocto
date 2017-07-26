/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author jpeter
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException(String string) {
		super(string);
	}

	public ApplicationException(String string, Throwable e) {
		super(string, e);
	}

}
