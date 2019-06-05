package imp.visitor.imp;

import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

public enum UnaryOp implements Enumerator {
	NEGATE(0, "NEGATE", "NEGATE"),

	NOT(1, "NOT", "NOT");

	public static final int NEGATE_VALUE = 0;

	public static final int NOT_VALUE = 1;

	private static final UnaryOp[] VALUES_ARRAY = new UnaryOp[] { NEGATE, NOT };

	public static final List<UnaryOp> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	private final int value;

	private final String name;

	private final String literal;

	private UnaryOp(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	public static UnaryOp get(int value) {
		switch (value) {
			case NEGATE_VALUE: return NEGATE;
			case NOT_VALUE: return NOT;
		}
		return null;
	}

	public static UnaryOp get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnaryOp result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static UnaryOp getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnaryOp result = VALUES_ARRAY[i];
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
