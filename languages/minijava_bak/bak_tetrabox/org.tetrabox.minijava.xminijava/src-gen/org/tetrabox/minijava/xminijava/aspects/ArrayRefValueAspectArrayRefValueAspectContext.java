package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue;
import org.tetrabox.minijava.xminijava.aspects.ArrayRefValueAspectArrayRefValueAspectProperties;

@SuppressWarnings("all")
public class ArrayRefValueAspectArrayRefValueAspectContext {
  public final static ArrayRefValueAspectArrayRefValueAspectContext INSTANCE = new ArrayRefValueAspectArrayRefValueAspectContext();
  
  public static ArrayRefValueAspectArrayRefValueAspectProperties getSelf(final ArrayRefValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ArrayRefValueAspectArrayRefValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ArrayRefValue, ArrayRefValueAspectArrayRefValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue, org.tetrabox.minijava.xminijava.aspects.ArrayRefValueAspectArrayRefValueAspectProperties>();
  
  public Map<ArrayRefValue, ArrayRefValueAspectArrayRefValueAspectProperties> getMap() {
    return map;
  }
}
