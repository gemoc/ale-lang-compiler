package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.DivisionAspectDivisionAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Division;

@SuppressWarnings("all")
public class DivisionAspectDivisionAspectContext {
  public final static DivisionAspectDivisionAspectContext INSTANCE = new DivisionAspectDivisionAspectContext();
  
  public static DivisionAspectDivisionAspectProperties getSelf(final Division _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.DivisionAspectDivisionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Division, DivisionAspectDivisionAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Division, org.tetrabox.minijava.xminijava.aspects.DivisionAspectDivisionAspectProperties>();
  
  public Map<Division, DivisionAspectDivisionAspectProperties> getMap() {
    return map;
  }
}
