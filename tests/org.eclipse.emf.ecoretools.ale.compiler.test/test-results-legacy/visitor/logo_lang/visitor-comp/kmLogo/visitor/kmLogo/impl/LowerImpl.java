package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Lower;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class LowerImpl extends BinaryExpImpl implements Lower {
	protected LowerImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.LOWER;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Lower(this);
	}
}
