package se.winquman.yocto.xcoder;

import java.util.List;

import se.winquman.yocto.core.YoctoObject;

/**
 * Will handle encoded objects of type A.
 * @author Joen
 *
 * @param <A>
 */
public interface EncodeReader<A> extends YoctoObject {
	
	public A readNext();
	
	public boolean hasNext();
	
	public List<A> readAll();

}
