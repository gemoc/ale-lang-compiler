package emfswitch;

import emfswitch.operation.CA0Operation;
import emfswitch.operation.CA1Operation;
import emfswitch.operation.CA2Operation;
import emfswitch.operation.CA3Operation;
import emfswitch.operation.CA4Operation;
import emfswitch.operation.CA5Operation;
import emfswitch.operation.CA6Operation;
import emfswitch.operation.CA7Operation;
import emfswitch.operation.CA8Operation;
import emfswitch.operation.CA9Operation;
import emfswitch.operation.CB0Operation;
import emfswitch.operation.CB1Operation;
import emfswitch.operation.CB2Operation;
import emfswitch.operation.CB3Operation;
import emfswitch.operation.CB4Operation;
import emfswitch.operation.CB5Operation;
import emfswitch.operation.CB6Operation;
import emfswitch.operation.CB7Operation;
import emfswitch.operation.CB8Operation;
import emfswitch.operation.CB9Operation;
import java.lang.Object;
import java.lang.Override;
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
import testmaprelations.util.TestmaprelationsSwitch;

public class SwitchImplementation extends TestmaprelationsSwitch<Object> {
	@Override
	public Object caseCA0(CA0 it) {
		return new CA0Operation(it, this);
	}

	@Override
	public Object caseCB0(CB0 it) {
		return new CB0Operation(it, this);
	}

	@Override
	public Object caseCB1(CB1 it) {
		return new CB1Operation(it, this);
	}

	@Override
	public Object caseCA1(CA1 it) {
		return new CA1Operation(it, this);
	}

	@Override
	public Object caseCA2(CA2 it) {
		return new CA2Operation(it, this);
	}

	@Override
	public Object caseCB2(CB2 it) {
		return new CB2Operation(it, this);
	}

	@Override
	public Object caseCB3(CB3 it) {
		return new CB3Operation(it, this);
	}

	@Override
	public Object caseCA3(CA3 it) {
		return new CA3Operation(it, this);
	}

	@Override
	public Object caseCA4(CA4 it) {
		return new CA4Operation(it, this);
	}

	@Override
	public Object caseCB4(CB4 it) {
		return new CB4Operation(it, this);
	}

	@Override
	public Object caseCA5(CA5 it) {
		return new CA5Operation(it, this);
	}

	@Override
	public Object caseCB5(CB5 it) {
		return new CB5Operation(it, this);
	}

	@Override
	public Object caseCA6(CA6 it) {
		return new CA6Operation(it, this);
	}

	@Override
	public Object caseCB6(CB6 it) {
		return new CB6Operation(it, this);
	}

	@Override
	public Object caseCA7(CA7 it) {
		return new CA7Operation(it, this);
	}

	@Override
	public Object caseCB7(CB7 it) {
		return new CB7Operation(it, this);
	}

	@Override
	public Object caseCA8(CA8 it) {
		return new CA8Operation(it, this);
	}

	@Override
	public Object caseCB8(CB8 it) {
		return new CB8Operation(it, this);
	}

	@Override
	public Object caseCB9(CB9 it) {
		return new CB9Operation(it, this);
	}

	@Override
	public Object caseCA9(CA9 it) {
		return new CA9Operation(it, this);
	}
}
