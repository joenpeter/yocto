/**
 * 
 */
package se.winquman.yocto.core.helpers;

import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.core.Context;
import se.winquman.yocto.core.RunConfiguration;
import se.winquman.yocto.core.engine.BasicComponentFactory;
import se.winquman.yocto.core.engine.BasicContext;
import se.winquman.yocto.core.engine.InternalRunConfiguration;
import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.core.engine.config.impl.BasicConfigurator;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationException;

/**
 * @author Joen
 *
 */
public class InternalSettings {
	
	public static Configurator getEmptyConfigurator() {
		
		return new BasicConfigurator();
	}
	
	public static Context getEmptyContext(Configurator config, LogSettings log) {
		
		return new BasicContext(config, log);
	}
	
	public static RunConfiguration getInternalRuntime() {
		
		return new InternalRunConfiguration();
	}

	public static ComponentFactory getDefaultComponentFactory(Context cont, Configurator conf) throws ApplicationException {

		ComponentFactory cf = new BasicComponentFactory();
		cf.create(cont, conf);
		return cf;
	}

}
