package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "CmpOpLess"
)
public class CmpOpLessImpl extends CmpOpImpl {
	protected CmpOpLessImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.CMP_OP_LESS;
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalResImpl vlhs = ((EvalResImpl) (((ExprImpl) (this.lhs)).eval((CtxImpl) (ctx))));
		EvalResImpl vrhs = ((EvalResImpl) (((ExprImpl) (this.rhs)).eval((CtxImpl) (ctx))));
		if (vlhs instanceof EvalIntResImpl) {
			if (vrhs instanceof EvalIntResImpl) {
				EvalIntResImpl ivlhs = ((EvalIntResImpl) (vlhs));
				EvalIntResImpl ivrhs = ((EvalIntResImpl) (vrhs));
				EvalBoolResImpl ret = ((EvalBoolResImpl) (BoaFactory.eINSTANCE.createEvalBoolRes()));
				ret.setValue((ivlhs.getValue()) < (ivrhs.getValue()));
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
