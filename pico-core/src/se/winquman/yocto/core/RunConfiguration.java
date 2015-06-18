/**
 * 
 */
package se.winquman.yocto.core;

import java.util.Map;

/**
 * This is where all context configuration goes - can be done in layers
 * @author Joen
 *
 */
public interface RunConfiguration {
	
	public Map<String,Instance> getInstances();
	
	public Map<String,ComponentFactory> getComponentFactories();
	
	public Map<String,Runner> getRunners();

}
