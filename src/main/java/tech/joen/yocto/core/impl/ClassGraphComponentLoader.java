/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
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
  private Map<Class<?>, Class<Component>> componentClassMapping;
  private Map<String, Class<Singleton>> singletons;
  private Map<Class<Singleton>, List<Class<?>>> singletonClassMapping;
  
  @Override
  public void loadComponents() {
    components = new ConcurrentHashMap<>();
    componentClassMapping = new ConcurrentHashMap<>();
    singletons = new ConcurrentHashMap<>();
    singletonClassMapping = new ConcurrentHashMap<>(); 
    
    try (ScanResult result = new ClassGraph().enableAllInfo().enableStaticFinalFieldConstantInitializerValues().scan()) {
      ClassInfoList cs = result.getClassesImplementing(Component.class);
      cs = cs.getStandardClasses();
      cs.forEach(this::handleClass);
    }
  }
  
  private void handleClass(ClassInfo info) {
    if(isSingleton(info)) {
      singletons.put(findName(info), getSingletonClass(info));
      singletonClassMapping.put(getSingletonClass(info), info.getInterfaces().loadClasses());
    } else {
      components.put(findName(info), getComponentClass(info));
      addClassMappings(info, this::addComponentClassMapping);
    }
  }
  
  @SuppressWarnings("rawtypes")
  private void addClassMappings(ClassInfo info, BiConsumer<ClassInfo, Class> function) {
    Class clazz = info.loadClass();
    info.getInterfaces().forEach(i -> function.accept(i, clazz));
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  private void addComponentClassMapping(ClassInfo inter, Class origin) {
    componentClassMapping.put(inter.loadClass(), origin);
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

  @Override
  public Map<Class<?>, Class<Component>> getComponentClassMap() {
    return componentClassMapping;
  }

  @Override
  public Map<Class<Singleton>, List<Class<?>>> getSingletonClassMap() {
    return singletonClassMapping;
  }

}
