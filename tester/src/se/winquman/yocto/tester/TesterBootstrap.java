/**
 * 
 */
package se.winquman.yocto.tester;

import se.winquman.yocto.core.Bootstrap;
import se.winquman.yocto.error.ApplicationException;

/**
 * @author Joen
 *
 */
public class TesterBootstrap extends Bootstrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bootstrap boot = new TesterBootstrap();
		try {
			boot.boot(new TesterRunConfiguration());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
