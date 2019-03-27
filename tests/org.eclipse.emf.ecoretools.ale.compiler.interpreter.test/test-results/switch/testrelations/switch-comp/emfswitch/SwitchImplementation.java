package emfswitch;

import emfswitch.operation.ConceptA0Operation;
import emfswitch.operation.ConceptA10Operation;
import emfswitch.operation.ConceptA11Operation;
import emfswitch.operation.ConceptA1Operation;
import emfswitch.operation.ConceptA2Operation;
import emfswitch.operation.ConceptA3Operation;
import emfswitch.operation.ConceptA4Operation;
import emfswitch.operation.ConceptA5Operation;
import emfswitch.operation.ConceptA8Operation;
import emfswitch.operation.ConceptA9Operation;
import emfswitch.operation.ConceptB0Operation;
import emfswitch.operation.ConceptB10Operation;
import emfswitch.operation.ConceptB11Operation;
import emfswitch.operation.ConceptB1Operation;
import emfswitch.operation.ConceptB2Operation;
import emfswitch.operation.ConceptB3Operation;
import emfswitch.operation.ConceptB4Operation;
import emfswitch.operation.ConceptB5Operation;
import emfswitch.operation.ConceptB8Operation;
import emfswitch.operation.ConceptB9Operation;
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
import fr.mleduc.xp.emfrelations.emfrelations.util.EmfrelationsSwitch;
import java.lang.Object;
import java.lang.Override;

public class SwitchImplementation extends EmfrelationsSwitch<Object> {
	@Override
	public Object caseConceptA0(ConceptA0 it) {
		return new ConceptA0Operation(it, this);
	}

	@Override
	public Object caseConceptB0(ConceptB0 it) {
		return new ConceptB0Operation(it, this);
	}

	@Override
	public Object caseConceptA1(ConceptA1 it) {
		return new ConceptA1Operation(it, this);
	}

	@Override
	public Object caseConceptB1(ConceptB1 it) {
		return new ConceptB1Operation(it, this);
	}

	@Override
	public Object caseConceptA2(ConceptA2 it) {
		return new ConceptA2Operation(it, this);
	}

	@Override
	public Object caseConceptB2(ConceptB2 it) {
		return new ConceptB2Operation(it, this);
	}

	@Override
	public Object caseConceptA3(ConceptA3 it) {
		return new ConceptA3Operation(it, this);
	}

	@Override
	public Object caseConceptB3(ConceptB3 it) {
		return new ConceptB3Operation(it, this);
	}

	@Override
	public Object caseConceptA4(ConceptA4 it) {
		return new ConceptA4Operation(it, this);
	}

	@Override
	public Object caseConceptB4(ConceptB4 it) {
		return new ConceptB4Operation(it, this);
	}

	@Override
	public Object caseConceptA5(ConceptA5 it) {
		return new ConceptA5Operation(it, this);
	}

	@Override
	public Object caseConceptB5(ConceptB5 it) {
		return new ConceptB5Operation(it, this);
	}

	@Override
	public Object caseConceptA8(ConceptA8 it) {
		return new ConceptA8Operation(it, this);
	}

	@Override
	public Object caseConceptB8(ConceptB8 it) {
		return new ConceptB8Operation(it, this);
	}

	@Override
	public Object caseConceptA9(ConceptA9 it) {
		return new ConceptA9Operation(it, this);
	}

	@Override
	public Object caseConceptB9(ConceptB9 it) {
		return new ConceptB9Operation(it, this);
	}

	@Override
	public Object caseConceptA10(ConceptA10 it) {
		return new ConceptA10Operation(it, this);
	}

	@Override
	public Object caseConceptB10(ConceptB10 it) {
		return new ConceptB10Operation(it, this);
	}

	@Override
	public Object caseConceptA11(ConceptA11 it) {
		return new ConceptA11Operation(it, this);
	}

	@Override
	public Object caseConceptB11(ConceptB11 it) {
		return new ConceptB11Operation(it, this);
	}
}
