package tech.joen.yocto.test.application;

import tech.joen.yocto.AbstractComponent;

public class TestComponentImpl extends AbstractComponent implements TestComponent {

  public static final String COMPONENTNAME = "TestComponent1";
  
  private boolean created = false;
  
  @Override
  public void create() {
    created = true;
  }
  
  @Override
  public boolean isCreated() {
    return created;
  }
}
