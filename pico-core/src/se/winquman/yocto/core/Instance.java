/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.InitializationException;

/**
 * @author Joen
 *
 */
public interface Instance {
	
	public void init() throws InitializationException;
	
	public void empty();

}
