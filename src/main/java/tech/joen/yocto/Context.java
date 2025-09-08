/**
 * 
 */
package tech.joen.yocto;

import java.util.Optional;

/**
 * This is the context of the currently running Yocto application.
 */
public interface Context {
  
  /**
   * Get the name of this Yocto application.
   * @return the name of the application
   */
  String getApplicationName();
  
  /**
   * Get an instance of the component with the specific name.
   * 
   * If this component is a Singleton, return the existing Singleton.
   * If this component is a factory, return a new instance from this factory.
   * @param name the name of the component to get
   * @return an instance of the component, or empty if no component with that name exists
   */
  Optional<Component> getComponent(String name);
  
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
   */
  Optional<Component> newComponent(String name);

}
