package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspectBooleanValueAspectProperties;

@SuppressWarnings("all")
public class BooleanValueToStringAspectBooleanValueAspectContext {
  public final static BooleanValueToStringAspectBooleanValueAspectContext INSTANCE = new BooleanValueToStringAspectBooleanValueAspectContext();
  
  public static BooleanValueToStringAspectBooleanValueAspectProperties getSelf(final BooleanValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspectBooleanValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BooleanValue, BooleanValueToStringAspectBooleanValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.BooleanValue, org.tetrabox.minijava.xminijava.aspects.BooleanValueToStringAspectBooleanValueAspectProperties>();
  
  public Map<BooleanValue, BooleanValueToStringAspectBooleanValueAspectProperties> getMap() {
    return map;
  }
}
