/**
 * 
 */
package se.yoctocontainer.core;

/**
 * @author Joen
 *
 */
public interface Version {

	public int getMajor();
	
	public int getMinor();
	
	public int getPatch();
	
	public int getRevision();
	
	public String getVersionString(int numberOfFields);
	
	/**
	 * Sets the data of this version.
	 * Typically can only be called once.
	 * @param major
	 * @param minor
	 * @param patch
	 * @param revision
	 */
	public void setVersion(int major, int minor, int patch, int revision);
	
	/**
	 * Checks compatability between this version and argument
	 * @param version
	 * @return true if they are compatable, else false
	 */
	public boolean isCompatable(Version version);
}
