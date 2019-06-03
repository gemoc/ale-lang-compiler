package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.aspects.StringValueAspectStringValueAspectProperties;

@SuppressWarnings("all")
public class StringValueAspectStringValueAspectContext {
  public final static StringValueAspectStringValueAspectContext INSTANCE = new StringValueAspectStringValueAspectContext();
  
  public static StringValueAspectStringValueAspectProperties getSelf(final StringValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.StringValueAspectStringValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StringValue, StringValueAspectStringValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.StringValue, org.tetrabox.minijava.xminijava.aspects.StringValueAspectStringValueAspectProperties>();
  
  public Map<StringValue, StringValueAspectStringValueAspectProperties> getMap() {
    return map;
  }
}
