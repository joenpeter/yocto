/**
 * 
 */
package se.winquman.yocto.core.engine;

import java.util.Iterator;

import se.winquman.yocto.core.Context;
import se.winquman.yocto.core.Instance;
import se.winquman.yocto.core.RunConfiguration;

/**
 * @author jpeter
 *
 */
public interface ContextSeed extends Context {

	public Context addRuntime(RunConfiguration runConfig);
	public Iterator<Instance> getAllInstances();
}
