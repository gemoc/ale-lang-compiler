package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.EqualityAspectEqualityAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Equality;

@SuppressWarnings("all")
public class EqualityAspectEqualityAspectContext {
  public final static EqualityAspectEqualityAspectContext INSTANCE = new EqualityAspectEqualityAspectContext();
  
  public static EqualityAspectEqualityAspectProperties getSelf(final Equality _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.EqualityAspectEqualityAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Equality, EqualityAspectEqualityAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Equality, org.tetrabox.minijava.xminijava.aspects.EqualityAspectEqualityAspectProperties>();
  
  public Map<Equality, EqualityAspectEqualityAspectProperties> getMap() {
    return map;
  }
}
