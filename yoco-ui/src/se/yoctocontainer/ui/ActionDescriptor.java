package se.yoctocontainer.ui;

/**
 * A descriptor, describing an action in the user interface
 * @author Joen
 *
 * @param <N> the type of additional information that may describe this event
 */
public interface ActionDescriptor<N> {

	/**
	 * 
	 * @return the name of the command that should be triggered from this action
	 */
	String getCommandName();
	
	/**
	 * 
	 * @return any additional information that was provided with this action
	 */
	N getAdditionalInformation();
}
