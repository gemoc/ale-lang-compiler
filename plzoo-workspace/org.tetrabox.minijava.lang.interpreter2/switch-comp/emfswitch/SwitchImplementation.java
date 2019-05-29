package emfswitch;

import emfswitch.operation.AndOperation;
import emfswitch.operation.ArrayAccessOperation;
import emfswitch.operation.ArrayInstanceOperation;
import emfswitch.operation.ArrayLengthOperation;
import emfswitch.operation.ArrayRefValueOperation;
import emfswitch.operation.ArrayTypeRefOperation;
import emfswitch.operation.AssigneeOperation;
import emfswitch.operation.AssignmentOperation;
import emfswitch.operation.BlockOperation;
import emfswitch.operation.BoolConstantOperation;
import emfswitch.operation.BooleanTypeRefOperation;
import emfswitch.operation.BooleanValueOperation;
import emfswitch.operation.CallOperation;
import emfswitch.operation.ClassRefOperation;
import emfswitch.operation.ClazzOperation;
import emfswitch.operation.ContextOperation;
import emfswitch.operation.DivisionOperation;
import emfswitch.operation.EqualityOperation;
import emfswitch.operation.ExpressionOperation;
import emfswitch.operation.FieldAccessOperation;
import emfswitch.operation.FieldBindingOperation;
import emfswitch.operation.FieldOperation;
import emfswitch.operation.ForStatementOperation;
import emfswitch.operation.FrameOperation;
import emfswitch.operation.IfStatementOperation;
import emfswitch.operation.ImportOperation;
import emfswitch.operation.InequalityOperation;
import emfswitch.operation.InferiorOperation;
import emfswitch.operation.InferiorOrEqualOperation;
import emfswitch.operation.IntConstantOperation;
import emfswitch.operation.IntegerTypeRefOperation;
import emfswitch.operation.IntegerValueOperation;
import emfswitch.operation.InterfaceOperation;
import emfswitch.operation.MemberOperation;
import emfswitch.operation.MethodCall2Operation;
import emfswitch.operation.MethodCallOperation;
import emfswitch.operation.MethodOperation;
import emfswitch.operation.MinusOperation;
import emfswitch.operation.ModuloOperation;
import emfswitch.operation.MultiplicationOperation;
import emfswitch.operation.NamedElementOperation;
import emfswitch.operation.NegOperation;
import emfswitch.operation.NewArrayOperation;
import emfswitch.operation.NewCallOperation;
import emfswitch.operation.NewObjectOperation;
import emfswitch.operation.NotOperation;
import emfswitch.operation.NullOperation;
import emfswitch.operation.NullValueOperation;
import emfswitch.operation.ObjectInstanceOperation;
import emfswitch.operation.ObjectRefValueOperation;
import emfswitch.operation.OrOperation;
import emfswitch.operation.OutputStreamOperation;
import emfswitch.operation.ParameterOperation;
import emfswitch.operation.PlusOperation;
import emfswitch.operation.PrintStatementOperation;
import emfswitch.operation.ProgramOperation;
import emfswitch.operation.ReturnOperation;
import emfswitch.operation.SingleTypeRefOperation;
import emfswitch.operation.StateOperation;
import emfswitch.operation.StatementOperation;
import emfswitch.operation.StringConstantOperation;
import emfswitch.operation.StringTypeRefOperation;
import emfswitch.operation.StringValueOperation;
import emfswitch.operation.SuperOperation;
import emfswitch.operation.SuperiorOperation;
import emfswitch.operation.SuperiorOrEqualOperation;
import emfswitch.operation.SymbolBindingOperation;
import emfswitch.operation.SymbolOperation;
import emfswitch.operation.SymbolRefOperation;
import emfswitch.operation.ThisOperation;
import emfswitch.operation.TypeDeclarationOperation;
import emfswitch.operation.TypeRefOperation;
import emfswitch.operation.TypedDeclarationOperation;
import emfswitch.operation.ValueOperation;
import emfswitch.operation.VariableDeclarationOperation;
import emfswitch.operation.VoidTypeRefOperation;
import emfswitch.operation.WhileStatementOperation;
import miniJava.And;
import miniJava.ArrayAccess;
import miniJava.ArrayInstance;
import miniJava.ArrayLength;
import miniJava.ArrayRefValue;
import miniJava.ArrayTypeRef;
import miniJava.Assignee;
import miniJava.Assignment;
import miniJava.Block;
import miniJava.BoolConstant;
import miniJava.BooleanTypeRef;
import miniJava.BooleanValue;
import miniJava.Call;
import miniJava.ClassRef;
import miniJava.Clazz;
import miniJava.Context;
import miniJava.Division;
import miniJava.Equality;
import miniJava.Expression;
import miniJava.Field;
import miniJava.FieldAccess;
import miniJava.FieldBinding;
import miniJava.ForStatement;
import miniJava.Frame;
import miniJava.IfStatement;
import miniJava.Import;
import miniJava.Inequality;
import miniJava.Inferior;
import miniJava.InferiorOrEqual;
import miniJava.IntConstant;
import miniJava.IntegerTypeRef;
import miniJava.IntegerValue;
import miniJava.Interface;
import miniJava.Member;
import miniJava.Method;
import miniJava.MethodCall;
import miniJava.MethodCall2;
import miniJava.Minus;
import miniJava.Modulo;
import miniJava.Multiplication;
import miniJava.NamedElement;
import miniJava.Neg;
import miniJava.NewArray;
import miniJava.NewCall;
import miniJava.NewObject;
import miniJava.Not;
import miniJava.Null;
import miniJava.NullValue;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Or;
import miniJava.OutputStream;
import miniJava.Parameter;
import miniJava.Plus;
import miniJava.PrintStatement;
import miniJava.Program;
import miniJava.Return;
import miniJava.SingleTypeRef;
import miniJava.State;
import miniJava.Statement;
import miniJava.StringConstant;
import miniJava.StringTypeRef;
import miniJava.StringValue;
import miniJava.Super;
import miniJava.Superior;
import miniJava.SuperiorOrEqual;
import miniJava.Symbol;
import miniJava.SymbolBinding;
import miniJava.SymbolRef;
import miniJava.This;
import miniJava.TypeDeclaration;
import miniJava.TypeRef;
import miniJava.TypedDeclaration;
import miniJava.Value;
import miniJava.VariableDeclaration;
import miniJava.VoidTypeRef;
import miniJava.WhileStatement;
import miniJava.util.MiniJavaSwitch;

