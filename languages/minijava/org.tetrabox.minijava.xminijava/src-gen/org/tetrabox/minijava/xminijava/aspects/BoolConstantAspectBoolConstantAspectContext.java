package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.BoolConstantAspectBoolConstantAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.BoolConstant;

@SuppressWarnings("all")
public class BoolConstantAspectBoolConstantAspectContext {
  public final static BoolConstantAspectBoolConstantAspectContext INSTANCE = new BoolConstantAspectBoolConstantAspectContext();
  
  public static BoolConstantAspectBoolConstantAspectProperties getSelf(final BoolConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.BoolConstantAspectBoolConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BoolConstant, BoolConstantAspectBoolConstantAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.BoolConstant, org.tetrabox.minijava.xminijava.aspects.BoolConstantAspectBoolConstantAspectProperties>();
  
  public Map<BoolConstant, BoolConstantAspectBoolConstantAspectProperties> getMap() {
    return map;
  }
}
