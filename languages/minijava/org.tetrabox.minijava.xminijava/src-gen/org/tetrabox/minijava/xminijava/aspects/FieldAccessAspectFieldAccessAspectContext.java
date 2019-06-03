package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.FieldAccessAspectFieldAccessAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.FieldAccess;

@SuppressWarnings("all")
public class FieldAccessAspectFieldAccessAspectContext {
  public final static FieldAccessAspectFieldAccessAspectContext INSTANCE = new FieldAccessAspectFieldAccessAspectContext();
  
  public static FieldAccessAspectFieldAccessAspectProperties getSelf(final FieldAccess _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.FieldAccessAspectFieldAccessAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FieldAccess, FieldAccessAspectFieldAccessAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.FieldAccess, org.tetrabox.minijava.xminijava.aspects.FieldAccessAspectFieldAccessAspectProperties>();
  
  public Map<FieldAccess, FieldAccessAspectFieldAccessAspectProperties> getMap() {
    return map;
  }
}
