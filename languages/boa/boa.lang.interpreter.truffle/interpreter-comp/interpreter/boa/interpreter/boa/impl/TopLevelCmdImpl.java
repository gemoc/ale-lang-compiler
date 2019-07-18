package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "TopLevelCmd"
)
public abstract class TopLevelCmdImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected TopLevelCmdImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.TOP_LEVEL_CMD;
	}

	public void nextLine(CtxImpl ctx) {
	}
}
