package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface Context extends EObject, NodeInterface {
  EList<SymbolBinding> getBindings();

  Context getParentContext();

  void setParentContext(Context value);

  Context getChildContext();

  void setChildContext(Context value);

  EMap<Symbol, SymbolBinding> getCache();

  SymbolBinding findBinding(Symbol symbol);

  Context findCurrentContext();
}
