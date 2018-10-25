package boa_dynamic.interpreter.boa_dynamic;

import boa_dynamic.interpreter.boa_dynamic.impl.Boa_dynamicFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface Boa_dynamicFactory extends EFactory {
  Boa_dynamicFactory eINSTANCE = Boa_dynamicFactoryImpl.init();

  Ctx createCtx();

  EvalMapRes createEvalMapRes();

  EvalFunRes createEvalFunRes();

  EvalBoundFunRes createEvalBoundFunRes();

  EvalIntRes createEvalIntRes();

  EvalBoolRes createEvalBoolRes();

  Boa_dynamicPackage getBoa_dynamicPackage();
}
