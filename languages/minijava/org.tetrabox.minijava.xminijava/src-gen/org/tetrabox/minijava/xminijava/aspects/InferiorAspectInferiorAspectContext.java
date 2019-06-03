package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.InferiorAspectInferiorAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Inferior;

@SuppressWarnings("all")
public class InferiorAspectInferiorAspectContext {
  public final static InferiorAspectInferiorAspectContext INSTANCE = new InferiorAspectInferiorAspectContext();
  
  public static InferiorAspectInferiorAspectProperties getSelf(final Inferior _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.InferiorAspectInferiorAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Inferior, InferiorAspectInferiorAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Inferior, org.tetrabox.minijava.xminijava.aspects.InferiorAspectInferiorAspectProperties>();
  
  public Map<Inferior, InferiorAspectInferiorAspectProperties> getMap() {
    return map;
  }
}
