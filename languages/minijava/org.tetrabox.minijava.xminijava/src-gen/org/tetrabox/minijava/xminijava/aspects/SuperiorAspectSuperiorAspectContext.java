package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.SuperiorAspectSuperiorAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Superior;

@SuppressWarnings("all")
public class SuperiorAspectSuperiorAspectContext {
  public final static SuperiorAspectSuperiorAspectContext INSTANCE = new SuperiorAspectSuperiorAspectContext();
  
  public static SuperiorAspectSuperiorAspectProperties getSelf(final Superior _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.SuperiorAspectSuperiorAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Superior, SuperiorAspectSuperiorAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Superior, org.tetrabox.minijava.xminijava.aspects.SuperiorAspectSuperiorAspectProperties>();
  
  public Map<Superior, SuperiorAspectSuperiorAspectProperties> getMap() {
    return map;
  }
}
