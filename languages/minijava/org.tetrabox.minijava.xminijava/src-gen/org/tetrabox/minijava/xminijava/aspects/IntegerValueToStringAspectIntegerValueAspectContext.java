package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspectIntegerValueAspectProperties;

@SuppressWarnings("all")
public class IntegerValueToStringAspectIntegerValueAspectContext {
  public final static IntegerValueToStringAspectIntegerValueAspectContext INSTANCE = new IntegerValueToStringAspectIntegerValueAspectContext();
  
  public static IntegerValueToStringAspectIntegerValueAspectProperties getSelf(final IntegerValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspectIntegerValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IntegerValue, IntegerValueToStringAspectIntegerValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.IntegerValue, org.tetrabox.minijava.xminijava.aspects.IntegerValueToStringAspectIntegerValueAspectProperties>();
  
  public Map<IntegerValue, IntegerValueToStringAspectIntegerValueAspectProperties> getMap() {
    return map;
  }
}
