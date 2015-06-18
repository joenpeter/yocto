/**
 * 
 */
package se.winquman.yocto.core;

/**
 * @author Joen
 *
 */
public interface Session {
	
	public Object getVariable(String name);
	
	public void setVariable(String name, Object content);
	
	public Object removeVariable(String name);

}
