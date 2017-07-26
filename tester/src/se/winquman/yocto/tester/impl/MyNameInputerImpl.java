/**
 * 
 */
package se.winquman.yocto.tester.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import se.winquman.yocto.tester.MyNameInputer;
import se.winquman.yocto.tester.MyNameRunner;
import se.yoctocontainer.core.AbstractInstance;

/**
 * @author jpeter
 *
 */
public class MyNameInputerImpl extends AbstractInstance implements MyNameInputer {

	/**
	 * 
	 */
	public MyNameInputerImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		info("Initiating name getter");
		String name = null;
		System.out.println("Type your name:");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while(name == null) {
			try {
				name = input.readLine();
				info("Noted name: " + name);
				MyNameRunner runner = (MyNameRunner) context.getInstance("MyNameRunner");
				runner.setMyName(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
