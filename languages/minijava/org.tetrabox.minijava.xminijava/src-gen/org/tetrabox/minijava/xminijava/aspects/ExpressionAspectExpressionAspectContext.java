package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Expression;

@SuppressWarnings("all")
public class ExpressionAspectExpressionAspectContext {
  public final static ExpressionAspectExpressionAspectContext INSTANCE = new ExpressionAspectExpressionAspectContext();
  
  public static ExpressionAspectExpressionAspectProperties getSelf(final Expression _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Expression, ExpressionAspectExpressionAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Expression, org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties>();
  
  public Map<Expression, ExpressionAspectExpressionAspectProperties> getMap() {
    return map;
  }
}
