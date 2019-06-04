package minijava_exec.impl.operation.impl;

import java.lang.Integer;
import miniJava.Clazz;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Method;
import miniJava.MethodCall;
import miniJava.MethodCall2;
import miniJava.MiniJavaFactory;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Parameter;
import miniJava.State;
import miniJava.SymbolBinding;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

public class MethodCallOpImpl extends ExpressionOpImpl implements MethodCallOp {
  private MiniJavaRevisitor<AndOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, EqualityOp, ExpressionOp, FieldOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InferiorOp, InferiorOrEqualOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCall2Op, MinusOp, ModuloOp, MultiplicationOp, NamedElementOp, NegOp, NewArrayOp, NewCallOp, NewObjectOp, NotOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperiorOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev;

  private MethodCall obj;

  public MethodCallOpImpl(MethodCall obj,
      MiniJavaRevisitor<AndOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, EqualityOp, ExpressionOp, FieldOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InferiorOp, InferiorOrEqualOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCall2Op, MinusOp, ModuloOp, MultiplicationOp, NamedElementOp, NegOp, NewArrayOp, NewCallOp, NewObjectOp, NotOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperiorOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public Value evaluateExpression(State state) {
    Value result;
    ObjectRefValue realReceiver0 = ((ObjectRefValue) (((ObjectRefValue) (rev.$((Expression)this.obj.getReceiver()).evaluateExpression(((State) (state)))))));
    ObjectInstance realReceiver = ((ObjectInstance) (realReceiver0.getInstance()));
    Method realMethod = ((Method) (((Method) (rev.$((Method)this.obj.getMethod()).findOverride(((Clazz) (realReceiver.getType())))))));
    Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
    int argsLength = ((int) (CollectionService.size(this.obj.getArgs())));
    int i = ((int) (0));
    while ((i) < (argsLength)) {
      Expression arg = ((Expression) (CollectionService.get(this.obj.getArgs(), i)));
      Parameter param = ((Parameter) (CollectionService.get(realMethod.getParams(), i)));
      SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
      binding.setSymbol(param);
      binding.setValue(rev.$((Expression)arg).evaluateExpression(((State) (state))));
      newContext.getBindings().add(binding);
      i = ((Integer) ((i) + (1)));
    }
    MethodCall2 call = ((MethodCall2) (MiniJavaFactory.eINSTANCE.createMethodCall2()));
    call.setMethodcall(this.obj);
    rev.$((State)state).pushNewFrame(((ObjectInstance) (realReceiver)), ((MethodCall2) (call)), ((Context) (newContext)));
    rev.$((MethodCall)this.obj).call(((Method) (realMethod)), ((State) (state)));
    Value returnValue = ((Value) (rev.$((State)state).findCurrentFrame().getReturnValue()));
    rev.$((State)state).popCurrentFrame();
    result = ((Value) (returnValue));
    return result;
  }

  public void call(Method realMethod, State state) {
    rev.$((Method)realMethod).call(((State) (state)));
  }
}
