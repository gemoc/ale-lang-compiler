package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface SymbolToSymbolBindingMap extends EObject, NodeInterface {
  Symbol getKey();

  void setKey(Symbol value);

  SymbolBinding getValue();

  void setValue(SymbolBinding value);
}
