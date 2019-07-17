package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "This"
)
public class ThisImpl extends ExprImpl {
	protected ThisImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.THIS;
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		EvalMapResImpl ret = ((EvalMapResImpl) (BoaFactory.eINSTANCE.createEvalMapRes()));
		MapService.putAll((EMap) (ret.getValues()), (EMap) (ctx.getTh()));
		result = (EvalResImpl) (ret) ;
		return result;
	}
}
