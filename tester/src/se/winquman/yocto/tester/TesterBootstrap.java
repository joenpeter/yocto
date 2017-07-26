/**
 * 
 */
package se.winquman.yocto.tester;

import se.yoctocontainer.core.Bootstrap;
import se.yoctocontainer.error.ApplicationException;

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
