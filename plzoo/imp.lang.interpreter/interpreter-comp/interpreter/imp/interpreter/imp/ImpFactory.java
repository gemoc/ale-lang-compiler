package interpreter.imp.interpreter.imp;

import interpreter.imp.interpreter.imp.impl.ImpFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface ImpFactory extends EFactory {
  ImpFactory eINSTANCE = ImpFactoryImpl.init();

  Skip createSkip();

  Assign createAssign();

  Block createBlock();

  If createIf();

  While createWhile();

  IntConst createIntConst();

  Var createVar();

  Unary createUnary();

  Binary createBinary();

  Store createStore();

  IntValue createIntValue();

  BoolValue createBoolValue();

  ArrayValue createArrayValue();

  ArrayDecl createArrayDecl();

  BoolConst createBoolConst();

  ImpPackage getImpPackage();
}
