/**
 * 
 */
package tech.joen.yocto.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import tech.joen.yocto.Context;

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
 */
public class Bootstrap {
  
  static Logger logger;
  static Context context;

  /**
   * @param args
   */
  public static void main(String[] args) {
    assembleLogger();
    logger.log(Level.INFO, "Starting to log. Startup initiated.");
    
    loadApplicationContext();
    loadComponents();
    startStartables();
  }

  private static void startStartables() {
    // TODO Auto-generated method stub
    
  }

  private static void loadComponents() {
    // TODO Auto-generated method stub
    
  }

  private static void loadApplicationContext() {
    // TODO Auto-generated method stub
    
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
