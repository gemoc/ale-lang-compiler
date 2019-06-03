package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ArrayLengthAspectArrayLengthAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.ArrayLength;

@SuppressWarnings("all")
public class ArrayLengthAspectArrayLengthAspectContext {
  public final static ArrayLengthAspectArrayLengthAspectContext INSTANCE = new ArrayLengthAspectArrayLengthAspectContext();
  
  public static ArrayLengthAspectArrayLengthAspectProperties getSelf(final ArrayLength _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ArrayLengthAspectArrayLengthAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ArrayLength, ArrayLengthAspectArrayLengthAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ArrayLength, org.tetrabox.minijava.xminijava.aspects.ArrayLengthAspectArrayLengthAspectProperties>();
  
  public Map<ArrayLength, ArrayLengthAspectArrayLengthAspectProperties> getMap() {
    return map;
  }
}
