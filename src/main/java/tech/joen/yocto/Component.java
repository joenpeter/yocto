/**
 * 
 */
package tech.joen.yocto;

import tech.joen.yocto.core.Context;
import tech.joen.yocto.core.impl.ApplicationException;

/**
 * This represent a single component inside a Yocto application.
 * A component can in runtime be initiated as a singleton or as a factory.
 */
public interface Component {
  int PRIORITY_DEFAULT = 0;

  /**
   * Globally unique name of this component
   * @return
   */
  String getComponentName();
  
  /**
   * Get the priority of this component implementation.
   * If multiple components implement the same interface,
   * the highest priority will win if a new component is instantiated based on interface.
   * 
   * @return the priority, with higher meaning higher priority
   */
  int getPriority();
  
  /**
   * Initialize this component - done before calling create(), right after calling default constructor.
   * This is called from the component framework, and can only be called once.
   * @param context the context of the application
   * @throws ApplicationException if something goes wrong during init
   */
  void init(Context context) throws ApplicationException;
  
  
}
