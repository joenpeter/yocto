/**
 * 
 */
package tech.joen.yocto.core.impl;

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
  private ComponentFactory factory;

  public ComponentRegisterImpl(ComponentFactory factory) {
    components = new ConcurrentHashMap<>();
    singletons = new ConcurrentHashMap<>();
    this.factory = factory;
  }
  
  @Override
  public <T extends Component> Optional<T> newComponent(String name) throws ApplicationException {
    try {
      Context context = createContext();
      return Optional.ofNullable(components.get(name))
          .map(c -> factory.createComponent(c, context));
    } catch (YoctoRuntimeApplicationException e) {
      throw e.toApplicationException();
    }
  }

  @Override
  public <T extends Singleton> Optional<T> getSingleton(String name) {
    return (Optional<T>) Optional.ofNullable(singletons.get(name));
  }

  private Context createContext() {
    return new ContextImpl(this);
  }
  
  public static ComponentRegisterBuilder builder() {
    return new ComponentRegisterBuilderImpl();
  }
  
  public static class ComponentRegisterBuilderImpl implements ComponentRegisterBuilder {

    ComponentLoader loader;
    ComponentFactory factory;
    
    @Override
    public ComponentRegister build() {
      ComponentRegisterImpl register = new ComponentRegisterImpl(factory);
      register.components = loader.getComponents();
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
