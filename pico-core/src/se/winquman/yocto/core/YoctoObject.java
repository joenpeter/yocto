/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.ApplicationException;

/**
 * @author jpeter
 *
 */
public interface YoctoObject {
	
	public void create(Context cont, Configurator conf) throws ApplicationException;

}
