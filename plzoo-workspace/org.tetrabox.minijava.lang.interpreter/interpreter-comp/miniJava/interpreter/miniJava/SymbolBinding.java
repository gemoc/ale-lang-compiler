package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface SymbolBinding extends EObject, NodeInterface {
  Value getValue();

  void setValue(Value value);

  Symbol getSymbol();

  void setSymbol(Symbol value);
}
