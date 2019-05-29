package visitor;

import factorydeclorder.visitor.factorydeclorder.A;
import factorydeclorder.visitor.factorydeclorder.B;
import factorydeclorder.visitor.factorydeclorder.C;
import factorydeclorder.visitor.factorydeclorder.D;
import visitor.operation.factorydeclorder.AOperation;
import visitor.operation.factorydeclorder.BOperation;
import visitor.operation.factorydeclorder.COperation;
import visitor.operation.factorydeclorder.DOperation;
import visitor.operation.factorydeclorder.impl.AOperationImpl;
import visitor.operation.factorydeclorder.impl.BOperationImpl;
import visitor.operation.factorydeclorder.impl.COperationImpl;
import visitor.operation.factorydeclorder.impl.DOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public COperation visitfactorydeclorder__C(C it) {
		return new COperationImpl(it, this);
	}

	public AOperation visitfactorydeclorder__A(A it) {
		return new AOperationImpl(it, this);
	}

	public BOperation visitfactorydeclorder__B(B it) {
		return new BOperationImpl(it, this);
	}

	public DOperation visitfactorydeclorder__D(D it) {
		return new DOperationImpl(it, this);
	}
}
