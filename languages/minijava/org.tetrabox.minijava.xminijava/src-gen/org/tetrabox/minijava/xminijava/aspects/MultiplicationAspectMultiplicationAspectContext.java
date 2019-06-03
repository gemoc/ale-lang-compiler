package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.MultiplicationAspectMultiplicationAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Multiplication;

@SuppressWarnings("all")
public class MultiplicationAspectMultiplicationAspectContext {
  public final static MultiplicationAspectMultiplicationAspectContext INSTANCE = new MultiplicationAspectMultiplicationAspectContext();
  
  public static MultiplicationAspectMultiplicationAspectProperties getSelf(final Multiplication _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.MultiplicationAspectMultiplicationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Multiplication, MultiplicationAspectMultiplicationAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Multiplication, org.tetrabox.minijava.xminijava.aspects.MultiplicationAspectMultiplicationAspectProperties>();
  
  public Map<Multiplication, MultiplicationAspectMultiplicationAspectProperties> getMap() {
    return map;
  }
}
