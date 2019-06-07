package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Skip;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Skip"
)
public class SkipImpl extends ExprImpl implements Skip {
	protected SkipImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.SKIP;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = (EvalRes) (BoaFactory.eINSTANCE.createEvalMapRes()) ;
		return result;
	}
}
