package se.yoctocontainer.command.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import se.yoctocontainer.command.Command;
import se.yoctocontainer.command.CommandFactory;
import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.core.AfterBootHook;
import se.yoctocontainer.error.ApplicationException;

public class CommandFactoryImpl extends AbstractInstance implements CommandFactory, AfterBootHook {

	Map<String, String> commandLookup;
	
	@Override
	public Command<?> newCommand(String name) throws ApplicationException {
		String commandName = commandLookup.get(name);
		if(commandName == null) {
			commandName = name;
		}
		return context.newComponent(commandName); 
	}


	@Override
	protected void init() throws ApplicationException {
		commandLookup = new HashMap<>();
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> void addExtraNames() throws ApplicationException {
		Map<String,Class<Command>>commands = context.getComponentsOfType(Command.class);
		for(Entry<String,Class<Command>> entry: commands.entrySet()) {
			Class<Command> commandType = entry.getValue();
			Command<T> command;
			try {
				command = commandType.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new ApplicationException("Unable to initiate CommandFactory - could not test command " 
						+ commandType.getSimpleName(), e);
			}
			for(String name: command.getUserFriendlyNames()) {
				commandLookup.put(name, entry.getKey());
			}
			
		}
	}


	@Override
	public void afterBootHook() {
		try {
			addExtraNames();
		} catch (ApplicationException e) {
			error("Could not initiate CommandFactory properly: " + e.getMessage(), e);
		}
	}

}
