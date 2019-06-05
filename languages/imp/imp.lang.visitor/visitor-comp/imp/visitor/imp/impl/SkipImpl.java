package imp.visitor.imp.impl;

import imp.visitor.imp.ImpPackage;
import imp.visitor.imp.Skip;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class SkipImpl extends StmtImpl implements Skip {
	protected SkipImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.SKIP;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitimp__Skip(this);
	}
}
