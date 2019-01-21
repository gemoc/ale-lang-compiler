package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.ClassRefDispatchWrapperCompare;
import org.eclipse.emf.ecore.EObject;

public interface ClassRef extends EObject, NodeInterface, SingleTypeRef {
  TypeDeclaration getReferencedClass();

  void setReferencedClass(TypeDeclaration value);

  boolean compare(TypeRef other);

  ClassRefDispatchWrapperCompare getCachedCompare();
}
