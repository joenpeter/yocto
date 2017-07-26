/**
 * 
 */
package se.winquman.yocto.xcoder.factory;

import java.util.Map;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.engine.AbstractComponentFactory;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotFoundException;
import se.winquman.yocto.xcoder.decode.ConfigurationTreeDecoderTask;

/**
 * @author jpeter
 *
 */
public class DecoderTaskFactory extends AbstractComponentFactory {

	/**
	 * 
	 */
	public DecoderTaskFactory() {
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.AbstractComponentFactory#creatables(java.util.Map)
	 */
	@Override
	protected Map<String, Class> creatables(Map<String, Class> map) {
		map.put("se.winquman.yocto.core.engine.config.ConfigurationItem", ConfigurationTreeDecoderTask.class);
		
		return map;
	}

}
