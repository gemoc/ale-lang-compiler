package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspectExpressionAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Expression;

@SuppressWarnings("all")
public class ExpressionStatementAspectExpressionAspectContext {
  public final static ExpressionStatementAspectExpressionAspectContext INSTANCE = new ExpressionStatementAspectExpressionAspectContext();
  
  public static ExpressionStatementAspectExpressionAspectProperties getSelf(final Expression _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspectExpressionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Expression, ExpressionStatementAspectExpressionAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Expression, org.tetrabox.minijava.xminijava.aspects.ExpressionStatementAspectExpressionAspectProperties>();
  
  public Map<Expression, ExpressionStatementAspectExpressionAspectProperties> getMap() {
    return map;
  }
}
