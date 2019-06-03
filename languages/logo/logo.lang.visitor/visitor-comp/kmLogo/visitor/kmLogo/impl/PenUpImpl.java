package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.PenUp;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class PenUpImpl extends PrimitiveImpl implements PenUp {
	protected PenUpImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PEN_UP;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__PenUp(this);
	}
}
