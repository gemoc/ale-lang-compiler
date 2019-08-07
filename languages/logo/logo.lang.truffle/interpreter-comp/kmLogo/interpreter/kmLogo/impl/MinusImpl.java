package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Minus;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Minus"
)
public class MinusImpl extends BinaryExpImpl implements Minus {
	protected MinusImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.MINUS;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (double) ((((Expression) (this.lhs)).eval((Turtle) (turtle))) - (((Expression) (this.rhs)).eval((Turtle) (turtle)))) ;
		return result;
	}
}
