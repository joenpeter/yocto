/**
 * 
 */
package se.yoctocontainer.core.engine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.Context;
import se.yoctocontainer.core.Instance;
import se.yoctocontainer.core.RunConfiguration;
import se.yoctocontainer.core.Session;
import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.core.logging.LogSettings;
import se.yoctocontainer.error.ApplicationException;
import se.yoctocontainer.error.ApplicationRuntimeException;
import se.yoctocontainer.error.NotCreatedException;
import se.yoctocontainer.error.NotFoundException;
import se.yoctocontainer.error.RuntimeEnvironmentException;

/**
 * @author Joen
 *
 */
public abstract class AbstractContext extends AbstractInstance
		implements Context, ContextSeed{

	protected Configurator config;
	protected Session session;
	
	protected boolean initInProgress = false;
	
	protected Map<String,Class<? extends Component>> components;
	protected Map<String,Instance> instances;
	protected Map<String,Boolean> instanceInitiation;
	protected Map<String,Thread> runnables;
	
	protected LogSettings logSettings;
	
	/**
	 * 
	 */
	public AbstractContext(Configurator conf, LogSettings log) {
		components = new HashMap<>();
		instances = new HashMap<>();
		instanceInitiation = new HashMap<>();
		runnables = new HashMap<>();
		config = conf;
		logSettings = log;
		
		create(this, config);
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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Instance> T getInstance(String name) {
		Instance i = instances.get(name);
		if(i != null) {
			debug("Found instance: " + i.getClass().getSimpleName() + "(" + name + ")");
			if(initInProgress) {
				// We are starting right now, some instances may not have been initiated
				if(instanceInitiation.containsKey(name)
						&& !instanceInitiation.get(name)) {
					
					initInstance(i);
				}
			}
			
			return (T) i;			
		} else {
			throw new NotFoundException("Could not find instance: " + name);
		}
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Context#newComponent(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Component> T newComponent(String name) throws ApplicationRuntimeException {
		
		Class<? extends Component> c = components.get(name);
		if(c == null) {
			throw new NotFoundException("Could not find component: " + name);
		}
		
		T comp = null;
		
		try {
			comp = (T) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new NotCreatedException("Could not create new component of type " + name, e);
		}
		try {
			comp.create(this, config);
		} catch (ApplicationException e) {
			throw new ApplicationRuntimeException("Unable to create component: " + name, e);
		}
		comp.setObjectName(name);
		
		debug("Created new component: " + comp.getClass().getSimpleName() + " (" + name + ")");
		
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
	public void addRuntime(RunConfiguration run) {
		info("Loading runtime environment: " + run);
		
		
		//----------
		Map<String,Class<? extends Component>> givenComponents = run.getComponents();
		Iterator<Entry<String, Class<? extends Component>>> itC = givenComponents.entrySet().iterator();
		while(itC.hasNext()) {
			info("Registered component: " + itC.next().getValue());
		}
		components.putAll(givenComponents);
		
		// Create instances
		Map<String,Instance> instanceMap = new HashMap<String,Instance>();
		Map<String,Class<? extends Instance>> givenInstances = run.getInstances();
		Iterator<Entry<String, Class<? extends Instance>>> itI = givenInstances.entrySet().iterator();
		
		while(itI.hasNext()) {
			Entry<String,Class<? extends Instance>> entry = itI.next();
			Instance i;
			try {
				 i = entry.getValue().newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassCastException e) {
				throw new RuntimeEnvironmentException("Could not create class: " + entry.getValue().toString(), e);
			}
			i.setObjectName(entry.getKey());
			info("Built instance: " + entry.getKey() + " (" + i.getClass().getSimpleName() + ")");
			instanceMap.put(entry.getKey(), i);
		}
		
		// Initiate all instances, should recursively handle dependencies
		for(String instanceName: instanceMap.keySet()) {
			instanceInitiation.put(instanceName, false);
		}
		
		initInProgress = true;
		for(Instance instance: instanceMap.values()) {
			initInstance(instance);
		}
		initInProgress = false;
		
		instances.putAll(instanceMap);
		
		// Run all runnable instances
		for(Instance instance: instanceMap.values()) {
			if(instance instanceof Runnable) {
				Thread thread = new Thread((Runnable) instance);
				thread.setName(instance.getObjectName());
				thread.start();
				runnables.put(instance.getObjectName(), thread);
			}
		}
	}
	
	@Override
	public Context getContext() {
		return this;
	}

	@Override
	protected void init() {
		
	}

	private void initInstance(Instance instance) {
		try {
			instance.create(this, config);
			info("Initiated instance: " + instance.getObjectName());
			instanceInitiation.put(instance.getObjectName(), true);
		} catch (ApplicationException e) {
			throw new ApplicationRuntimeException("Unable to initiate instance: " + instance.getObjectName(), e);
		}
	}

}
