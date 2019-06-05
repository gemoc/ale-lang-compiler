package imp.visitor.imp;

import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

public enum BinaryOp implements Enumerator {
	ADD(0, "ADD", "ADD"),

	SUB(1, "SUB", "SUB"),

	MUL(2, "MUL", "MUL"),

	LT(3, "LT", "LT"),

	LEQ(4, "LEQ", "LEQ"),

	EQ(5, "EQ", "EQ"),

	GEQ(6, "GEQ", "GEQ"),

	GT(7, "GT", "GT"),

	AND(8, "AND", "AND"),

	OR(9, "OR", "OR");

	public static final int ADD_VALUE = 0;

	public static final int SUB_VALUE = 1;

	public static final int MUL_VALUE = 2;

	public static final int LT_VALUE = 3;

	public static final int LEQ_VALUE = 4;

	public static final int EQ_VALUE = 5;

	public static final int GEQ_VALUE = 6;

	public static final int GT_VALUE = 7;

	public static final int AND_VALUE = 8;

	public static final int OR_VALUE = 9;

	private static final BinaryOp[] VALUES_ARRAY = new BinaryOp[] { ADD, SUB, MUL, LT, LEQ, EQ, GEQ, GT, AND, OR };

	public static final List<BinaryOp> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	private final int value;

	private final String name;

	private final String literal;

	private BinaryOp(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	public static BinaryOp get(int value) {
		switch (value) {
			case ADD_VALUE: return ADD;
			case SUB_VALUE: return SUB;
			case MUL_VALUE: return MUL;
			case LT_VALUE: return LT;
			case LEQ_VALUE: return LEQ;
			case EQ_VALUE: return EQ;
			case GEQ_VALUE: return GEQ;
			case GT_VALUE: return GT;
			case AND_VALUE: return AND;
			case OR_VALUE: return OR;
		}
		return null;
	}

	public static BinaryOp get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BinaryOp result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static BinaryOp getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			BinaryOp result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public String getLiteral() {
		return literal;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return literal;
	}
}
