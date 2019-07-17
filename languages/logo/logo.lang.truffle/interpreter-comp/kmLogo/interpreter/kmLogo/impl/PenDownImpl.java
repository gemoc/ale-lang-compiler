package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "PenDown"
)
public class PenDownImpl extends PrimitiveImpl {
	protected PenDownImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PEN_DOWN;
	}

	public double eval(TurtleImpl turtle) {
		double result;
		turtle.setPenUp(false);
		result = (double) (0.0) ;
		return result;
	}
}
