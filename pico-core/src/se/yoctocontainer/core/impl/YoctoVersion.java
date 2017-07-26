/**
 * 
 */
package se.yoctocontainer.core.impl;

import se.yoctocontainer.core.AbstractVersion;
import se.yoctocontainer.core.Version;

/**
 * @author jpeter
 *
 */
public class YoctoVersion extends AbstractVersion {

	/**
	 * 
	 */
	public YoctoVersion() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractVersion#isCompatable(se.winquman.yocto.core.Version)
	 */
	@Override
	public boolean isCompatable(Version version) {
		return major == version.getMajor()
				&& minor == version.getMinor();
	}
}
