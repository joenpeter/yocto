package se.yoctocontainer.command;

import se.yoctocontainer.core.AbstractComponent;
import se.yoctocontainer.error.ApplicationException;

public class CommandCallbackAdapter<T> extends AbstractComponent implements CommandCallback<T> {

	@Override
	protected void init() {
		
	}

	@Override
	public void success(T data) {
		
	}

	@Override
	public void failure(ApplicationException e) {
		
	}

}
