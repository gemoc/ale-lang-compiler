package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Div;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class DivImpl extends BinaryExpImpl implements Div {
	protected DivImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.DIV;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Div(this);
	}
}
