package test.impl;

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
import test.impl.operation.AndOp;
import test.impl.operation.ArrayAccessOp;
import test.impl.operation.ArrayInstanceOp;
import test.impl.operation.ArrayLengthOp;
import test.impl.operation.ArrayRefValueOp;
import test.impl.operation.ArrayTypeRefOp;
import test.impl.operation.AssigneeOp;
import test.impl.operation.AssignmentOp;
import test.impl.operation.BlockOp;
import test.impl.operation.BoolConstantOp;
import test.impl.operation.BooleanTypeRefOp;
import test.impl.operation.BooleanValueOp;
import test.impl.operation.CallOp;
import test.impl.operation.ClassRefOp;
import test.impl.operation.ClazzOp;
import test.impl.operation.ContextOp;
import test.impl.operation.DivisionOp;
import test.impl.operation.EqualityOp;
import test.impl.operation.ExpressionOp;
import test.impl.operation.FieldAccessOp;
import test.impl.operation.FieldBindingOp;
import test.impl.operation.FieldOp;
import test.impl.operation.ForStatementOp;
import test.impl.operation.FrameOp;
import test.impl.operation.IfStatementOp;
import test.impl.operation.ImportOp;
import test.impl.operation.InequalityOp;
import test.impl.operation.InferiorOp;
import test.impl.operation.InferiorOrEqualOp;
import test.impl.operation.IntConstantOp;
import test.impl.operation.IntegerTypeRefOp;
import test.impl.operation.IntegerValueOp;
import test.impl.operation.InterfaceOp;
import test.impl.operation.MemberOp;
import test.impl.operation.MethodCall2Op;
import test.impl.operation.MethodCallOp;
import test.impl.operation.MethodOp;
import test.impl.operation.MinusOp;
import test.impl.operation.ModuloOp;
import test.impl.operation.MultiplicationOp;
import test.impl.operation.NamedElementOp;
import test.impl.operation.NegOp;
import test.impl.operation.NewArrayOp;
import test.impl.operation.NewCallOp;
import test.impl.operation.NewObjectOp;
import test.impl.operation.NotOp;
import test.impl.operation.NullOp;
import test.impl.operation.NullValueOp;
import test.impl.operation.ObjectInstanceOp;
import test.impl.operation.ObjectRefValueOp;
import test.impl.operation.OrOp;
import test.impl.operation.OutputStreamOp;
import test.impl.operation.ParameterOp;
import test.impl.operation.PlusOp;
import test.impl.operation.PrintStatementOp;
import test.impl.operation.ProgramOp;
import test.impl.operation.ReturnOp;
import test.impl.operation.SingleTypeRefOp;
import test.impl.operation.StateOp;
import test.impl.operation.StatementOp;
import test.impl.operation.StringConstantOp;
import test.impl.operation.StringTypeRefOp;
import test.impl.operation.StringValueOp;
import test.impl.operation.SuperOp;
import test.impl.operation.SuperiorOp;
import test.impl.operation.SuperiorOrEqualOp;
import test.impl.operation.SymbolBindingOp;
import test.impl.operation.SymbolOp;
import test.impl.operation.SymbolRefOp;
import test.impl.operation.ThisOp;
import test.impl.operation.TypeDeclarationOp;
import test.impl.operation.TypeRefOp;
import test.impl.operation.TypedDeclarationOp;
import test.impl.operation.ValueOp;
import test.impl.operation.VariableDeclarationOp;
import test.impl.operation.VoidTypeRefOp;
import test.impl.operation.WhileStatementOp;
import test.impl.operation.impl.AndOpImpl;
import test.impl.operation.impl.ArrayAccessOpImpl;
import test.impl.operation.impl.ArrayInstanceOpImpl;
import test.impl.operation.impl.ArrayLengthOpImpl;
import test.impl.operation.impl.ArrayRefValueOpImpl;
import test.impl.operation.impl.ArrayTypeRefOpImpl;
import test.impl.operation.impl.AssigneeOpImpl;
import test.impl.operation.impl.AssignmentOpImpl;
import test.impl.operation.impl.BlockOpImpl;
import test.impl.operation.impl.BoolConstantOpImpl;
import test.impl.operation.impl.BooleanTypeRefOpImpl;
import test.impl.operation.impl.BooleanValueOpImpl;
import test.impl.operation.impl.CallOpImpl;
import test.impl.operation.impl.ClassRefOpImpl;
import test.impl.operation.impl.ClazzOpImpl;
import test.impl.operation.impl.ContextOpImpl;
import test.impl.operation.impl.DivisionOpImpl;
import test.impl.operation.impl.EqualityOpImpl;
import test.impl.operation.impl.ExpressionOpImpl;
import test.impl.operation.impl.FieldAccessOpImpl;
import test.impl.operation.impl.FieldBindingOpImpl;
import test.impl.operation.impl.FieldOpImpl;
import test.impl.operation.impl.ForStatementOpImpl;
import test.impl.operation.impl.FrameOpImpl;
import test.impl.operation.impl.IfStatementOpImpl;
import test.impl.operation.impl.ImportOpImpl;
import test.impl.operation.impl.InequalityOpImpl;
import test.impl.operation.impl.InferiorOpImpl;
import test.impl.operation.impl.InferiorOrEqualOpImpl;
import test.impl.operation.impl.IntConstantOpImpl;
import test.impl.operation.impl.IntegerTypeRefOpImpl;
import test.impl.operation.impl.IntegerValueOpImpl;
import test.impl.operation.impl.InterfaceOpImpl;
import test.impl.operation.impl.MemberOpImpl;
import test.impl.operation.impl.MethodCall2OpImpl;
import test.impl.operation.impl.MethodCallOpImpl;
import test.impl.operation.impl.MethodOpImpl;
import test.impl.operation.impl.MinusOpImpl;
import test.impl.operation.impl.ModuloOpImpl;
import test.impl.operation.impl.MultiplicationOpImpl;
import test.impl.operation.impl.NamedElementOpImpl;
import test.impl.operation.impl.NegOpImpl;
import test.impl.operation.impl.NewArrayOpImpl;
import test.impl.operation.impl.NewCallOpImpl;
import test.impl.operation.impl.NewObjectOpImpl;
import test.impl.operation.impl.NotOpImpl;
import test.impl.operation.impl.NullOpImpl;
import test.impl.operation.impl.NullValueOpImpl;
import test.impl.operation.impl.ObjectInstanceOpImpl;
import test.impl.operation.impl.ObjectRefValueOpImpl;
import test.impl.operation.impl.OrOpImpl;
import test.impl.operation.impl.OutputStreamOpImpl;
import test.impl.operation.impl.ParameterOpImpl;
import test.impl.operation.impl.PlusOpImpl;
import test.impl.operation.impl.PrintStatementOpImpl;
import test.impl.operation.impl.ProgramOpImpl;
import test.impl.operation.impl.ReturnOpImpl;
import test.impl.operation.impl.SingleTypeRefOpImpl;
import test.impl.operation.impl.StateOpImpl;
import test.impl.operation.impl.StatementOpImpl;
import test.impl.operation.impl.StringConstantOpImpl;
import test.impl.operation.impl.StringTypeRefOpImpl;
import test.impl.operation.impl.StringValueOpImpl;
import test.impl.operation.impl.SuperOpImpl;
import test.impl.operation.impl.SuperiorOpImpl;
import test.impl.operation.impl.SuperiorOrEqualOpImpl;
import test.impl.operation.impl.SymbolBindingOpImpl;
import test.impl.operation.impl.SymbolOpImpl;
import test.impl.operation.impl.SymbolRefOpImpl;
import test.impl.operation.impl.ThisOpImpl;
import test.impl.operation.impl.TypeDeclarationOpImpl;
import test.impl.operation.impl.TypeRefOpImpl;
import test.impl.operation.impl.TypedDeclarationOpImpl;
import test.impl.operation.impl.ValueOpImpl;
import test.impl.operation.impl.VariableDeclarationOpImpl;
import test.impl.operation.impl.VoidTypeRefOpImpl;
import test.impl.operation.impl.WhileStatementOpImpl;

