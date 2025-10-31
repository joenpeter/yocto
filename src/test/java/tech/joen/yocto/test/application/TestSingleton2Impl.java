/**
 * 
 */
package tech.joen.yocto.test.application;

import tech.joen.yocto.AbstractComponent;

/**
 * 
 */
public class TestSingleton2Impl extends AbstractComponent implements TestSingleton {

  public static final String COMPONENTNAME = "TestSingleton2";
  boolean started = false;
  boolean created = false;
  
  @Override
  public void create() {
    created = true;
  }
      
  @Override
  public void run() {
    info("Started TestSingleton");
    started = true;
  }

  @Override
  public boolean isStarted() {
    return started;
  }

  @Override
  public boolean isCreated() {
    return created;
  }
  
}
