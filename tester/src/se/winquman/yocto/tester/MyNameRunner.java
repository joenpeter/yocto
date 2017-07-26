/**
 * 
 */
package se.winquman.yocto.tester;

import se.yoctocontainer.core.Instance;

/**
 * @author jpeter
 *
 */
public interface MyNameRunner extends Instance, Runnable {

	public void setMyName(String name);
	
}