public interface TestImplementation extends MiniJavaRevisitor<AndOp, AndOp, AndOp, ArrayAccessOp, ArrayAccessOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayLengthOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BoolConstantOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, DivisionOp, DivisionOp, EqualityOp, EqualityOp, EqualityOp, ExpressionOp, ExpressionOp, ExpressionOp, FieldOp, FieldAccessOp, FieldAccessOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InequalityOp, InequalityOp, InferiorOp, InferiorOp, InferiorOp, InferiorOrEqualOp, InferiorOrEqualOp, InferiorOrEqualOp, IntConstantOp, IntConstantOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCallOp, MethodCallOp, MethodCall2Op, MinusOp, MinusOp, MinusOp, ModuloOp, ModuloOp, ModuloOp, MultiplicationOp, MultiplicationOp, MultiplicationOp, NamedElementOp, NegOp, NegOp, NegOp, NewArrayOp, NewArrayOp, NewArrayOp, NewCallOp, NewObjectOp, NewObjectOp, NewObjectOp, NotOp, NotOp, NotOp, NullOp, NullOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OrOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PlusOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringConstantOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperOp, SuperOp, SuperiorOp, SuperiorOp, SuperiorOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, SymbolRefOp, SymbolRefOp, ThisOp, ThisOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VariableDeclarationOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> {
	default AndOp miniJava__And(And it) {
		return new AndOpImpl(it, this);
	}

