package diamond.revisitor;

public interface DiamondRevisitor<Diamond__AT, Diamond__BT extends Diamond__AT, Diamond__CT extends Diamond__AT, Diamond__DT extends Diamond__BT, Diamond__DT_AS_Diamond__CT extends Diamond__CT> {
	Diamond__AT diamond__A(final diamond.A it);
	Diamond__BT diamond__B(final diamond.B it);
	Diamond__CT diamond__C(final diamond.C it);
	Diamond__DT diamond__D(final diamond.D it);
	Diamond__DT_AS_Diamond__CT diamond__D__AS__diamond__C(final diamond.D it);

	default Diamond__AT $(final diamond.A it) {
		if (it.getClass() == diamond.impl.BImpl.class)
			return diamond__B((diamond.B) it);
		if (it.getClass() == diamond.impl.CImpl.class)
			return diamond__C((diamond.C) it);
		if (it.getClass() == diamond.impl.DImpl.class)
			return diamond__D((diamond.D) it);
		return diamond__A(it);
	}
	default Diamond__BT $(final diamond.B it) {
		if (it.getClass() == diamond.impl.DImpl.class)
			return diamond__D((diamond.D) it);
		return diamond__B(it);
	}
	default Diamond__CT $(final diamond.C it) {
		if (it.getClass() == diamond.impl.DImpl.class)
			return diamond__D__AS__diamond__C((diamond.D) it);
		return diamond__C(it);
	}

	default Diamond__DT $(final diamond.D it) {
		return diamond__D(it);
	}
}
