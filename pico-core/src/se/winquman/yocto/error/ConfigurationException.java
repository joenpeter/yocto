/**
 * 
 */
package se.winquman.yocto.error;

/**
 * @author Joen
 *
 */
public class ConfigurationException extends ApplicationException {

	/**
	 * @param string
	 */
	public ConfigurationException(String string) {
		super(string);
	}

	/**
	 * @param string
	 * @param e
	 */
	public ConfigurationException(String string, Throwable e) {
		super(string, e);
	}

}
