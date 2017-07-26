/**
 * 
 */
package se.yoctocontainer.core.engine;

import se.yoctocontainer.core.Context;
import se.yoctocontainer.core.RunConfiguration;

/**
 * @author jpeter
 *
 */
public interface ContextSeed extends Context {

	/**
	 * Add a runtime configuration to this context.
	 * @param runConfig the runtime configuration to add
	 */
	public void addRuntime(RunConfiguration runConfig);
	
	/**
	 * Get the context associated with this seed.
	 * @return the context
	 */
	public Context getContext();
}
