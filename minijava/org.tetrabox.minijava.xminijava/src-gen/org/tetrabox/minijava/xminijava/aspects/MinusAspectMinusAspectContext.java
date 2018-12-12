package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.MinusAspectMinusAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Minus;

@SuppressWarnings("all")
public class MinusAspectMinusAspectContext {
  public final static MinusAspectMinusAspectContext INSTANCE = new MinusAspectMinusAspectContext();
  
  public static MinusAspectMinusAspectProperties getSelf(final Minus _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.MinusAspectMinusAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Minus, MinusAspectMinusAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Minus, org.tetrabox.minijava.xminijava.aspects.MinusAspectMinusAspectProperties>();
  
  public Map<Minus, MinusAspectMinusAspectProperties> getMap() {
    return map;
  }
}
