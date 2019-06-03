package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ClassRefAspectClassRefAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.ClassRef;

@SuppressWarnings("all")
public class ClassRefAspectClassRefAspectContext {
  public final static ClassRefAspectClassRefAspectContext INSTANCE = new ClassRefAspectClassRefAspectContext();
  
  public static ClassRefAspectClassRefAspectProperties getSelf(final ClassRef _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ClassRefAspectClassRefAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ClassRef, ClassRefAspectClassRefAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.ClassRef, org.tetrabox.minijava.xminijava.aspects.ClassRefAspectClassRefAspectProperties>();
  
  public Map<ClassRef, ClassRefAspectClassRefAspectProperties> getMap() {
    return map;
  }
}
