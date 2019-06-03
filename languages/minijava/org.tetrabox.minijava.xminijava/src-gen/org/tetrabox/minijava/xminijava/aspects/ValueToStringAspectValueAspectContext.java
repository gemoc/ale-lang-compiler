package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties;

@SuppressWarnings("all")
public class ValueToStringAspectValueAspectContext {
  public final static ValueToStringAspectValueAspectContext INSTANCE = new ValueToStringAspectValueAspectContext();
  
  public static ValueToStringAspectValueAspectProperties getSelf(final Value _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Value, ValueToStringAspectValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Value, org.tetrabox.minijava.xminijava.aspects.ValueToStringAspectValueAspectProperties>();
  
  public Map<Value, ValueToStringAspectValueAspectProperties> getMap() {
    return map;
  }
}
