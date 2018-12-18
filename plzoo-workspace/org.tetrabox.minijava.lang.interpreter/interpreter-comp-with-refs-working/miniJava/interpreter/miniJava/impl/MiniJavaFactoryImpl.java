package miniJava.interpreter.miniJava.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.And;
import miniJava.interpreter.miniJava.ArrayAccess;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayLength;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.ArrayTypeRef;
import miniJava.interpreter.miniJava.Assignee;
import miniJava.interpreter.miniJava.Assignment;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.BoolConstant;
import miniJava.interpreter.miniJava.BooleanTypeRef;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.ClassRef;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Division;
import miniJava.interpreter.miniJava.Equality;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldAccess;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.ForStatement;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.IfStatement;
import miniJava.interpreter.miniJava.Import;
import miniJava.interpreter.miniJava.Inequality;
import miniJava.interpreter.miniJava.Inferior;
import miniJava.interpreter.miniJava.InferiorOrEqual;
import miniJava.interpreter.miniJava.IntConstant;
import miniJava.interpreter.miniJava.IntegerTypeRef;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.Interface;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MethodCall;
import miniJava.interpreter.miniJava.MethodCall2;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Minus;
import miniJava.interpreter.miniJava.Multiplication;
import miniJava.interpreter.miniJava.NamedElement;
import miniJava.interpreter.miniJava.Neg;
import miniJava.interpreter.miniJava.NewArray;
import miniJava.interpreter.miniJava.NewCall;
import miniJava.interpreter.miniJava.NewObject;
import miniJava.interpreter.miniJava.Not;
import miniJava.interpreter.miniJava.Null;
import miniJava.interpreter.miniJava.NullValue;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.Or;
import miniJava.interpreter.miniJava.OutputStream;
import miniJava.interpreter.miniJava.Parameter;
import miniJava.interpreter.miniJava.Plus;
import miniJava.interpreter.miniJava.PrintStatement;
import miniJava.interpreter.miniJava.Program;
import miniJava.interpreter.miniJava.Return;
import miniJava.interpreter.miniJava.SingleTypeRef;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Statement;
import miniJava.interpreter.miniJava.StringConstant;
import miniJava.interpreter.miniJava.StringTypeRef;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Super;
import miniJava.interpreter.miniJava.Superior;
import miniJava.interpreter.miniJava.SuperiorOrEqual;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;
import miniJava.interpreter.miniJava.SymbolRef;
import miniJava.interpreter.miniJava.This;
import miniJava.interpreter.miniJava.TypeDeclaration;
import miniJava.interpreter.miniJava.TypeRef;
import miniJava.interpreter.miniJava.TypedDeclaration;
import miniJava.interpreter.miniJava.Value;
import miniJava.interpreter.miniJava.VariableDeclaration;
import miniJava.interpreter.miniJava.VoidTypeRef;
import miniJava.interpreter.miniJava.WhileStatement;

