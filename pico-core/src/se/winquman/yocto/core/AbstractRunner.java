/**
 * 
 */
package se.winquman.yocto.core;

import java.util.List;

import se.winquman.yocto.core.engine.RunnerState;
import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;
import se.winquman.yocto.error.InitializationException;

/**
 * @author Joen
 *
 */
public abstract class AbstractRunner extends AbstractInstance implements Runner {

	private String name;
	private RunnerState status = RunnerState.NEW;
	protected List<Object> arguments;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(status != status.STARTED) {
			throw new ApplicationRuntimeException("Is in run, but was never started!");
		}
		
		running();
		
		
		// end of running
		status = status.ENDED;
	}
	

	@Override
	public void create(Context cont, Configurator conf) {
		super.create(cont, conf);
		name = getName();
		status = status.INIT;
	}
	
	protected abstract String getName();

	public String getRunnerName() {
		return name;
	}
	
	public void setStatus(RunnerState state) {
		status = state;
	}
	
	
	public RunnerState getStatus() {
		return status;
	}
	
	public void setRunArguments(List<Object> arguments) {
		check();
		this.arguments = arguments;
		status = status.READY;
	}
}
