package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.InferiorOrEqualAspectInferiorOrEqualAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.InferiorOrEqual;

@SuppressWarnings("all")
public class InferiorOrEqualAspectInferiorOrEqualAspectContext {
  public final static InferiorOrEqualAspectInferiorOrEqualAspectContext INSTANCE = new InferiorOrEqualAspectInferiorOrEqualAspectContext();
  
  public static InferiorOrEqualAspectInferiorOrEqualAspectProperties getSelf(final InferiorOrEqual _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.InferiorOrEqualAspectInferiorOrEqualAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InferiorOrEqual, InferiorOrEqualAspectInferiorOrEqualAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.InferiorOrEqual, org.tetrabox.minijava.xminijava.aspects.InferiorOrEqualAspectInferiorOrEqualAspectProperties>();
  
  public Map<InferiorOrEqual, InferiorOrEqualAspectInferiorOrEqualAspectProperties> getMap() {
    return map;
  }
}
