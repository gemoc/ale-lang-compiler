package kmLogo.visitor.kmLogo.impl;

import java.lang.Override;
import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;

public abstract class ExpressionImpl extends InstructionImpl implements Expression {
	protected ExpressionImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.EXPRESSION;
	}
}
