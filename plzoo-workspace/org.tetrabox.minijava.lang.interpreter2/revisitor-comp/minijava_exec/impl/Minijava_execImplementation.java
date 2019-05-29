package minijava_exec.impl;

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
import miniJava.revisitor.MiniJavaRevisitor;
import minijava_exec.impl.operation.AndOp;
import minijava_exec.impl.operation.ArrayAccessOp;
import minijava_exec.impl.operation.ArrayInstanceOp;
import minijava_exec.impl.operation.ArrayLengthOp;
import minijava_exec.impl.operation.ArrayRefValueOp;
import minijava_exec.impl.operation.ArrayTypeRefOp;
import minijava_exec.impl.operation.AssigneeOp;
import minijava_exec.impl.operation.AssignmentOp;
import minijava_exec.impl.operation.BlockOp;
import minijava_exec.impl.operation.BoolConstantOp;
import minijava_exec.impl.operation.BooleanTypeRefOp;
import minijava_exec.impl.operation.BooleanValueOp;
import minijava_exec.impl.operation.CallOp;
import minijava_exec.impl.operation.ClassRefOp;
import minijava_exec.impl.operation.ClazzOp;
import minijava_exec.impl.operation.ContextOp;
import minijava_exec.impl.operation.DivisionOp;
import minijava_exec.impl.operation.EqualityOp;
import minijava_exec.impl.operation.ExpressionOp;
import minijava_exec.impl.operation.FieldAccessOp;
import minijava_exec.impl.operation.FieldBindingOp;
import minijava_exec.impl.operation.FieldOp;
import minijava_exec.impl.operation.ForStatementOp;
import minijava_exec.impl.operation.FrameOp;
import minijava_exec.impl.operation.IfStatementOp;
import minijava_exec.impl.operation.ImportOp;
import minijava_exec.impl.operation.InequalityOp;
import minijava_exec.impl.operation.InferiorOp;
import minijava_exec.impl.operation.InferiorOrEqualOp;
import minijava_exec.impl.operation.IntConstantOp;
import minijava_exec.impl.operation.IntegerTypeRefOp;
import minijava_exec.impl.operation.IntegerValueOp;
import minijava_exec.impl.operation.InterfaceOp;
import minijava_exec.impl.operation.MemberOp;
import minijava_exec.impl.operation.MethodCall2Op;
import minijava_exec.impl.operation.MethodCallOp;
import minijava_exec.impl.operation.MethodOp;
import minijava_exec.impl.operation.MinusOp;
import minijava_exec.impl.operation.ModuloOp;
import minijava_exec.impl.operation.MultiplicationOp;
import minijava_exec.impl.operation.NamedElementOp;
import minijava_exec.impl.operation.NegOp;
import minijava_exec.impl.operation.NewArrayOp;
import minijava_exec.impl.operation.NewCallOp;
import minijava_exec.impl.operation.NewObjectOp;
import minijava_exec.impl.operation.NotOp;
import minijava_exec.impl.operation.NullOp;
import minijava_exec.impl.operation.NullValueOp;
import minijava_exec.impl.operation.ObjectInstanceOp;
import minijava_exec.impl.operation.ObjectRefValueOp;
import minijava_exec.impl.operation.OrOp;
import minijava_exec.impl.operation.OutputStreamOp;
import minijava_exec.impl.operation.ParameterOp;
import minijava_exec.impl.operation.PlusOp;
import minijava_exec.impl.operation.PrintStatementOp;
import minijava_exec.impl.operation.ProgramOp;
import minijava_exec.impl.operation.ReturnOp;
import minijava_exec.impl.operation.SingleTypeRefOp;
import minijava_exec.impl.operation.StateOp;
import minijava_exec.impl.operation.StatementOp;
import minijava_exec.impl.operation.StringConstantOp;
import minijava_exec.impl.operation.StringTypeRefOp;
import minijava_exec.impl.operation.StringValueOp;
import minijava_exec.impl.operation.SuperOp;
import minijava_exec.impl.operation.SuperiorOp;
import minijava_exec.impl.operation.SuperiorOrEqualOp;
import minijava_exec.impl.operation.SymbolBindingOp;
import minijava_exec.impl.operation.SymbolOp;
import minijava_exec.impl.operation.SymbolRefOp;
import minijava_exec.impl.operation.ThisOp;
import minijava_exec.impl.operation.TypeDeclarationOp;
import minijava_exec.impl.operation.TypeRefOp;
import minijava_exec.impl.operation.TypedDeclarationOp;
import minijava_exec.impl.operation.ValueOp;
import minijava_exec.impl.operation.VariableDeclarationOp;
import minijava_exec.impl.operation.VoidTypeRefOp;
import minijava_exec.impl.operation.WhileStatementOp;
import minijava_exec.impl.operation.impl.AndOpImpl;
import minijava_exec.impl.operation.impl.ArrayAccessOpImpl;
import minijava_exec.impl.operation.impl.ArrayInstanceOpImpl;
import minijava_exec.impl.operation.impl.ArrayLengthOpImpl;
import minijava_exec.impl.operation.impl.ArrayRefValueOpImpl;
import minijava_exec.impl.operation.impl.ArrayTypeRefOpImpl;
import minijava_exec.impl.operation.impl.AssigneeOpImpl;
import minijava_exec.impl.operation.impl.AssignmentOpImpl;
import minijava_exec.impl.operation.impl.BlockOpImpl;
import minijava_exec.impl.operation.impl.BoolConstantOpImpl;
import minijava_exec.impl.operation.impl.BooleanTypeRefOpImpl;
import minijava_exec.impl.operation.impl.BooleanValueOpImpl;
import minijava_exec.impl.operation.impl.CallOpImpl;
import minijava_exec.impl.operation.impl.ClassRefOpImpl;
import minijava_exec.impl.operation.impl.ClazzOpImpl;
import minijava_exec.impl.operation.impl.ContextOpImpl;
import minijava_exec.impl.operation.impl.DivisionOpImpl;
import minijava_exec.impl.operation.impl.EqualityOpImpl;
import minijava_exec.impl.operation.impl.ExpressionOpImpl;
import minijava_exec.impl.operation.impl.FieldAccessOpImpl;
import minijava_exec.impl.operation.impl.FieldBindingOpImpl;
import minijava_exec.impl.operation.impl.FieldOpImpl;
import minijava_exec.impl.operation.impl.ForStatementOpImpl;
import minijava_exec.impl.operation.impl.FrameOpImpl;
import minijava_exec.impl.operation.impl.IfStatementOpImpl;
import minijava_exec.impl.operation.impl.ImportOpImpl;
import minijava_exec.impl.operation.impl.InequalityOpImpl;
import minijava_exec.impl.operation.impl.InferiorOpImpl;
import minijava_exec.impl.operation.impl.InferiorOrEqualOpImpl;
import minijava_exec.impl.operation.impl.IntConstantOpImpl;
import minijava_exec.impl.operation.impl.IntegerTypeRefOpImpl;
import minijava_exec.impl.operation.impl.IntegerValueOpImpl;
import minijava_exec.impl.operation.impl.InterfaceOpImpl;
import minijava_exec.impl.operation.impl.MemberOpImpl;
import minijava_exec.impl.operation.impl.MethodCall2OpImpl;
import minijava_exec.impl.operation.impl.MethodCallOpImpl;
import minijava_exec.impl.operation.impl.MethodOpImpl;
import minijava_exec.impl.operation.impl.MinusOpImpl;
import minijava_exec.impl.operation.impl.ModuloOpImpl;
import minijava_exec.impl.operation.impl.MultiplicationOpImpl;
import minijava_exec.impl.operation.impl.NamedElementOpImpl;
import minijava_exec.impl.operation.impl.NegOpImpl;
import minijava_exec.impl.operation.impl.NewArrayOpImpl;
import minijava_exec.impl.operation.impl.NewCallOpImpl;
import minijava_exec.impl.operation.impl.NewObjectOpImpl;
import minijava_exec.impl.operation.impl.NotOpImpl;
import minijava_exec.impl.operation.impl.NullOpImpl;
import minijava_exec.impl.operation.impl.NullValueOpImpl;
import minijava_exec.impl.operation.impl.ObjectInstanceOpImpl;
import minijava_exec.impl.operation.impl.ObjectRefValueOpImpl;
import minijava_exec.impl.operation.impl.OrOpImpl;
import minijava_exec.impl.operation.impl.OutputStreamOpImpl;
import minijava_exec.impl.operation.impl.ParameterOpImpl;
import minijava_exec.impl.operation.impl.PlusOpImpl;
import minijava_exec.impl.operation.impl.PrintStatementOpImpl;
import minijava_exec.impl.operation.impl.ProgramOpImpl;
import minijava_exec.impl.operation.impl.ReturnOpImpl;
import minijava_exec.impl.operation.impl.SingleTypeRefOpImpl;
import minijava_exec.impl.operation.impl.StateOpImpl;
import minijava_exec.impl.operation.impl.StatementOpImpl;
import minijava_exec.impl.operation.impl.StringConstantOpImpl;
import minijava_exec.impl.operation.impl.StringTypeRefOpImpl;
import minijava_exec.impl.operation.impl.StringValueOpImpl;
import minijava_exec.impl.operation.impl.SuperOpImpl;
import minijava_exec.impl.operation.impl.SuperiorOpImpl;
import minijava_exec.impl.operation.impl.SuperiorOrEqualOpImpl;
import minijava_exec.impl.operation.impl.SymbolBindingOpImpl;
import minijava_exec.impl.operation.impl.SymbolOpImpl;
import minijava_exec.impl.operation.impl.SymbolRefOpImpl;
import minijava_exec.impl.operation.impl.ThisOpImpl;
import minijava_exec.impl.operation.impl.TypeDeclarationOpImpl;
import minijava_exec.impl.operation.impl.TypeRefOpImpl;
import minijava_exec.impl.operation.impl.TypedDeclarationOpImpl;
import minijava_exec.impl.operation.impl.ValueOpImpl;
import minijava_exec.impl.operation.impl.VariableDeclarationOpImpl;
import minijava_exec.impl.operation.impl.VoidTypeRefOpImpl;
import minijava_exec.impl.operation.impl.WhileStatementOpImpl;

