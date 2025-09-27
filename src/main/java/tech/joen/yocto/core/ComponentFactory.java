/**
 * 
 */
package tech.joen.yocto.core;

import java.util.List;
import tech.joen.yocto.Component;

/**
 * Creates new components and initializes them correctly
 */
public interface ComponentFactory {

  public <T extends Component> T createComponent(Class<Component> from, Context context);
  
  public List<Component> createTogether(List<Class<Component>> from, Context context); 
}
