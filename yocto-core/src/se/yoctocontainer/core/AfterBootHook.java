package se.yoctocontainer.core;

/**
 * Hook to indicate this instance needs to do some work after the boot sequence is completed 
 * @author Joen
 *
 */
public interface AfterBootHook extends Instance {

	/**
	 * Called after the boot sequence is completed;
	 * ie all instances and components have been populated.
	 */
	void afterBootHook();
}
