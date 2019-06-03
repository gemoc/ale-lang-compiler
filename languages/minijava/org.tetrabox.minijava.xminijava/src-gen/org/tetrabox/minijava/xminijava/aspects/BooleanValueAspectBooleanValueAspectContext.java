package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.aspects.BooleanValueAspectBooleanValueAspectProperties;

@SuppressWarnings("all")
public class BooleanValueAspectBooleanValueAspectContext {
  public final static BooleanValueAspectBooleanValueAspectContext INSTANCE = new BooleanValueAspectBooleanValueAspectContext();
  
  public static BooleanValueAspectBooleanValueAspectProperties getSelf(final BooleanValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.BooleanValueAspectBooleanValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BooleanValue, BooleanValueAspectBooleanValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.BooleanValue, org.tetrabox.minijava.xminijava.aspects.BooleanValueAspectBooleanValueAspectProperties>();
  
  public Map<BooleanValue, BooleanValueAspectBooleanValueAspectProperties> getMap() {
    return map;
  }
}
