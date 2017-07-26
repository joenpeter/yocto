/**
 * 
 */
package se.winquman.yocto.xcoder.decode;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.xcoder.Encodable;

/**
 * @author jpeter
 *
 */
public interface DecoderTask extends Component {

	public Encodable decode(String msg);
	
}
