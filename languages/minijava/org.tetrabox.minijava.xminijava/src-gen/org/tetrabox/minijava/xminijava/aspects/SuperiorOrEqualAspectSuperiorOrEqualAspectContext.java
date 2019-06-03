package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.SuperiorOrEqualAspectSuperiorOrEqualAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.SuperiorOrEqual;

@SuppressWarnings("all")
public class SuperiorOrEqualAspectSuperiorOrEqualAspectContext {
  public final static SuperiorOrEqualAspectSuperiorOrEqualAspectContext INSTANCE = new SuperiorOrEqualAspectSuperiorOrEqualAspectContext();
  
  public static SuperiorOrEqualAspectSuperiorOrEqualAspectProperties getSelf(final SuperiorOrEqual _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.SuperiorOrEqualAspectSuperiorOrEqualAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SuperiorOrEqual, SuperiorOrEqualAspectSuperiorOrEqualAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.SuperiorOrEqual, org.tetrabox.minijava.xminijava.aspects.SuperiorOrEqualAspectSuperiorOrEqualAspectProperties>();
  
  public Map<SuperiorOrEqual, SuperiorOrEqualAspectSuperiorOrEqualAspectProperties> getMap() {
    return map;
  }
}
