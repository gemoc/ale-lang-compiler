package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ThisAspectThisAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.This;

@SuppressWarnings("all")
public class ThisAspectThisAspectContext {
  public final static ThisAspectThisAspectContext INSTANCE = new ThisAspectThisAspectContext();
  
  public static ThisAspectThisAspectProperties getSelf(final This _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ThisAspectThisAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<This, ThisAspectThisAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.This, org.tetrabox.minijava.xminijava.aspects.ThisAspectThisAspectProperties>();
  
  public Map<This, ThisAspectThisAspectProperties> getMap() {
    return map;
  }
}
