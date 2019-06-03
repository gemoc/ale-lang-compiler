package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.NegAspectNegAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Neg;

@SuppressWarnings("all")
public class NegAspectNegAspectContext {
  public final static NegAspectNegAspectContext INSTANCE = new NegAspectNegAspectContext();
  
  public static NegAspectNegAspectProperties getSelf(final Neg _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.NegAspectNegAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Neg, NegAspectNegAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Neg, org.tetrabox.minijava.xminijava.aspects.NegAspectNegAspectProperties>();
  
  public Map<Neg, NegAspectNegAspectProperties> getMap() {
    return map;
  }
}
