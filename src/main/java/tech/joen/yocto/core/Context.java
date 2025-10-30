/**
 * 
 */
package tech.joen.yocto.core;

import java.util.Optional;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.impl.ApplicationException;

/**
 * This is the context of the currently running Yocto application.
 */
public interface Context {
  
  /**
   * Gets the name of the component that this context is associated with
   * @return the name of the component
   */
  String getComponentName();
  
  /**
   * Get a Singleton with the specific name.
   * @param name the name of the Singleton to get
   * @return the requested singleton, or empty if none exist
   */
  Optional<Singleton> getSingleton(String name);
  
  /**
   * Creates a new component from the named factory/component.
   * @param name the name of the component to create a new instance of
   * @return the newly created component, or empty if no factory with that name exists
   * @throws ApplicationException 
   */
  Optional<Component> newComponent(String name) throws ApplicationException;

}
