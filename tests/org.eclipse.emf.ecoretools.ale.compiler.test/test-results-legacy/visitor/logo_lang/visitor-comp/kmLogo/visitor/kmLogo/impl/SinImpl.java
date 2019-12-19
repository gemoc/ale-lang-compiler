package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Sin;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class SinImpl extends UnaryExpressionImpl implements Sin {
	protected SinImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.SIN;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Sin(this);
	}
}
