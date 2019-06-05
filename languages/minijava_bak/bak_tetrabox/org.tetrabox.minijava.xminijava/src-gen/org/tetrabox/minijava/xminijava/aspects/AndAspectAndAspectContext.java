package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.AndAspectAndAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.And;

@SuppressWarnings("all")
public class AndAspectAndAspectContext {
  public final static AndAspectAndAspectContext INSTANCE = new AndAspectAndAspectContext();
  
  public static AndAspectAndAspectProperties getSelf(final And _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.AndAspectAndAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<And, AndAspectAndAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.And, org.tetrabox.minijava.xminijava.aspects.AndAspectAndAspectProperties>();
  
  public Map<And, AndAspectAndAspectProperties> getMap() {
    return map;
  }
}
