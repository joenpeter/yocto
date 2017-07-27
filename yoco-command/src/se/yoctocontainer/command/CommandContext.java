package se.yoctocontainer.command;

import se.yoctocontainer.error.ApplicationException;

/**
 * Local context of the specific command
 * @author Joen
 *
 */
public interface CommandContext {

	/**
	 * Execute another command as part of this command chain
	 * @param command the command to execute
	 * @return the result of that command
	 */
	<T> T execute(Command<T> command) throws ApplicationException;
}
