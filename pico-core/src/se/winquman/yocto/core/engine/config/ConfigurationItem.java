/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.xcoder.Encodable;

/**
 * @author Joen
 *
 */
public interface ConfigurationItem extends Component, Encodable {

	public String getName();
	
}
