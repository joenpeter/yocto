/**
 * 
 */
package se.winquman.yocto.xcoder.encode;

import java.io.Writer;
import java.util.List;

import se.winquman.yocto.core.YoctoObject;
import se.winquman.yocto.xcoder.Encodable;

/**
 * @author Joen
 * Encodes encodables to some format for saving or sending.
 * Typically some plain text format or XML, and then sends to a writer.
 * Only encodes to type A objects
 */
public interface Encoder<A extends Encodable> extends YoctoObject {
	
	public void encode(A object);
	
	public void encodeAll(List<A> objects);
	
	public void setWriter(Writer writer);

}
