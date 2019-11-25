package testoperationbody.visitor.testoperationbody;

import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.Enumerator;

public enum EnumA implements Enumerator {
	CASE1(0, "CASE1", "CASE1"),

	CASE2(1, "CASE2", "CASE2");

	public static final int CASE1_VALUE = 0;

	public static final int CASE2_VALUE = 1;

	private static final EnumA[] VALUES_ARRAY = new EnumA[] { CASE1, CASE2 };

	public static final List<EnumA> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	private final int value;

	private final String name;

	private final String literal;

	private EnumA(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	public static EnumA get(int value) {
		switch (value) {
			case CASE1_VALUE: return CASE1;
			case CASE2_VALUE: return CASE2;
		}
		return null;
	}

	public static EnumA get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumA result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	public static EnumA getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumA result = VALUES_ARRAY[i];
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
