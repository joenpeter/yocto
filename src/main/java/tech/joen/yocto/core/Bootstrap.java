/**
 * 
 */
package tech.joen.yocto.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import tech.joen.yocto.Singleton;
import tech.joen.yocto.core.impl.ClassGraphComponentLoader;
import tech.joen.yocto.core.impl.ComponentFactoryImpl;
import tech.joen.yocto.core.impl.ComponentRegisterImpl;
import tech.joen.yocto.core.impl.ContextImpl;

/**
 * Bootstraps the yocto container. Does the following:
 * 
 * - Creates a context for the application
 * - Loads any components it may find
 *   - Remember implemented interfaces
 *   - Remember designated priority
 * - Initiates all singletons it may find
 * - Start startable singletons
 * 
 * TODO
 * ComponentLoader + Scanner?
 * ComponentRegister
 * ComponentFactory
 * 
 */
public class Bootstrap {
  
  static Logger logger;

  /**
   * @param args
   */
  public static void main(String[] args) {
    startup();
  }
  
  static ComponentRegister startup() {
    assembleLogger();
    logger.log(Level.INFO, "Starting to log. Startup initiated.");
    
    
    ComponentRegister register = loadComponents();
    startStartables(register);
    
    return register;
  }

  private static void startStartables(ComponentRegister register) {
    register.allSingletons().stream()
        .filter(Runnable.class::isInstance)
        .map(Bootstrap::logStartup)
        .map(Runnable.class::cast)
        .forEach(Bootstrap::startComponent);
  }
  
  private static Runnable startComponent(Runnable c) {
    Thread.startVirtualThread(c);
    return c;
  }
  
  private static Singleton logStartup(Singleton c) {
    logger.log(Level.INFO, "STARTING: " + c.getComponentName());
    return c;
  }

  private static ComponentRegister loadComponents() {
    ComponentLoader loader = createComponentLoader();
    loader.loadComponents();
    ComponentFactory factory = createComponentFactory();
    ComponentRegisterBuilder register = createComponentRegisterBuilder();
    return register.fromLoader(loader).withFactory(factory).build();
  }

  private static ComponentFactory createComponentFactory() {
    return new ComponentFactoryImpl();
  }

  private static ComponentRegisterBuilder createComponentRegisterBuilder() {
    return ComponentRegisterImpl.builder();
  }

  private static ComponentLoader createComponentLoader() {
    return new ClassGraphComponentLoader();
  }

  private static void assembleLogger() {
    try (InputStream stream = Bootstrap.class.getResourceAsStream("/logging.properties")) {
      LogManager.getLogManager().readConfiguration(stream);
  } catch (IOException e) {
      System.err.println("Failed to load logging configuration from classpath: " + e.getMessage());
  }
    logger = Logger.getLogger("Bootstrap");
  }

}
