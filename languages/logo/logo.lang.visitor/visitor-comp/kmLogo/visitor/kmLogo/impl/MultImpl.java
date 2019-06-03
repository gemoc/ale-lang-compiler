package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Mult;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class MultImpl extends BinaryExpImpl implements Mult {
	protected MultImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.MULT;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Mult(this);
	}
}
