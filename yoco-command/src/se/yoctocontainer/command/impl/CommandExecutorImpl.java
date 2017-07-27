package se.yoctocontainer.command.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;

import se.yoctocontainer.command.Command;
import se.yoctocontainer.command.CommandCallback;
import se.yoctocontainer.command.CommandCallbackAdapter;
import se.yoctocontainer.command.CommandContext;
import se.yoctocontainer.command.CommandExecutor;
import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.error.ApplicationException;

public class CommandExecutorImpl extends AbstractInstance implements CommandExecutor, Runnable {

	private static final int SLEEP_TIME = 1000;
	
	private Queue<CommandInvokation<?>> commandQueue;
	private String busy = "";
	private boolean isRunning = true;
	private Thread commandThread;
	
	@Override
	public void run() {
		commandThread = Thread.currentThread();
		while(isRunning) {
			try {
				CommandInvokation<?> invoke = commandQueue.poll();
				if(invoke == null) {
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
						// do nothing
					}
					continue;
				} else {
					runCommand(invoke);
				}
				
			} catch (ApplicationException e) {
				error("Unknown error in command thread", e);
			}
		}
	}

	private <T> void runCommand(CommandInvokation<T> invoke) throws ApplicationException {
		T data;
		try {
			data = executeCommand(invoke);
		} catch (ApplicationException e) {
			error("Failed to execute command " + invoke.getCommand().getObjectName(), e);
			if(invoke.getCommandCallback() != null) {
				invoke.getCommandCallback().failure(e);
			}
			return;
		}
		if(invoke.getCommandCallback() != null) {
			invoke.getCommandCallback().success(data);
		}
	}
	
	private <T> T executeCommand(CommandInvokation<T> invoke) throws ApplicationException {
		if(!isCommandThread()) {
			throw new ApplicationException("Tried to execute command from outside command thread!");
		}
		Command<T> command = invoke.getCommand();
		
		info("Executing command: " + command.getObjectName());
		command.setCommandContext(invoke.getCommandContext());
		return command.execute();
	}

	@Override
	public <T> void enqueue(Command<T> command) {
		enqueue(command, null);
	}

	@Override
	public <T> void enqueue(Command<T> command, CommandCallback<T> callback) {
		debug("Queueing command: " + command.getObjectName());
		commandQueue.add(new CommandInvokation<T>(command, callback, new CommandContextImpl()));
	}

	@Override
	public <T> T enqueueAndWait(Command<T> command) throws ApplicationException {
		
		CommandResult<T> result = new CommandResult<>();
		
		enqueue(command, new CommandCallbackAdapter<T>() {
			@Override
			public void success(T data) {
				synchronized(result) {
					result.setData(data);
					result.notifyAll();
				}
			}
			public void failure(ApplicationException e) {
				synchronized(result) {
					result.setException(e);
					result.notifyAll();
				}
			}
		});
		
		synchronized(result) {
			while(!result.isSet()) {
				try {
					result.wait();
				} catch (InterruptedException e) {
					// don't care
				}
			}
		}
		
		return result.getData();
	}

	@Override
	public boolean isBusy() {
		return !busy.equals("");
	}

	@Override
	protected void init() {
		commandQueue = new LinkedList<>();
	}
	
	protected boolean isCommandThread() {
		return Thread.currentThread().equals(commandThread);
	}
	
	private class CommandContextImpl implements CommandContext {

		@Override
		public <T> T execute(Command<T> command) throws ApplicationException {
			return executeCommand(new CommandInvokation<T>(command, null, this));
		}
		
	}

	
	private static class CommandResult<T> {
		private T data;
		private boolean set = false;
		private ApplicationException exception;
		
		public void setException(ApplicationException e) {
			exception = e;
			set = true;
		}
		
		public void setData(T d) {
			data = d;
			set = true;
		}
		
		public T getData() throws ApplicationException {
			if(exception != null) {
				throw exception;
			} else {
				return data;
			}
		}
		
		public boolean isSet() {
			return set;
		}
	}
	
	private static class CommandInvokation <T> implements Callable<T> {
		private Command<T> command;
		private CommandCallback<T> callback;
		private CommandContext commandContext;
		
		public CommandInvokation(Command<T> cmd, CommandCallback<T> cmdCallback, CommandContext cmdContext) {
			command = cmd;
			callback = cmdCallback;
			commandContext = cmdContext;
		}
		
		Command<T> getCommand() {
			return command;
		}
		
		CommandCallback<T> getCommandCallback() {
			return callback;
		}
		
		CommandContext getCommandContext() {
			return commandContext;
		}

		@Override
		public T call() throws Exception {
			return command.execute();
		}
	}

}
