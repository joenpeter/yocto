/**
 * 
 */
package tech.joen.yocto.core;

import java.util.Map;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;

/**
 * Will load references to all components, in a way defined in the implementation.
 */
public interface ComponentLoader {

  /**
   * Loads reference to all components into memory
   */
  void loadComponents();
  
  /**
   * gets a list of all classes implementing Component, including ant Singletons
   */
  Map<String, Class<Component>> getComponents();
  
  Map<String, Class<Singleton>> getSingletons();
}
