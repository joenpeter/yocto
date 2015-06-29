/**
 * 
 */
package se.winquman.yocto.xcoder;

import java.util.List;

import se.winquman.yocto.core.YoctoObject;

/**
 * @author Joen
 * Actually writes encoded objects to somewhere, typically a stream
 * Will handle encoded objects of type A.
 */
public interface DecodeWriter<A> extends YoctoObject {
	
	public void write(A encoded);
	
	public void writeAll(List<A> encodeds);

}
