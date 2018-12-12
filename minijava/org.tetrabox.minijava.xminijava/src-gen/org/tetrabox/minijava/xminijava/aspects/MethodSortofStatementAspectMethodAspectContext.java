package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspectMethodAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Method;

@SuppressWarnings("all")
public class MethodSortofStatementAspectMethodAspectContext {
  public final static MethodSortofStatementAspectMethodAspectContext INSTANCE = new MethodSortofStatementAspectMethodAspectContext();
  
  public static MethodSortofStatementAspectMethodAspectProperties getSelf(final Method _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspectMethodAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Method, MethodSortofStatementAspectMethodAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Method, org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspectMethodAspectProperties>();
  
  public Map<Method, MethodSortofStatementAspectMethodAspectProperties> getMap() {
    return map;
  }
}
