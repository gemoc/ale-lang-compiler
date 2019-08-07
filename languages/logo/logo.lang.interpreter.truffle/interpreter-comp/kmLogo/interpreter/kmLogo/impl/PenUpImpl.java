package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.PenUp;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "PenUp"
)
public class PenUpImpl extends PrimitiveImpl implements PenUp {
	protected PenUpImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PEN_UP;
	}

	public double eval(Turtle turtle) {
		double result;
		turtle.setPenUp(true);
		result = (double) (0.0) ;
		return result;
	}
}