public interface Minijava_execImplementation extends MiniJavaRevisitor<AndOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, EqualityOp, ExpressionOp, FieldOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InferiorOp, InferiorOrEqualOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCall2Op, MinusOp, ModuloOp, MultiplicationOp, NamedElementOp, NegOp, NewArrayOp, NewCallOp, NewObjectOp, NotOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperiorOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> {
	default ProgramOp miniJava__Program(Program it) {
		return new ProgramOpImpl(it, this);
	}

	default ImportOp miniJava__Import(Import it) {
		return new ImportOpImpl(it, this);
	}

	default TypeDeclarationOp miniJava__TypeDeclaration(TypeDeclaration it) {
		return new TypeDeclarationOpImpl(it, this);
	}

	default ClazzOp miniJava__Clazz(Clazz it) {
		return new ClazzOpImpl(it, this);
	}

	default InterfaceOp miniJava__Interface(Interface it) {
		return new InterfaceOpImpl(it, this);
	}

	default MemberOp miniJava__Member(Member it) {
		return new MemberOpImpl(it, this);
	}

	default MethodOp miniJava__Method(Method it) {
		return new MethodOpImpl(it, this);
	}

	default ParameterOp miniJava__Parameter(Parameter it) {
		return new ParameterOpImpl(it, this);
	}

