/**
 * 
 */
package se.yoctocontainer.error;

/**
 * @author jpeter
 *
 */
@SuppressWarnings("serial")
public class ApplicationRuntimeException extends RuntimeException {

	public ApplicationRuntimeException(String string) {
		super(string);
	}

	public ApplicationRuntimeException(String string, Throwable e) {
		super(string,e);
	}

}
