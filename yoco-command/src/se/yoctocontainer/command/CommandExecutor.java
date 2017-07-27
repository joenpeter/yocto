package se.yoctocontainer.command;

import se.yoctocontainer.core.Instance;
import se.yoctocontainer.error.ApplicationException;

/**
 * Command executor, used to execute command.
 * This is an easy way to enforce a control flow in the program,
 * as all command will run on the same thread and executed in the same way.
 * @author Joen
 *
 */
public interface CommandExecutor extends Instance {
	
	/**
	 * Queue a command for execution
	 * @param command the command to be queued
	 */
	<T> void enqueue(Command<T> command);
	
	/**
	 * Queue a command for execution, and leave a callback reference to
	 * be able to follow up on the result as needed.
	 * @param command the command to be queued
	 * @param callback the callback to be used when the command is completed
	 */
	<T> void enqueue(Command<T> command, CommandCallback<T> callback);
	
	/**
	 * Queue a command for execution, and wait for it to be completed
	 * @param command the command to be executed
	 * @return the result of the command
	 */
	<T> T enqueueAndWait(Command<T> command) throws ApplicationException;
	
	/**
	 * Check if the executor is currently busy
	 * @return true if it is busy (is currently executing a command), otherwise false
	 */
	boolean isBusy();
	
	

}
