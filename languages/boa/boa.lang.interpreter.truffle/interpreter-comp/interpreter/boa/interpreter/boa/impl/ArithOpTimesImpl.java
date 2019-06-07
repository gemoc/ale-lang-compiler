package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.ArithOpTimes;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalIntRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "ArithOpTimes"
)
public class ArithOpTimesImpl extends ArithOpImpl implements ArithOpTimes {
	protected ArithOpTimesImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_TIMES;
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
				ret.setValue((ivlhs.getValue()) * (ivrhs.getValue()));
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
