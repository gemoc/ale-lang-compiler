package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.aspects.ObjectRefValueAspectObjectRefValueAspectProperties;

@SuppressWarnings("all")
public class ObjectRefValueAspectObjectRefValueAspectContext {
  public final static ObjectRefValueAspectObjectRefValueAspectContext INSTANCE = new ObjectRefValueAspectObjectRefValueAspectContext();
  
  public static ObjectRefValueAspectObjectRefValueAspectProperties getSelf(final ObjectRefValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ObjectRefValueAspectObjectRefValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ObjectRefValue, ObjectRefValueAspectObjectRefValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue, org.tetrabox.minijava.xminijava.aspects.ObjectRefValueAspectObjectRefValueAspectProperties>();
  
  public Map<ObjectRefValue, ObjectRefValueAspectObjectRefValueAspectProperties> getMap() {
    return map;
  }
}
