package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Clear;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Clear"
)
public class ClearImpl extends PrimitiveImpl implements Clear {
	protected ClearImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CLEAR;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) (0.0) ;
		return result;
	}
}
