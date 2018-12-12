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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see imp.model.imp.ImpPackage
 * @generated
 */
public class ImpAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImpPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ImpPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpSwitch<Adapter> modelSwitch = new ImpSwitch<Adapter>() {
		@Override
		public Adapter caseStmt(Stmt object) {
			return createStmtAdapter();
		}

		@Override
		public Adapter caseSkip(Skip object) {
			return createSkipAdapter();
		}

		@Override
		public Adapter caseDeclaration(Declaration object) {
			return createDeclarationAdapter();
		}

		@Override
		public Adapter caseExpr(Expr object) {
			return createExprAdapter();
		}

		@Override
		public Adapter caseBlock(Block object) {
			return createBlockAdapter();
		}

		@Override
		public Adapter caseIf(If object) {
			return createIfAdapter();
		}

		@Override
		public Adapter caseWhile(While object) {
			return createWhileAdapter();
		}

		@Override
		public Adapter caseIntConst(IntConst object) {
			return createIntConstAdapter();
		}

		@Override
		public Adapter caseUnary(Unary object) {
			return createUnaryAdapter();
		}

		@Override
		public Adapter caseBinary(Binary object) {
			return createBinaryAdapter();
		}

		@Override
		public Adapter caseStore(Store object) {
			return createStoreAdapter();
		}

		@Override
		public Adapter caseStringToValueMap(Map.Entry<String, Value> object) {
			return createStringToValueMapAdapter();
		}

		@Override
		public Adapter caseValue(Value object) {
			return createValueAdapter();
		}

		@Override
		public Adapter caseIntValue(IntValue object) {
			return createIntValueAdapter();
		}

		@Override
		public Adapter caseBoolValue(BoolValue object) {
			return createBoolValueAdapter();
		}

		@Override
		public Adapter caseArrayValue(ArrayValue object) {
			return createArrayValueAdapter();
		}

		@Override
		public Adapter caseArrayDecl(ArrayDecl object) {
			return createArrayDeclAdapter();
		}

		@Override
		public Adapter caseBoolConst(BoolConst object) {
			return createBoolConstAdapter();
		}

		@Override
		public Adapter caseProgram(Program object) {
			return createProgramAdapter();
		}

		@Override
		public Adapter caseMethodDecl(MethodDecl object) {
			return createMethodDeclAdapter();
		}

		@Override
		public Adapter caseReturn(Return object) {
			return createReturnAdapter();
		}

		@Override
		public Adapter casePrint(Print object) {
			return createPrintAdapter();
		}

		@Override
		public Adapter caseStringConst(StringConst object) {
			return createStringConstAdapter();
		}

		@Override
		public Adapter caseStringValue(StringValue object) {
			return createStringValueAdapter();
		}

		@Override
		public Adapter caseParamDecl(ParamDecl object) {
			return createParamDeclAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseClass(imp.model.imp.Class object) {
			return createClassAdapter();
		}

		@Override
		public Adapter caseAttributeDecl(AttributeDecl object) {
			return createAttributeDeclAdapter();
		}

		@Override
		public Adapter caseThis(This object) {
			return createThisAdapter();
		}

		@Override
		public Adapter caseNewClass(NewClass object) {
			return createNewClassAdapter();
		}

		@Override
		public Adapter caseAssignment(Assignment object) {
			return createAssignmentAdapter();
		}

		@Override
		public Adapter caseProject(Project object) {
			return createProjectAdapter();
		}

		@Override
		public Adapter caseSymbol(Symbol object) {
			return createSymbolAdapter();
		}

		@Override
		public Adapter caseMember(Member object) {
			return createMemberAdapter();
		}

		@Override
		public Adapter caseVarRef(VarRef object) {
			return createVarRefAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Stmt <em>Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Stmt
	 * @generated
	 */
	public Adapter createStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Skip
	 * @generated
	 */
	public Adapter createSkipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Expr
	 * @generated
	 */
	public Adapter createExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.While
	 * @generated
	 */
	public Adapter createWhileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.IntConst <em>Int Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.IntConst
	 * @generated
	 */
	public Adapter createIntConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Unary <em>Unary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Unary
	 * @generated
	 */
	public Adapter createUnaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Binary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Binary
	 * @generated
	 */
	public Adapter createBinaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Store
	 * @generated
	 */
	public Adapter createStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Value Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToValueMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.IntValue
	 * @generated
	 */
	public Adapter createIntValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.BoolValue
	 * @generated
	 */
	public Adapter createBoolValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.ArrayValue <em>Array Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.ArrayValue
	 * @generated
	 */
	public Adapter createArrayValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.ArrayDecl <em>Array Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.ArrayDecl
	 * @generated
	 */
	public Adapter createArrayDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.BoolConst <em>Bool Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.BoolConst
	 * @generated
	 */
	public Adapter createBoolConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.MethodDecl <em>Method Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.MethodDecl
	 * @generated
	 */
	public Adapter createMethodDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Return
	 * @generated
	 */
	public Adapter createReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Print
	 * @generated
	 */
	public Adapter createPrintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.StringConst <em>String Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.StringConst
	 * @generated
	 */
	public Adapter createStringConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.StringValue
	 * @generated
	 */
	public Adapter createStringValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.ParamDecl <em>Param Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.ParamDecl
	 * @generated
	 */
	public Adapter createParamDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.AttributeDecl <em>Attribute Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.AttributeDecl
	 * @generated
	 */
	public Adapter createAttributeDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.This <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.This
	 * @generated
	 */
	public Adapter createThisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.NewClass <em>New Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.NewClass
	 * @generated
	 */
	public Adapter createNewClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Project
	 * @generated
	 */
	public Adapter createProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Symbol
	 * @generated
	 */
	public Adapter createSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.Member
	 * @generated
	 */
	public Adapter createMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link imp.model.imp.VarRef <em>Var Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see imp.model.imp.VarRef
	 * @generated
	 */
	public Adapter createVarRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ImpAdapterFactory
