package minijava_exec.impl.operation.impl;

import java.lang.Boolean;
import miniJava.BooleanValue;
import miniJava.Equality;
import miniJava.Expression;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.NullValue;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.StringValue;
import miniJava.Value;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class EqualityOpImpl extends ExpressionOpImpl implements EqualityOp {
  private MiniJavaRevisitor<AndOp, AndOp, AndOp, ArrayAccessOp, ArrayAccessOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayLengthOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BoolConstantOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, DivisionOp, DivisionOp, EqualityOp, EqualityOp, EqualityOp, ExpressionOp, ExpressionOp, ExpressionOp, FieldOp, FieldAccessOp, FieldAccessOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InequalityOp, InequalityOp, InferiorOp, InferiorOp, InferiorOp, InferiorOrEqualOp, InferiorOrEqualOp, InferiorOrEqualOp, IntConstantOp, IntConstantOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCallOp, MethodCallOp, MethodCall2Op, MinusOp, MinusOp, MinusOp, ModuloOp, ModuloOp, ModuloOp, MultiplicationOp, MultiplicationOp, MultiplicationOp, NamedElementOp, NegOp, NegOp, NegOp, NewArrayOp, NewArrayOp, NewArrayOp, NewCallOp, NewObjectOp, NewObjectOp, NewObjectOp, NotOp, NotOp, NotOp, NullOp, NullOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OrOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PlusOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringConstantOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperOp, SuperOp, SuperiorOp, SuperiorOp, SuperiorOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, SymbolRefOp, SymbolRefOp, ThisOp, ThisOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VariableDeclarationOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev;

  private Equality obj;

  public EqualityOpImpl(Equality obj,
      MiniJavaRevisitor<AndOp, AndOp, AndOp, ArrayAccessOp, ArrayAccessOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayLengthOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BoolConstantOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, DivisionOp, DivisionOp, EqualityOp, EqualityOp, EqualityOp, ExpressionOp, ExpressionOp, ExpressionOp, FieldOp, FieldAccessOp, FieldAccessOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InequalityOp, InequalityOp, InferiorOp, InferiorOp, InferiorOp, InferiorOrEqualOp, InferiorOrEqualOp, InferiorOrEqualOp, IntConstantOp, IntConstantOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCallOp, MethodCallOp, MethodCall2Op, MinusOp, MinusOp, MinusOp, ModuloOp, ModuloOp, ModuloOp, MultiplicationOp, MultiplicationOp, MultiplicationOp, NamedElementOp, NegOp, NegOp, NegOp, NewArrayOp, NewArrayOp, NewArrayOp, NewCallOp, NewObjectOp, NewObjectOp, NewObjectOp, NotOp, NotOp, NotOp, NullOp, NullOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OrOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PlusOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringConstantOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperOp, SuperOp, SuperiorOp, SuperiorOp, SuperiorOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, SymbolRefOp, SymbolRefOp, ThisOp, ThisOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VariableDeclarationOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public Value evaluateExpression(State state) {
    Value result;
    Value left = ((Value) (rev.$((Expression)this.obj.getLeft()).evaluateExpression(((State) (state)))));
    Value right = ((Value) (rev.$((Expression)this.obj.getRight()).evaluateExpression(((State) (state)))));
    boolean tmp = ((boolean) (false));
    if(left instanceof IntegerValue) {
      if(right instanceof IntegerValue) {
        IntegerValue ileft = ((IntegerValue) (left));
        IntegerValue iright = ((IntegerValue) (right));
        tmp = ((Boolean) (EqualService.equals((ileft.getValue()), (iright.getValue()))));
      }
    }
    else {
      if(left instanceof StringValue) {
        if(right instanceof StringValue) {
          StringValue ileft = ((StringValue) (left));
          StringValue iright = ((StringValue) (right));
          tmp = ((Boolean) (EqualService.equals((ileft.getValue()), (iright.getValue()))));
        }
      }
      else {
        if(left instanceof BooleanValue) {
          if(right instanceof BooleanValue) {
            BooleanValue ileft = ((BooleanValue) (left));
            BooleanValue iright = ((BooleanValue) (right));
            tmp = ((Boolean) (EqualService.equals((ileft.isValue()), (iright.isValue()))));
          }
        }
        else {
          if(left instanceof NullValue) {
            if(right instanceof NullValue) {
              tmp = ((Boolean) (true));
            }
          }
          else {
            if(left instanceof ObjectRefValue) {
              if(right instanceof ObjectRefValue) {
                ObjectRefValue ileft = ((ObjectRefValue) (left));
                ObjectRefValue iright = ((ObjectRefValue) (right));
                tmp = ((Boolean) (EqualService.equals((ileft.getInstance()), (iright.getInstance()))));
              }
            }
          }
        }
      }
    }
    BooleanValue tmpo = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
    tmpo.setValue(tmp);
    result = ((BooleanValue) (tmpo));
    return result;
  }
}
