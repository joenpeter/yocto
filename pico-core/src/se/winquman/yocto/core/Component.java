/**
 * 
 */
package se.winquman.yocto.core;

/**
 * @author Joen
 *
 */
public interface Component extends YoctoObject {
	
	public Component replicate();
	
	public void destroy();

}
