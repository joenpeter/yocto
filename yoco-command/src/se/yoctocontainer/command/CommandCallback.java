package se.yoctocontainer.command;

import se.yoctocontainer.core.Component;
import se.yoctocontainer.error.ApplicationException;

/**
 * A callback, to be implemented to handle a result from a command
 * @author Joen
 *
 * @param <T> the type of data the command associated with this callback will deliver
 */
public interface CommandCallback <T> extends Component {

	/**
	 * Will be called if command execution was successful
	 * @param data the data produced by the command
	 */
	void success(T data);
	
	/**
	 * Will be called if the command failed
	 * @param e the exception associated with the failure
	 */
	void failure(ApplicationException e);
	
}
