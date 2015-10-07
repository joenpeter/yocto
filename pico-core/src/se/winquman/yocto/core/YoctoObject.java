/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.error.ApplicationException;

/**
 * @author jpeter
 *
 */
public interface YoctoObject {
	
	public void create(Context cont, Configurator conf);

	public boolean isCheck();
}
