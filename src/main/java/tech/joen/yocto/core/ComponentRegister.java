/**
 * 
 */
package tech.joen.yocto.core;

import java.util.List;
import java.util.Optional;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.impl.ApplicationException;

/**
 * A register of all loaded components, blueprints and singletons
 */
public interface ComponentRegister {
  
  <T extends Component> Optional<T> newComponent(String name) throws ApplicationException;
  
  <T extends Singleton> Optional<T> getSingleton(String name);
  
  List<Singleton> allSingletons();

  <T extends Component> Optional<T> newComponent(Class<T> clazz) throws ApplicationException;
  
  <T extends Singleton> Optional<T> getSingleton(Class<T> clazz);
  
}
