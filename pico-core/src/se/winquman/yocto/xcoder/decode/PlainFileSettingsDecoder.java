/**
 * 
 */
package se.winquman.yocto.xcoder.decode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import se.winquman.yocto.xcoder.Encodable;

/**
 * @author jpeter
 *
 */
public class PlainFileSettingsDecoder<A extends Encodable> extends AbstractDecoder<A> implements
		Decoder<A> {

	protected BufferedReader buffer;
	
	@Override
	protected String fetchNext() throws IOException {
		try {
			return buffer.readLine();
		} catch (IOException e) {
			error("Trouble reading from file", e);
			throw e;
		}
	}

	@Override
	protected String waitAndFetchNext() throws IOException{
		// Not actually needed in this implementation
		return fetchNext();
	}

	@Override
	public void setReader(Reader r) {
		reader = r;
		buffer = new BufferedReader(reader);
	}

}
