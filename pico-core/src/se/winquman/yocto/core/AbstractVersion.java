/**
 * 
 */
package se.winquman.yocto.core;

/**
 * @author jpeter
 *
 */
public abstract class AbstractVersion extends AbstractComponent implements Version {

	protected int major;
	protected int minor;
	protected int patch;
	protected int revision;
	
	/**
	 * 
	 */
	public AbstractVersion() {
		
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#getMajor()
	 */
	@Override
	public int getMajor() {
		return major;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#getMinor()
	 */
	@Override
	public int getMinor() {
		return minor;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#getPatch()
	 */
	@Override
	public int getPatch() {
		return patch;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#getRevision()
	 */
	@Override
	public int getRevision() {
		return revision;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#getVersionString(int)
	 */
	@Override
	public String getVersionString(int numberOfFields) {
		int i = numberOfFields;
		String result = "";
		
		if(i > 0) {
			result = result + major;
			i--;
		}
		if(i > 0) {
			result = result + "." + minor;
			i--;
		}
		if(i > 0) {
			result = result + "." + patch;
			i--;
		}
		if(i > 0) {
			result = result + "." + revision;
			i--;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#setVersion(int, int, int, int)
	 */
	@Override
	public void setVersion(int major, int minor, int patch, int revision) {
		this.major = major;
		this.minor = minor;
		this.patch = patch;
		this.revision = revision;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Version#isCompatable(se.winquman.yocto.core.Version)
	 */
	@Override
	public abstract boolean isCompatable(Version version);

}
