/**
 * 
 */
package se.winquman.yocto.core;

import java.util.List;

import se.winquman.yocto.core.engine.RunnerState;
import se.winquman.yocto.error.InitializationException;

/**
 * @author Joen
 *
 */
public interface Runner extends Instance, Runnable {
	
	public void init(String runnerName) throws InitializationException;
	
	/**
	 * This is what you extand for actually making this runner do something when it runs
	 */
	public void running();

	public String getRunnerName();
	
	public void setRunArguments(List<Object> arguments);
	
	public void setStatus(RunnerState state);
	
	public RunnerState getStatus();
}
