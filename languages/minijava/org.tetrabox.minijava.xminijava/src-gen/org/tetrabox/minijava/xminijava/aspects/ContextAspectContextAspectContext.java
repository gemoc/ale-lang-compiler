package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties;

@SuppressWarnings("all")
public class ContextAspectContextAspectContext {
  public final static ContextAspectContextAspectContext INSTANCE = new ContextAspectContextAspectContext();
  
  public static ContextAspectContextAspectProperties getSelf(final Context _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Context, ContextAspectContextAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Context, org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties>();
  
  public Map<Context, ContextAspectContextAspectProperties> getMap() {
    return map;
  }
}
