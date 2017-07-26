/**
 * 
 */
package se.winquman.yocto.tester.impl;

import se.winquman.yocto.tester.MyNameRunner;
import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.error.ConfigurationException;

/**
 * @author jpeter
 *
 */
public class MyNameRunnerImpl extends AbstractInstance implements MyNameRunner {

	private String name = "";
	
	/**
	 * 
	 */
	public MyNameRunnerImpl() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		boolean proceed = true;
		
		while(proceed) {
			try {
				Thread.sleep(5000);
				debug("Checking for name...");
			} catch (InterruptedException e) {
				//
			}
			
			synchronized(name) {
				if(name != "") {
					info("Name was found!");
					String msg = null;
					try {
						msg = config.getStringConfiguration("/General/helloMessage");
					} catch (ConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Hello " + name + "!!!!!!! " + msg);
					proceed = false;
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.tester.MyNameRunner#setName(java.lang.String)
	 */
	@Override
	public void setMyName(String n) {
		synchronized(name) {
			name = n;
		}
		info("Name has been set!");
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {

	}

}
