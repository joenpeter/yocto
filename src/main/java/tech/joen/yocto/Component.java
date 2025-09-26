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
  String getName();
  
  /**
   * Calls when the component is ceated.
   * For a factory, this means every time a new instance is initiated.
   * For a Singleton, this means on application startup. 
   */
  void create() throws ApplicationException;
  
  /**
   * Get the priority of this component implementation.
   * If multiple components implement the same interface,
   * the highest priority will win if a new component is instantiated based on interface.
   * 
   * @return the priority, with higher meaning higher priority
   */
  int getPriority();
  
  /**
   * Initialize this component - done before calling create(), right after calling default constructor
   * @param context the context of the application
   * @throws ApplicationException 
   */
  void init(Context context) throws ApplicationException;
  
  
}
