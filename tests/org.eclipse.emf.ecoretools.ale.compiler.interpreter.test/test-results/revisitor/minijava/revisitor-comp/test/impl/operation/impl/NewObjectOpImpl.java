package test.impl.operation.impl;

import java.lang.Integer;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Field;
import miniJava.FieldBinding;
import miniJava.Member;
import miniJava.Method;
import miniJava.MiniJavaFactory;
import miniJava.NewCall;
import miniJava.NewObject;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Parameter;
import miniJava.State;
import miniJava.SymbolBinding;
import miniJava.Value;
import miniJava.revisitor.MiniJavaRevisitor;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
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

public class NewObjectOpImpl extends ExpressionOpImpl implements NewObjectOp {
  private MiniJavaRevisitor<AndOp, AndOp, AndOp, ArrayAccessOp, ArrayAccessOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayLengthOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BoolConstantOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, DivisionOp, DivisionOp, EqualityOp, EqualityOp, EqualityOp, ExpressionOp, ExpressionOp, ExpressionOp, FieldOp, FieldAccessOp, FieldAccessOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InequalityOp, InequalityOp, InferiorOp, InferiorOp, InferiorOp, InferiorOrEqualOp, InferiorOrEqualOp, InferiorOrEqualOp, IntConstantOp, IntConstantOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCallOp, MethodCallOp, MethodCall2Op, MinusOp, MinusOp, MinusOp, ModuloOp, ModuloOp, ModuloOp, MultiplicationOp, MultiplicationOp, MultiplicationOp, NamedElementOp, NegOp, NegOp, NegOp, NewArrayOp, NewArrayOp, NewArrayOp, NewCallOp, NewObjectOp, NewObjectOp, NewObjectOp, NotOp, NotOp, NotOp, NullOp, NullOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OrOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PlusOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringConstantOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperOp, SuperOp, SuperiorOp, SuperiorOp, SuperiorOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, SymbolRefOp, SymbolRefOp, ThisOp, ThisOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VariableDeclarationOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev;

  private NewObject obj;

  public NewObjectOpImpl(NewObject obj,
      MiniJavaRevisitor<AndOp, AndOp, AndOp, ArrayAccessOp, ArrayAccessOp, ArrayAccessOp, ArrayInstanceOp, ArrayLengthOp, ArrayLengthOp, ArrayLengthOp, ArrayRefValueOp, ArrayTypeRefOp, AssigneeOp, AssignmentOp, BlockOp, BoolConstantOp, BoolConstantOp, BoolConstantOp, BooleanTypeRefOp, BooleanValueOp, CallOp, ClassRefOp, ClazzOp, ContextOp, DivisionOp, DivisionOp, DivisionOp, EqualityOp, EqualityOp, EqualityOp, ExpressionOp, ExpressionOp, ExpressionOp, FieldOp, FieldAccessOp, FieldAccessOp, FieldAccessOp, FieldBindingOp, ForStatementOp, FrameOp, IfStatementOp, ImportOp, InequalityOp, InequalityOp, InequalityOp, InferiorOp, InferiorOp, InferiorOp, InferiorOrEqualOp, InferiorOrEqualOp, InferiorOrEqualOp, IntConstantOp, IntConstantOp, IntConstantOp, IntegerTypeRefOp, IntegerValueOp, InterfaceOp, MemberOp, MethodOp, MethodCallOp, MethodCallOp, MethodCallOp, MethodCall2Op, MinusOp, MinusOp, MinusOp, ModuloOp, ModuloOp, ModuloOp, MultiplicationOp, MultiplicationOp, MultiplicationOp, NamedElementOp, NegOp, NegOp, NegOp, NewArrayOp, NewArrayOp, NewArrayOp, NewCallOp, NewObjectOp, NewObjectOp, NewObjectOp, NotOp, NotOp, NotOp, NullOp, NullOp, NullOp, NullValueOp, ObjectInstanceOp, ObjectRefValueOp, OrOp, OrOp, OrOp, OutputStreamOp, ParameterOp, PlusOp, PlusOp, PlusOp, PrintStatementOp, ProgramOp, ReturnOp, SingleTypeRefOp, StateOp, StatementOp, StringConstantOp, StringConstantOp, StringConstantOp, StringTypeRefOp, StringValueOp, SuperOp, SuperOp, SuperOp, SuperiorOp, SuperiorOp, SuperiorOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SuperiorOrEqualOp, SymbolOp, SymbolBindingOp, SymbolRefOp, SymbolRefOp, SymbolRefOp, ThisOp, ThisOp, ThisOp, TypeDeclarationOp, TypeRefOp, TypedDeclarationOp, ValueOp, VariableDeclarationOp, VariableDeclarationOp, VariableDeclarationOp, VoidTypeRefOp, WhileStatementOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public Value evaluateExpression(State state) {
    Value result;
    ObjectInstance res = ((ObjectInstance) (MiniJavaFactory.eINSTANCE.createObjectInstance()));
    res.setType(this.obj.getType());
    state.getObjectsHeap().add(res);
    int i = ((int) (0));
    int z = ((int) (CollectionService.size(res.getType().getMembers())));
    while ((i) < (z)) {
      Member m = ((Member) (CollectionService.get(res.getType().getMembers(), i)));
      if(m instanceof Field) {
        Field f = ((Field) (m));
        if(!EqualService.equals((f.getDefaultValue()), (null))) {
          Value v = ((Value) (rev.$((Expression)f.getDefaultValue()).evaluateExpression(((State) (state)))));
          FieldBinding fb = ((FieldBinding) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
          fb.setField(f);
          fb.setValue(v);
          res.getFieldbindings().add(fb);
        }
      }
      i = ((Integer) ((i) + (1)));
    }
    i = ((Integer) (0));
    Method constructor = ((Method) (null));
    while ((((i) < (z)) && (EqualService.equals((constructor), (null))))) {
      Member m = ((Member) (CollectionService.get(res.getType().getMembers(), i)));
      if(m instanceof Method) {
        Method mtd = ((Method) (m));
        if(((EqualService.equals((mtd.getName()), (null))) && (EqualService.equals((CollectionService.size(mtd.getParams())), (CollectionService.size(this.obj.getArgs())))))) {
          constructor = ((Method) (mtd));
        }
      }
      i = ((Integer) ((i) + (1)));
    }
    if(!EqualService.equals((constructor), (null))) {
      Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
      i = ((Integer) (0));
      z = ((Integer) (CollectionService.size(this.obj.getArgs())));
      while ((i) < (z)) {
        Expression arg = ((Expression) (CollectionService.get(this.obj.getArgs(), i)));
        Parameter param = ((Parameter) (CollectionService.get(constructor.getParams(), i)));
        SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
        binding.setSymbol(param);
        binding.setValue(rev.$((Expression)arg).evaluateExpression(((State) (state))));
        i = ((Integer) ((i) + (1)));
        newContext.getBindings().add(binding);
      }
      NewCall call = ((NewCall) (MiniJavaFactory.eINSTANCE.createNewCall()));
      call.setNewz(this.obj);
      rev.$((State)state).pushNewFrame(((ObjectInstance) (res)), ((NewCall) (call)), ((Context) (newContext)));
      constructor.getBody().evaluateStatement((State) (state));
      rev.$((State)state).popCurrentFrame();
    }
    ObjectRefValue tmp = ((ObjectRefValue) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
    tmp.setInstance(res);
    result = ((ObjectRefValue) (tmp));
    return result;
  }
}
