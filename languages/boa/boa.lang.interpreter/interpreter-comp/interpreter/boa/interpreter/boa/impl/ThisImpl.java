package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalMapRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.This;
import java.lang.Override;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

public class ThisImpl extends ExprImpl implements This {
	protected ThisImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.THIS;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		ret.getValues().putAll((EMap) (ctx.getTh()));
		result = (EvalRes) (ret) ;
		return result;
	}
}
