package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.WhileStatementAspectWhileStatementAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.WhileStatement;

@SuppressWarnings("all")
public class WhileStatementAspectWhileStatementAspectContext {
  public final static WhileStatementAspectWhileStatementAspectContext INSTANCE = new WhileStatementAspectWhileStatementAspectContext();
  
  public static WhileStatementAspectWhileStatementAspectProperties getSelf(final WhileStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.WhileStatementAspectWhileStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<WhileStatement, WhileStatementAspectWhileStatementAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.WhileStatement, org.tetrabox.minijava.xminijava.aspects.WhileStatementAspectWhileStatementAspectProperties>();
  
  public Map<WhileStatement, WhileStatementAspectWhileStatementAspectProperties> getMap() {
    return map;
  }
}
