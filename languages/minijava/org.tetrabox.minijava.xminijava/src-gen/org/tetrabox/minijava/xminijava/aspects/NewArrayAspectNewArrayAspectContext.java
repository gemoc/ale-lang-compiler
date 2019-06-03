package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.NewArrayAspectNewArrayAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.NewArray;

@SuppressWarnings("all")
public class NewArrayAspectNewArrayAspectContext {
  public final static NewArrayAspectNewArrayAspectContext INSTANCE = new NewArrayAspectNewArrayAspectContext();
  
  public static NewArrayAspectNewArrayAspectProperties getSelf(final NewArray _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.NewArrayAspectNewArrayAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NewArray, NewArrayAspectNewArrayAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.NewArray, org.tetrabox.minijava.xminijava.aspects.NewArrayAspectNewArrayAspectProperties>();
  
  public Map<NewArray, NewArrayAspectNewArrayAspectProperties> getMap() {
    return map;
  }
}