	default AndOp miniJava__And__AS__miniJava__Assignee(And it) {
		return new AndOpImpl(it, this);
	}

	default AndOp miniJava__And__AS__miniJava__Statement(And it) {
		return new AndOpImpl(it, this);
	}

	default ArrayAccessOp miniJava__ArrayAccess(ArrayAccess it) {
		return new ArrayAccessOpImpl(it, this);
	}

	default ArrayAccessOp miniJava__ArrayAccess__AS__miniJava__Assignee(ArrayAccess it) {
		return new ArrayAccessOpImpl(it, this);
	}

	default ArrayAccessOp miniJava__ArrayAccess__AS__miniJava__Statement(ArrayAccess it) {
		return new ArrayAccessOpImpl(it, this);
	}

	default ArrayInstanceOp miniJava__ArrayInstance(ArrayInstance it) {
		return new ArrayInstanceOpImpl(it, this);
	}

	default ArrayLengthOp miniJava__ArrayLength(ArrayLength it) {
		return new ArrayLengthOpImpl(it, this);
	}

	default ArrayLengthOp miniJava__ArrayLength__AS__miniJava__Assignee(ArrayLength it) {
		return new ArrayLengthOpImpl(it, this);
	}

	default ArrayLengthOp miniJava__ArrayLength__AS__miniJava__Statement(ArrayLength it) {
		return new ArrayLengthOpImpl(it, this);
	}

	default ArrayRefValueOp miniJava__ArrayRefValue(ArrayRefValue it) {
		return new ArrayRefValueOpImpl(it, this);
	}

	default ArrayTypeRefOp miniJava__ArrayTypeRef(ArrayTypeRef it) {
		return new ArrayTypeRefOpImpl(it, this);
	}

	default AssigneeOp miniJava__Assignee(Assignee it) {
		return new AssigneeOpImpl(it, this);
	}

	default AssignmentOp miniJava__Assignment(Assignment it) {
		return new AssignmentOpImpl(it, this);
	}

	default BlockOp miniJava__Block(Block it) {
		return new BlockOpImpl(it, this);
	}

	default BoolConstantOp miniJava__BoolConstant(BoolConstant it) {
		return new BoolConstantOpImpl(it, this);
	}

	default BoolConstantOp miniJava__BoolConstant__AS__miniJava__Assignee(BoolConstant it) {
		return new BoolConstantOpImpl(it, this);
	}

	default BoolConstantOp miniJava__BoolConstant__AS__miniJava__Statement(BoolConstant it) {
		return new BoolConstantOpImpl(it, this);
	}

