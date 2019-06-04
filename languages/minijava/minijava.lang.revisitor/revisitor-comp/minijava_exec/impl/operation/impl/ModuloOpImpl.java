package minijava_exec.impl.operation.impl;

import miniJava.Expression;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.Modulo;
import miniJava.State;
import miniJava.Value;
import miniJava.revisitor.MiniJavaRevisitor;
import minijava.MathService;
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

public class ModuloOpImpl extends ExpressionOpImpl implements ModuloOp {
  private MiniJavaRevisitor<AndOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, EqualityOp, ExpressionOp, FieldOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InferiorOp, InferiorOrEqualOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCall2Op, MinusOp, ModuloOp, MultiplicationOp, NamedElementOp, NegOp, NewArrayOp, NewCallOp, NewObjectOp, NotOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperiorOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev;

  private Modulo obj;

  public ModuloOpImpl(Modulo obj,
      MiniJavaRevisitor<AndOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, EqualityOp, ExpressionOp, FieldOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InferiorOp, InferiorOrEqualOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCall2Op, MinusOp, ModuloOp, MultiplicationOp, NamedElementOp, NegOp, NewArrayOp, NewCallOp, NewObjectOp, NotOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperiorOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public Value evaluateExpression(State state) {
    Value result;
    Value left = ((Value) (rev.$((Expression)this.obj.getLeft()).evaluateExpression(((State) (state)))));
    Value right = ((Value) (rev.$((Expression)this.obj.getRight()).evaluateExpression(((State) (state)))));
    if(left instanceof IntegerValue) {
      if(right instanceof IntegerValue) {
        IntegerValue bleft = ((IntegerValue) (left));
        IntegerValue bright = ((IntegerValue) (right));
        IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
        tmp.setValue(MathService.mod((Modulo) (this.obj), (int) (bleft.getValue()), (int) (bright.getValue())));
        result = ((IntegerValue) (tmp));
      }
      else {
        result = ((Value) (null));
      }
    }
    else {
      result = ((Value) (null));
    }
    return result;
  }
}
