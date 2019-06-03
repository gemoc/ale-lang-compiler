package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Program;

@SuppressWarnings("all")
public class ProgramAspectProgramAspectContext {
  public final static ProgramAspectProgramAspectContext INSTANCE = new ProgramAspectProgramAspectContext();
  
  public static ProgramAspectProgramAspectProperties getSelf(final Program _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Program, ProgramAspectProgramAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.Program, org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties>();
  
  public Map<Program, ProgramAspectProgramAspectProperties> getMap() {
    return map;
  }
}
