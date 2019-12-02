package test.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA0;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA1;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA10;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA11;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA2;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA3;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA4;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA5;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA8;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA9;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB0;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB1;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB10;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB11;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB2;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB3;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB4;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB5;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB8;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB9;
import fr.mleduc.xp.emfrelations.revisitor.EmfrelationsRevisitor;
import test.impl.operation.ConceptA0Op;
import test.impl.operation.ConceptA10Op;
import test.impl.operation.ConceptA11Op;
import test.impl.operation.ConceptA1Op;
import test.impl.operation.ConceptA2Op;
import test.impl.operation.ConceptA3Op;
import test.impl.operation.ConceptA4Op;
import test.impl.operation.ConceptA5Op;
import test.impl.operation.ConceptA8Op;
import test.impl.operation.ConceptA9Op;
import test.impl.operation.ConceptB0Op;
import test.impl.operation.ConceptB10Op;
import test.impl.operation.ConceptB11Op;
import test.impl.operation.ConceptB1Op;
import test.impl.operation.ConceptB2Op;
import test.impl.operation.ConceptB3Op;
import test.impl.operation.ConceptB4Op;
import test.impl.operation.ConceptB5Op;
import test.impl.operation.ConceptB8Op;
import test.impl.operation.ConceptB9Op;
import test.impl.operation.impl.ConceptA0OpImpl;
import test.impl.operation.impl.ConceptA10OpImpl;
import test.impl.operation.impl.ConceptA11OpImpl;
import test.impl.operation.impl.ConceptA1OpImpl;
import test.impl.operation.impl.ConceptA2OpImpl;
import test.impl.operation.impl.ConceptA3OpImpl;
import test.impl.operation.impl.ConceptA4OpImpl;
import test.impl.operation.impl.ConceptA5OpImpl;
import test.impl.operation.impl.ConceptA8OpImpl;
import test.impl.operation.impl.ConceptA9OpImpl;
import test.impl.operation.impl.ConceptB0OpImpl;
import test.impl.operation.impl.ConceptB10OpImpl;
import test.impl.operation.impl.ConceptB11OpImpl;
import test.impl.operation.impl.ConceptB1OpImpl;
import test.impl.operation.impl.ConceptB2OpImpl;
import test.impl.operation.impl.ConceptB3OpImpl;
import test.impl.operation.impl.ConceptB4OpImpl;
import test.impl.operation.impl.ConceptB5OpImpl;
import test.impl.operation.impl.ConceptB8OpImpl;
import test.impl.operation.impl.ConceptB9OpImpl;

public interface TestImplementation extends EmfrelationsRevisitor<ConceptA0Op, ConceptA1Op, ConceptA10Op, ConceptA11Op, ConceptA2Op, ConceptA3Op, ConceptA4Op, ConceptA5Op, ConceptA8Op, ConceptA9Op, ConceptB0Op, ConceptB1Op, ConceptB10Op, ConceptB11Op, ConceptB2Op, ConceptB3Op, ConceptB4Op, ConceptB5Op, ConceptB8Op, ConceptB9Op> {
		default ConceptA0Op emfrelations__ConceptA0(ConceptA0 it) {
		return new ConceptA0OpImpl(it, this);
	}

	default ConceptA1Op emfrelations__ConceptA1(ConceptA1 it) {
		return new ConceptA1OpImpl(it, this);
	}

	default ConceptA10Op emfrelations__ConceptA10(ConceptA10 it) {
		return new ConceptA10OpImpl(it, this);
	}

	default ConceptA11Op emfrelations__ConceptA11(ConceptA11 it) {
		return new ConceptA11OpImpl(it, this);
	}

	default ConceptA2Op emfrelations__ConceptA2(ConceptA2 it) {
		return new ConceptA2OpImpl(it, this);
	}

	default ConceptA3Op emfrelations__ConceptA3(ConceptA3 it) {
		return new ConceptA3OpImpl(it, this);
	}

	default ConceptA4Op emfrelations__ConceptA4(ConceptA4 it) {
		return new ConceptA4OpImpl(it, this);
	}

	default ConceptA5Op emfrelations__ConceptA5(ConceptA5 it) {
		return new ConceptA5OpImpl(it, this);
	}

	default ConceptA8Op emfrelations__ConceptA8(ConceptA8 it) {
		return new ConceptA8OpImpl(it, this);
	}

	default ConceptA9Op emfrelations__ConceptA9(ConceptA9 it) {
		return new ConceptA9OpImpl(it, this);
	}

	default ConceptB0Op emfrelations__ConceptB0(ConceptB0 it) {
		return new ConceptB0OpImpl(it, this);
	}

	default ConceptB1Op emfrelations__ConceptB1(ConceptB1 it) {
		return new ConceptB1OpImpl(it, this);
	}

	default ConceptB10Op emfrelations__ConceptB10(ConceptB10 it) {
		return new ConceptB10OpImpl(it, this);
	}

	default ConceptB11Op emfrelations__ConceptB11(ConceptB11 it) {
		return new ConceptB11OpImpl(it, this);
	}

	default ConceptB2Op emfrelations__ConceptB2(ConceptB2 it) {
		return new ConceptB2OpImpl(it, this);
	}

	default ConceptB3Op emfrelations__ConceptB3(ConceptB3 it) {
		return new ConceptB3OpImpl(it, this);
	}

	default ConceptB4Op emfrelations__ConceptB4(ConceptB4 it) {
		return new ConceptB4OpImpl(it, this);
	}

	default ConceptB5Op emfrelations__ConceptB5(ConceptB5 it) {
		return new ConceptB5OpImpl(it, this);
	}

	default ConceptB8Op emfrelations__ConceptB8(ConceptB8 it) {
		return new ConceptB8OpImpl(it, this);
	}

	default ConceptB9Op emfrelations__ConceptB9(ConceptB9 it) {
		return new ConceptB9OpImpl(it, this);
	}
}
