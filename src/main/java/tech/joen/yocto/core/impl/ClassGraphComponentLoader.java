/**
 * 
 */
package tech.joen.yocto.core.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import tech.joen.yocto.Component;
import tech.joen.yocto.core.ComponentLoader;

/**
 * Uses the ClassGraph library to load any component on classpath
 */
public class ClassGraphComponentLoader implements ComponentLoader {

  private Map<String, Class<Component>> components;
  
  @Override
  public void loadComponents() {
    components = new ConcurrentHashMap<>();
    try (ScanResult result = new ClassGraph().enableAllInfo().enableStaticFinalFieldConstantInitializerValues().scan()) {
      ClassInfoList cs = result.getClassesImplementing(Component.class);
      cs = cs.getStandardClasses();
      cs.forEach(a -> {
              FieldInfo nameField = a.getFieldInfo("COMPONENTNAME");
              Class<Component> clazz = (Class<Component>) a.loadClass();
              if(nameField != null && nameField.getConstantInitializerValue() instanceof String name) {
                components.put(name, clazz);
              } else {
                components.put(clazz.getName(), clazz);
              }
          });
    }
  }

  @Override
  public Map<String,Class<Component>> getComponents() {
    return components;
  }

}
