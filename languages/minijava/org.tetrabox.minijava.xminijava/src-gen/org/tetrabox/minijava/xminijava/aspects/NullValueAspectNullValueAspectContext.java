package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.NullValue;
import org.tetrabox.minijava.xminijava.aspects.NullValueAspectNullValueAspectProperties;

@SuppressWarnings("all")
public class NullValueAspectNullValueAspectContext {
  public final static NullValueAspectNullValueAspectContext INSTANCE = new NullValueAspectNullValueAspectContext();
  
  public static NullValueAspectNullValueAspectProperties getSelf(final NullValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.NullValueAspectNullValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NullValue, NullValueAspectNullValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.NullValue, org.tetrabox.minijava.xminijava.aspects.NullValueAspectNullValueAspectProperties>();
  
  public Map<NullValue, NullValueAspectNullValueAspectProperties> getMap() {
    return map;
  }
}
