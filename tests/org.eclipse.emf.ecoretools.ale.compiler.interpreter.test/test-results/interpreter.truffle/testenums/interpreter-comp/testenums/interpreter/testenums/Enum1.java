package testenums.interpreter.testenums;

import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

public enum Enum1 implements Enumerator {
	LITERAL0(0, "LITERAL0", "LITERAL0"),

	LITERAL1(1, "LITERAL1", "LITERAL1");

	public static final int LITERAL0_VALUE = 0;

	public static final int LITERAL1_VALUE = 1;

	private static final Enum1[] VALUES_ARRAY = new Enum1[] { LITERAL0, LITERAL1 };

	public static final List<Enum1> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	private final int value;

	private final String name;

	private final String literal;

	private Enum1(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	public static Enum1 get(int value) {
		switch (value) {
			case LITERAL0_VALUE: return LITERAL0;
			case LITERAL1_VALUE: return LITERAL1;
		}
		return null;
	}

	public static Enum1 get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Enum1 result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static Enum1 getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Enum1 result = VALUES_ARRAY[i];
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
