package se.yoctocontainer.ui;

import se.yoctocontainer.core.Instance;

/**
 * Handles an action arriving to the UI, and sends it to the correct action listener
 * @author Joen
 *
 */
public interface ActionHandler extends Instance {
	
	/**
	 * Register a new action listener
	 * @param listener the listener
	 */
	void registerListener(ActionListener<?> listener);
	
	/**
	 * Unregister an action listener
	 * @param listener the listener to unregister
	 */
	void unregisterListener(ActionListener<?> listener);
	
	/**
	 * Trigger an action
	 * @param action the descriptor descibing the action that occured
	 */
	<N> void action(ActionDescriptor<N> action);

}
