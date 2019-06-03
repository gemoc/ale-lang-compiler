package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ParameterAspectParameterAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;

@SuppressWarnings("all")
public class ParameterAspectParameterAspectContext {
  public final static ParameterAspectParameterAspectContext INSTANCE = new ParameterAspectParameterAspectContext();
  
  public static ParameterAspectParameterAspectProperties getSelf(final Parameter _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ParameterAspectParameterAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Parameter, ParameterAspectParameterAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Parameter, org.tetrabox.minijava.xminijava.aspects.ParameterAspectParameterAspectProperties>();
  
  public Map<Parameter, ParameterAspectParameterAspectProperties> getMap() {
    return map;
  }
}
