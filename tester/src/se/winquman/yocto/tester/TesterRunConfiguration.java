/**
 * 
 */
package se.winquman.yocto.tester;

import java.util.Map;

import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.core.Instance;
import se.winquman.yocto.core.RunConfiguration;
import se.winquman.yocto.core.Runner;

/**
 * @author Joen
 *
 */
public class TesterRunConfiguration implements RunConfiguration {

	/* (non-Javadoc)
	 * @see se.winquman.pico.core.RunConfiguration#getInstances()
	 */
	@Override
	public Map<String, Instance> getInstances() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see se.winquman.pico.core.RunConfiguration#getComponentFactories()
	 */
	@Override
	public Map<String, ComponentFactory> getComponentFactories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Runner> getRunners() {
		// TODO Auto-generated method stub
		return null;
	}

}
