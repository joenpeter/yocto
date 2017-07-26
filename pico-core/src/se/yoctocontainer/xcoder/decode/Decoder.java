/**
 * 
 */
package se.yoctocontainer.xcoder.decode;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import se.yoctocontainer.core.Component;
import se.yoctocontainer.xcoder.Encodable;

/**
 * @author Joen
 * Decodes objects from an EncodeReader.
 * Will fetch the object from the reader and then decode.
 * Only decodes from type A objects.
 */
public interface Decoder<A extends Encodable> extends Component {

	/**
	 * first fetches object from reader, then decodes it.
	 * @return
	 * @throws IOException 
	 */
	public A decodeNext() throws IOException;
	
	/**
	 * Waits until a new A is available, then returns it
	 * @return
	 * @throws IOException 
	 */
	public A waitAndDecodeNext() throws IOException;
	
	public List<A> decodeAll() throws IOException;
	
	public boolean hasNext();

	void setReader(Reader reader);
	
	void setDecoderTask(DecoderTask task);
	
}
