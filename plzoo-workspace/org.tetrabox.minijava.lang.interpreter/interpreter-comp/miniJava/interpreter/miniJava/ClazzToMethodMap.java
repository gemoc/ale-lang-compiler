package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

public interface ClazzToMethodMap extends EObject {
  Clazz getKey();

  void setKey(Clazz value);

  Method getValue();

  void setValue(Method value);
}
