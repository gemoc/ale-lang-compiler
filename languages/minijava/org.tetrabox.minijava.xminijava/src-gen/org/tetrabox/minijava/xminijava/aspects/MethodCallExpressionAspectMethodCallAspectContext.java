package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspectMethodCallAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.MethodCall;

@SuppressWarnings("all")
public class MethodCallExpressionAspectMethodCallAspectContext {
  public final static MethodCallExpressionAspectMethodCallAspectContext INSTANCE = new MethodCallExpressionAspectMethodCallAspectContext();
  
  public static MethodCallExpressionAspectMethodCallAspectProperties getSelf(final MethodCall _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspectMethodCallAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MethodCall, MethodCallExpressionAspectMethodCallAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.MethodCall, org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspectMethodCallAspectProperties>();
  
  public Map<MethodCall, MethodCallExpressionAspectMethodCallAspectProperties> getMap() {
    return map;
  }
}
