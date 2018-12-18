/**
 * generated by Xtext 2.14.0
 */
package org.xtext.example.mydsl.myDsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xtext.example.mydsl.myDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage
 * @generated
 */
public class MyDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MyDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MyDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MyDslPackage.FILE:
      {
        File file = (File)theEObject;
        T result = caseFile(file);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.TOP_LEVEL_CMD:
      {
        TopLevelCmd topLevelCmd = (TopLevelCmd)theEObject;
        T result = caseTopLevelCmd(topLevelCmd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T result = caseExpr(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.DEF:
      {
        Def def = (Def)theEObject;
        T result = caseDef(def);
        if (result == null) result = caseTopLevelCmd(def);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.APP:
      {
        App app = (App)theEObject;
        T result = caseApp(app);
        if (result == null) result = caseTopLevelCmd(app);
        if (result == null) result = caseExpr(app);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.VAR:
      {
        Var var = (Var)theEObject;
        T result = caseVar(var);
        if (result == null) result = caseTopLevelCmd(var);
        if (result == null) result = caseExpr(var);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.THIS:
      {
        This this_ = (This)theEObject;
        T result = caseThis(this_);
        if (result == null) result = caseTopLevelCmd(this_);
        if (result == null) result = caseExpr(this_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.BOOL:
      {
        Bool bool = (Bool)theEObject;
        T result = caseBool(bool);
        if (result == null) result = caseTopLevelCmd(bool);
        if (result == null) result = caseExpr(bool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.INT:
      {
        Int int_ = (Int)theEObject;
        T result = caseInt(int_);
        if (result == null) result = caseTopLevelCmd(int_);
        if (result == null) result = caseExpr(int_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.SKIP:
      {
        Skip skip = (Skip)theEObject;
        T result = caseSkip(skip);
        if (result == null) result = caseTopLevelCmd(skip);
        if (result == null) result = caseExpr(skip);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.PROJECT:
      {
        Project project = (Project)theEObject;
        T result = caseProject(project);
        if (result == null) result = caseTopLevelCmd(project);
        if (result == null) result = caseExpr(project);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.BOBJECT:
      {
        BObject bObject = (BObject)theEObject;
        T result = caseBObject(bObject);
        if (result == null) result = caseTopLevelCmd(bObject);
        if (result == null) result = caseExpr(bObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.COPY:
      {
        Copy copy = (Copy)theEObject;
        T result = caseCopy(copy);
        if (result == null) result = caseTopLevelCmd(copy);
        if (result == null) result = caseExpr(copy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.WITH:
      {
        With with = (With)theEObject;
        T result = caseWith(with);
        if (result == null) result = caseTopLevelCmd(with);
        if (result == null) result = caseExpr(with);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.NOT:
      {
        Not not = (Not)theEObject;
        T result = caseNot(not);
        if (result == null) result = caseTopLevelCmd(not);
        if (result == null) result = caseExpr(not);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.IF:
      {
        If if_ = (If)theEObject;
        T result = caseIf(if_);
        if (result == null) result = caseTopLevelCmd(if_);
        if (result == null) result = caseExpr(if_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.LET:
      {
        Let let = (Let)theEObject;
        T result = caseLet(let);
        if (result == null) result = caseTopLevelCmd(let);
        if (result == null) result = caseExpr(let);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.FUN:
      {
        Fun fun = (Fun)theEObject;
        T result = caseFun(fun);
        if (result == null) result = caseTopLevelCmd(fun);
        if (result == null) result = caseExpr(fun);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ASSIGN:
      {
        Assign assign = (Assign)theEObject;
        T result = caseAssign(assign);
        if (result == null) result = caseTopLevelCmd(assign);
        if (result == null) result = caseExpr(assign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ARITH_OP_PLUS:
      {
        ArithOpPlus arithOpPlus = (ArithOpPlus)theEObject;
        T result = caseArithOpPlus(arithOpPlus);
        if (result == null) result = caseTopLevelCmd(arithOpPlus);
        if (result == null) result = caseExpr(arithOpPlus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ARITH_OP_MINUS:
      {
        ArithOpMinus arithOpMinus = (ArithOpMinus)theEObject;
        T result = caseArithOpMinus(arithOpMinus);
        if (result == null) result = caseTopLevelCmd(arithOpMinus);
        if (result == null) result = caseExpr(arithOpMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ARITH_OP_TIMES:
      {
        ArithOpTimes arithOpTimes = (ArithOpTimes)theEObject;
        T result = caseArithOpTimes(arithOpTimes);
        if (result == null) result = caseTopLevelCmd(arithOpTimes);
        if (result == null) result = caseExpr(arithOpTimes);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ARITH_OP_DIVIDE:
      {
        ArithOpDivide arithOpDivide = (ArithOpDivide)theEObject;
        T result = caseArithOpDivide(arithOpDivide);
        if (result == null) result = caseTopLevelCmd(arithOpDivide);
        if (result == null) result = caseExpr(arithOpDivide);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ARITH_OP_REMAINDER:
      {
        ArithOpRemainder arithOpRemainder = (ArithOpRemainder)theEObject;
        T result = caseArithOpRemainder(arithOpRemainder);
        if (result == null) result = caseTopLevelCmd(arithOpRemainder);
        if (result == null) result = caseExpr(arithOpRemainder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.BOOL_OP_AND:
      {
        BoolOpAnd boolOpAnd = (BoolOpAnd)theEObject;
        T result = caseBoolOpAnd(boolOpAnd);
        if (result == null) result = caseTopLevelCmd(boolOpAnd);
        if (result == null) result = caseExpr(boolOpAnd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.BOOL_OP_OR:
      {
        BoolOpOr boolOpOr = (BoolOpOr)theEObject;
        T result = caseBoolOpOr(boolOpOr);
        if (result == null) result = caseTopLevelCmd(boolOpOr);
        if (result == null) result = caseExpr(boolOpOr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.SEQ:
      {
        Seq seq = (Seq)theEObject;
        T result = caseSeq(seq);
        if (result == null) result = caseTopLevelCmd(seq);
        if (result == null) result = caseExpr(seq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.CMP_OP_EQUAL:
      {
        CmpOpEqual cmpOpEqual = (CmpOpEqual)theEObject;
        T result = caseCmpOpEqual(cmpOpEqual);
        if (result == null) result = caseTopLevelCmd(cmpOpEqual);
        if (result == null) result = caseExpr(cmpOpEqual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.CMP_OP_UNEQUAL:
      {
        CmpOpUnequal cmpOpUnequal = (CmpOpUnequal)theEObject;
        T result = caseCmpOpUnequal(cmpOpUnequal);
        if (result == null) result = caseTopLevelCmd(cmpOpUnequal);
        if (result == null) result = caseExpr(cmpOpUnequal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.CMP_OP_LESS:
      {
        CmpOpLess cmpOpLess = (CmpOpLess)theEObject;
        T result = caseCmpOpLess(cmpOpLess);
        if (result == null) result = caseTopLevelCmd(cmpOpLess);
        if (result == null) result = caseExpr(cmpOpLess);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.FIELD:
      {
        Field field = (Field)theEObject;
        T result = caseField(field);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFile(File object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Top Level Cmd</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Top Level Cmd</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTopLevelCmd(TopLevelCmd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpr(Expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDef(Def object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>App</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>App</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApp(App object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVar(Var object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>This</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>This</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThis(This object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBool(Bool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInt(Int object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Skip</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Skip</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSkip(Skip object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Project</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProject(Project object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>BObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBObject(BObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Copy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Copy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCopy(Copy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>With</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>With</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWith(With object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNot(Not object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIf(If object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLet(Let object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFun(Fun object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssign(Assign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arith Op Plus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arith Op Plus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithOpPlus(ArithOpPlus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arith Op Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arith Op Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithOpMinus(ArithOpMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arith Op Times</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arith Op Times</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithOpTimes(ArithOpTimes object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arith Op Divide</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arith Op Divide</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithOpDivide(ArithOpDivide object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arith Op Remainder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arith Op Remainder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithOpRemainder(ArithOpRemainder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Op And</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Op And</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolOpAnd(BoolOpAnd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Op Or</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Op Or</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolOpOr(BoolOpOr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Seq</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Seq</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSeq(Seq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cmp Op Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cmp Op Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCmpOpEqual(CmpOpEqual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cmp Op Unequal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cmp Op Unequal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCmpOpUnequal(CmpOpUnequal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cmp Op Less</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cmp Op Less</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCmpOpLess(CmpOpLess object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseField(Field object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MyDslSwitch
