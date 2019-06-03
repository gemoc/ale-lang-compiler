package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.OrAspectOrAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Or;

@SuppressWarnings("all")
public class OrAspectOrAspectContext {
  public final static OrAspectOrAspectContext INSTANCE = new OrAspectOrAspectContext();
  
  public static OrAspectOrAspectProperties getSelf(final Or _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.OrAspectOrAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Or, OrAspectOrAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Or, org.tetrabox.minijava.xminijava.aspects.OrAspectOrAspectProperties>();
  
  public Map<Or, OrAspectOrAspectProperties> getMap() {
    return map;
  }
}
