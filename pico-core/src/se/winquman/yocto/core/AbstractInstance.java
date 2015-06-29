/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotInitiatedException;

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
