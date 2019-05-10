package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Greater;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class GreaterImpl extends BinaryExpImpl implements Greater {
	protected GreaterImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.GREATER;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Greater(this);
	}
}
