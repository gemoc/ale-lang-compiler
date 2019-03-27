package functioncall.visitor.functioncall.impl;

import functioncall.visitor.functioncall.ConceptB;
import functioncall.visitor.functioncall.FunctioncallPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import visitor.VisitorInterface;

public class ConceptBImpl extends ConceptAImpl implements ConceptB {
	protected ConceptBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FunctioncallPackage.Literals.CONCEPT_B;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitfunctioncall__ConceptB(this);
	}
}
