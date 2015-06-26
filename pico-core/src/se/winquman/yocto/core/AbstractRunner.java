/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.InitializationException;

/**
 * @author Joen
 *
 */
public abstract class AbstractRunner extends AbstractInstance implements Runner {

	private String name;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	public void init(String runnerName) throws InitializationException {
		super.init();
		name = runnerName;
	}

	public String getRunnerName() {
		return name;
	}
}
