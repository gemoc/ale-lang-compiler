package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.NullAspectNullAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Null;

@SuppressWarnings("all")
public class NullAspectNullAspectContext {
  public final static NullAspectNullAspectContext INSTANCE = new NullAspectNullAspectContext();
  
  public static NullAspectNullAspectProperties getSelf(final Null _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.NullAspectNullAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Null, NullAspectNullAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Null, org.tetrabox.minijava.xminijava.aspects.NullAspectNullAspectProperties>();
  
  public Map<Null, NullAspectNullAspectProperties> getMap() {
    return map;
  }
}
