/**
 * 
 */
package se.winquman.yocto.tester;

import se.winquman.yocto.core.Bootstrap;

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
		boot.boot(new TesterRunConfiguration());
	}

}
