package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.ArithOpPlus;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalIntRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ArithOpPlusImpl extends ArithOpImpl implements ArithOpPlus {
	protected ArithOpPlusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_PLUS;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vlhs = ((EvalRes) (((Expr) (this.lhs)).eval((Ctx) (ctx))));
		EvalRes vrhs = ((EvalRes) (((Expr) (this.rhs)).eval((Ctx) (ctx))));
		if (vlhs instanceof EvalIntRes) {
			if (vrhs instanceof EvalIntRes) {
				EvalIntRes ivlhs = ((EvalIntRes) (vlhs));
				EvalIntRes ivrhs = ((EvalIntRes) (vrhs));
				EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
				ret.setValue((ivlhs.getValue()) + (ivrhs.getValue()));
				result = (EvalRes) (ret) ;
			}
			else {
				result = (EvalRes) (null) ;
			}
		}
		else {
			result = (EvalRes) (null) ;
		}
		return result;
	}
}
