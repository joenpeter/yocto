package se.winquman.yocto.tester.impl;

import java.util.Arrays;
import java.util.List;

import se.yoctocontainer.command.AbstractCommand;
import se.yoctocontainer.error.ApplicationException;
import se.yoctocontainer.error.ConfigurationException;
import se.yoctocontainer.ui.InputCommand;

public class DisplayNameCommand extends AbstractCommand<String> implements InputCommand<String,String> {

	private String input;
	private String helloPhrase;
	
	@Override
	public List<String> getUserFriendlyNames() {
		return Arrays.asList(new String[]{"name"});
	}

	@Override
	protected void init() throws ConfigurationException {
		helloPhrase = context.getConfigurator().getStringConfiguration("/General/helloMessage");
	}

	@Override
	public String execute() throws ApplicationException {
		System.out.println("Hello " + input + ", " + helloPhrase);
		return "hi";
	}

	@Override
	public void setInput(String input) {
		this.input = input;
	}

}
