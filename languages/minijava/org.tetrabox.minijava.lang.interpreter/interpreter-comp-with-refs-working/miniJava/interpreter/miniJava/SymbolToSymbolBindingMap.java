package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

public interface SymbolToSymbolBindingMap extends EObject {
  Symbol getKey();

  void setKey(Symbol value);

  SymbolBinding getValue();

  void setValue(SymbolBinding value);
}
