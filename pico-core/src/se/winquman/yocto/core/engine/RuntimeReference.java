/**
 * 
 */
package se.winquman.yocto.core.engine;

import se.winquman.yocto.core.Runner;

/**
 * @author Joen
 *
 */
public interface RuntimeReference {

	public Runner[] getRunners(RunnerState state);
	
}
