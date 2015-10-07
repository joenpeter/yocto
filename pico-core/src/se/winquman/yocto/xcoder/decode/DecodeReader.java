package se.winquman.yocto.xcoder.decode;

import java.util.List;

import se.winquman.yocto.core.YoctoObject;

/**
 * Will handle encoded objects of type A.
 * @author Joen
 *
 * @param <A>
 */
public interface DecodeReader<A> extends YoctoObject {
	
	public A readNext();
	
	public boolean hasNext();
	
	public List<A> readAll();

}
