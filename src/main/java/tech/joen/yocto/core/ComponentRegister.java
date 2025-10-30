/**
 * 
 */
package tech.joen.yocto.core;

import java.util.Optional;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.impl.ApplicationException;

/**
 * A register of all loaded components, blueprints and singletons
 */
public interface ComponentRegister {
  
  public <T extends Component> Optional<T> newComponent(String name) throws ApplicationException;
  
  public <T extends Singleton> Optional<T> getSingleton(String name);
  
}
