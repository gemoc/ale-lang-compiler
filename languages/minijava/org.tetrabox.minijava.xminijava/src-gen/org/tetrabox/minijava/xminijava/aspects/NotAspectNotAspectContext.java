package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.NotAspectNotAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Not;

@SuppressWarnings("all")
public class NotAspectNotAspectContext {
  public final static NotAspectNotAspectContext INSTANCE = new NotAspectNotAspectContext();
  
  public static NotAspectNotAspectProperties getSelf(final Not _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.NotAspectNotAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Not, NotAspectNotAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Not, org.tetrabox.minijava.xminijava.aspects.NotAspectNotAspectProperties>();
  
  public Map<Not, NotAspectNotAspectProperties> getMap() {
    return map;
  }
}
