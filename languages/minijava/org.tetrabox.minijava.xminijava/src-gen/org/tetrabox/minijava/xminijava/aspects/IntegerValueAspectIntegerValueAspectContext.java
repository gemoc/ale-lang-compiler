package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.aspects.IntegerValueAspectIntegerValueAspectProperties;

@SuppressWarnings("all")
public class IntegerValueAspectIntegerValueAspectContext {
  public final static IntegerValueAspectIntegerValueAspectContext INSTANCE = new IntegerValueAspectIntegerValueAspectContext();
  
  public static IntegerValueAspectIntegerValueAspectProperties getSelf(final IntegerValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.IntegerValueAspectIntegerValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IntegerValue, IntegerValueAspectIntegerValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.IntegerValue, org.tetrabox.minijava.xminijava.aspects.IntegerValueAspectIntegerValueAspectProperties>();
  
  public Map<IntegerValue, IntegerValueAspectIntegerValueAspectProperties> getMap() {
    return map;
  }
}
