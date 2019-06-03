package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectProperties;

@SuppressWarnings("all")
public class FrameAspectFrameAspectContext {
  public final static FrameAspectFrameAspectContext INSTANCE = new FrameAspectFrameAspectContext();
  
  public static FrameAspectFrameAspectProperties getSelf(final Frame _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Frame, FrameAspectFrameAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Frame, org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectProperties>();
  
  public Map<Frame, FrameAspectFrameAspectProperties> getMap() {
    return map;
  }
}
