package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.TopLevelCmd;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "TopLevelCmd"
)
public abstract class TopLevelCmdImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements TopLevelCmd {
	protected TopLevelCmdImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.TOP_LEVEL_CMD;
	}

	public void nextLine(Ctx ctx) {
	}
}
