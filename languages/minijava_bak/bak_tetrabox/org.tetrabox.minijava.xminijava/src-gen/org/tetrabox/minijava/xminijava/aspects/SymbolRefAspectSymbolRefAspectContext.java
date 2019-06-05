package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.SymbolRefAspectSymbolRefAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.SymbolRef;

@SuppressWarnings("all")
public class SymbolRefAspectSymbolRefAspectContext {
  public final static SymbolRefAspectSymbolRefAspectContext INSTANCE = new SymbolRefAspectSymbolRefAspectContext();
  
  public static SymbolRefAspectSymbolRefAspectProperties getSelf(final SymbolRef _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.SymbolRefAspectSymbolRefAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SymbolRef, SymbolRefAspectSymbolRefAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.SymbolRef, org.tetrabox.minijava.xminijava.aspects.SymbolRefAspectSymbolRefAspectProperties>();
  
  public Map<SymbolRef, SymbolRefAspectSymbolRefAspectProperties> getMap() {
    return map;
  }
}
