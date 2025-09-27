package tech.joen.yocto.core;

/**
 * Container for starting a Yocto application and running in test 
 */
public class TestContainer {

  ComponentRegister register; 

  public static TestContainerBuilder builder() {
    return new TestContainerBuilder();
  }
  
  private TestContainer() {
    
  }
 
  public void startup() {
    register = Bootstrap.startup();
  }
  
  public ComponentRegister getRegister() {
    return register;
  }
  
  public static class TestContainerBuilder {
    public TestContainer build() {
      TestContainer container = new TestContainer();
      return container;
    }
  }
}
