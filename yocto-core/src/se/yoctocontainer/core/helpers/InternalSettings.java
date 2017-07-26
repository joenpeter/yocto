/**
 * 
 */
package se.yoctocontainer.core.helpers;

import se.yoctocontainer.core.RunConfiguration;
import se.yoctocontainer.core.engine.BasicContext;
import se.yoctocontainer.core.engine.ContextSeed;
import se.yoctocontainer.core.engine.InternalRunConfiguration;
import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.core.engine.config.impl.BasicConfigurator;
import se.yoctocontainer.core.logging.LogSettings;

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
