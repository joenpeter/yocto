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
  /**
   * Default priority setting
   */
  int COMPONENTPRIORITY = 0;
  
  /**
   * The name of the static field that can be set to indicate name of the component.
   * The field must be of type String.
   * If it is not set, a name will be generated.
   */
  String NAME = "COMPONENTNAME";
  
  /**
   * The name of the static field that can be set to signify priority.
   * This should be of type int, and higher value means higher priority.
   * Only the highest priority implementation of a specific interface will be available
   * from the component registry using the interface.
   */
  String PRIORITY = "COMPONENTPRIORITY";

  /**
   * Globally unique name of this component
   * @return
   */
  String getComponentName();
  
  /**
   * Initialize this component - done before calling create(), right after calling default constructor.
   * This is called from the component framework, and can only be called once.
   * @param context the context of the application
   * @throws ApplicationException if something goes wrong during init
   */
  void init(Context context) throws ApplicationException;
  
  
}
