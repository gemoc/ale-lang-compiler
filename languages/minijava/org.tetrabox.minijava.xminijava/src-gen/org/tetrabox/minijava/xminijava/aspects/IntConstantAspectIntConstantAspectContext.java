package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.IntConstantAspectIntConstantAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.IntConstant;

@SuppressWarnings("all")
public class IntConstantAspectIntConstantAspectContext {
  public final static IntConstantAspectIntConstantAspectContext INSTANCE = new IntConstantAspectIntConstantAspectContext();
  
  public static IntConstantAspectIntConstantAspectProperties getSelf(final IntConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.IntConstantAspectIntConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IntConstant, IntConstantAspectIntConstantAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.IntConstant, org.tetrabox.minijava.xminijava.aspects.IntConstantAspectIntConstantAspectProperties>();
  
  public Map<IntConstant, IntConstantAspectIntConstantAspectProperties> getMap() {
    return map;
  }
}