	default FieldOp miniJava__Field(Field it) {
		return new FieldOpImpl(it, this);
	}

	default BlockOp miniJava__Block(Block it) {
		return new BlockOpImpl(it, this);
	}

	default StatementOp miniJava__Statement(Statement it) {
		return new StatementOpImpl(it, this);
	}

	default PrintStatementOp miniJava__PrintStatement(PrintStatement it) {
		return new PrintStatementOpImpl(it, this);
	}

	default ReturnOp miniJava__Return(Return it) {
		return new ReturnOpImpl(it, this);
	}

	default IfStatementOp miniJava__IfStatement(IfStatement it) {
		return new IfStatementOpImpl(it, this);
	}

	default WhileStatementOp miniJava__WhileStatement(WhileStatement it) {
		return new WhileStatementOpImpl(it, this);
	}

	default ForStatementOp miniJava__ForStatement(ForStatement it) {
		return new ForStatementOpImpl(it, this);
	}

	default TypeRefOp miniJava__TypeRef(TypeRef it) {
		return new TypeRefOpImpl(it, this);
	}

	default SingleTypeRefOp miniJava__SingleTypeRef(SingleTypeRef it) {
		return new SingleTypeRefOpImpl(it, this);
	}

	default ClassRefOp miniJava__ClassRef(ClassRef it) {
		return new ClassRefOpImpl(it, this);
	}