public class SwitchImplementation extends MiniJavaSwitch<Object> {
	@Override
	public Object caseProgram(Program it) {
		return new ProgramOperation(it, this);
	}

	@Override
	public Object caseImport(Import it) {
		return new ImportOperation(it, this);
	}

	@Override
	public Object caseTypeDeclaration(TypeDeclaration it) {
		return new TypeDeclarationOperation(it, this);
	}

	@Override
	public Object caseClazz(Clazz it) {
		return new ClazzOperation(it, this);
	}

	@Override
	public Object caseInterface(Interface it) {
		return new InterfaceOperation(it, this);
	}

	@Override
	public Object caseMember(Member it) {
		return new MemberOperation(it, this);
	}

	@Override
	public Object caseMethod(Method it) {
		return new MethodOperation(it, this);
	}

	@Override
	public Object caseParameter(Parameter it) {
		return new ParameterOperation(it, this);
	}

	@Override
	public Object caseField(Field it) {
		return new FieldOperation(it, this);
	}

	@Override
	public Object caseBlock(Block it) {
		return new BlockOperation(it, this);
	}

	@Override
	public Object caseStatement(Statement it) {
		return new StatementOperation(it, this);
	}

	@Override
	public Object casePrintStatement(PrintStatement it) {
		return new PrintStatementOperation(it, this);
	}

	@Override
	public Object caseReturn(Return it) {
		return new ReturnOperation(it, this);
	}

	@Override
	public Object caseIfStatement(IfStatement it) {
		return new IfStatementOperation(it, this);
	}

	@Override
	public Object caseWhileStatement(WhileStatement it) {
		return new WhileStatementOperation(it, this);
	}

	@Override
	public Object caseForStatement(ForStatement it) {
		return new ForStatementOperation(it, this);
	}

	@Override
	public Object caseTypeRef(TypeRef it) {
		return new TypeRefOperation(it, this);
	}

	@Override
	public Object caseSingleTypeRef(SingleTypeRef it) {
		return new SingleTypeRefOperation(it, this);
	}

	@Override
	public Object caseClassRef(ClassRef it) {
		return new ClassRefOperation(it, this);
	}

	@Override
	public Object caseNamedElement(NamedElement it) {
		return new NamedElementOperation(it, this);
	}

	@Override
	public Object caseTypedDeclaration(TypedDeclaration it) {
		return new TypedDeclarationOperation(it, this);
	}

	@Override
	public Object caseSymbol(Symbol it) {
		return new SymbolOperation(it, this);
	}

	@Override
	public Object caseVariableDeclaration(VariableDeclaration it) {
		return new VariableDeclarationOperation(it, this);
	}

	@Override
	public Object caseAssignment(Assignment it) {
		return new AssignmentOperation(it, this);
	}

	@Override
	public Object caseAssignee(Assignee it) {
		return new AssigneeOperation(it, this);
	}

	@Override
	public Object caseExpression(Expression it) {
		return new ExpressionOperation(it, this);
	}

	@Override
	public Object caseArrayTypeRef(ArrayTypeRef it) {
		return new ArrayTypeRefOperation(it, this);
	}

	@Override
	public Object caseIntegerTypeRef(IntegerTypeRef it) {
		return new IntegerTypeRefOperation(it, this);
	}

	@Override
	public Object caseBooleanTypeRef(BooleanTypeRef it) {
		return new BooleanTypeRefOperation(it, this);
	}

	@Override
	public Object caseStringTypeRef(StringTypeRef it) {
		return new StringTypeRefOperation(it, this);
	}

	@Override
	public Object caseVoidTypeRef(VoidTypeRef it) {
		return new VoidTypeRefOperation(it, this);
	}

	@Override
	public Object caseOr(Or it) {
		return new OrOperation(it, this);
	}

