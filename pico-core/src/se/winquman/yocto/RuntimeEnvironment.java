/**
 * 
 */
package se.winquman.yocto;

import java.util.List;
import java.util.Map;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.core.Instance;
import se.winquman.yocto.core.Runner;
import se.winquman.yocto.core.Version;

/**
 * @author Joen
 *
 */
public interface RuntimeEnvironment {
	
	public Map<String, Class> defaultComponents(Map<String, Class> components);
	
	public Map<String,Class> instances(Map<String,Class> instances);
	
	public Map<String,Class> runners(Map<String,Class> runners);
	
	public Map<String,Class> componentFactories(Map<String,Class> factories);
	
	public Map<String,String> settings(Map<String,String> settings);
	
	public Version version();

}
