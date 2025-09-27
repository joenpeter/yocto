/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import tech.joen.yocto.Component;
import tech.joen.yocto.core.ComponentFactory;
import tech.joen.yocto.core.Context;

/**
 * 
 */
public class ComponentFactoryImpl implements ComponentFactory {

  @Override
  public <T extends Component> T createComponent(Class<Component> from, Context context) {
    T component = createComponentInternal(from, context);
    setup(component);
    return component;
  }

  @Override
  public List<Component> createTogether(List<Class<Component>> from, Context context) {
    List<Component> cList = new ArrayList<>();
    for(Class<Component> clazz: from) {
      Component c = createComponentInternal(clazz, context);
      cList.add(c);
    }
    for(Component c: cList) {
      setup(c);
    }
    return cList;
  }

  private <T extends Component> T createComponentInternal(Class<Component> from, Context context) {
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

  /**
   * Sets up the component, ie all user-specified operations for component creation
   * @param c
   */
  private void setup(Component c) {
    try {
      c.create();
    } catch (ApplicationException e) {
      throw YoctoRuntimeApplicationException.from(null, "Failed to setup new component: " + c.getName());
    }
  }

}
