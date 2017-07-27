package se.yoctocontainer.ui;

import se.yoctocontainer.command.Command;

/**
 * A command to process some input and result in some data to return to the user
 * @author Joen
 *
 * @param <T> the type of the expected returned data
 * @param <N> the type of the input
 */
public interface InputCommand<T,N> extends Command<T> {

	/**
	 * Set the input for this command to handle
	 * @param input the input for this command to handle
	 */
	void setInput(N input);
}
