package se.yoctocontainer.ui.impl;

import java.util.List;

import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.ui.ActionDescriptor;
import se.yoctocontainer.ui.ActionHandler;
import se.yoctocontainer.ui.ActionListener;

public class ActionHandlerImpl extends AbstractInstance implements ActionHandler {

	List<ActionListener<?>> listeners;
	
	@Override
	public void registerListener(ActionListener<?> listener) {
		listeners.add(listener);
	}

	@Override
	public void unregisterListener(ActionListener<?> listener) {
		listeners.remove(listener);
	}

	@Override
	public <N> void action(ActionDescriptor<N> action) {
		for(ActionListener<?> listener: listeners) {
			if(listener.getSupportedActionType().isAssignableFrom(action.getAdditionalInformation().getClass())) {
				// ie, the listener will be able to interpret the action information
				@SuppressWarnings("unchecked")
				ActionListener<N> castedListener = (ActionListener<N>) listener;
				castedListener.actionTriggered(action);
			}
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

	}

}
