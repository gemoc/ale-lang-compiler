package test.impl;

import test.impl.operation.CA0Op;
import test.impl.operation.CA1Op;
import test.impl.operation.CA2Op;
import test.impl.operation.CA3Op;
import test.impl.operation.CA4Op;
import test.impl.operation.CA5Op;
import test.impl.operation.CA6Op;
import test.impl.operation.CA7Op;
import test.impl.operation.CA8Op;
import test.impl.operation.CA9Op;
import test.impl.operation.CB0Op;
import test.impl.operation.CB1Op;
import test.impl.operation.CB2Op;
import test.impl.operation.CB3Op;
import test.impl.operation.CB4Op;
import test.impl.operation.CB5Op;
import test.impl.operation.CB6Op;
import test.impl.operation.CB7Op;
import test.impl.operation.CB8Op;
import test.impl.operation.CB9Op;
import test.impl.operation.impl.CA0OpImpl;
import test.impl.operation.impl.CA1OpImpl;
import test.impl.operation.impl.CA2OpImpl;
import test.impl.operation.impl.CA3OpImpl;
import test.impl.operation.impl.CA4OpImpl;
import test.impl.operation.impl.CA5OpImpl;
import test.impl.operation.impl.CA6OpImpl;
import test.impl.operation.impl.CA7OpImpl;
import test.impl.operation.impl.CA8OpImpl;
import test.impl.operation.impl.CA9OpImpl;
import test.impl.operation.impl.CB0OpImpl;
import test.impl.operation.impl.CB1OpImpl;
import test.impl.operation.impl.CB2OpImpl;
import test.impl.operation.impl.CB3OpImpl;
import test.impl.operation.impl.CB4OpImpl;
import test.impl.operation.impl.CB5OpImpl;
import test.impl.operation.impl.CB6OpImpl;
import test.impl.operation.impl.CB7OpImpl;
import test.impl.operation.impl.CB8OpImpl;
import test.impl.operation.impl.CB9OpImpl;
import testmaprelations.CA0;
import testmaprelations.CA1;
import testmaprelations.CA2;
import testmaprelations.CA3;
import testmaprelations.CA4;
import testmaprelations.CA5;
import testmaprelations.CA6;
import testmaprelations.CA7;
import testmaprelations.CA8;
import testmaprelations.CA9;
import testmaprelations.CB0;
import testmaprelations.CB1;
import testmaprelations.CB2;
import testmaprelations.CB3;
import testmaprelations.CB4;
import testmaprelations.CB5;
import testmaprelations.CB6;
import testmaprelations.CB7;
import testmaprelations.CB8;
import testmaprelations.CB9;
import testmaprelations.revisitor.TestmaprelationsRevisitor;

public interface TestImplementation extends TestmaprelationsRevisitor<CA0Op, CA1Op, CA2Op, CA3Op, CA4Op, CA5Op, CA6Op, CA7Op, CA8Op, CA9Op, CB0Op, CB1Op, CB2Op, CB3Op, CB4Op, CB5Op, CB6Op, CB7Op, CB8Op, CB9Op> {
		default CA0Op testmaprelations__CA0(CA0 it) {
		return new CA0OpImpl(it, this);
	}

	default CA1Op testmaprelations__CA1(CA1 it) {
		return new CA1OpImpl(it, this);
	}

	default CA2Op testmaprelations__CA2(CA2 it) {
		return new CA2OpImpl(it, this);
	}

	default CA3Op testmaprelations__CA3(CA3 it) {
		return new CA3OpImpl(it, this);
	}

	default CA4Op testmaprelations__CA4(CA4 it) {
		return new CA4OpImpl(it, this);
	}

	default CA5Op testmaprelations__CA5(CA5 it) {
		return new CA5OpImpl(it, this);
	}

	default CA6Op testmaprelations__CA6(CA6 it) {
		return new CA6OpImpl(it, this);
	}

	default CA7Op testmaprelations__CA7(CA7 it) {
		return new CA7OpImpl(it, this);
	}

	default CA8Op testmaprelations__CA8(CA8 it) {
		return new CA8OpImpl(it, this);
	}

	default CA9Op testmaprelations__CA9(CA9 it) {
		return new CA9OpImpl(it, this);
	}

	default CB0Op testmaprelations__CB0(CB0 it) {
		return new CB0OpImpl(it, this);
	}

	default CB1Op testmaprelations__CB1(CB1 it) {
		return new CB1OpImpl(it, this);
	}

	default CB2Op testmaprelations__CB2(CB2 it) {
		return new CB2OpImpl(it, this);
	}

	default CB3Op testmaprelations__CB3(CB3 it) {
		return new CB3OpImpl(it, this);
	}

	default CB4Op testmaprelations__CB4(CB4 it) {
		return new CB4OpImpl(it, this);
	}

	default CB5Op testmaprelations__CB5(CB5 it) {
		return new CB5OpImpl(it, this);
	}

	default CB6Op testmaprelations__CB6(CB6 it) {
		return new CB6OpImpl(it, this);
	}

	default CB7Op testmaprelations__CB7(CB7 it) {
		return new CB7OpImpl(it, this);
	}

	default CB8Op testmaprelations__CB8(CB8 it) {
		return new CB8OpImpl(it, this);
	}

	default CB9Op testmaprelations__CB9(CB9 it) {
		return new CB9OpImpl(it, this);
	}
}
