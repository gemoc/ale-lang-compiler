package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Clazz extends EObject, NodeInterface, TypeDeclaration {
  boolean isIsabstract();

  void setIsabstract(boolean value);

  Clazz getSuperClass();

  void setSuperClass(Clazz value);
}