	default BooleanTypeRefOp miniJava__BooleanTypeRef(BooleanTypeRef it) {
		return new BooleanTypeRefOpImpl(it, this);
	}

	default BooleanValueOp miniJava__BooleanValue(BooleanValue it) {
		return new BooleanValueOpImpl(it, this);
	}

	default CallOp miniJava__Call(Call it) {
		return new CallOpImpl(it, this);
	}

	default ClassRefOp miniJava__ClassRef(ClassRef it) {
		return new ClassRefOpImpl(it, this);
	}

	default ClazzOp miniJava__Clazz(Clazz it) {
		return new ClazzOpImpl(it, this);
	}

	default ContextOp miniJava__Context(Context it) {
		return new ContextOpImpl(it, this);
	}

	default DivisionOp miniJava__Division(Division it) {
		return new DivisionOpImpl(it, this);
	}

	default DivisionOp miniJava__Division__AS__miniJava__Assignee(Division it) {
		return new DivisionOpImpl(it, this);
	}

	default DivisionOp miniJava__Division__AS__miniJava__Statement(Division it) {
		return new DivisionOpImpl(it, this);
	}

	default EqualityOp miniJava__Equality(Equality it) {
		return new EqualityOpImpl(it, this);
	}

	default EqualityOp miniJava__Equality__AS__miniJava__Assignee(Equality it) {
		return new EqualityOpImpl(it, this);
	}

	default EqualityOp miniJava__Equality__AS__miniJava__Statement(Equality it) {
		return new EqualityOpImpl(it, this);
	}

	default ExpressionOp miniJava__Expression(Expression it) {
		return new ExpressionOpImpl(it, this);
	}

	default ExpressionOp miniJava__Expression__AS__miniJava__Assignee(Expression it) {
		return new ExpressionOpImpl(it, this);
	}

	default ExpressionOp miniJava__Expression__AS__miniJava__Statement(Expression it) {
		return new ExpressionOpImpl(it, this);
	}

	default FieldOp miniJava__Field(Field it) {
		return new FieldOpImpl(it, this);
	}

	default FieldAccessOp miniJava__FieldAccess(FieldAccess it) {
		return new FieldAccessOpImpl(it, this);
	}

	default FieldAccessOp miniJava__FieldAccess__AS__miniJava__Assignee(FieldAccess it) {
		return new FieldAccessOpImpl(it, this);
	}

	default FieldAccessOp miniJava__FieldAccess__AS__miniJava__Statement(FieldAccess it) {
		return new FieldAccessOpImpl(it, this);
	}

	default FieldBindingOp miniJava__FieldBinding(FieldBinding it) {
		return new FieldBindingOpImpl(it, this);
	}

	default ForStatementOp miniJava__ForStatement(ForStatement it) {
		return new ForStatementOpImpl(it, this);
	}

	default FrameOp miniJava__Frame(Frame it) {
		return new FrameOpImpl(it, this);
	}

	default IfStatementOp miniJava__IfStatement(IfStatement it) {
		return new IfStatementOpImpl(it, this);
	}

	default ImportOp miniJava__Import(Import it) {
		return new ImportOpImpl(it, this);
	}

	default InequalityOp miniJava__Inequality(Inequality it) {
		return new InequalityOpImpl(it, this);
	}

	default InequalityOp miniJava__Inequality__AS__miniJava__Assignee(Inequality it) {
		return new InequalityOpImpl(it, this);
	}

	default InequalityOp miniJava__Inequality__AS__miniJava__Statement(Inequality it) {
		return new InequalityOpImpl(it, this);
	}

	default InferiorOp miniJava__Inferior(Inferior it) {
		return new InferiorOpImpl(it, this);
	}

	default InferiorOp miniJava__Inferior__AS__miniJava__Assignee(Inferior it) {
		return new InferiorOpImpl(it, this);
	}

	default InferiorOp miniJava__Inferior__AS__miniJava__Statement(Inferior it) {
		return new InferiorOpImpl(it, this);
	}

