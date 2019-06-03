package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Assign;
import interpreter.imp.interpreter.imp.Binary;
import interpreter.imp.interpreter.imp.BinaryOp;
import interpreter.imp.interpreter.imp.Block;
import interpreter.imp.interpreter.imp.BoolValue;
import interpreter.imp.interpreter.imp.If;
import interpreter.imp.interpreter.imp.ImpFactory;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntConst;
import interpreter.imp.interpreter.imp.IntValue;
import interpreter.imp.interpreter.imp.Skip;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Unary;
import interpreter.imp.interpreter.imp.UnaryOp;
import interpreter.imp.interpreter.imp.Value;
import interpreter.imp.interpreter.imp.Var;
import interpreter.imp.interpreter.imp.While;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class ImpFactoryImpl extends EFactoryImpl implements ImpFactory {
	public ImpFactoryImpl() {
		super();
	}

	public static ImpFactory init() {
		try {
			ImpFactory theImpFactory = (ImpFactory) EPackage.Registry.INSTANCE.getEFactory(ImpPackage.eNS_URI);
			if (theImpFactory != null) {
				return theImpFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImpFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ImpPackage.SKIP :
				return createSkip();
			case ImpPackage.ASSIGN :
				return createAssign();
			case ImpPackage.BLOCK :
				return createBlock();
			case ImpPackage.IF :
				return createIf();
			case ImpPackage.WHILE :
				return createWhile();
			case ImpPackage.INT_CONST :
				return createIntConst();
			case ImpPackage.VAR :
				return createVar();
			case ImpPackage.UNARY :
				return createUnary();
			case ImpPackage.BINARY :
				return createBinary();
			case ImpPackage.STORE :
				return createStore();
			case ImpPackage.STRING_TO_VALUE_MAP :
				return (EObject) createStringToValueMap();
			case ImpPackage.INT_VALUE :
				return createIntValue();
			case ImpPackage.BOOL_VALUE :
				return createBoolValue();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ImpPackage.UNARY_OP :
				return createUnaryOpFromString(eDataType, initialValue);
			case ImpPackage.BINARY_OP :
				return createBinaryOpFromString(eDataType, initialValue);
			default :
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ImpPackage.UNARY_OP :
				return convertUnaryOpToString(eDataType, instanceValue);
			case ImpPackage.BINARY_OP :
				return convertBinaryOpToString(eDataType, instanceValue);
			default :
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	public Skip createSkip() {
		SkipImpl skip = new SkipImpl();
		return skip;
	}

	public Assign createAssign() {
		AssignImpl assign = new AssignImpl();
		return assign;
	}

	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	public While createWhile() {
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	public IntConst createIntConst() {
		IntConstImpl intConst = new IntConstImpl();
		return intConst;
	}

	public Var createVar() {
		VarImpl var = new VarImpl();
		return var;
	}

	public Unary createUnary() {
		UnaryImpl unary = new UnaryImpl();
		return unary;
	}

	public Binary createBinary() {
		BinaryImpl binary = new BinaryImpl();
		return binary;
	}

	public Store createStore() {
		StoreImpl store = new StoreImpl();
		return store;
	}

	public Map.Entry<String, Value> createStringToValueMap() {
		StringToValueMapImpl stringToValueMap = new StringToValueMapImpl();
		return stringToValueMap;
	}

	public IntValue createIntValue() {
		IntValueImpl intValue = new IntValueImpl();
		return intValue;
	}

	public BoolValue createBoolValue() {
		BoolValueImpl boolValue = new BoolValueImpl();
		return boolValue;
	}

	public UnaryOp createUnaryOpFromString(EDataType eDataType, String initialValue) {
		UnaryOp result = UnaryOp.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	public String convertUnaryOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	public BinaryOp createBinaryOpFromString(EDataType eDataType, String initialValue) {
		BinaryOp result = BinaryOp.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	public String convertBinaryOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	public ImpPackage getImpPackage() {
		return (ImpPackage) getEPackage();
	}

	@Deprecated
	public static ImpPackage getPackage() {
		return ImpPackage.eINSTANCE;
	}
}
