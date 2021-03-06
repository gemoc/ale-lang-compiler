package miniJava.interpreter.miniJava;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface Context extends EObject {
  EList<SymbolBinding> getBindings();

  Context getParentContext();

  void setParentContext(Context value);

  Context getChildContext();

  void setChildContext(Context value);

  EList<Entry<Symbol, SymbolBinding>> getCache();

  SymbolBinding findBinding(Symbol symbol);

  Context findCurrentContext();
}
