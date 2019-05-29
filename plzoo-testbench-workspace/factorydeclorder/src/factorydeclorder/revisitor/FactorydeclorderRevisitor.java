package factorydeclorder.revisitor;

public interface FactorydeclorderRevisitor<Factorydeclorder__AT, 
	Factorydeclorder__AT_AS_Factorydeclorder__DT extends Factorydeclorder__DT, 
	Factorydeclorder__AT_AS_Factorydeclorder__BT extends Factorydeclorder__BT, 
	Factorydeclorder__BT, Factorydeclorder__CT, 
	Factorydeclorder__CT_AS_Factorydeclorder__DT extends Factorydeclorder__DT, 
	Factorydeclorder__CT_AS_Factorydeclorder__BT extends Factorydeclorder__BT, 
	Factorydeclorder__CT_AS_Factorydeclorder__AT extends Factorydeclorder__AT, 
	Factorydeclorder__DT> {
	Factorydeclorder__AT factorydeclorder__A(final factorydeclorder.A it);
	Factorydeclorder__AT_AS_Factorydeclorder__DT factorydeclorder__A__AS__factorydeclorder__D(final factorydeclorder.A it);
	Factorydeclorder__AT_AS_Factorydeclorder__BT factorydeclorder__A__AS__factorydeclorder__B(final factorydeclorder.A it);
	Factorydeclorder__BT factorydeclorder__B(final factorydeclorder.B it);
	Factorydeclorder__CT factorydeclorder__C(final factorydeclorder.C it);
	Factorydeclorder__CT_AS_Factorydeclorder__DT factorydeclorder__C__AS__factorydeclorder__D(final factorydeclorder.C it);
	Factorydeclorder__CT_AS_Factorydeclorder__BT factorydeclorder__C__AS__factorydeclorder__B(final factorydeclorder.C it);
	Factorydeclorder__CT_AS_Factorydeclorder__AT factorydeclorder__C__AS__factorydeclorder__A(final factorydeclorder.C it);
	Factorydeclorder__DT factorydeclorder__D(final factorydeclorder.D it);

	default Factorydeclorder__AT $(final factorydeclorder.A it) {
		if (it.getClass() == factorydeclorder.impl.CImpl.class)
			return factorydeclorder__C__AS__factorydeclorder__A((factorydeclorder.C) it);
		return factorydeclorder__A(it);
	}
	default Factorydeclorder__BT $(final factorydeclorder.B it) {
		if (it.getClass() == factorydeclorder.impl.AImpl.class)
			return factorydeclorder__A__AS__factorydeclorder__B((factorydeclorder.A) it);
		if (it.getClass() == factorydeclorder.impl.CImpl.class)
			return factorydeclorder__C__AS__factorydeclorder__B((factorydeclorder.C) it);
		return factorydeclorder__B(it);
	}
	default Factorydeclorder__CT $(final factorydeclorder.C it) {
		return factorydeclorder__C(it);
	}
	default Factorydeclorder__DT $(final factorydeclorder.D it) {
		if (it.getClass() == factorydeclorder.impl.AImpl.class)
			return factorydeclorder__A__AS__factorydeclorder__D((factorydeclorder.A) it);
		if (it.getClass() == factorydeclorder.impl.CImpl.class)
			return factorydeclorder__C__AS__factorydeclorder__D((factorydeclorder.C) it);
		return factorydeclorder__D(it);
	}
}
