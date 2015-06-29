/**
 * 
 */
package se.winquman.yocto.error;

/**
 * @author jpeter
 *
 */
public class ApplicationRuntimeException extends RuntimeException {

	public ApplicationRuntimeException(String string) {
		super(string);
	}

	public ApplicationRuntimeException(String string, Throwable e) {
		super(string,e);
	}

}
