package org.tetrabox.minijava.xminijava.aspects;

import java.util.HashMap;
import java.util.Map;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;
import org.tetrabox.minijava.xminijava.miniJava.Symbol;

@SuppressWarnings("all")
public class ContextAspectContextAspectProperties {
  public final Map<Symbol, SymbolBinding> cache = new HashMap<Symbol, SymbolBinding>();
}
