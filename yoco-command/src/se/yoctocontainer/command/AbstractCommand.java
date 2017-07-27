package se.yoctocontainer.command;

import se.yoctocontainer.core.AbstractComponent;

public abstract class AbstractCommand<T> extends AbstractComponent implements Command<T> {

	protected CommandContext commandContext;
	
	@Override
	public void setCommandContext(CommandContext cmdContext) {
		commandContext = cmdContext;
	}

}
