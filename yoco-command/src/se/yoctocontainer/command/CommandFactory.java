package se.yoctocontainer.command;

import se.yoctocontainer.core.Instance;
import se.yoctocontainer.error.ApplicationException;

/**
 * Creates command on demand
 * @author Joen
 *
 */
public interface CommandFactory extends Instance {

	/**
	 * Get a command from a name
	 * @param name the user-friendly name of the command, as registered
	 * @return the command
	 */
	Command<?> newCommand(String name) throws ApplicationException;
	
	
}
