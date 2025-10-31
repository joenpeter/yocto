/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.ComponentFactory;
import tech.joen.yocto.core.ComponentLoader;
import tech.joen.yocto.core.ComponentRegister;
import tech.joen.yocto.core.ComponentRegisterBuilder;
import tech.joen.yocto.core.Context;

/**
 * 
 */
public class ComponentRegisterImpl implements ComponentRegister {
  private Map<String, Class<Component>> components;
  private Map<String, Singleton> singletons;
  private Map<Class<Component>, Class<Component>> componentMappings;
  private Map<Class<Singleton>, Singleton> singletonMappings;
  private ComponentFactory factory;

  private ComponentRegisterImpl(ComponentFactory factory, 
      Map<String, Class<Singleton>> singletonClasses, 
      Map<Class<Singleton>, Class<Singleton>> singletonInterfaceMappings) {
    
    this.factory = factory;
    Map<String, Singleton> map = new ConcurrentHashMap<>();
    // TODO Rework how we handle singletons to put them all in 2 lists
    singletonClasses.forEach((name, clazz) -> map.put(name, createSingleton(clazz, name)));
    singletons = Map.copyOf(map);
  }
    
  private Singleton createSingleton(Class<Singleton> clazz, String name) {
    return factory.createComponent(clazz, createContext(name));
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends Component> Optional<T> newComponent(String name) throws ApplicationException {
    try {
      return Optional.ofNullable(components.get(name))
          .map(c -> factory.createComponent(c, createContext(name)))
          .map(c -> (T) c);
    } catch (YoctoRuntimeApplicationException e) {
      throw e.toApplicationException();
    }
  }

  @Override
  public <T extends Component> Optional<T> newComponent(Class<T> clazz) throws ApplicationException {
    try {
      return Optional.ofNullable(componentMappings.get(clazz))
          .map(c -> factory.createComponent(c, createContext(null)))
          .filter(clazz::isInstance)
          .map(clazz::cast);
    } catch (YoctoRuntimeApplicationException e) {
      throw e.toApplicationException();
    }
  }

  @SuppressWarnings({"unchecked"})
  @Override
  public <T extends Singleton> Optional<T> getSingleton(String name) {
    return Optional.ofNullable(singletons.get(name)).map(c -> (T) c);
  }

  @Override
  public <T extends Singleton> Optional<T> getSingleton(Class<T> clazz) {
    return Optional.ofNullable(singletonMappings.get(clazz))
        .filter(clazz::isInstance)
        .map(clazz::cast);
  }

  @Override
  public List<Singleton> allSingletons() {
    return List.copyOf(singletons.values());
  }

  private Context createContext(String name) {
    return new ContextImpl(this, name);
  }
  
  public static ComponentRegisterBuilder builder() {
    return new ComponentRegisterBuilderImpl();
  }
  
  public static class ComponentRegisterBuilderImpl implements ComponentRegisterBuilder {

    ComponentLoader loader;
    ComponentFactory factory;

    @Override
    public ComponentRegister build() {
      // TODO get the secondary singleton list from loader
      ComponentRegisterImpl register = new ComponentRegisterImpl(factory, loader.getSingletons(), null);
      // TODO also get component mapping based on class
      register.components = Map.copyOf(loader.getComponents());
      return register;
    }

    @Override
    public ComponentRegisterBuilder fromLoader(ComponentLoader loader) {
      this.loader = loader;
      return this;
    }

    @Override
    public ComponentRegisterBuilder withFactory(ComponentFactory factory) {
      this.factory = factory;
      return this;
    }
    
  }

}
