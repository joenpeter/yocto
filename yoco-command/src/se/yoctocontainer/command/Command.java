package se.yoctocontainer.command;

import java.util.List;

import se.yoctocontainer.core.Component;
import se.yoctocontainer.error.ApplicationException;

/**
 * A command, performing a certain task and then returning a resulting data
 * for handling somewhere else (possibly).
 * @author Joen
 *
 * @param <T> the type of data this command produces
 */
public interface Command<T> extends Component {

	/**
	 * This is where the execution of the command is implemented.
	 * @return the data produced by the command (may be null)
	 */
	T execute() throws ApplicationException;
	
	/**
	 * Sets a command context on this command, will be done by the command executor
	 * @param cmdContext the command context for this command to use
	 */
	void setCommandContext(CommandContext cmdContext);
	
	/**
	 * 
	 * @return a list of user-friendly names of this command 
	 */
	List<String> getUserFriendlyNames();
}
