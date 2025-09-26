/**
 * 
 */
package tech.joen.yocto.test.application;

import tech.joen.yocto.AbstractComponent;

/**
 * 
 */
public class TestSingletonImpl extends AbstractComponent implements TestSingleton {

  boolean started = false;
  boolean created = false;
  
  @Override
  public void create() {
    created = true;
  }
  
  @Override
  public String getName() {
    return "TestSingleton1";
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
