package functioncall.visitor.functioncall.impl;

import functioncall.visitor.functioncall.ConceptA;
import functioncall.visitor.functioncall.FunctioncallPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FunctioncallPackage.Literals.CONCEPT_A;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfunctioncall__ConceptA(this);
	}
}
