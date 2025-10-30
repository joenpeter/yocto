/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.lang.reflect.InvocationTargetException;
import tech.joen.yocto.Component;
import tech.joen.yocto.core.ComponentFactory;
import tech.joen.yocto.core.Context;

/**
 * 
 */
public class ComponentFactoryImpl implements ComponentFactory {

  @Override
  public <T extends Component> T createComponent(Class<T> from, Context context) {
    T component = createComponentInternal(from, context);
    return component;
  }

  @SuppressWarnings("unchecked")
  private <T extends Component> T createComponentInternal(Class<T> from, Context context) {
    try {
      Component c = from.getConstructor().newInstance();
      init(c, context);
      return (T) c;
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException | NoSuchMethodException | SecurityException | ApplicationException e) {

      throw YoctoRuntimeApplicationException.from(e, "Failed to create component from factory: " + from.getName());
    }
  }

  /**
   * Initializes the component, ie all background inits that need to be done
   * @param c
   * @throws ApplicationException 
   */
  private void init(Component c, Context context) throws ApplicationException {
    c.init(context);
  }

}
