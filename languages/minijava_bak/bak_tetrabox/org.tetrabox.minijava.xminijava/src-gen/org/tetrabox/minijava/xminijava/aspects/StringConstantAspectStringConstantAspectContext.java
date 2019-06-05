package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.StringConstantAspectStringConstantAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.StringConstant;

@SuppressWarnings("all")
public class StringConstantAspectStringConstantAspectContext {
  public final static StringConstantAspectStringConstantAspectContext INSTANCE = new StringConstantAspectStringConstantAspectContext();
  
  public static StringConstantAspectStringConstantAspectProperties getSelf(final StringConstant _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.StringConstantAspectStringConstantAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StringConstant, StringConstantAspectStringConstantAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.StringConstant, org.tetrabox.minijava.xminijava.aspects.StringConstantAspectStringConstantAspectProperties>();
  
  public Map<StringConstant, StringConstantAspectStringConstantAspectProperties> getMap() {
    return map;
  }
}
