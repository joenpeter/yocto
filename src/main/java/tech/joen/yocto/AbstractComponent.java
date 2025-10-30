/**
 * 
 */
package tech.joen.yocto;

import java.util.logging.Level;
import java.util.logging.Logger;
import tech.joen.yocto.core.Context;
import tech.joen.yocto.core.impl.ApplicationException;

/**
 * 
 */
public abstract class AbstractComponent implements Component {
  private Logger logger;
  private Context context;
  private boolean initialized = false;
  
  public AbstractComponent() {
    // do nothing
  }
  
  
  /**
   * Calls when the component is ceated.
   * For a factory, this means every time a new instance is initiated.
   * For a Singleton, this means on application startup. 
   */
  abstract protected void create() throws ApplicationException;

  @Override
  public final void init(Context context) throws ApplicationException {
    if(initialized) {
      throw new ApplicationException("Component already initialized: " + getComponentName());
    }
    initialized = true;
    this.context = context;
    logger = Logger.getLogger(getComponentName());
    info("CREATE: " + getComponentName());
    create();
  }
  
  @Override
  public final String getComponentName() {
    return context.getComponentName();
  }

  @Override
  public int getPriority() {
    return 0;
  }
  
  protected Context getContext() {
    return context;
  }

  protected void debug(String message) {
    logger.fine(message);
  }
  
  protected void debug(String message, Throwable throwable) {
    logger.log(Level.FINE, message, throwable);
  }
  
  protected void info(String message) {
    logger.info(message);
  }
  
  protected void info(String message, Throwable throwable) {
    logger.log(Level.INFO, message, throwable);
  }

  protected void warn(String message) {
    logger.warning(message);
  }
  
  protected void warn(String message, Throwable throwable) {
    logger.log(Level.WARNING, message, throwable);
  }
  
  protected void error(String message) {
    logger.severe(message);
  }
  
  protected void error(String message, Throwable throwable) {
    logger.log(Level.SEVERE, message, throwable);
  }

}
