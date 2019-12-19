package visitor;

import testmaprelations.visitor.testmaprelations.CA0;
import testmaprelations.visitor.testmaprelations.CA1;
import testmaprelations.visitor.testmaprelations.CA2;
import testmaprelations.visitor.testmaprelations.CA3;
import testmaprelations.visitor.testmaprelations.CA4;
import testmaprelations.visitor.testmaprelations.CA5;
import testmaprelations.visitor.testmaprelations.CA6;
import testmaprelations.visitor.testmaprelations.CA7;
import testmaprelations.visitor.testmaprelations.CA8;
import testmaprelations.visitor.testmaprelations.CA9;
import testmaprelations.visitor.testmaprelations.CB0;
import testmaprelations.visitor.testmaprelations.CB1;
import testmaprelations.visitor.testmaprelations.CB2;
import testmaprelations.visitor.testmaprelations.CB3;
import testmaprelations.visitor.testmaprelations.CB4;
import testmaprelations.visitor.testmaprelations.CB5;
import testmaprelations.visitor.testmaprelations.CB6;
import testmaprelations.visitor.testmaprelations.CB7;
import testmaprelations.visitor.testmaprelations.CB8;
import testmaprelations.visitor.testmaprelations.CB9;
import testmaprelations.visitor.testmaprelations.MapCA0ToCB0MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA1ToCB1MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA2ToCB2MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA3ToCB3MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA4ToCB4MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA5ToCB5MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA6ToCB6MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA7ToCB7MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA8ToCB8MapEntry;
import testmaprelations.visitor.testmaprelations.MapCA9ToCB9MapEntry;
import visitor.operation.testmaprelations.CA0Operation;
import visitor.operation.testmaprelations.CA1Operation;
import visitor.operation.testmaprelations.CA2Operation;
import visitor.operation.testmaprelations.CA3Operation;
import visitor.operation.testmaprelations.CA4Operation;
import visitor.operation.testmaprelations.CA5Operation;
import visitor.operation.testmaprelations.CA6Operation;
import visitor.operation.testmaprelations.CA7Operation;
import visitor.operation.testmaprelations.CA8Operation;
import visitor.operation.testmaprelations.CA9Operation;
import visitor.operation.testmaprelations.CB0Operation;
import visitor.operation.testmaprelations.CB1Operation;
import visitor.operation.testmaprelations.CB2Operation;
import visitor.operation.testmaprelations.CB3Operation;
import visitor.operation.testmaprelations.CB4Operation;
import visitor.operation.testmaprelations.CB5Operation;
import visitor.operation.testmaprelations.CB6Operation;
import visitor.operation.testmaprelations.CB7Operation;
import visitor.operation.testmaprelations.CB8Operation;
import visitor.operation.testmaprelations.CB9Operation;
import visitor.operation.testmaprelations.MapCA0ToCB0MapEntryOperation;
import visitor.operation.testmaprelations.MapCA1ToCB1MapEntryOperation;
import visitor.operation.testmaprelations.MapCA2ToCB2MapEntryOperation;
import visitor.operation.testmaprelations.MapCA3ToCB3MapEntryOperation;
import visitor.operation.testmaprelations.MapCA4ToCB4MapEntryOperation;
import visitor.operation.testmaprelations.MapCA5ToCB5MapEntryOperation;
import visitor.operation.testmaprelations.MapCA6ToCB6MapEntryOperation;
import visitor.operation.testmaprelations.MapCA7ToCB7MapEntryOperation;
import visitor.operation.testmaprelations.MapCA8ToCB8MapEntryOperation;
import visitor.operation.testmaprelations.MapCA9ToCB9MapEntryOperation;
import visitor.operation.testmaprelations.impl.CA0OperationImpl;
import visitor.operation.testmaprelations.impl.CA1OperationImpl;
import visitor.operation.testmaprelations.impl.CA2OperationImpl;
import visitor.operation.testmaprelations.impl.CA3OperationImpl;
import visitor.operation.testmaprelations.impl.CA4OperationImpl;
import visitor.operation.testmaprelations.impl.CA5OperationImpl;
import visitor.operation.testmaprelations.impl.CA6OperationImpl;
import visitor.operation.testmaprelations.impl.CA7OperationImpl;
import visitor.operation.testmaprelations.impl.CA8OperationImpl;
import visitor.operation.testmaprelations.impl.CA9OperationImpl;
import visitor.operation.testmaprelations.impl.CB0OperationImpl;
import visitor.operation.testmaprelations.impl.CB1OperationImpl;
import visitor.operation.testmaprelations.impl.CB2OperationImpl;
import visitor.operation.testmaprelations.impl.CB3OperationImpl;
import visitor.operation.testmaprelations.impl.CB4OperationImpl;
import visitor.operation.testmaprelations.impl.CB5OperationImpl;
import visitor.operation.testmaprelations.impl.CB6OperationImpl;
import visitor.operation.testmaprelations.impl.CB7OperationImpl;
import visitor.operation.testmaprelations.impl.CB8OperationImpl;
import visitor.operation.testmaprelations.impl.CB9OperationImpl;
import visitor.operation.testmaprelations.impl.MapCA0ToCB0MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA1ToCB1MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA2ToCB2MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA3ToCB3MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA4ToCB4MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA5ToCB5MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA6ToCB6MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA7ToCB7MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA8ToCB8MapEntryOperationImpl;
import visitor.operation.testmaprelations.impl.MapCA9ToCB9MapEntryOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public MapCA0ToCB0MapEntryOperation visittestmaprelations__MapCA0ToCB0MapEntry(
			MapCA0ToCB0MapEntry it) {
		return new MapCA0ToCB0MapEntryOperationImpl(it, this);
	}

	public CA0Operation visittestmaprelations__CA0(CA0 it) {
		return new CA0OperationImpl(it, this);
	}

	public CB0Operation visittestmaprelations__CB0(CB0 it) {
		return new CB0OperationImpl(it, this);
	}

	public MapCA1ToCB1MapEntryOperation visittestmaprelations__MapCA1ToCB1MapEntry(
			MapCA1ToCB1MapEntry it) {
		return new MapCA1ToCB1MapEntryOperationImpl(it, this);
	}

	public CB1Operation visittestmaprelations__CB1(CB1 it) {
		return new CB1OperationImpl(it, this);
	}

	public CA1Operation visittestmaprelations__CA1(CA1 it) {
		return new CA1OperationImpl(it, this);
	}

	public CA2Operation visittestmaprelations__CA2(CA2 it) {
		return new CA2OperationImpl(it, this);
	}

	public CB2Operation visittestmaprelations__CB2(CB2 it) {
		return new CB2OperationImpl(it, this);
	}

	public MapCA2ToCB2MapEntryOperation visittestmaprelations__MapCA2ToCB2MapEntry(
			MapCA2ToCB2MapEntry it) {
		return new MapCA2ToCB2MapEntryOperationImpl(it, this);
	}

	public CB3Operation visittestmaprelations__CB3(CB3 it) {
		return new CB3OperationImpl(it, this);
	}

	public CA3Operation visittestmaprelations__CA3(CA3 it) {
		return new CA3OperationImpl(it, this);
	}

	public MapCA3ToCB3MapEntryOperation visittestmaprelations__MapCA3ToCB3MapEntry(
			MapCA3ToCB3MapEntry it) {
		return new MapCA3ToCB3MapEntryOperationImpl(it, this);
	}

	public CA4Operation visittestmaprelations__CA4(CA4 it) {
		return new CA4OperationImpl(it, this);
	}

	public MapCA4ToCB4MapEntryOperation visittestmaprelations__MapCA4ToCB4MapEntry(
			MapCA4ToCB4MapEntry it) {
		return new MapCA4ToCB4MapEntryOperationImpl(it, this);
	}

	public CB4Operation visittestmaprelations__CB4(CB4 it) {
		return new CB4OperationImpl(it, this);
	}

	public CA5Operation visittestmaprelations__CA5(CA5 it) {
		return new CA5OperationImpl(it, this);
	}

	public CB5Operation visittestmaprelations__CB5(CB5 it) {
		return new CB5OperationImpl(it, this);
	}

	public MapCA5ToCB5MapEntryOperation visittestmaprelations__MapCA5ToCB5MapEntry(
			MapCA5ToCB5MapEntry it) {
		return new MapCA5ToCB5MapEntryOperationImpl(it, this);
	}

	public MapCA6ToCB6MapEntryOperation visittestmaprelations__MapCA6ToCB6MapEntry(
			MapCA6ToCB6MapEntry it) {
		return new MapCA6ToCB6MapEntryOperationImpl(it, this);
	}

	public CA6Operation visittestmaprelations__CA6(CA6 it) {
		return new CA6OperationImpl(it, this);
	}

	public CB6Operation visittestmaprelations__CB6(CB6 it) {
		return new CB6OperationImpl(it, this);
	}

	public CA7Operation visittestmaprelations__CA7(CA7 it) {
		return new CA7OperationImpl(it, this);
	}

	public MapCA7ToCB7MapEntryOperation visittestmaprelations__MapCA7ToCB7MapEntry(
			MapCA7ToCB7MapEntry it) {
		return new MapCA7ToCB7MapEntryOperationImpl(it, this);
	}

	public CB7Operation visittestmaprelations__CB7(CB7 it) {
		return new CB7OperationImpl(it, this);
	}

	public CA8Operation visittestmaprelations__CA8(CA8 it) {
		return new CA8OperationImpl(it, this);
	}

	public MapCA8ToCB8MapEntryOperation visittestmaprelations__MapCA8ToCB8MapEntry(
			MapCA8ToCB8MapEntry it) {
		return new MapCA8ToCB8MapEntryOperationImpl(it, this);
	}

	public CB8Operation visittestmaprelations__CB8(CB8 it) {
		return new CB8OperationImpl(it, this);
	}

	public MapCA9ToCB9MapEntryOperation visittestmaprelations__MapCA9ToCB9MapEntry(
			MapCA9ToCB9MapEntry it) {
		return new MapCA9ToCB9MapEntryOperationImpl(it, this);
	}

	public CB9Operation visittestmaprelations__CB9(CB9 it) {
		return new CB9OperationImpl(it, this);
	}

	public CA9Operation visittestmaprelations__CA9(CA9 it) {
		return new CA9OperationImpl(it, this);
	}
}
