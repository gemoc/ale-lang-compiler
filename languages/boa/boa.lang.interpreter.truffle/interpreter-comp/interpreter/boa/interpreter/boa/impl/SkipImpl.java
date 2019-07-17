package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Skip"
)
public class SkipImpl extends ExprImpl {
	protected SkipImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.SKIP;
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		result = (EvalResImpl) (BoaFactory.eINSTANCE.createEvalMapRes()) ;
		return result;
	}
}
