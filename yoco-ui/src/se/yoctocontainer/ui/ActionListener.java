package se.yoctocontainer.ui;

import se.yoctocontainer.core.Instance;

/**
 * Listens for actions from the user
 * @author Joen
 *
 */
public interface ActionListener<N> extends Instance {

	/**
	 * Called when a UI action is triggered
	 * @param action the action that triggered this call
	 */
	void actionTriggered(ActionDescriptor<N> action);
	
}
