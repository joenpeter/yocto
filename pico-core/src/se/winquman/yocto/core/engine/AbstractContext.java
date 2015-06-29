/**
 * 
 */
package se.winquman.yocto.core.engine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.core.Configurator;
import se.winquman.yocto.core.Context;
import se.winquman.yocto.core.Instance;
import se.winquman.yocto.core.RunConfiguration;
import se.winquman.yocto.core.Runner;
import se.winquman.yocto.core.Session;
import se.winquman.yocto.core.helpers.InternalSettings;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;
import se.winquman.yocto.error.NotCreatedException;
import se.winquman.yocto.error.NotFoundException;
import se.winquman.yocto.error.RuntimeEnvironmentException;

/**
 * @author Joen
 *
 */
public abstract class AbstractContext implements Context {

	protected Configurator config;
	protected Session session;
	
	protected ComponentFactory defaultFactory;
	protected Map<String,Class> components;
	protected Map<String,ComponentFactory> factories;
	protected Map<String,Instance> instances;
	protected Map<String,Runner> runners;
	
	protected LogSettings logSettings;
	protected Logger logger;
	
	/**
	 * 
	 */
	public AbstractContext(Configurator conf, LogSettings log) {
		components = new HashMap<String,Class>();
		factories = new HashMap<String,ComponentFactory>();
		instances = new HashMap<String,Instance>();
		runners = new HashMap<String,Runner>();
		config = conf;
		logSettings = log;
		logger = logSettings.getConfiguredLogger();
		try {
			defaultFactory = InternalSettings.getDefaultComponentFactory(this, conf);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#getConfigurator()
	 */
	@Override
	public Configurator getConfigurator() {

		return config;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#getSession()
	 */
	@Override
	public Session getSession() {

		return session;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#getInstance(java.lang.String)
	 */
	@Override
	public Instance getInstance(String name) {
		Instance i = instances.get(name);
		if(i != null) {
			if(i.isCheck()) {
				return i;
			} else {
				i.create(this, config);
				return i;
			}
			
		} else {
			throw new NotFoundException("Could not find instance: " + name);
		}
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#getComponentFactory(java.lang.String)
	 */
	@Override
	public ComponentFactory getComponentFactory(String type) {
		ComponentFactory i = factories.get(type);
		if(i != null) {
			if(i.isCheck()) {
				return i;
			} else {
				i.create(this, config);
				return i;
			}
			
		} else {
			throw new NotFoundException("Could not find factory: " + type);
		}
	}


	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#newComponent(java.lang.String)
	 */
	@Override
	public Component newComponent(String name) {
		
		Class c = components.get(name);
		if(c == null) {
			throw new NotFoundException("Could not find component assigned to a factory: " + name);
		}
		
		Component comp = null;
		
		try {
			comp = (Component) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new NotCreatedException("Could not create new component of type " + name, e);
		}
		comp.create(this, config);
		
		return comp;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#getLogSettings()
	 */
	@Override
	public LogSettings getLogSettings() {
		return logSettings;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#addRuntime(se.winquman.yocto.core.RunConfiguration)
	 */
	@Override
	public RuntimeReference addRuntime(RunConfiguration run) {
		Map<String,ComponentFactory> factoryMap = new HashMap<String,ComponentFactory>();
		Map<String,Class> given = run.getComponentFactories();
		Iterator<Entry<String,Class>> it = given.entrySet().iterator();
		logger.fine("Loading runtime environment: " + run);
		
		while(it.hasNext()) {
			Entry<String,Class> entry = it.next();
			ComponentFactory c;
			try {
				c = (ComponentFactory) entry.getValue().newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassCastException e) {
				throw new RuntimeEnvironmentException("Could not create class: " + entry.getValue().toString(), e);
			}
			logger.fine("Built factory: " + c.toString());
			factoryMap.put(entry.getKey(), c);
		}	
		factories.putAll(factoryMap);
		
		//----------
		given = run.getComponents();
		it = given.entrySet().iterator();
		while(it.hasNext()) {
			logger.fine("Registered component: " + it.next().getValue());
		}
		components.putAll(given);
		
		//----------
		Map<String,Instance> instanceMap = new HashMap<String,Instance>();
		given = run.getInstances();
		it = given.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<String,Class> entry = it.next();
			Instance i;
			try {
				 i = (Instance) entry.getValue().newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassCastException e) {
				throw new RuntimeEnvironmentException("Could not create class: " + entry.getValue().toString(), e);
			}
			logger.fine("Built instance: " + i.toString());
			instanceMap.put(entry.getKey(), i);
		}
		instances.putAll(instanceMap);
		
		// ----------
		Map<String,Runner> runnerMap = new HashMap<String,Runner>();
		given = run.getRunners();
		it = given.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<String,Class> entry = it.next();
			Runner r;
			try {
				r = (Runner) entry.getValue().newInstance();
				r.create(this, config);
			} catch (InstantiationException | IllegalAccessException | ClassCastException e) {
				throw new RuntimeEnvironmentException("Could not create class: " + entry.getValue().toString(), e);
			}
			logger.fine("Built runner: " + r.toString());
			runnerMap.put(entry.getKey(), r);
		}
		runners.putAll(runnerMap);
		
		//----------
		ContextRuntimeReference runtime = new ContextRuntimeReference();
		runtime.create(this, config);
		runtime.addRunners(runners);
		return runtime;
	}

}
