/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.Context;

/**
 * Base implementation of Context
 */
public class ContextImpl implements Context {
  Map<String, Class<Component>> components;
  Map<String, Singleton> singletons;
  
  public ContextImpl() {
    components = new ConcurrentHashMap<>();
    singletons = new ConcurrentHashMap<>();
  }

  @Override
  public Optional<Singleton> getSingleton(String name) {
    return Optional.ofNullable(singletons.get(name));
  }

  @Override
  public Optional<Component> newComponent(String name) throws ApplicationException {
    try {
      return Optional.ofNullable(components.get(name))
          .map(this::newComponentFromClass);
    } catch (YoctoRuntimeApplicationException e) {
      throw e.toApplicationException();
    }
  }
  
  private Component newComponentFromClass(Class<Component> clazz) {
    try {
      Component c = clazz.getConstructor().newInstance();
      return initialize(c);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException | NoSuchMethodException | SecurityException | ApplicationException e) {

      throw YoctoRuntimeApplicationException.from(e, "Failed to create component from factory: " + clazz.getName());
    }
  }

  private Component initialize(Component c) throws ApplicationException {
    c.init(this);
    c.create();
    return c;
  }

}
