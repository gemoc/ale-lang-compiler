package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.IfStatementAspectIfStatementAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.IfStatement;

@SuppressWarnings("all")
public class IfStatementAspectIfStatementAspectContext {
  public final static IfStatementAspectIfStatementAspectContext INSTANCE = new IfStatementAspectIfStatementAspectContext();
  
  public static IfStatementAspectIfStatementAspectProperties getSelf(final IfStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.IfStatementAspectIfStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IfStatement, IfStatementAspectIfStatementAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.IfStatement, org.tetrabox.minijava.xminijava.aspects.IfStatementAspectIfStatementAspectProperties>();
  
  public Map<IfStatement, IfStatementAspectIfStatementAspectProperties> getMap() {
    return map;
  }
}
