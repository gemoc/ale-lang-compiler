package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.NewObjectAspectNewObjectAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.NewObject;

@SuppressWarnings("all")
public class NewObjectAspectNewObjectAspectContext {
  public final static NewObjectAspectNewObjectAspectContext INSTANCE = new NewObjectAspectNewObjectAspectContext();
  
  public static NewObjectAspectNewObjectAspectProperties getSelf(final NewObject _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.NewObjectAspectNewObjectAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NewObject, NewObjectAspectNewObjectAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.NewObject, org.tetrabox.minijava.xminijava.aspects.NewObjectAspectNewObjectAspectProperties>();
  
  public Map<NewObject, NewObjectAspectNewObjectAspectProperties> getMap() {
    return map;
  }
}
