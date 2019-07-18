package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MathService;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "ArithOpRemainder"
)
public class ArithOpRemainderImpl extends ArithOpImpl {
	protected ArithOpRemainderImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.ARITH_OP_REMAINDER;
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
				ret.setValue(MathService.mod((ArithOpRemainderImpl) (this), (int) (ivlhs.getValue()), (int) (ivrhs.getValue())));
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
