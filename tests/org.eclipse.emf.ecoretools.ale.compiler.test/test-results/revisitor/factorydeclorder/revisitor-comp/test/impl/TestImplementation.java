package test.impl;

import factorydeclorder.A;
import factorydeclorder.B;
import factorydeclorder.C;
import factorydeclorder.D;
import factorydeclorder.revisitor.FactorydeclorderRevisitor;
import test.impl.operation.AOp;
import test.impl.operation.BOp;
import test.impl.operation.COp;
import test.impl.operation.DOp;
import test.impl.operation.impl.AOpImpl;
import test.impl.operation.impl.BOpImpl;
import test.impl.operation.impl.COpImpl;
import test.impl.operation.impl.DOpImpl;

public interface TestImplementation extends FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> {
	default AOp factorydeclorder__A(A it) {
		return new AOpImpl(it, this);
	}

	default AOp factorydeclorder__A__AS__factorydeclorder__B(A it) {
		return new AOpImpl(it, this);
	}

	default AOp factorydeclorder__A__AS__factorydeclorder__D(A it) {
		return new AOpImpl(it, this);
	}

	default BOp factorydeclorder__B(B it) {
		return new BOpImpl(it, this);
	}

	default COp factorydeclorder__C(C it) {
		return new COpImpl(it, this);
	}

	default COp factorydeclorder__C__AS__factorydeclorder__A(C it) {
		return new COpImpl(it, this);
	}

	default COp factorydeclorder__C__AS__factorydeclorder__B(C it) {
		return new COpImpl(it, this);
	}

	default COp factorydeclorder__C__AS__factorydeclorder__D(C it) {
		return new COpImpl(it, this);
	}

	default DOp factorydeclorder__D(D it) {
		return new DOpImpl(it, this);
	}
}
