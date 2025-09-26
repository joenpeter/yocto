/**
 * 
 */
package tech.joen.yocto.test.application;

import tech.joen.yocto.Singleton;

/**
 * 
 */
public interface TestSingleton extends Singleton, Runnable{

  boolean isStarted();
  boolean isCreated();
}
