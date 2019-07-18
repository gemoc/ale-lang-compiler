package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "ArithOpPlus"
)
public class ArithOpPlusImpl extends ArithOpImpl {
	protected ArithOpPlusImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_PLUS;
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalResImpl vlhs = ((EvalResImpl) (((ExprImpl) (this.lhs)).eval((CtxImpl) (ctx))));
		EvalResImpl vrhs = ((EvalResImpl) (((ExprImpl) (this.rhs)).eval((CtxImpl) (ctx))));
		if (vlhs instanceof EvalIntResImpl) {
			if (vrhs instanceof EvalIntResImpl) {
				EvalIntResImpl ivlhs = ((EvalIntResImpl) (vlhs));
				EvalIntResImpl ivrhs = ((EvalIntResImpl) (vrhs));
				EvalIntResImpl ret = ((EvalIntResImpl) (BoaFactory.eINSTANCE.createEvalIntRes()));
				ret.setValue((ivlhs.getValue()) + (ivrhs.getValue()));
				result = (EvalResImpl) (ret) ;
			}
			else {
				result = (EvalResImpl) (null) ;
			}
		}
		else {
			result = (EvalResImpl) (null) ;
		}
		return result;
	}
}
