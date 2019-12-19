package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Clear;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class ClearImpl extends PrimitiveImpl implements Clear {
	protected ClearImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CLEAR;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Clear(this);
	}
}
