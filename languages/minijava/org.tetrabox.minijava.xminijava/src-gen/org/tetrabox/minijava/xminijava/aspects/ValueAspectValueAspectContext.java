package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties;

@SuppressWarnings("all")
public class ValueAspectValueAspectContext {
  public final static ValueAspectValueAspectContext INSTANCE = new ValueAspectValueAspectContext();
  
  public static ValueAspectValueAspectProperties getSelf(final Value _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Value, ValueAspectValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Value, org.tetrabox.minijava.xminijava.aspects.ValueAspectValueAspectProperties>();
  
  public Map<Value, ValueAspectValueAspectProperties> getMap() {
    return map;
  }
}
