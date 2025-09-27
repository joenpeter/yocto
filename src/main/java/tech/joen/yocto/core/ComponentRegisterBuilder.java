/**
 * 
 */
package tech.joen.yocto.core;

/**
 *
 */
public interface ComponentRegisterBuilder {

  ComponentRegister build();
  
  ComponentRegisterBuilder fromLoader(ComponentLoader loader);
  
  ComponentRegisterBuilder withFactory(ComponentFactory factory);
}
