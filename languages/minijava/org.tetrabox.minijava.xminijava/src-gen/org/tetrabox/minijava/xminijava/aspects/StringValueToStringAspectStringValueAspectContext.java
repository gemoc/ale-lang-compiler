package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspectStringValueAspectProperties;

@SuppressWarnings("all")
public class StringValueToStringAspectStringValueAspectContext {
  public final static StringValueToStringAspectStringValueAspectContext INSTANCE = new StringValueToStringAspectStringValueAspectContext();
  
  public static StringValueToStringAspectStringValueAspectProperties getSelf(final StringValue _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspectStringValueAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StringValue, StringValueToStringAspectStringValueAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.StringValue, org.tetrabox.minijava.xminijava.aspects.StringValueToStringAspectStringValueAspectProperties>();
  
  public Map<StringValue, StringValueToStringAspectStringValueAspectProperties> getMap() {
    return map;
  }
}
