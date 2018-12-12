package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.TypeRef;

@SuppressWarnings("all")
public class TypeRefAspectTypeRefAspectContext {
  public final static TypeRefAspectTypeRefAspectContext INSTANCE = new TypeRefAspectTypeRefAspectContext();
  
  public static TypeRefAspectTypeRefAspectProperties getSelf(final TypeRef _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TypeRef, TypeRefAspectTypeRefAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.TypeRef, org.tetrabox.minijava.xminijava.aspects.TypeRefAspectTypeRefAspectProperties>();
  
  public Map<TypeRef, TypeRefAspectTypeRefAspectProperties> getMap() {
    return map;
  }
}
