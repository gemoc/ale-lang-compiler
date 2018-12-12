/**
 */
package imp.model.imp.util;

import imp.model.imp.ArrayDecl;
import imp.model.imp.ArrayValue;
import imp.model.imp.Assignment;
import imp.model.imp.AttributeDecl;
import imp.model.imp.Binary;
import imp.model.imp.Block;
import imp.model.imp.BoolConst;
import imp.model.imp.BoolValue;
import imp.model.imp.Declaration;
import imp.model.imp.Expr;
import imp.model.imp.If;
import imp.model.imp.ImpPackage;
import imp.model.imp.IntConst;
import imp.model.imp.IntValue;
import imp.model.imp.Member;
import imp.model.imp.MethodDecl;
import imp.model.imp.NamedElement;
import imp.model.imp.NewClass;
import imp.model.imp.ParamDecl;
import imp.model.imp.Print;
import imp.model.imp.Program;
import imp.model.imp.Project;
import imp.model.imp.Return;
import imp.model.imp.Skip;
import imp.model.imp.Stmt;
import imp.model.imp.Store;
import imp.model.imp.StringConst;
import imp.model.imp.StringValue;
import imp.model.imp.Symbol;
import imp.model.imp.This;
import imp.model.imp.Unary;
import imp.model.imp.Value;
import imp.model.imp.VarRef;
import imp.model.imp.While;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see imp.model.imp.ImpPackage
 * @generated
 */
