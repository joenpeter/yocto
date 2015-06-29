/**
 * 
 */
package se.winquman.yocto.core.engine;

import java.util.Map;

import se.winquman.yocto.core.AbstractComponent;
import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.Runner;

/**
 * @author Joen
 *
 */
public class ContextRuntimeReference extends AbstractComponent implements RuntimeReference {


	Map<String,Runner> runners;
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.RuntimeReference#getRunners(se.winquman.yocto.core.engine.RunnerState)
	 */
	@Override
	public Runner[] getRunners(RunnerState state) {
		return (Runner[]) runners.values().toArray(); 
	}


	@Override
	protected void init() {
		// Do nothing
	}
	
	public void addRunners(Map<String,Runner> map) {
		runners = map;
	}

}
