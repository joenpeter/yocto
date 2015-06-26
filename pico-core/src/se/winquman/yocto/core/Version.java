/**
 * 
 */
package se.winquman.yocto.core;

/**
 * @author Joen
 *
 */
public class Version {

	int head;
	int major;
	int minor;
	int revision;
	String program;
	
	public Version(Integer head, Integer major, Integer minor, Integer revision) {
		this.head = head;
		this.major = major;
		this.minor = minor;
		this.revision = revision;
	}
	
	public String toString() {
		String text = "" + head + "." + major + "." + minor;
		if(revision != 0) {
			return text + "-r" + revision;
		}
		return text;
	}
}
