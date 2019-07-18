package miniJava.interpreter.miniJava;

import miniJava.interpreter.miniJava.impl.AndImpl;
import miniJava.interpreter.miniJava.impl.ArrayAccessImpl;
import miniJava.interpreter.miniJava.impl.ArrayInstanceImpl;
import miniJava.interpreter.miniJava.impl.ArrayLengthImpl;
import miniJava.interpreter.miniJava.impl.ArrayRefValueImpl;
import miniJava.interpreter.miniJava.impl.ArrayTypeRefImpl;
import miniJava.interpreter.miniJava.impl.AssigneeImpl;
import miniJava.interpreter.miniJava.impl.AssignmentImpl;
import miniJava.interpreter.miniJava.impl.BlockImpl;
import miniJava.interpreter.miniJava.impl.BoolConstantImpl;
import miniJava.interpreter.miniJava.impl.BooleanTypeRefImpl;
import miniJava.interpreter.miniJava.impl.BooleanValueImpl;
import miniJava.interpreter.miniJava.impl.ClassRefImpl;
import miniJava.interpreter.miniJava.impl.ClazzImpl;
import miniJava.interpreter.miniJava.impl.ContextImpl;
import miniJava.interpreter.miniJava.impl.DivisionImpl;
import miniJava.interpreter.miniJava.impl.EqualityImpl;
import miniJava.interpreter.miniJava.impl.ExpressionImpl;
import miniJava.interpreter.miniJava.impl.FieldAccessImpl;
import miniJava.interpreter.miniJava.impl.FieldBindingImpl;
import miniJava.interpreter.miniJava.impl.FieldImpl;
import miniJava.interpreter.miniJava.impl.ForStatementImpl;
import miniJava.interpreter.miniJava.impl.FrameImpl;
import miniJava.interpreter.miniJava.impl.IfStatementImpl;
import miniJava.interpreter.miniJava.impl.ImportImpl;
import miniJava.interpreter.miniJava.impl.InequalityImpl;
import miniJava.interpreter.miniJava.impl.InferiorImpl;
import miniJava.interpreter.miniJava.impl.InferiorOrEqualImpl;
import miniJava.interpreter.miniJava.impl.IntConstantImpl;
import miniJava.interpreter.miniJava.impl.IntegerTypeRefImpl;
import miniJava.interpreter.miniJava.impl.IntegerValueImpl;
import miniJava.interpreter.miniJava.impl.InterfaceImpl;
import miniJava.interpreter.miniJava.impl.MemberImpl;
import miniJava.interpreter.miniJava.impl.MethodCall2Impl;
import miniJava.interpreter.miniJava.impl.MethodCallImpl;
import miniJava.interpreter.miniJava.impl.MethodImpl;
import miniJava.interpreter.miniJava.impl.MiniJavaFactoryImpl;
import miniJava.interpreter.miniJava.impl.MinusImpl;
import miniJava.interpreter.miniJava.impl.ModuloImpl;
import miniJava.interpreter.miniJava.impl.MultiplicationImpl;
import miniJava.interpreter.miniJava.impl.NamedElementImpl;
import miniJava.interpreter.miniJava.impl.NegImpl;
import miniJava.interpreter.miniJava.impl.NewArrayImpl;
import miniJava.interpreter.miniJava.impl.NewCallImpl;
import miniJava.interpreter.miniJava.impl.NewObjectImpl;
import miniJava.interpreter.miniJava.impl.NotImpl;
import miniJava.interpreter.miniJava.impl.NullImpl;
import miniJava.interpreter.miniJava.impl.NullValueImpl;
import miniJava.interpreter.miniJava.impl.ObjectInstanceImpl;
import miniJava.interpreter.miniJava.impl.ObjectRefValueImpl;
import miniJava.interpreter.miniJava.impl.OrImpl;
import miniJava.interpreter.miniJava.impl.OutputStreamImpl;
import miniJava.interpreter.miniJava.impl.ParameterImpl;
import miniJava.interpreter.miniJava.impl.PlusImpl;
import miniJava.interpreter.miniJava.impl.PrintStatementImpl;
import miniJava.interpreter.miniJava.impl.ProgramImpl;
import miniJava.interpreter.miniJava.impl.ReturnImpl;
import miniJava.interpreter.miniJava.impl.SingleTypeRefImpl;
import miniJava.interpreter.miniJava.impl.StateImpl;
import miniJava.interpreter.miniJava.impl.StatementImpl;
import miniJava.interpreter.miniJava.impl.StringConstantImpl;
import miniJava.interpreter.miniJava.impl.StringTypeRefImpl;
import miniJava.interpreter.miniJava.impl.StringValueImpl;
import miniJava.interpreter.miniJava.impl.SuperImpl;
import miniJava.interpreter.miniJava.impl.SuperiorImpl;
import miniJava.interpreter.miniJava.impl.SuperiorOrEqualImpl;
import miniJava.interpreter.miniJava.impl.SymbolBindingImpl;
import miniJava.interpreter.miniJava.impl.SymbolImpl;
import miniJava.interpreter.miniJava.impl.SymbolRefImpl;
import miniJava.interpreter.miniJava.impl.ThisImpl;
import miniJava.interpreter.miniJava.impl.TypeDeclarationImpl;
import miniJava.interpreter.miniJava.impl.TypeRefImpl;
import miniJava.interpreter.miniJava.impl.TypedDeclarationImpl;
import miniJava.interpreter.miniJava.impl.ValueImpl;
import miniJava.interpreter.miniJava.impl.VariableDeclarationImpl;
import miniJava.interpreter.miniJava.impl.VoidTypeRefImpl;
import miniJava.interpreter.miniJava.impl.WhileStatementImpl;
import org.eclipse.emf.ecore.EFactory;

