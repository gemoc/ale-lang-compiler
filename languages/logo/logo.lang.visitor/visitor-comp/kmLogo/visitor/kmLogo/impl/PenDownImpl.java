package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.PenDown;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class PenDownImpl extends PrimitiveImpl implements PenDown {
	protected PenDownImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PEN_DOWN;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__PenDown(this);
	}
}