	@Override
	public Object caseAnd(And it) {
		return new AndOperation(it, this);
	}

	@Override
	public Object caseEquality(Equality it) {
		return new EqualityOperation(it, this);
	}

	@Override
	public Object caseInequality(Inequality it) {
		return new InequalityOperation(it, this);
	}

	@Override
	public Object caseSuperiorOrEqual(SuperiorOrEqual it) {
		return new SuperiorOrEqualOperation(it, this);
	}

	@Override
	public Object caseInferiorOrEqual(InferiorOrEqual it) {
		return new InferiorOrEqualOperation(it, this);
	}

	@Override
	public Object caseSuperior(Superior it) {
		return new SuperiorOperation(it, this);
	}

	@Override
	public Object caseInferior(Inferior it) {
		return new InferiorOperation(it, this);
	}

	@Override
	public Object casePlus(Plus it) {
		return new PlusOperation(it, this);
	}

	@Override
	public Object caseMinus(Minus it) {
		return new MinusOperation(it, this);
	}

	@Override
	public Object caseMultiplication(Multiplication it) {
		return new MultiplicationOperation(it, this);
	}

	@Override
	public Object caseDivision(Division it) {
		return new DivisionOperation(it, this);
	}

	@Override
	public Object caseArrayAccess(ArrayAccess it) {
		return new ArrayAccessOperation(it, this);
	}

	@Override
	public Object caseArrayLength(ArrayLength it) {
		return new ArrayLengthOperation(it, this);
	}

	@Override
	public Object caseNot(Not it) {
		return new NotOperation(it, this);
	}

	@Override
	public Object caseNeg(Neg it) {
		return new NegOperation(it, this);
	}

	@Override
	public Object caseFieldAccess(FieldAccess it) {
		return new FieldAccessOperation(it, this);
	}

	@Override
	public Object caseMethodCall(MethodCall it) {
		return new MethodCallOperation(it, this);
	}

	@Override
	public Object caseStringConstant(StringConstant it) {
		return new StringConstantOperation(it, this);
	}

	@Override
	public Object caseIntConstant(IntConstant it) {
		return new IntConstantOperation(it, this);
	}

	@Override
	public Object caseBoolConstant(BoolConstant it) {
		return new BoolConstantOperation(it, this);
	}

	@Override
	public Object caseThis(This it) {
		return new ThisOperation(it, this);
	}

	@Override
	public Object caseSuper(Super it) {
		return new SuperOperation(it, this);
	}

	@Override
	public Object caseNull(Null it) {
		return new NullOperation(it, this);
	}

	@Override
	public Object caseNewObject(NewObject it) {
		return new NewObjectOperation(it, this);
	}

	@Override
	public Object caseNewArray(NewArray it) {
		return new NewArrayOperation(it, this);
	}

	@Override
	public Object caseSymbolRef(SymbolRef it) {
		return new SymbolRefOperation(it, this);
	}

	@Override
	public Object caseContext(Context it) {
		return new ContextOperation(it, this);
	}

	@Override
	public Object caseValue(Value it) {
		return new ValueOperation(it, this);
	}

	@Override
	public Object caseIntegerValue(IntegerValue it) {
		return new IntegerValueOperation(it, this);
	}

	@Override
	public Object caseSymbolBinding(SymbolBinding it) {
		return new SymbolBindingOperation(it, this);
	}

	@Override
	public Object caseFieldBinding(FieldBinding it) {
		return new FieldBindingOperation(it, this);
	}

	@Override
	public Object caseStringValue(StringValue it) {
		return new StringValueOperation(it, this);
	}

	@Override
	public Object caseBooleanValue(BooleanValue it) {
		return new BooleanValueOperation(it, this);
	}

	@Override
	public Object caseOutputStream(OutputStream it) {
		return new OutputStreamOperation(it, this);
	}

	@Override
	public Object caseState(State it) {
		return new StateOperation(it, this);
	}

	@Override
	public Object caseFrame(Frame it) {
		return new FrameOperation(it, this);
	}

	@Override
	public Object caseNullValue(NullValue it) {
		return new NullValueOperation(it, this);
	}

	@Override
	public Object caseCall(Call it) {
		return new CallOperation(it, this);
	}

	@Override
	public Object caseNewCall(NewCall it) {
		return new NewCallOperation(it, this);
	}

	@Override
	public Object caseMethodCall2(MethodCall2 it) {
		return new MethodCall2Operation(it, this);
	}

	@Override
	public Object caseObjectInstance(ObjectInstance it) {
		return new ObjectInstanceOperation(it, this);
	}

	@Override
	public Object caseArrayInstance(ArrayInstance it) {
		return new ArrayInstanceOperation(it, this);
	}

	@Override
	public Object caseObjectRefValue(ObjectRefValue it) {
		return new ObjectRefValueOperation(it, this);
	}

	@Override
	public Object caseArrayRefValue(ArrayRefValue it) {
		return new ArrayRefValueOperation(it, this);
	}

	@Override
	public Object caseModulo(Modulo it) {
		return new ModuloOperation(it, this);
	}
}
