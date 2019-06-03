package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.InequalityAspectInequalityAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Inequality;

@SuppressWarnings("all")
public class InequalityAspectInequalityAspectContext {
  public final static InequalityAspectInequalityAspectContext INSTANCE = new InequalityAspectInequalityAspectContext();
  
  public static InequalityAspectInequalityAspectProperties getSelf(final Inequality _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.InequalityAspectInequalityAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Inequality, InequalityAspectInequalityAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Inequality, org.tetrabox.minijava.xminijava.aspects.InequalityAspectInequalityAspectProperties>();
  
  public Map<Inequality, InequalityAspectInequalityAspectProperties> getMap() {
    return map;
  }
}
