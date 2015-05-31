package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

public class CustomFocusPolicy extends FocusTraversalPolicy {
	
	Vector<Component> components;
	
	public CustomFocusPolicy(Vector<Component> c) {
		components = c;
	}
	
	@Override
	public Component getComponentAfter(Container aContainer,
			Component aComponent) {
		int index = components.indexOf(aComponent);
		index+=2;
		if (index>=components.size())
			if (index%2==0) index = 1;
			else index=0;
		return components.get(index);
	}

	@Override
	public Component getComponentBefore(Container aContainer,
			Component aComponent) {
		int index = components.indexOf(aComponent);
		index-=2;
		if (index<0) {
			if (index%2==0) {
				if (components.size()%2==0) index = components.size()-1;
				else index=components.size()-2;
			} else {
				if (components.size()%2==0) index = components.size()-2;
				else index=components.size()-1;
			}
		}
		return components.get(index);
	}

	@Override
	public Component getDefaultComponent(Container aContainer) {
		return components.get(0);
	}

	@Override
	public Component getFirstComponent(Container aContainer) {
		return components.get(0);
	}

	@Override
	public Component getLastComponent(Container aContainer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
