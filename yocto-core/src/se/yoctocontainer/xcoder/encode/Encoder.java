/**
 * 
 */
package se.yoctocontainer.xcoder.encode;

import java.io.Writer;
import java.util.List;

import se.yoctocontainer.core.YoctoObject;
import se.yoctocontainer.xcoder.Encodable;

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
