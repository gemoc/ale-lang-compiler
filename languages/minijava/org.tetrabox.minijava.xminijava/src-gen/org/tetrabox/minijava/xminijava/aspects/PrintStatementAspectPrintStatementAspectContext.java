package org.tetrabox.minijava.xminijava.aspects;

import java.util.Map;
import org.tetrabox.minijava.xminijava.aspects.PrintStatementAspectPrintStatementAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.PrintStatement;

@SuppressWarnings("all")
public class PrintStatementAspectPrintStatementAspectContext {
  public final static PrintStatementAspectPrintStatementAspectContext INSTANCE = new PrintStatementAspectPrintStatementAspectContext();
  
  public static PrintStatementAspectPrintStatementAspectProperties getSelf(final PrintStatement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.tetrabox.minijava.xminijava.aspects.PrintStatementAspectPrintStatementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<PrintStatement, PrintStatementAspectPrintStatementAspectProperties> map = new java.util.WeakHashMap<org.tetrabox.minijava.xminijava.miniJava.PrintStatement, org.tetrabox.minijava.xminijava.aspects.PrintStatementAspectPrintStatementAspectProperties>();
  
  public Map<PrintStatement, PrintStatementAspectPrintStatementAspectProperties> getMap() {
    return map;
  }
}
