/**
 * 
 */
package se.winquman.yocto.core.helpers;

import java.util.HashMap;
import java.util.Map;

import se.winquman.yocto.core.Runner;
import se.winquman.yocto.error.ApplicationException;

/**
 * @author Joen
 *
 */
public class RunnerHelper {
	
	private static Map<String,Thread> runners;
	
	public static void startRunner(Runner runner) throws ApplicationException {
		checkMap();
		if(runners.containsKey(runner.getRunnerName())) {
			// Already in list, or a duplicate
			
			if(runners.get(runner.getRunnerName()).equals(runner)) {
				// Okay, they are the same...proceed
			} else {
				// This is bad, same name but not same thread
				throw new ApplicationException("Duplicate runner name, cannot start runner: " + runner.getRunnerName());
			}
		}
		
		Thread thread = new Thread(runner, runner.getRunnerName());
		runners.put(runner.getRunnerName(), thread);
		thread.start();
	}

	private static void checkMap() {
		if(runners == null) {
			runners = new HashMap<String,Thread>();
		}
	}

}
