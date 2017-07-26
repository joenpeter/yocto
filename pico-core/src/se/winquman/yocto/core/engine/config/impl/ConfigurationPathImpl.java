/**
 * 
 */
package se.winquman.yocto.core.engine.config.impl;

import se.winquman.yocto.core.AbstractComponent;
import se.winquman.yocto.core.engine.config.ConfigurationPath;

/**
 * @author jpeter
 *
 */
public class ConfigurationPathImpl extends AbstractComponent implements
		ConfigurationPath {

	private String path;
	private int current;
	private String[] splitPath;

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationPath#setPath(java.lang.String)
	 */
	@Override
	public void setPath(String p) {
		path = p;
		splitPath = path.split("/");
		current = 0;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationPath#next()
	 */
	@Override
	public String next() {
		debug(splitPath[current] + " -> " + splitPath[current+1]);
		current++;
		return splitPath[current];
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationPath#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return splitPath.length > (current+1);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {

	}

}