public interface MiniJavaFactory extends EFactory {
	MiniJavaFactory eINSTANCE = MiniJavaFactoryImpl.init();

	ProgramImpl createProgram();

	ImportImpl createImport();

	TypeDeclarationImpl createTypeDeclaration();

	ClazzImpl createClazz();

	InterfaceImpl createInterface();

	MemberImpl createMember();

	MethodImpl createMethod();

	ParameterImpl createParameter();

	FieldImpl createField();

	BlockImpl createBlock();

	StatementImpl createStatement();

	PrintStatementImpl createPrintStatement();

	ReturnImpl createReturn();

	IfStatementImpl createIfStatement();

	WhileStatementImpl createWhileStatement();

	ForStatementImpl createForStatement();

	TypeRefImpl createTypeRef();

	SingleTypeRefImpl createSingleTypeRef();

	ClassRefImpl createClassRef();

	NamedElementImpl createNamedElement();

	TypedDeclarationImpl createTypedDeclaration();

	SymbolImpl createSymbol();

	VariableDeclarationImpl createVariableDeclaration();

	AssignmentImpl createAssignment();

	AssigneeImpl createAssignee();

	ExpressionImpl createExpression();

	ArrayTypeRefImpl createArrayTypeRef();

	IntegerTypeRefImpl createIntegerTypeRef();

	BooleanTypeRefImpl createBooleanTypeRef();

	StringTypeRefImpl createStringTypeRef();

	VoidTypeRefImpl createVoidTypeRef();

	OrImpl createOr();

	AndImpl createAnd();

	EqualityImpl createEquality();

	InequalityImpl createInequality();

	SuperiorOrEqualImpl createSuperiorOrEqual();

	InferiorOrEqualImpl createInferiorOrEqual();

	SuperiorImpl createSuperior();

	InferiorImpl createInferior();

	PlusImpl createPlus();

	MinusImpl createMinus();

	MultiplicationImpl createMultiplication();

	DivisionImpl createDivision();

	ArrayAccessImpl createArrayAccess();

	ArrayLengthImpl createArrayLength();

	NotImpl createNot();

	NegImpl createNeg();

	FieldAccessImpl createFieldAccess();

	MethodCallImpl createMethodCall();

	StringConstantImpl createStringConstant();

	IntConstantImpl createIntConstant();

	BoolConstantImpl createBoolConstant();

	ThisImpl createThis();

	SuperImpl createSuper();

	NullImpl createNull();

	NewObjectImpl createNewObject();

	NewArrayImpl createNewArray();

	SymbolRefImpl createSymbolRef();

	ContextImpl createContext();

	ValueImpl createValue();

	IntegerValueImpl createIntegerValue();

	SymbolBindingImpl createSymbolBinding();

	FieldBindingImpl createFieldBinding();

	StringValueImpl createStringValue();

	BooleanValueImpl createBooleanValue();

	OutputStreamImpl createOutputStream();

	StateImpl createState();

	FrameImpl createFrame();

	NullValueImpl createNullValue();

	NewCallImpl createNewCall();

	MethodCall2Impl createMethodCall2();

	ObjectInstanceImpl createObjectInstance();

	ArrayInstanceImpl createArrayInstance();

	ObjectRefValueImpl createObjectRefValue();

	ArrayRefValueImpl createArrayRefValue();

	ModuloImpl createModulo();

	MiniJavaPackage getMiniJavaPackage();
}
