package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.aspects.ObjectRefValueToStringAspectObjectRefValueAspectProperties;

@SuppressWarnings("all")
public class ObjectRefValueToStringAspectObjectRefValueAspectContext {
  public final static ObjectRefValueToStringAspectObjectRefValueAspectContext INSTANCE = new ObjectRefValueToStringAspectObjectRefValueAspectContext();
  
  public static ObjectRefValueToStringAspectObjectRefValueAspectProperties getSelf(final ObjectRefValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ObjectRefValueToStringAspectObjectRefValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ObjectRefValue, ObjectRefValueToStringAspectObjectRefValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue, org.tetrabox.minijava.xminijava.aspects.ObjectRefValueToStringAspectObjectRefValueAspectProperties>();
  
  public Map<ObjectRefValue, ObjectRefValueToStringAspectObjectRefValueAspectProperties> getMap() {
    return map;
  }
}
