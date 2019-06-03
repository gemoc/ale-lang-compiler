package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspectArrayAccessAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.ArrayAccess;

@SuppressWarnings("all")
public class ArrayAccessAspectArrayAccessAspectContext {
  public final static ArrayAccessAspectArrayAccessAspectContext INSTANCE = new ArrayAccessAspectArrayAccessAspectContext();
  
  public static ArrayAccessAspectArrayAccessAspectProperties getSelf(final ArrayAccess _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspectArrayAccessAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ArrayAccess, ArrayAccessAspectArrayAccessAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ArrayAccess, org.tetrabox.minijava.xminijava.aspects.ArrayAccessAspectArrayAccessAspectProperties>();
  
  public Map<ArrayAccess, ArrayAccessAspectArrayAccessAspectProperties> getMap() {
    return map;
  }
}
