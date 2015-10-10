/**
 * 
 */
package se.winquman.yocto.xcoder.decode;

import se.winquman.yocto.core.AbstractComponent;
import se.winquman.yocto.core.engine.config.ConfigurationFolder;
import se.winquman.yocto.core.engine.config.ConfigurationItem;
import se.winquman.yocto.core.engine.config.ConfigurationPoint;
import se.winquman.yocto.xcoder.Encodable;

/**
 * @author jpeter
 *
 */
public class ConfigurationTreeDecoderTask extends AbstractComponent implements
		DecoderTask {


	/* (non-Javadoc)
	 * @see se.winquman.yocto.xcoder.decode.DecoderTask#decode(java.lang.String)
	 */
	@Override
	public Encodable decode(String msg) {
		if(msg == null) {
			return null;
		}
		
		if(msg.startsWith("[")) {
			// This is a folder
			return decodeFolder(msg);
		} else {
			return decodeItem(msg);
		}
	}

	private Encodable decodeItem(String msg) {
		debug("Decoding config item: " + msg);
		String ss[] = msg.split("=");
		if (ss.length < 3) {
			// This is not a valid element
			warn("Did not manage to decode object! " + msg);
			return null;
		}
		
		ConfigurationPoint item = (ConfigurationPoint) context.newComponent("ConfigurationPoint");
		item.setName(ss[0]);
		item.setValue(decodeValue(ss[1], ss[2]));
		debug("Adding configuration point: " + item);
		return item;
	}

	private Object decodeValue(String type, String value) {
		if(type.equals("boolean")) {
			// case boolean
			return Boolean.parseBoolean(value);
		} else if (type.equals("int")) {
			// case int
			return Integer.parseInt(value);
		} else {
			// case String
			return value;
		}
	}

	private Encodable decodeFolder(String msg) {
		ConfigurationFolder folder = (ConfigurationFolder) context.newComponent("ConfigurationFolder");
		String newMsg = msg.substring(1, msg.length()-1);
		folder.setName(newMsg);
		debug("Adding configuration folder: " + folder);
		return folder;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {

	}

}
