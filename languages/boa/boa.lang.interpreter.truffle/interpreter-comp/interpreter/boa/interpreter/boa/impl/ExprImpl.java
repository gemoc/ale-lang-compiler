package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.SerializeService;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

@NodeInfo(
		description = "Expr"
)
public abstract class ExprImpl extends TopLevelCmdImpl {
	protected ExprImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.EXPR;
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		result = (EvalResImpl) (null) ;
		return result;
	}

	public void nextLine(CtxImpl ctx) {
		LogService.log(SerializeService.serialize((EvalResImpl) (((ExprImpl) (this)).eval((CtxImpl) (ctx)))));
	}
}
