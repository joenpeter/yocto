/**
 * 
 */
package se.yoctocontainer.xcoder.decode;

import se.yoctocontainer.core.Component;
import se.yoctocontainer.xcoder.Encodable;

/**
 * @author jpeter
 *
 */
public interface DecoderTask extends Component {

	public Encodable decode(String msg);
	
}
