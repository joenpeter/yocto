package tech.joen.yocto.test.application;

import tech.joen.yocto.AbstractComponent;

public class TestComponent2Impl extends AbstractComponent implements TestComponent {

  public static final String COMPONENTNAME = "TestComponent2";
  
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
