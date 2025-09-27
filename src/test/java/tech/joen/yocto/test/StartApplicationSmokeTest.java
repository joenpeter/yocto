/**
 * 
 */
package tech.joen.yocto.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.joen.yocto.core.ComponentRegister;
import tech.joen.yocto.core.Context;
import tech.joen.yocto.core.TestContainer;
import tech.joen.yocto.test.application.TestComponent;
import tech.joen.yocto.test.application.TestSingleton;

/**
 * 
 */
class StartApplicationSmokeTest {
  public static final String TEST_SINGLETON_RUNNABLE = "TestSingleton1";
  public static final String TEST_COMPONENT = "TestComponent1";

  /**
   * 
   */
  @BeforeEach
  void setUp() throws Exception {}

  /**
   * 
   */
  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void baseApplicationStartup() throws Throwable{
    TestContainer container = TestContainer.builder().build();
    container.startup();
    ComponentRegister register = container.getRegister();
    assertNotNull(register, "Check component register exists");
//    register.getSingleton(TEST_SINGLETON_RUNNABLE)
//        .map(c -> (TestSingleton) c)
//        .map(c -> {assertTrue(c.isCreated(), "Check create was called on singleton"); return c;})
//        .map(c -> {assertTrue(c.isStarted(), "Check run was called on runnable singleton"); return c;})
//        .map(c -> {assertEquals(TEST_SINGLETON_RUNNABLE, c.getName(), "Check reported component name matches for Runnable Singleton"); return c;})
//        .orElseThrow();
    
    register.newComponent(TEST_COMPONENT)
        .map(c -> (TestComponent) c)
        .map(c -> {assertTrue(c.isCreated(), "Check create was called on component"); return c;})
        .orElseThrow();
  }

}
