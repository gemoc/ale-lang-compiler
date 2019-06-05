package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ForStatementAspectForStatementAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.ForStatement;

@SuppressWarnings("all")
public class ForStatementAspectForStatementAspectContext {
  public final static ForStatementAspectForStatementAspectContext INSTANCE = new ForStatementAspectForStatementAspectContext();
  
  public static ForStatementAspectForStatementAspectProperties getSelf(final ForStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ForStatementAspectForStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ForStatement, ForStatementAspectForStatementAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ForStatement, org.tetrabox.minijava.xminijava.aspects.ForStatementAspectForStatementAspectProperties>();
  
  public Map<ForStatement, ForStatementAspectForStatementAspectProperties> getMap() {
    return map;
  }
}
