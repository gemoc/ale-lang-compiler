package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Plus;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class PlusImpl extends BinaryExpImpl implements Plus {
	protected PlusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PLUS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Plus(this);
	}
}
