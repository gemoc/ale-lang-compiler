package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class MiniJavaFactoryImpl extends EFactoryImpl implements MiniJavaFactory {
	public MiniJavaFactoryImpl() {
		super();
	}

	public static MiniJavaFactory init() {
		try {
			MiniJavaFactory theMiniJavaFactory = (MiniJavaFactory) EPackage.Registry.INSTANCE.getEFactory(MiniJavaPackage.eNS_URI);
			if (theMiniJavaFactory != null) {
				return theMiniJavaFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MiniJavaFactoryImpl();
	}

	@Override
	@TruffleBoundary
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MiniJavaPackage.PROGRAM :
				return createProgram();
			case MiniJavaPackage.IMPORT :
				return createImport();
			case MiniJavaPackage.TYPE_DECLARATION :
				return createTypeDeclaration();
			case MiniJavaPackage.CLAZZ :
				return createClazz();
			case MiniJavaPackage.INTERFACE :
				return createInterface();
			case MiniJavaPackage.MEMBER :
				return createMember();
			case MiniJavaPackage.METHOD :
				return createMethod();
			case MiniJavaPackage.PARAMETER :
				return createParameter();
			case MiniJavaPackage.FIELD :
				return createField();
			case MiniJavaPackage.BLOCK :
				return createBlock();
			case MiniJavaPackage.STATEMENT :
				return createStatement();
			case MiniJavaPackage.PRINT_STATEMENT :
				return createPrintStatement();
			case MiniJavaPackage.RETURN :
				return createReturn();
			case MiniJavaPackage.IF_STATEMENT :
				return createIfStatement();
			case MiniJavaPackage.WHILE_STATEMENT :
				return createWhileStatement();
			case MiniJavaPackage.FOR_STATEMENT :
				return createForStatement();
			case MiniJavaPackage.TYPE_REF :
				return createTypeRef();
			case MiniJavaPackage.SINGLE_TYPE_REF :
				return createSingleTypeRef();
			case MiniJavaPackage.CLASS_REF :
				return createClassRef();
			case MiniJavaPackage.NAMED_ELEMENT :
				return createNamedElement();
			case MiniJavaPackage.TYPED_DECLARATION :
				return createTypedDeclaration();
			case MiniJavaPackage.SYMBOL :
				return createSymbol();
			case MiniJavaPackage.VARIABLE_DECLARATION :
				return createVariableDeclaration();
			case MiniJavaPackage.ASSIGNMENT :
				return createAssignment();
			case MiniJavaPackage.ASSIGNEE :
				return createAssignee();
			case MiniJavaPackage.EXPRESSION :
				return createExpression();
			case MiniJavaPackage.ARRAY_TYPE_REF :
				return createArrayTypeRef();
			case MiniJavaPackage.INTEGER_TYPE_REF :
				return createIntegerTypeRef();
			case MiniJavaPackage.BOOLEAN_TYPE_REF :
				return createBooleanTypeRef();
			case MiniJavaPackage.STRING_TYPE_REF :
				return createStringTypeRef();
			case MiniJavaPackage.VOID_TYPE_REF :
				return createVoidTypeRef();
			case MiniJavaPackage.OR :
				return createOr();
			case MiniJavaPackage.AND :
				return createAnd();
			case MiniJavaPackage.EQUALITY :
				return createEquality();
			case MiniJavaPackage.INEQUALITY :
				return createInequality();
			case MiniJavaPackage.SUPERIOR_OR_EQUAL :
				return createSuperiorOrEqual();
			case MiniJavaPackage.INFERIOR_OR_EQUAL :
				return createInferiorOrEqual();
			case MiniJavaPackage.SUPERIOR :
				return createSuperior();
			case MiniJavaPackage.INFERIOR :
				return createInferior();
			case MiniJavaPackage.PLUS :
				return createPlus();
			case MiniJavaPackage.MINUS :
				return createMinus();
			case MiniJavaPackage.MULTIPLICATION :
				return createMultiplication();
			case MiniJavaPackage.DIVISION :
				return createDivision();
			case MiniJavaPackage.ARRAY_ACCESS :
				return createArrayAccess();
			case MiniJavaPackage.ARRAY_LENGTH :
				return createArrayLength();
			case MiniJavaPackage.NOT :
				return createNot();
			case MiniJavaPackage.NEG :
				return createNeg();
			case MiniJavaPackage.FIELD_ACCESS :
				return createFieldAccess();
			case MiniJavaPackage.METHOD_CALL :
				return createMethodCall();
			case MiniJavaPackage.STRING_CONSTANT :
				return createStringConstant();
			case MiniJavaPackage.INT_CONSTANT :
				return createIntConstant();
			case MiniJavaPackage.BOOL_CONSTANT :
				return createBoolConstant();
			case MiniJavaPackage.THIS :
				return createThis();
			case MiniJavaPackage.SUPER :
				return createSuper();
			case MiniJavaPackage.NULL :
				return createNull();
			case MiniJavaPackage.NEW_OBJECT :
				return createNewObject();
			case MiniJavaPackage.NEW_ARRAY :
				return createNewArray();
			case MiniJavaPackage.SYMBOL_REF :
				return createSymbolRef();
			case MiniJavaPackage.CONTEXT :
				return createContext();
			case MiniJavaPackage.VALUE :
				return createValue();
			case MiniJavaPackage.INTEGER_VALUE :
				return createIntegerValue();
			case MiniJavaPackage.SYMBOL_BINDING :
				return createSymbolBinding();
			case MiniJavaPackage.FIELD_BINDING :
				return createFieldBinding();
			case MiniJavaPackage.STRING_VALUE :
				return createStringValue();
			case MiniJavaPackage.BOOLEAN_VALUE :
				return createBooleanValue();
			case MiniJavaPackage.OUTPUT_STREAM :
				return createOutputStream();
			case MiniJavaPackage.STATE :
				return createState();
			case MiniJavaPackage.FRAME :
				return createFrame();
			case MiniJavaPackage.NULL_VALUE :
				return createNullValue();
			case MiniJavaPackage.NEW_CALL :
				return createNewCall();
			case MiniJavaPackage.METHOD_CALL2 :
				return createMethodCall2();
			case MiniJavaPackage.OBJECT_INSTANCE :
				return createObjectInstance();
			case MiniJavaPackage.ARRAY_INSTANCE :
				return createArrayInstance();
			case MiniJavaPackage.OBJECT_REF_VALUE :
				return createObjectRefValue();
			case MiniJavaPackage.ARRAY_REF_VALUE :
				return createArrayRefValue();
			case MiniJavaPackage.SYMBOL_TO_SYMBOL_BINDING_MAP :
				return (EObject) createSymbolToSymbolBindingMap();
			case MiniJavaPackage.CLAZZ_TO_METHOD_MAP :
				return (EObject) createClazzToMethodMap();
			case MiniJavaPackage.MODULO :
				return createModulo();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MiniJavaPackage.ACCESS_LEVEL :
				return createAccessLevelFromString(eDataType, initialValue);
			default :
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MiniJavaPackage.ACCESS_LEVEL :
				return convertAccessLevelToString(eDataType, instanceValue);
			default :
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	@TruffleBoundary
	public ProgramImpl createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	@TruffleBoundary
	public ImportImpl createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	@TruffleBoundary
	public TypeDeclarationImpl createTypeDeclaration() {
		TypeDeclarationImpl typeDeclaration = new TypeDeclarationImpl();
		return typeDeclaration;
	}

	@TruffleBoundary
	public ClazzImpl createClazz() {
		ClazzImpl clazz = new ClazzImpl();
		return clazz;
	}

	@TruffleBoundary
	public InterfaceImpl createInterface() {
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
	}

	@TruffleBoundary
	public MemberImpl createMember() {
		MemberImpl member = new MemberImpl();
		return member;
	}

	@TruffleBoundary
	public MethodImpl createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	@TruffleBoundary
	public ParameterImpl createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	@TruffleBoundary
	public FieldImpl createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	@TruffleBoundary
	public BlockImpl createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	@TruffleBoundary
	public StatementImpl createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	@TruffleBoundary
	public PrintStatementImpl createPrintStatement() {
		PrintStatementImpl printStatement = new PrintStatementImpl();
		return printStatement;
	}

	@TruffleBoundary
	public ReturnImpl createReturn() {
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	@TruffleBoundary
	public IfStatementImpl createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	@TruffleBoundary
	public WhileStatementImpl createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	@TruffleBoundary
	public ForStatementImpl createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	@TruffleBoundary
	public TypeRefImpl createTypeRef() {
		TypeRefImpl typeRef = new TypeRefImpl();
		return typeRef;
	}

	@TruffleBoundary
	public SingleTypeRefImpl createSingleTypeRef() {
		SingleTypeRefImpl singleTypeRef = new SingleTypeRefImpl();
		return singleTypeRef;
	}

	@TruffleBoundary
	public ClassRefImpl createClassRef() {
		ClassRefImpl classRef = new ClassRefImpl();
		return classRef;
	}

	@TruffleBoundary
	public NamedElementImpl createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	@TruffleBoundary
	public TypedDeclarationImpl createTypedDeclaration() {
		TypedDeclarationImpl typedDeclaration = new TypedDeclarationImpl();
		return typedDeclaration;
	}

	@TruffleBoundary
	public SymbolImpl createSymbol() {
		SymbolImpl symbol = new SymbolImpl();
		return symbol;
	}

	@TruffleBoundary
	public VariableDeclarationImpl createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	@TruffleBoundary
	public AssignmentImpl createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	@TruffleBoundary
	public AssigneeImpl createAssignee() {
		AssigneeImpl assignee = new AssigneeImpl();
		return assignee;
	}

	@TruffleBoundary
	public ExpressionImpl createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	@TruffleBoundary
	public ArrayTypeRefImpl createArrayTypeRef() {
		ArrayTypeRefImpl arrayTypeRef = new ArrayTypeRefImpl();
		return arrayTypeRef;
	}

	@TruffleBoundary
	public IntegerTypeRefImpl createIntegerTypeRef() {
		IntegerTypeRefImpl integerTypeRef = new IntegerTypeRefImpl();
		return integerTypeRef;
	}

	@TruffleBoundary
	public BooleanTypeRefImpl createBooleanTypeRef() {
		BooleanTypeRefImpl booleanTypeRef = new BooleanTypeRefImpl();
		return booleanTypeRef;
	}

	@TruffleBoundary
	public StringTypeRefImpl createStringTypeRef() {
		StringTypeRefImpl stringTypeRef = new StringTypeRefImpl();
		return stringTypeRef;
	}

	@TruffleBoundary
	public VoidTypeRefImpl createVoidTypeRef() {
		VoidTypeRefImpl voidTypeRef = new VoidTypeRefImpl();
		return voidTypeRef;
	}

	@TruffleBoundary
	public OrImpl createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	@TruffleBoundary
	public AndImpl createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	@TruffleBoundary
	public EqualityImpl createEquality() {
		EqualityImpl equality = new EqualityImpl();
		return equality;
	}

	@TruffleBoundary
	public InequalityImpl createInequality() {
		InequalityImpl inequality = new InequalityImpl();
		return inequality;
	}

	@TruffleBoundary
	public SuperiorOrEqualImpl createSuperiorOrEqual() {
		SuperiorOrEqualImpl superiorOrEqual = new SuperiorOrEqualImpl();
		return superiorOrEqual;
	}

	@TruffleBoundary
	public InferiorOrEqualImpl createInferiorOrEqual() {
		InferiorOrEqualImpl inferiorOrEqual = new InferiorOrEqualImpl();
		return inferiorOrEqual;
	}

	@TruffleBoundary
	public SuperiorImpl createSuperior() {
		SuperiorImpl superior = new SuperiorImpl();
		return superior;
	}

	@TruffleBoundary
	public InferiorImpl createInferior() {
		InferiorImpl inferior = new InferiorImpl();
		return inferior;
	}

	@TruffleBoundary
	public PlusImpl createPlus() {
		PlusImpl plus = new PlusImpl();
		return plus;
	}

	@TruffleBoundary
	public MinusImpl createMinus() {
		MinusImpl minus = new MinusImpl();
		return minus;
	}

	@TruffleBoundary
	public MultiplicationImpl createMultiplication() {
		MultiplicationImpl multiplication = new MultiplicationImpl();
		return multiplication;
	}

	@TruffleBoundary
	public DivisionImpl createDivision() {
		DivisionImpl division = new DivisionImpl();
		return division;
	}

	@TruffleBoundary
	public ArrayAccessImpl createArrayAccess() {
		ArrayAccessImpl arrayAccess = new ArrayAccessImpl();
		return arrayAccess;
	}

	@TruffleBoundary
	public ArrayLengthImpl createArrayLength() {
		ArrayLengthImpl arrayLength = new ArrayLengthImpl();
		return arrayLength;
	}

	@TruffleBoundary
	public NotImpl createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	@TruffleBoundary
	public NegImpl createNeg() {
		NegImpl neg = new NegImpl();
		return neg;
	}

	@TruffleBoundary
	public FieldAccessImpl createFieldAccess() {
		FieldAccessImpl fieldAccess = new FieldAccessImpl();
		return fieldAccess;
	}

	@TruffleBoundary
	public MethodCallImpl createMethodCall() {
		MethodCallImpl methodCall = new MethodCallImpl();
		return methodCall;
	}

	@TruffleBoundary
	public StringConstantImpl createStringConstant() {
		StringConstantImpl stringConstant = new StringConstantImpl();
		return stringConstant;
	}

	@TruffleBoundary
	public IntConstantImpl createIntConstant() {
		IntConstantImpl intConstant = new IntConstantImpl();
		return intConstant;
	}

	@TruffleBoundary
	public BoolConstantImpl createBoolConstant() {
		BoolConstantImpl boolConstant = new BoolConstantImpl();
		return boolConstant;
	}

	@TruffleBoundary
	public ThisImpl createThis() {
		ThisImpl this_ = new ThisImpl();
		return this_;
	}

	@TruffleBoundary
	public SuperImpl createSuper() {
		SuperImpl super_ = new SuperImpl();
		return super_;
	}

	@TruffleBoundary
	public NullImpl createNull() {
		NullImpl null_ = new NullImpl();
		return null_;
	}

	@TruffleBoundary
	public NewObjectImpl createNewObject() {
		NewObjectImpl newObject = new NewObjectImpl();
		return newObject;
	}

	@TruffleBoundary
	public NewArrayImpl createNewArray() {
		NewArrayImpl newArray = new NewArrayImpl();
		return newArray;
	}

	@TruffleBoundary
	public SymbolRefImpl createSymbolRef() {
		SymbolRefImpl symbolRef = new SymbolRefImpl();
		return symbolRef;
	}

	@TruffleBoundary
	public ContextImpl createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	@TruffleBoundary
	public ValueImpl createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	@TruffleBoundary
	public IntegerValueImpl createIntegerValue() {
		IntegerValueImpl integerValue = new IntegerValueImpl();
		return integerValue;
	}

	@TruffleBoundary
	public SymbolBindingImpl createSymbolBinding() {
		SymbolBindingImpl symbolBinding = new SymbolBindingImpl();
		return symbolBinding;
	}

	@TruffleBoundary
	public FieldBindingImpl createFieldBinding() {
		FieldBindingImpl fieldBinding = new FieldBindingImpl();
		return fieldBinding;
	}

	@TruffleBoundary
	public StringValueImpl createStringValue() {
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

	@TruffleBoundary
	public BooleanValueImpl createBooleanValue() {
		BooleanValueImpl booleanValue = new BooleanValueImpl();
		return booleanValue;
	}

	@TruffleBoundary
	public OutputStreamImpl createOutputStream() {
		OutputStreamImpl outputStream = new OutputStreamImpl();
		return outputStream;
	}

	@TruffleBoundary
	public StateImpl createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	@TruffleBoundary
	public FrameImpl createFrame() {
		FrameImpl frame = new FrameImpl();
		return frame;
	}

	@TruffleBoundary
	public NullValueImpl createNullValue() {
		NullValueImpl nullValue = new NullValueImpl();
		return nullValue;
	}

	@TruffleBoundary
	public NewCallImpl createNewCall() {
		NewCallImpl newCall = new NewCallImpl();
		return newCall;
	}

	@TruffleBoundary
	public MethodCall2Impl createMethodCall2() {
		MethodCall2Impl methodCall2 = new MethodCall2Impl();
		return methodCall2;
	}

	@TruffleBoundary
	public ObjectInstanceImpl createObjectInstance() {
		ObjectInstanceImpl objectInstance = new ObjectInstanceImpl();
		return objectInstance;
	}

	@TruffleBoundary
	public ArrayInstanceImpl createArrayInstance() {
		ArrayInstanceImpl arrayInstance = new ArrayInstanceImpl();
		return arrayInstance;
	}

	@TruffleBoundary
	public ObjectRefValueImpl createObjectRefValue() {
		ObjectRefValueImpl objectRefValue = new ObjectRefValueImpl();
		return objectRefValue;
	}

	@TruffleBoundary
	public ArrayRefValueImpl createArrayRefValue() {
		ArrayRefValueImpl arrayRefValue = new ArrayRefValueImpl();
		return arrayRefValue;
	}

	@TruffleBoundary
	public Map.Entry<Symbol, SymbolBinding> createSymbolToSymbolBindingMap() {
		SymbolToSymbolBindingMapImpl symbolToSymbolBindingMap = new SymbolToSymbolBindingMapImpl();
		return symbolToSymbolBindingMap;
	}

	@TruffleBoundary
	public Map.Entry<Clazz, Method> createClazzToMethodMap() {
		ClazzToMethodMapImpl clazzToMethodMap = new ClazzToMethodMapImpl();
		return clazzToMethodMap;
	}

	@TruffleBoundary
	public ModuloImpl createModulo() {
		ModuloImpl modulo = new ModuloImpl();
		return modulo;
	}

	public AccessLevel createAccessLevelFromString(EDataType eDataType, String initialValue) {
		AccessLevel result = AccessLevel.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	public String convertAccessLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	public MiniJavaPackage getMiniJavaPackage() {
		return (MiniJavaPackage) getEPackage();
	}

	@Deprecated
	public static MiniJavaPackage getPackage() {
		return MiniJavaPackage.eINSTANCE;
	}
}
