package tech.joen.yocto.core;

/**
 * Container for starting a Yocto application and running in test 
 */
public class TestContainer {

  Context context; 

  public static TestContainerBuilder builder() {
    return new TestContainerBuilder();
  }
  
  private TestContainer() {
    
  }
 
  public void startup() {
    context = Bootstrap.startup();
  }
  
  public Context getContext() {
    return context;
  }
  
  public static class TestContainerBuilder {
    public TestContainer build() {
      TestContainer container = new TestContainer();
      return container;
    }
  }
}
