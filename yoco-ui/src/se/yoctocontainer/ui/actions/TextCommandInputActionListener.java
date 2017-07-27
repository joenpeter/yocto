package se.yoctocontainer.ui.actions;

import se.yoctocontainer.command.CommandExecutor;
import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.ui.ActionDescriptor;
import se.yoctocontainer.ui.ActionListener;
import se.yoctocontainer.ui.InputCommand;

/**
 * Takes in a String, and sends it to a corresponding input command
 * @author Joen
 *
 * @param <N> is a String
 */
public class TextInputActionListener<N> extends AbstractInstance implements ActionListener<String> {

	private CommandExecutor executor;
	
	@Override
	public void actionTriggered(ActionDescriptor<String> action) {
		InputCommand<?, String> command = context.newComponent("TextInputCommand");
		command.setInput(action.getAdditionalInformation());
		executor.enqueue(command);
	}

	@Override
	protected void init() {
		executor = context.getInstance("CommandExecutor");
	}


}