public class ImpSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImpPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpSwitch() {
		if (modelPackage == null) {
			modelPackage = ImpPackage.eINSTANCE;
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
	protected boolean isSwitchFor(EPackage ePackage) {
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ImpPackage.STMT: {
			Stmt stmt = (Stmt) theEObject;
			T result = caseStmt(stmt);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.SKIP: {
			Skip skip = (Skip) theEObject;
			T result = caseSkip(skip);
			if (result == null)
				result = caseStmt(skip);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.DECLARATION: {
			Declaration declaration = (Declaration) theEObject;
			T result = caseDeclaration(declaration);
			if (result == null)
				result = caseStmt(declaration);
			if (result == null)
				result = caseSymbol(declaration);
			if (result == null)
				result = caseMember(declaration);
			if (result == null)
				result = caseNamedElement(declaration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.EXPR: {
			Expr expr = (Expr) theEObject;
			T result = caseExpr(expr);
			if (result == null)
				result = caseStmt(expr);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.BLOCK: {
			Block block = (Block) theEObject;
			T result = caseBlock(block);
			if (result == null)
				result = caseStmt(block);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.IF: {
			If if_ = (If) theEObject;
			T result = caseIf(if_);
			if (result == null)
				result = caseStmt(if_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.WHILE: {
			While while_ = (While) theEObject;
			T result = caseWhile(while_);
			if (result == null)
				result = caseStmt(while_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.INT_CONST: {
			IntConst intConst = (IntConst) theEObject;
			T result = caseIntConst(intConst);
			if (result == null)
				result = caseExpr(intConst);
			if (result == null)
				result = caseStmt(intConst);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.UNARY: {
			Unary unary = (Unary) theEObject;
			T result = caseUnary(unary);
			if (result == null)
				result = caseExpr(unary);
			if (result == null)
				result = caseStmt(unary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.BINARY: {
			Binary binary = (Binary) theEObject;
			T result = caseBinary(binary);
			if (result == null)
				result = caseExpr(binary);
			if (result == null)
				result = caseStmt(binary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.STORE: {
			Store store = (Store) theEObject;
			T result = caseStore(store);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.STRING_TO_VALUE_MAP: {
			@SuppressWarnings("unchecked")
			Map.Entry<String, Value> stringToValueMap = (Map.Entry<String, Value>) theEObject;
			T result = caseStringToValueMap(stringToValueMap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.VALUE: {
			Value value = (Value) theEObject;
			T result = caseValue(value);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.INT_VALUE: {
			IntValue intValue = (IntValue) theEObject;
			T result = caseIntValue(intValue);
			if (result == null)
				result = caseValue(intValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.BOOL_VALUE: {
			BoolValue boolValue = (BoolValue) theEObject;
			T result = caseBoolValue(boolValue);
			if (result == null)
				result = caseValue(boolValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.ARRAY_VALUE: {
			ArrayValue arrayValue = (ArrayValue) theEObject;
			T result = caseArrayValue(arrayValue);
			if (result == null)
				result = caseValue(arrayValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.ARRAY_DECL: {
			ArrayDecl arrayDecl = (ArrayDecl) theEObject;
			T result = caseArrayDecl(arrayDecl);
			if (result == null)
				result = caseExpr(arrayDecl);
			if (result == null)
				result = caseStmt(arrayDecl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.BOOL_CONST: {
			BoolConst boolConst = (BoolConst) theEObject;
			T result = caseBoolConst(boolConst);
			if (result == null)
				result = caseExpr(boolConst);
			if (result == null)
				result = caseStmt(boolConst);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.PROGRAM: {
			Program program = (Program) theEObject;
			T result = caseProgram(program);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.METHOD_DECL: {
			MethodDecl methodDecl = (MethodDecl) theEObject;
			T result = caseMethodDecl(methodDecl);
			if (result == null)
				result = caseMember(methodDecl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.RETURN: {
			Return return_ = (Return) theEObject;
			T result = caseReturn(return_);
			if (result == null)
				result = caseStmt(return_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.PRINT: {
			Print print = (Print) theEObject;
			T result = casePrint(print);
			if (result == null)
				result = caseStmt(print);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.STRING_CONST: {
			StringConst stringConst = (StringConst) theEObject;
			T result = caseStringConst(stringConst);
			if (result == null)
				result = caseExpr(stringConst);
			if (result == null)
				result = caseStmt(stringConst);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.STRING_VALUE: {
			StringValue stringValue = (StringValue) theEObject;
			T result = caseStringValue(stringValue);
			if (result == null)
				result = caseValue(stringValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.PARAM_DECL: {
			ParamDecl paramDecl = (ParamDecl) theEObject;
			T result = caseParamDecl(paramDecl);
			if (result == null)
				result = caseSymbol(paramDecl);
			if (result == null)
				result = caseMember(paramDecl);
			if (result == null)
				result = caseNamedElement(paramDecl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.NAMED_ELEMENT: {
			NamedElement namedElement = (NamedElement) theEObject;
			T result = caseNamedElement(namedElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.CLASS: {
			imp.model.imp.Class class_ = (imp.model.imp.Class) theEObject;
			T result = caseClass(class_);
			if (result == null)
				result = caseNamedElement(class_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.ATTRIBUTE_DECL: {
			AttributeDecl attributeDecl = (AttributeDecl) theEObject;
			T result = caseAttributeDecl(attributeDecl);
			if (result == null)
				result = caseMember(attributeDecl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.THIS: {
			This this_ = (This) theEObject;
			T result = caseThis(this_);
			if (result == null)
				result = caseExpr(this_);
			if (result == null)
				result = caseStmt(this_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.NEW_CLASS: {
			NewClass newClass = (NewClass) theEObject;
			T result = caseNewClass(newClass);
			if (result == null)
				result = caseExpr(newClass);
			if (result == null)
				result = caseStmt(newClass);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.ASSIGNMENT: {
			Assignment assignment = (Assignment) theEObject;
			T result = caseAssignment(assignment);
			if (result == null)
				result = caseStmt(assignment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.PROJECT: {
			Project project = (Project) theEObject;
			T result = caseProject(project);
			if (result == null)
				result = caseExpr(project);
			if (result == null)
				result = caseStmt(project);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.SYMBOL: {
			Symbol symbol = (Symbol) theEObject;
			T result = caseSymbol(symbol);
			if (result == null)
				result = caseNamedElement(symbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.MEMBER: {
			Member member = (Member) theEObject;
			T result = caseMember(member);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpPackage.VAR_REF: {
			VarRef varRef = (VarRef) theEObject;
			T result = caseVarRef(varRef);
			if (result == null)
				result = caseExpr(varRef);
			if (result == null)
				result = caseStmt(varRef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStmt(Stmt object) {
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
	public T caseSkip(Skip object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
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
	public T caseExpr(Expr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
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
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhile(While object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Const</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Const</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntConst(IntConst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnary(Unary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinary(Binary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStore(Store object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Value Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Value Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToValueMap(Map.Entry<String, Value> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntValue(IntValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolValue(BoolValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayValue(ArrayValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayDecl(ArrayDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Const</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Const</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolConst(BoolConst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodDecl(MethodDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturn(Return object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Print</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrint(Print object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Const</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Const</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringConst(StringConst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValue(StringValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamDecl(ParamDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(imp.model.imp.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDecl(AttributeDecl object) {
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
	public T caseThis(This object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewClass(NewClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
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
	public T caseProject(Project object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbol(Symbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMember(Member object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarRef(VarRef object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //ImpSwitch
