package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface TypedDeclaration extends EObject, NodeInterface, NamedElement {
  TypeRef getTypeRef();

  void setTypeRef(TypeRef value);
}