public class MiniJavaFactoryImpl extends EFactoryImpl implements MiniJavaFactory {
	public static MiniJavaFactory init() {
		try {
			MiniJavaFactory theMiniJavaFactory = (MiniJavaFactory) EPackage.Registry.INSTANCE
					.getEFactory(MiniJavaPackage.eNS_URI);
			if (theMiniJavaFactory != null) {
				return theMiniJavaFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MiniJavaFactoryImpl();
	}

	public MiniJavaFactoryImpl() {
	}

	public String convertAccessLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case MiniJavaPackage.ACCESS_LEVEL:
			return convertAccessLevelToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MiniJavaPackage.PROGRAM:
			return createProgram();
		case MiniJavaPackage.IMPORT:
			return createImport();
		case MiniJavaPackage.TYPE_DECLARATION:
			return createTypeDeclaration();
		case MiniJavaPackage.CLAZZ:
			return createClazz();
		case MiniJavaPackage.INTERFACE:
			return createInterface();
		case MiniJavaPackage.MEMBER:
			return createMember();
		case MiniJavaPackage.METHOD:
			return createMethod();
		case MiniJavaPackage.PARAMETER:
			return createParameter();
		case MiniJavaPackage.FIELD:
			return createField();
		case MiniJavaPackage.BLOCK:
			return createBlock();
		case MiniJavaPackage.STATEMENT:
			return createStatement();
		case MiniJavaPackage.PRINT_STATEMENT:
			return createPrintStatement();
		case MiniJavaPackage.RETURN:
			return createReturn();
		case MiniJavaPackage.IF_STATEMENT:
			return createIfStatement();
		case MiniJavaPackage.WHILE_STATEMENT:
			return createWhileStatement();
		case MiniJavaPackage.FOR_STATEMENT:
			return createForStatement();
		case MiniJavaPackage.TYPE_REF:
			return createTypeRef();
		case MiniJavaPackage.SINGLE_TYPE_REF:
			return createSingleTypeRef();
		case MiniJavaPackage.CLASS_REF:
			return createClassRef();
		case MiniJavaPackage.NAMED_ELEMENT:
			return createNamedElement();
		case MiniJavaPackage.TYPED_DECLARATION:
			return createTypedDeclaration();
		case MiniJavaPackage.SYMBOL:
			return createSymbol();
		case MiniJavaPackage.VARIABLE_DECLARATION:
			return createVariableDeclaration();
		case MiniJavaPackage.ASSIGNMENT:
			return createAssignment();
		case MiniJavaPackage.ASSIGNEE:
			return createAssignee();
		case MiniJavaPackage.EXPRESSION:
			return createExpression();
		case MiniJavaPackage.ARRAY_TYPE_REF:
			return createArrayTypeRef();
		case MiniJavaPackage.INTEGER_TYPE_REF:
			return createIntegerTypeRef();
		case MiniJavaPackage.BOOLEAN_TYPE_REF:
			return createBooleanTypeRef();
		case MiniJavaPackage.STRING_TYPE_REF:
			return createStringTypeRef();
		case MiniJavaPackage.VOID_TYPE_REF:
			return createVoidTypeRef();
		case MiniJavaPackage.OR:
			return createOr();
		case MiniJavaPackage.AND:
			return createAnd();
		case MiniJavaPackage.EQUALITY:
			return createEquality();
		case MiniJavaPackage.INEQUALITY:
			return createInequality();
		case MiniJavaPackage.SUPERIOR_OR_EQUAL:
			return createSuperiorOrEqual();
		case MiniJavaPackage.INFERIOR_OR_EQUAL:
			return createInferiorOrEqual();
		case MiniJavaPackage.SUPERIOR:
			return createSuperior();
		case MiniJavaPackage.INFERIOR:
			return createInferior();
		case MiniJavaPackage.PLUS:
			return createPlus();
		case MiniJavaPackage.MINUS:
			return createMinus();
		case MiniJavaPackage.MULTIPLICATION:
			return createMultiplication();
		case MiniJavaPackage.DIVISION:
			return createDivision();
		case MiniJavaPackage.ARRAY_ACCESS:
			return createArrayAccess();
		case MiniJavaPackage.ARRAY_LENGTH:
			return createArrayLength();
		case MiniJavaPackage.NOT:
			return createNot();
		case MiniJavaPackage.NEG:
			return createNeg();
		case MiniJavaPackage.FIELD_ACCESS:
			return createFieldAccess();
		case MiniJavaPackage.METHOD_CALL:
			return createMethodCall();
		case MiniJavaPackage.STRING_CONSTANT:
			return createStringConstant();
		case MiniJavaPackage.INT_CONSTANT:
			return createIntConstant();
		case MiniJavaPackage.BOOL_CONSTANT:
			return createBoolConstant();
		case MiniJavaPackage.THIS:
			return createThis();
		case MiniJavaPackage.SUPER:
			return createSuper();
		case MiniJavaPackage.NULL:
			return createNull();
		case MiniJavaPackage.NEW_OBJECT:
			return createNewObject();
		case MiniJavaPackage.NEW_ARRAY:
			return createNewArray();
		case MiniJavaPackage.SYMBOL_REF:
			return createSymbolRef();
		case MiniJavaPackage.CONTEXT:
			return createContext();
		case MiniJavaPackage.VALUE:
			return createValue();
		case MiniJavaPackage.INTEGER_VALUE:
			return createIntegerValue();
		case MiniJavaPackage.SYMBOL_BINDING:
			return createSymbolBinding();
		case MiniJavaPackage.FIELD_BINDING:
			return createFieldBinding();
		case MiniJavaPackage.STRING_VALUE:
			return createStringValue();
		case MiniJavaPackage.BOOLEAN_VALUE:
			return createBooleanValue();
		case MiniJavaPackage.OUTPUT_STREAM:
			return createOutputStream();
		case MiniJavaPackage.STATE:
			return createState();
		case MiniJavaPackage.FRAME:
			return createFrame();
		case MiniJavaPackage.NULL_VALUE:
			return createNullValue();
		case MiniJavaPackage.NEW_CALL:
			return createNewCall();
		case MiniJavaPackage.METHOD_CALL2:
			return createMethodCall2();
		case MiniJavaPackage.OBJECT_INSTANCE:
			return createObjectInstance();
		case MiniJavaPackage.ARRAY_INSTANCE:
			return createArrayInstance();
		case MiniJavaPackage.OBJECT_REF_VALUE:
			return createObjectRefValue();
		case MiniJavaPackage.ARRAY_REF_VALUE:
			return createArrayRefValue();
		case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP:
			return (org.eclipse.emf.ecore.EObject) createSymbolToSymbolBindingMap();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public AccessLevel createAccessLevelFromString(EDataType eDataType, String initialValue) {
		AccessLevel result = AccessLevel.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	public And createAnd() {
		AndImpl ret = new AndImpl();
		return ret;
	}

	public ArrayAccess createArrayAccess() {
		ArrayAccessImpl ret = new ArrayAccessImpl();
		return ret;
	}

	public ArrayInstance createArrayInstance() {
		ArrayInstanceImpl ret = new ArrayInstanceImpl();
		return ret;
	}

	public ArrayLength createArrayLength() {
		ArrayLengthImpl ret = new ArrayLengthImpl();
		return ret;
	}

	public ArrayRefValue createArrayRefValue() {
		ArrayRefValueImpl ret = new ArrayRefValueImpl();
		return ret;
	}

	public ArrayTypeRef createArrayTypeRef() {
		ArrayTypeRefImpl ret = new ArrayTypeRefImpl();
		return ret;
	}

	public Assignee createAssignee() {
		AssigneeImpl ret = new AssigneeImpl();
		return ret;
	}

	public Assignment createAssignment() {
		AssignmentImpl ret = new AssignmentImpl();
		return ret;
	}

	public Block createBlock() {
		BlockImpl ret = new BlockImpl();
		return ret;
	}

	public BoolConstant createBoolConstant() {
		BoolConstantImpl ret = new BoolConstantImpl();
		return ret;
	}

	public BooleanTypeRef createBooleanTypeRef() {
		BooleanTypeRefImpl ret = new BooleanTypeRefImpl();
		return ret;
	}

	public BooleanValue createBooleanValue() {
		BooleanValueImpl ret = new BooleanValueImpl();
		return ret;
	}

	public ClassRef createClassRef() {
		ClassRefImpl ret = new ClassRefImpl();
		return ret;
	}

	public Clazz createClazz() {
		ClazzImpl ret = new ClazzImpl();
		return ret;
	}

	public Context createContext() {
		ContextImpl ret = new ContextImpl();
		return ret;
	}

	public Division createDivision() {
		DivisionImpl ret = new DivisionImpl();
		return ret;
	}

	public Equality createEquality() {
		EqualityImpl ret = new EqualityImpl();
		return ret;
	}

	public Expression createExpression() {
		ExpressionImpl ret = new ExpressionImpl();
		return ret;
	}

	public Field createField() {
		FieldImpl ret = new FieldImpl();
		return ret;
	}

	public FieldAccess createFieldAccess() {
		FieldAccessImpl ret = new FieldAccessImpl();
		return ret;
	}

	public FieldBinding createFieldBinding() {
		FieldBindingImpl ret = new FieldBindingImpl();
		return ret;
	}

	public ForStatement createForStatement() {
		ForStatementImpl ret = new ForStatementImpl();
		return ret;
	}

	public Frame createFrame() {
		FrameImpl ret = new FrameImpl();
		return ret;
	}

	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case MiniJavaPackage.ACCESS_LEVEL:
			return createAccessLevelFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	public IfStatement createIfStatement() {
		IfStatementImpl ret = new IfStatementImpl();
		return ret;
	}

	public Import createImport() {
		ImportImpl ret = new ImportImpl();
		return ret;
	}

	public Inequality createInequality() {
		InequalityImpl ret = new InequalityImpl();
		return ret;
	}

	public Inferior createInferior() {
		InferiorImpl ret = new InferiorImpl();
		return ret;
	}

	public InferiorOrEqual createInferiorOrEqual() {
		InferiorOrEqualImpl ret = new InferiorOrEqualImpl();
		return ret;
	}

	public IntConstant createIntConstant() {
		IntConstantImpl ret = new IntConstantImpl();
		return ret;
	}

	public IntegerTypeRef createIntegerTypeRef() {
		IntegerTypeRefImpl ret = new IntegerTypeRefImpl();
		return ret;
	}

	public IntegerValue createIntegerValue() {
		IntegerValueImpl ret = new IntegerValueImpl();
		return ret;
	}

	public Interface createInterface() {
		InterfaceImpl ret = new InterfaceImpl();
		return ret;
	}

	public Member createMember() {
		MemberImpl ret = new MemberImpl();
		return ret;
	}

	public Method createMethod() {
		MethodImpl ret = new MethodImpl();
		return ret;
	}

	public MethodCall createMethodCall() {
		MethodCallImpl ret = new MethodCallImpl();
		return ret;
	}

	public MethodCall2 createMethodCall2() {
		MethodCall2Impl ret = new MethodCall2Impl();
		return ret;
	}

	public Minus createMinus() {
		MinusImpl ret = new MinusImpl();
		return ret;
	}

	public Multiplication createMultiplication() {
		MultiplicationImpl ret = new MultiplicationImpl();
		return ret;
	}

	public NamedElement createNamedElement() {
		NamedElementImpl ret = new NamedElementImpl();
		return ret;
	}

	public Neg createNeg() {
		NegImpl ret = new NegImpl();
		return ret;
	}

	public NewArray createNewArray() {
		NewArrayImpl ret = new NewArrayImpl();
		return ret;
	}

	public NewCall createNewCall() {
		NewCallImpl ret = new NewCallImpl();
		return ret;
	}

	public NewObject createNewObject() {
		NewObjectImpl ret = new NewObjectImpl();
		return ret;
	}

	public Not createNot() {
		NotImpl ret = new NotImpl();
		return ret;
	}

	public Null createNull() {
		NullImpl ret = new NullImpl();
		return ret;
	}

	public NullValue createNullValue() {
		NullValueImpl ret = new NullValueImpl();
		return ret;
	}

	public ObjectInstance createObjectInstance() {
		ObjectInstanceImpl ret = new ObjectInstanceImpl();
		return ret;
	}

	public ObjectRefValue createObjectRefValue() {
		ObjectRefValueImpl ret = new ObjectRefValueImpl();
		return ret;
	}

	public Or createOr() {
		OrImpl ret = new OrImpl();
		return ret;
	}

	public OutputStream createOutputStream() {
		OutputStreamImpl ret = new OutputStreamImpl();
		return ret;
	}

	public Parameter createParameter() {
		ParameterImpl ret = new ParameterImpl();
		return ret;
	}

	public Plus createPlus() {
		PlusImpl ret = new PlusImpl();
		return ret;
	}

	public PrintStatement createPrintStatement() {
		PrintStatementImpl ret = new PrintStatementImpl();
		return ret;
	}

	public Program createProgram() {
		ProgramImpl ret = new ProgramImpl();
		return ret;
	}

	public Return createReturn() {
		ReturnImpl ret = new ReturnImpl();
		return ret;
	}

	public SingleTypeRef createSingleTypeRef() {
		SingleTypeRefImpl ret = new SingleTypeRefImpl();
		return ret;
	}

	public State createState() {
		StateImpl ret = new StateImpl();
		return ret;
	}

	public Statement createStatement() {
		StatementImpl ret = new StatementImpl();
		return ret;
	}

	public StringConstant createStringConstant() {
		StringConstantImpl ret = new StringConstantImpl();
		return ret;
	}

	public StringTypeRef createStringTypeRef() {
		StringTypeRefImpl ret = new StringTypeRefImpl();
		return ret;
	}

	public StringValue createStringValue() {
		StringValueImpl ret = new StringValueImpl();
		return ret;
	}

	public Super createSuper() {
		SuperImpl ret = new SuperImpl();
		return ret;
	}

	public Superior createSuperior() {
		SuperiorImpl ret = new SuperiorImpl();
		return ret;
	}

	public SuperiorOrEqual createSuperiorOrEqual() {
		SuperiorOrEqualImpl ret = new SuperiorOrEqualImpl();
		return ret;
	}

	public Symbol createSymbol() {
		SymbolImpl ret = new SymbolImpl();
		return ret;
	}

	public SymbolBinding createSymbolBinding() {
		SymbolBindingImpl ret = new SymbolBindingImpl();
		return ret;
	}

	public SymbolRef createSymbolRef() {
		SymbolRefImpl ret = new SymbolRefImpl();
		return ret;
	}

	public Map.Entry<Symbol, SymbolBinding> createSymbolToSymbolBindingMap() {
		SymbolToSymbolBindingMapImpl ret = new SymbolToSymbolBindingMapImpl();
		return ret;
	}

	public This createThis() {
		ThisImpl ret = new ThisImpl();
		return ret;
	}

	public TypedDeclaration createTypedDeclaration() {
		TypedDeclarationImpl ret = new TypedDeclarationImpl();
		return ret;
	}

	public TypeDeclaration createTypeDeclaration() {
		TypeDeclarationImpl ret = new TypeDeclarationImpl();
		return ret;
	}

	public TypeRef createTypeRef() {
		TypeRefImpl ret = new TypeRefImpl();
		return ret;
	}

	public Value createValue() {
		ValueImpl ret = new ValueImpl();
		return ret;
	}

	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl ret = new VariableDeclarationImpl();
		return ret;
	}

	public VoidTypeRef createVoidTypeRef() {
		VoidTypeRefImpl ret = new VoidTypeRefImpl();
		return ret;
	}

	public WhileStatement createWhileStatement() {
		WhileStatementImpl ret = new WhileStatementImpl();
		return ret;
	}

	public MiniJavaPackage getMiniJavaPackage() {
		return (MiniJavaPackage) getEPackage();
	}
}