	default NamedElementOp miniJava__NamedElement(NamedElement it) {
		return new NamedElementOpImpl(it, this);
	}

	default TypedDeclarationOp miniJava__TypedDeclaration(TypedDeclaration it) {
		return new TypedDeclarationOpImpl(it, this);
	}

	default SymbolOp miniJava__Symbol(Symbol it) {
		return new SymbolOpImpl(it, this);
	}

	default VariableDeclarationOp miniJava__VariableDeclaration(VariableDeclaration it) {
		return new VariableDeclarationOpImpl(it, this);
	}

	default AssignmentOp miniJava__Assignment(Assignment it) {
		return new AssignmentOpImpl(it, this);
	}

	default AssigneeOp miniJava__Assignee(Assignee it) {
		return new AssigneeOpImpl(it, this);
	}

	default ExpressionOp miniJava__Expression(Expression it) {
		return new ExpressionOpImpl(it, this);
	}

	default ArrayTypeRefOp miniJava__ArrayTypeRef(ArrayTypeRef it) {
		return new ArrayTypeRefOpImpl(it, this);
	}

	default IntegerTypeRefOp miniJava__IntegerTypeRef(IntegerTypeRef it) {
		return new IntegerTypeRefOpImpl(it, this);
	}

	default BooleanTypeRefOp miniJava__BooleanTypeRef(BooleanTypeRef it) {
		return new BooleanTypeRefOpImpl(it, this);
	}

	default StringTypeRefOp miniJava__StringTypeRef(StringTypeRef it) {
		return new StringTypeRefOpImpl(it, this);
	}

	default VoidTypeRefOp miniJava__VoidTypeRef(VoidTypeRef it) {
		return new VoidTypeRefOpImpl(it, this);
	}

	default OrOp miniJava__Or(Or it) {
		return new OrOpImpl(it, this);
	}

	default AndOp miniJava__And(And it) {
		return new AndOpImpl(it, this);
	}

	default EqualityOp miniJava__Equality(Equality it) {
		return new EqualityOpImpl(it, this);
	}

	default InequalityOp miniJava__Inequality(Inequality it) {
		return new InequalityOpImpl(it, this);
	}

	default SuperiorOrEqualOp miniJava__SuperiorOrEqual(SuperiorOrEqual it) {
		return new SuperiorOrEqualOpImpl(it, this);
	}

	default InferiorOrEqualOp miniJava__InferiorOrEqual(InferiorOrEqual it) {
		return new InferiorOrEqualOpImpl(it, this);
	}

	default SuperiorOp miniJava__Superior(Superior it) {
		return new SuperiorOpImpl(it, this);
	}

	default InferiorOp miniJava__Inferior(Inferior it) {
		return new InferiorOpImpl(it, this);
	}

	default PlusOp miniJava__Plus(Plus it) {
		return new PlusOpImpl(it, this);
	}

	default MinusOp miniJava__Minus(Minus it) {
		return new MinusOpImpl(it, this);
	}

	default MultiplicationOp miniJava__Multiplication(Multiplication it) {
		return new MultiplicationOpImpl(it, this);
	}

	default DivisionOp miniJava__Division(Division it) {
		return new DivisionOpImpl(it, this);
	}

	default ArrayAccessOp miniJava__ArrayAccess(ArrayAccess it) {
		return new ArrayAccessOpImpl(it, this);
	}

