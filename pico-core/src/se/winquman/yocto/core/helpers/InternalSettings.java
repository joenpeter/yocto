/**
 * 
 */
package se.winquman.yocto.core.helpers;

import se.winquman.yocto.core.RunConfiguration;
import se.winquman.yocto.core.engine.BasicContext;
import se.winquman.yocto.core.engine.ContextSeed;
import se.winquman.yocto.core.engine.InternalRunConfiguration;
import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.core.engine.config.impl.BasicConfigurator;
import se.winquman.yocto.core.logging.LogSettings;

/**
 * @author Joen
 *
 */
public class InternalSettings {
	
	public static Configurator getEmptyConfigurator() {
		
		return new BasicConfigurator();
	}
	
	public static ContextSeed getEmptyContext(Configurator config, LogSettings log) {
		
		return new BasicContext(config, log);
	}
	
	public static RunConfiguration getInternalRuntime() {
		
		return new InternalRunConfiguration();
	}


}
