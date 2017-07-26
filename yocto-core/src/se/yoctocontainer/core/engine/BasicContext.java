/**
 * 
 */
package se.yoctocontainer.core.engine;

import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.core.logging.LogSettings;

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
