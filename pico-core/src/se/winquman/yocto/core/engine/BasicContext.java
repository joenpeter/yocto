/**
 * 
 */
package se.winquman.yocto.core.engine;

import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.core.logging.LogSettings;

/**
 * @author Joen
 *
 */
public class BasicContext extends AbstractContext {

	/**
	 * @param conf
	 * @param log
	 */
	public BasicContext(Configurator conf, LogSettings log) {
		super(conf, log);
	}

}
