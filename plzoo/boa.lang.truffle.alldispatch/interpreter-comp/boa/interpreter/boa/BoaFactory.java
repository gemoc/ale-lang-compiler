package boa.interpreter.boa;

import boa.interpreter.boa.impl.BoaFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface BoaFactory extends EFactory {
  BoaFactory eINSTANCE = BoaFactoryImpl.init();

  File createFile();

  Def createDef();

  App createApp();

  Var createVar();

  This createThis();

  Bool createBool();

  Int createInt();

  Skip createSkip();

  Project createProject();

  BObject createBObject();

  Field createField();

  Copy createCopy();

  With createWith();

  Not createNot();

  If createIf();

  Let createLet();

  Fun createFun();

  Assign createAssign();

  ArithOpPlus createArithOpPlus();

  ArithOpMinus createArithOpMinus();

  ArithOpTimes createArithOpTimes();

  ArithOpDivide createArithOpDivide();

  ArithOpRemainder createArithOpRemainder();

  BoolOpAnd createBoolOpAnd();

  BoolOpOr createBoolOpOr();

  Seq createSeq();

  CmpOpEqual createCmpOpEqual();

  CmpOpUnequal createCmpOpUnequal();

  CmpOpLess createCmpOpLess();

  Ctx createCtx();

  EvalMapRes createEvalMapRes();

  EvalFunRes createEvalFunRes();

  EvalBoundFunRes createEvalBoundFunRes();

  EvalIntRes createEvalIntRes();

  EvalBoolRes createEvalBoolRes();

  BoaPackage getBoaPackage();
}
