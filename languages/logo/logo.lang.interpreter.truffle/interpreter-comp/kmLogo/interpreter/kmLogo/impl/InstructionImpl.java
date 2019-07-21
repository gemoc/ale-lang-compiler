package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "Instruction"
)
public abstract class InstructionImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected InstructionImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.INSTRUCTION;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		result = (double) (0.0) ;
		return result;
	}
}