	default InferiorOrEqualOp miniJava__InferiorOrEqual(InferiorOrEqual it) {
		return new InferiorOrEqualOpImpl(it, this);
	}

	default InferiorOrEqualOp miniJava__InferiorOrEqual__AS__miniJava__Assignee(InferiorOrEqual it) {
		return new InferiorOrEqualOpImpl(it, this);
	}

	default InferiorOrEqualOp miniJava__InferiorOrEqual__AS__miniJava__Statement(InferiorOrEqual it) {
		return new InferiorOrEqualOpImpl(it, this);
	}

	default IntConstantOp miniJava__IntConstant(IntConstant it) {
		return new IntConstantOpImpl(it, this);
	}

	default IntConstantOp miniJava__IntConstant__AS__miniJava__Assignee(IntConstant it) {
		return new IntConstantOpImpl(it, this);
	}

	default IntConstantOp miniJava__IntConstant__AS__miniJava__Statement(IntConstant it) {
		return new IntConstantOpImpl(it, this);
	}

	default IntegerTypeRefOp miniJava__IntegerTypeRef(IntegerTypeRef it) {
		return new IntegerTypeRefOpImpl(it, this);
	}

	default IntegerValueOp miniJava__IntegerValue(IntegerValue it) {
		return new IntegerValueOpImpl(it, this);
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

	default MethodCallOp miniJava__MethodCall(MethodCall it) {
		return new MethodCallOpImpl(it, this);
	}

	default MethodCallOp miniJava__MethodCall__AS__miniJava__Assignee(MethodCall it) {
		return new MethodCallOpImpl(it, this);
	}

	default MethodCallOp miniJava__MethodCall__AS__miniJava__Statement(MethodCall it) {
		return new MethodCallOpImpl(it, this);
	}

	default MethodCall2Op miniJava__MethodCall2(MethodCall2 it) {
		return new MethodCall2OpImpl(it, this);
	}

	default MinusOp miniJava__Minus(Minus it) {
		return new MinusOpImpl(it, this);
	}

	default MinusOp miniJava__Minus__AS__miniJava__Assignee(Minus it) {
		return new MinusOpImpl(it, this);
	}

	default MinusOp miniJava__Minus__AS__miniJava__Statement(Minus it) {
		return new MinusOpImpl(it, this);
	}

	default ModuloOp miniJava__Modulo(Modulo it) {
		return new ModuloOpImpl(it, this);
	}

	default ModuloOp miniJava__Modulo__AS__miniJava__Assignee(Modulo it) {
		return new ModuloOpImpl(it, this);
	}

	default ModuloOp miniJava__Modulo__AS__miniJava__Statement(Modulo it) {
		return new ModuloOpImpl(it, this);
	}

	default MultiplicationOp miniJava__Multiplication(Multiplication it) {
		return new MultiplicationOpImpl(it, this);
	}

	default MultiplicationOp miniJava__Multiplication__AS__miniJava__Assignee(Multiplication it) {
		return new MultiplicationOpImpl(it, this);
	}

	default MultiplicationOp miniJava__Multiplication__AS__miniJava__Statement(Multiplication it) {
		return new MultiplicationOpImpl(it, this);
	}

	default NamedElementOp miniJava__NamedElement(NamedElement it) {
		return new NamedElementOpImpl(it, this);
	}

	default NegOp miniJava__Neg(Neg it) {
		return new NegOpImpl(it, this);
	}

	default NegOp miniJava__Neg__AS__miniJava__Assignee(Neg it) {
		return new NegOpImpl(it, this);
	}

	default NegOp miniJava__Neg__AS__miniJava__Statement(Neg it) {
		return new NegOpImpl(it, this);
	}

	default NewArrayOp miniJava__NewArray(NewArray it) {
		return new NewArrayOpImpl(it, this);
	}

	default NewArrayOp miniJava__NewArray__AS__miniJava__Assignee(NewArray it) {
		return new NewArrayOpImpl(it, this);
	}

	default NewArrayOp miniJava__NewArray__AS__miniJava__Statement(NewArray it) {
		return new NewArrayOpImpl(it, this);
	}

	default NewCallOp miniJava__NewCall(NewCall it) {
		return new NewCallOpImpl(it, this);
	}

	default NewObjectOp miniJava__NewObject(NewObject it) {
		return new NewObjectOpImpl(it, this);
	}

	default NewObjectOp miniJava__NewObject__AS__miniJava__Assignee(NewObject it) {
		return new NewObjectOpImpl(it, this);
	}

	default NewObjectOp miniJava__NewObject__AS__miniJava__Statement(NewObject it) {
		return new NewObjectOpImpl(it, this);
	}

	default NotOp miniJava__Not(Not it) {
		return new NotOpImpl(it, this);
	}

	default NotOp miniJava__Not__AS__miniJava__Assignee(Not it) {
		return new NotOpImpl(it, this);
	}

	default NotOp miniJava__Not__AS__miniJava__Statement(Not it) {
		return new NotOpImpl(it, this);
	}

	default NullOp miniJava__Null(Null it) {
		return new NullOpImpl(it, this);
	}

	default NullOp miniJava__Null__AS__miniJava__Assignee(Null it) {
		return new NullOpImpl(it, this);
	}

	default NullOp miniJava__Null__AS__miniJava__Statement(Null it) {
		return new NullOpImpl(it, this);
	}

	default NullValueOp miniJava__NullValue(NullValue it) {
		return new NullValueOpImpl(it, this);
	}

	default ObjectInstanceOp miniJava__ObjectInstance(ObjectInstance it) {
		return new ObjectInstanceOpImpl(it, this);
	}

	default ObjectRefValueOp miniJava__ObjectRefValue(ObjectRefValue it) {
		return new ObjectRefValueOpImpl(it, this);
	}

	default OrOp miniJava__Or(Or it) {
		return new OrOpImpl(it, this);
	}

	default OrOp miniJava__Or__AS__miniJava__Assignee(Or it) {
		return new OrOpImpl(it, this);
	}

	default OrOp miniJava__Or__AS__miniJava__Statement(Or it) {
		return new OrOpImpl(it, this);
	}

	default OutputStreamOp miniJava__OutputStream(OutputStream it) {
		return new OutputStreamOpImpl(it, this);
	}

	default ParameterOp miniJava__Parameter(Parameter it) {
		return new ParameterOpImpl(it, this);
	}

	default PlusOp miniJava__Plus(Plus it) {
		return new PlusOpImpl(it, this);
	}

	default PlusOp miniJava__Plus__AS__miniJava__Assignee(Plus it) {
		return new PlusOpImpl(it, this);
	}

	default PlusOp miniJava__Plus__AS__miniJava__Statement(Plus it) {
		return new PlusOpImpl(it, this);
	}

	default PrintStatementOp miniJava__PrintStatement(PrintStatement it) {
		return new PrintStatementOpImpl(it, this);
	}

	default ProgramOp miniJava__Program(Program it) {
		return new ProgramOpImpl(it, this);
	}

	default ReturnOp miniJava__Return(Return it) {
		return new ReturnOpImpl(it, this);
	}

	default SingleTypeRefOp miniJava__SingleTypeRef(SingleTypeRef it) {
		return new SingleTypeRefOpImpl(it, this);
	}

	default StateOp miniJava__State(State it) {
		return new StateOpImpl(it, this);
	}

	default StatementOp miniJava__Statement(Statement it) {
		return new StatementOpImpl(it, this);
	}

	default StringConstantOp miniJava__StringConstant(StringConstant it) {
		return new StringConstantOpImpl(it, this);
	}

	default StringConstantOp miniJava__StringConstant__AS__miniJava__Assignee(StringConstant it) {
		return new StringConstantOpImpl(it, this);
	}

	default StringConstantOp miniJava__StringConstant__AS__miniJava__Statement(StringConstant it) {
		return new StringConstantOpImpl(it, this);
	}

	default StringTypeRefOp miniJava__StringTypeRef(StringTypeRef it) {
		return new StringTypeRefOpImpl(it, this);
	}

	default StringValueOp miniJava__StringValue(StringValue it) {
		return new StringValueOpImpl(it, this);
	}

	default SuperOp miniJava__Super(Super it) {
		return new SuperOpImpl(it, this);
	}

	default SuperOp miniJava__Super__AS__miniJava__Assignee(Super it) {
		return new SuperOpImpl(it, this);
	}

	default SuperOp miniJava__Super__AS__miniJava__Statement(Super it) {
		return new SuperOpImpl(it, this);
	}

	default SuperiorOp miniJava__Superior(Superior it) {
		return new SuperiorOpImpl(it, this);
	}

	default SuperiorOp miniJava__Superior__AS__miniJava__Assignee(Superior it) {
		return new SuperiorOpImpl(it, this);
	}

	default SuperiorOp miniJava__Superior__AS__miniJava__Statement(Superior it) {
		return new SuperiorOpImpl(it, this);
	}

	default SuperiorOrEqualOp miniJava__SuperiorOrEqual(SuperiorOrEqual it) {
		return new SuperiorOrEqualOpImpl(it, this);
	}

	default SuperiorOrEqualOp miniJava__SuperiorOrEqual__AS__miniJava__Assignee(SuperiorOrEqual it) {
		return new SuperiorOrEqualOpImpl(it, this);
	}

	default SuperiorOrEqualOp miniJava__SuperiorOrEqual__AS__miniJava__Statement(SuperiorOrEqual it) {
		return new SuperiorOrEqualOpImpl(it, this);
	}

	default SymbolOp miniJava__Symbol(Symbol it) {
		return new SymbolOpImpl(it, this);
	}

	default SymbolBindingOp miniJava__SymbolBinding(SymbolBinding it) {
		return new SymbolBindingOpImpl(it, this);
	}

	default SymbolRefOp miniJava__SymbolRef(SymbolRef it) {
		return new SymbolRefOpImpl(it, this);
	}

	default SymbolRefOp miniJava__SymbolRef__AS__miniJava__Assignee(SymbolRef it) {
		return new SymbolRefOpImpl(it, this);
	}

	default SymbolRefOp miniJava__SymbolRef__AS__miniJava__Statement(SymbolRef it) {
		return new SymbolRefOpImpl(it, this);
	}

	default ThisOp miniJava__This(This it) {
		return new ThisOpImpl(it, this);
	}

	default ThisOp miniJava__This__AS__miniJava__Assignee(This it) {
		return new ThisOpImpl(it, this);
	}

	default ThisOp miniJava__This__AS__miniJava__Statement(This it) {
		return new ThisOpImpl(it, this);
	}

	default TypeDeclarationOp miniJava__TypeDeclaration(TypeDeclaration it) {
		return new TypeDeclarationOpImpl(it, this);
	}

	default TypeRefOp miniJava__TypeRef(TypeRef it) {
		return new TypeRefOpImpl(it, this);
	}

	default TypedDeclarationOp miniJava__TypedDeclaration(TypedDeclaration it) {
		return new TypedDeclarationOpImpl(it, this);
	}

	default ValueOp miniJava__Value(Value it) {
		return new ValueOpImpl(it, this);
	}

	default VariableDeclarationOp miniJava__VariableDeclaration(VariableDeclaration it) {
		return new VariableDeclarationOpImpl(it, this);
	}

	default VariableDeclarationOp miniJava__VariableDeclaration__AS__miniJava__Assignee(
			VariableDeclaration it) {
		return new VariableDeclarationOpImpl(it, this);
	}

	default VariableDeclarationOp miniJava__VariableDeclaration__AS__miniJava__Symbol(
			VariableDeclaration it) {
		return new VariableDeclarationOpImpl(it, this);
	}

	default VoidTypeRefOp miniJava__VoidTypeRef(VoidTypeRef it) {
		return new VoidTypeRefOpImpl(it, this);
	}

	default WhileStatementOp miniJava__WhileStatement(WhileStatement it) {
		return new WhileStatementOpImpl(it, this);
	}
}
