/**
 * 
 */
package tech.joen.yocto.core;

import java.util.List;
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
   * gets a map of all classes implementing Component, including any Singletons
   */
  Map<String, Class<Component>> getComponents();
  
  /**
   * gets a map of all classes implementing Singleton
   */
  Map<String, Class<Singleton>> getSingletons();
  
  /**
   * gets a map of all interfaces that have been implemented by a component, 
   * with its implementing component of the highest priority for that interface
   */
  Map<Class<?>, Class<Component>> getComponentClassMap();
  
  /**
   * gets a map of all interfaces that have been implemented by a component, 
   * with its implementing component of the highest priority for that interface
   */
  Map<Class<Singleton>, List<Class<?>>> getSingletonClassMap();
}
