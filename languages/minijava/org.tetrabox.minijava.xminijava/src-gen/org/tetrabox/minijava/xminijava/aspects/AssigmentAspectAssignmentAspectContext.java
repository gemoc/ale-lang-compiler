package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.AssigmentAspectAssignmentAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Assignment;

@SuppressWarnings("all")
public class AssigmentAspectAssignmentAspectContext {
  public final static AssigmentAspectAssignmentAspectContext INSTANCE = new AssigmentAspectAssignmentAspectContext();
  
  public static AssigmentAspectAssignmentAspectProperties getSelf(final Assignment _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.AssigmentAspectAssignmentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Assignment, AssigmentAspectAssignmentAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Assignment, org.tetrabox.minijava.xminijava.aspects.AssigmentAspectAssignmentAspectProperties>();
  
  public Map<Assignment, AssigmentAspectAssignmentAspectProperties> getMap() {
    return map;
  }
}
