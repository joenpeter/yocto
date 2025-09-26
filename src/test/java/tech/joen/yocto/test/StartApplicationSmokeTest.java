/**
 * 
 */
package tech.joen.yocto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.Context;
import tech.joen.yocto.core.TestContainer;
import tech.joen.yocto.test.application.TestSingleton;

/**
 * 
 */
class StartApplicationSmokeTest {
  public static final String TEST_SINGLETON_RUNNABLE = "TestSingleton1";

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
    Context context = container.getContext();
    assertNotNull(context, "Check context exists");
//    Optional<Singleton> opt = context.getSingleton(TEST_SINGLETON_RUNNABLE);
//    assertFalse(opt.isEmpty(), "Check Runnable Singleton was loaded");
//    TestSingleton s = (TestSingleton) opt.get();
//    assertTrue(s.isCreated(), "Check create was called");
//    assertTrue(s.isStarted(), "Check run was called");
//    assertEquals(TEST_SINGLETON_RUNNABLE, s.getName(), "Check reported component name matches for Runnable Singleton");
  }

}
