package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Minus;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class MinusImpl extends BinaryExpImpl implements Minus {
	protected MinusImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.MINUS;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Minus(this);
	}
}
