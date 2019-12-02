package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Tan;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class TanImpl extends UnaryExpressionImpl implements Tan {
	protected TanImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.TAN;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Tan(this);
	}
}
