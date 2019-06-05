package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.PlusAspectPlusAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Plus;

@SuppressWarnings("all")
public class PlusAspectPlusAspectContext {
  public final static PlusAspectPlusAspectContext INSTANCE = new PlusAspectPlusAspectContext();
  
  public static PlusAspectPlusAspectProperties getSelf(final Plus _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.PlusAspectPlusAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Plus, PlusAspectPlusAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Plus, org.tetrabox.minijava.xminijava.aspects.PlusAspectPlusAspectProperties>();
  
  public Map<Plus, PlusAspectPlusAspectProperties> getMap() {
    return map;
  }
}