	default ArrayLengthOp miniJava__ArrayLength(ArrayLength it) {
		return new ArrayLengthOpImpl(it, this);
	}

	default NotOp miniJava__Not(Not it) {
		return new NotOpImpl(it, this);
	}

	default NegOp miniJava__Neg(Neg it) {
		return new NegOpImpl(it, this);
	}

	default FieldAccessOp miniJava__FieldAccess(FieldAccess it) {
		return new FieldAccessOpImpl(it, this);
	}

	default MethodCallOp miniJava__MethodCall(MethodCall it) {
		return new MethodCallOpImpl(it, this);
	}

	default StringConstantOp miniJava__StringConstant(StringConstant it) {
		return new StringConstantOpImpl(it, this);
	}

	default IntConstantOp miniJava__IntConstant(IntConstant it) {
		return new IntConstantOpImpl(it, this);
	}

	default BoolConstantOp miniJava__BoolConstant(BoolConstant it) {
		return new BoolConstantOpImpl(it, this);
	}

	default ThisOp miniJava__This(This it) {
		return new ThisOpImpl(it, this);
	}

	default SuperOp miniJava__Super(Super it) {
		return new SuperOpImpl(it, this);
	}

	default NullOp miniJava__Null(Null it) {
		return new NullOpImpl(it, this);
	}

	default NewObjectOp miniJava__NewObject(NewObject it) {
		return new NewObjectOpImpl(it, this);
	}

	default NewArrayOp miniJava__NewArray(NewArray it) {
		return new NewArrayOpImpl(it, this);
	}

	default SymbolRefOp miniJava__SymbolRef(SymbolRef it) {
		return new SymbolRefOpImpl(it, this);
	}

	default ContextOp miniJava__Context(Context it) {
		return new ContextOpImpl(it, this);
	}

	default ValueOp miniJava__Value(Value it) {
		return new ValueOpImpl(it, this);
	}

	default IntegerValueOp miniJava__IntegerValue(IntegerValue it) {
		return new IntegerValueOpImpl(it, this);
	}

	default SymbolBindingOp miniJava__SymbolBinding(SymbolBinding it) {
		return new SymbolBindingOpImpl(it, this);
	}

	default FieldBindingOp miniJava__FieldBinding(FieldBinding it) {
		return new FieldBindingOpImpl(it, this);
	}

	default StringValueOp miniJava__StringValue(StringValue it) {
		return new StringValueOpImpl(it, this);
	}

	default BooleanValueOp miniJava__BooleanValue(BooleanValue it) {
		return new BooleanValueOpImpl(it, this);
	}

	default OutputStreamOp miniJava__OutputStream(OutputStream it) {
		return new OutputStreamOpImpl(it, this);
	}

	default StateOp miniJava__State(State it) {
		return new StateOpImpl(it, this);
	}

	default FrameOp miniJava__Frame(Frame it) {
		return new FrameOpImpl(it, this);
	}

	default NullValueOp miniJava__NullValue(NullValue it) {
		return new NullValueOpImpl(it, this);
	}

	default CallOp miniJava__Call(Call it) {
		return new CallOpImpl(it, this);
	}

	default NewCallOp miniJava__NewCall(NewCall it) {
		return new NewCallOpImpl(it, this);
	}

	default MethodCall2Op miniJava__MethodCall2(MethodCall2 it) {
		return new MethodCall2OpImpl(it, this);
	}

	default ObjectInstanceOp miniJava__ObjectInstance(ObjectInstance it) {
		return new ObjectInstanceOpImpl(it, this);
	}

	default ArrayInstanceOp miniJava__ArrayInstance(ArrayInstance it) {
		return new ArrayInstanceOpImpl(it, this);
	}

	default ObjectRefValueOp miniJava__ObjectRefValue(ObjectRefValue it) {
		return new ObjectRefValueOpImpl(it, this);
	}

	default ArrayRefValueOp miniJava__ArrayRefValue(ArrayRefValue it) {
		return new ArrayRefValueOpImpl(it, this);
	}

	default ModuloOp miniJava__Modulo(Modulo it) {
		return new ModuloOpImpl(it, this);
	}
}
