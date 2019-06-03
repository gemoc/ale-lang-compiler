package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ReturnAspectReturnAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Return;

@SuppressWarnings("all")
public class ReturnAspectReturnAspectContext {
  public final static ReturnAspectReturnAspectContext INSTANCE = new ReturnAspectReturnAspectContext();
  
  public static ReturnAspectReturnAspectProperties getSelf(final Return _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ReturnAspectReturnAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Return, ReturnAspectReturnAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Return, org.tetrabox.minijava.xminijava.aspects.ReturnAspectReturnAspectProperties>();
  
  public Map<Return, ReturnAspectReturnAspectProperties> getMap() {
    return map;
  }
}
