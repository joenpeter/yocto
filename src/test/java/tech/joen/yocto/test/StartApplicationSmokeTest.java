/**
 * 
 */
package tech.joen.yocto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
  public static final String TEST_COMPONENT_HIGHER_PRIO = "TestComponent2";
  public static final String TEST_SINGLETON_HIGHER_PRIO = "TestSingleton2";
  public static final String NOT_INITIALIZABLE_COMPONENT = "MyAbstractComponent";

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
    register.newComponent(TEST_COMPONENT)
        .map(c -> (TestComponent) c)
        .map(c -> {assertTrue(c.isCreated(), "Check create was called on component"); return c;})
        .map(c -> {assertEquals(TEST_COMPONENT, c.getComponentName(), "Check reported component name matches for Runnable Singleton"); return c;})
        .orElseThrow();
    
    register.getSingleton(TEST_SINGLETON_RUNNABLE)
        .map(c -> (TestSingleton) c)
        .map(c -> {assertTrue(c.isCreated(), "Check create was called on singleton"); return c;})
        .map(c -> {assertTrue(c.isStarted(), "Check run was called on runnable singleton"); return c;})
        .map(c -> {assertEquals(TEST_SINGLETON_RUNNABLE, c.getComponentName(), "Check reported component name matches for Runnable Singleton"); return c;})
        .orElseThrow();
    
    // Non-initializable component should result in empty response, not exception
    assertFalse(register.newComponent(NOT_INITIALIZABLE_COMPONENT).isPresent());
  }
  
  @Disabled("Not yet implemented.")
  @Test
  void multiImplementationTest() {
    TestContainer container = TestContainer.builder().build();
    container.startup();
    ComponentRegister register = container.getRegister();
    register.newComponent(TestComponent.class)
        .map(c -> {assertEquals(TEST_COMPONENT_HIGHER_PRIO, c.getComponentName(), "Check name matches the higher priority component"); return c;})
        .orElseThrow();
    
    register.getSingleton(TestSingleton.class)
        .map(c -> {assertEquals(TEST_SINGLETON_HIGHER_PRIO, c.getComponentName(), "Check name matches higher priority singleton"); return c;})
        .orElseThrow();
  }

}
