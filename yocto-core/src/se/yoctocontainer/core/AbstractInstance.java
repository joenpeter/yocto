/**
 * 
 */
package se.yoctocontainer.core;

import se.yoctocontainer.core.engine.config.Configurator;

/**
 * @author Joen
 *
 */
public abstract class AbstractInstance extends AbstractYoctoObject implements Instance {

	
	@Override
	public void create(Context cont, Configurator conf) {
		super.create(cont, conf);
	}

	
}
