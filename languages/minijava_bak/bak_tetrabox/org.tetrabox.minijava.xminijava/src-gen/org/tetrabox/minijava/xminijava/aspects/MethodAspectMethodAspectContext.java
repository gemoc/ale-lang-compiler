package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Method;

@SuppressWarnings("all")
public class MethodAspectMethodAspectContext {
  public final static MethodAspectMethodAspectContext INSTANCE = new MethodAspectMethodAspectContext();
  
  public static MethodAspectMethodAspectProperties getSelf(final Method _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Method, MethodAspectMethodAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Method, org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties>();
  
  public Map<Method, MethodAspectMethodAspectProperties> getMap() {
    return map;
  }
}
