/**
 * 
 */
package tech.joen.yocto.core;

import tech.joen.yocto.Component;

/**
 * Creates new components and initializes them correctly
 */
public interface ComponentFactory {

  public <T extends Component> T createComponent(Class<T> from, Context context);

}
