/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.util.Optional;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.ComponentRegister;
import tech.joen.yocto.core.Context;

/**
 * Base implementation of Context
 */
public class ContextImpl implements Context {
  private ComponentRegister register;
  private String name;
  
  public ContextImpl(ComponentRegister register, String name) {
    this.register = register;
    this.name = name;
  }

  @Override
  public Optional<Singleton> getSingleton(String name) {
    return register.getSingleton(name);
  }

  @Override
  public Optional<Component> newComponent(String name) throws ApplicationException {
    return register.newComponent(name);
  }

  @Override
  public String getComponentName() {
    return name;
  }

}
