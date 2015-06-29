/**
 * 
 */
package se.winquman.yocto.xcoder;

import java.util.List;

import se.winquman.yocto.core.YoctoObject;

/**
 * @author Joen
 * Decodes objects from an EncodeReader.
 * Will fetch the object from the reader and then decode.
 * Only decodes from type A objects.
 */
public interface Decoder<A> extends YoctoObject {

	/**
	 * first fetches object from reader, then decodes it.
	 * @return
	 */
	public Encodable decodeNext();
	
	public List<Encodable> decodeAll();
	
	public boolean hasNext();
	
	public void setReader(EncodeReader<A> reader);
}
