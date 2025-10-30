/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import tech.joen.yocto.Component;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.ComponentLoader;

/**
 * Uses the ClassGraph library to load any component on classpath
 */
public class ClassGraphComponentLoader implements ComponentLoader {

  private Map<String, Class<Component>> components;
  private Map<String, Class<Singleton>> singletons;
  
  @Override
  public void loadComponents() {
    components = new ConcurrentHashMap<>();
    singletons = new ConcurrentHashMap<>();
    try (ScanResult result = new ClassGraph().enableAllInfo().enableStaticFinalFieldConstantInitializerValues().scan()) {
      ClassInfoList cs = result.getClassesImplementing(Component.class);
      cs = cs.getStandardClasses();
      cs.forEach(this::handleClass);
    }
  }
  
  private void handleClass(ClassInfo info) {
    if(isSingleton(info)) {
      singletons.put(findName(info), getSingletonClass(info));
    } else {
      components.put(findName(info), getComponentClass(info));
    }
  }
  
  private boolean isSingleton(ClassInfo info) {
    return info.implementsInterface(Singleton.class);
  }

  @SuppressWarnings("unchecked")
  private Class<Singleton> getSingletonClass(ClassInfo info) {
    return (Class<Singleton>) info.loadClass();
  }

  @SuppressWarnings("unchecked")
  private Class<Component> getComponentClass(ClassInfo info) {
    return (Class<Component>) info.loadClass();
  }

  private String findName(ClassInfo info) {
    FieldInfo nameField = info.getFieldInfo("COMPONENTNAME");
    if(nameField != null && nameField.getConstantInitializerValue() instanceof String name) {
      return name;
    } else {
      return info.getSimpleName();
    }    
  }

  @Override
  public Map<String,Class<Component>> getComponents() {
    return components;
  }

  @Override
  public Map<String, Class<Singleton>> getSingletons() {
    return singletons;
  }

}
