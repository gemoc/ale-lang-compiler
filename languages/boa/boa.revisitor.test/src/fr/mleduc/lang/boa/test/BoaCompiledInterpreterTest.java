package fr.mleduc.lang.boa.test;

import org.junit.Test;

import interpreter.boa.interpreter.boa.ArithOpPlus;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.File;
import interpreter.boa.interpreter.boa.Int;

public class BoaCompiledInterpreterTest {

	@Test
	public void test() {
		BoaFactory f = BoaFactory.eINSTANCE;

		File file = f.createFile();
		ArithOpPlus createArithOpPlus = f.createArithOpPlus();
		Int createInt = f.createInt();
		createInt.setValue(1);
		createArithOpPlus.setLhs(createInt);
		Int createInt2 = f.createInt();
		createInt2.setValue(2);
		createArithOpPlus.setRhs(createInt2);
		file.getCommands().add(createArithOpPlus);
		file.eval();
	}
}
