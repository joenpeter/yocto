package tech.joen.yocto.test.application;

import tech.joen.yocto.AbstractComponent;

public abstract class SomeAbstractComponent extends AbstractComponent implements TestComponent {

  public static final String COMPONENTNAME = "SomeAbstractComponent";
  
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
