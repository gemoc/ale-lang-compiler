package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Cos;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class CosImpl extends UnaryExpressionImpl implements Cos {
	protected CosImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.COS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Cos(this);
	}
}
