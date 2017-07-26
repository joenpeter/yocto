/**
 * 
 */
package se.winquman.yocto.tester;

import se.winquman.yocto.core.Instance;

/**
 * @author jpeter
 *
 */
public interface MyNameRunner extends Instance, Runnable {

	public void setName(String name);
	
}
