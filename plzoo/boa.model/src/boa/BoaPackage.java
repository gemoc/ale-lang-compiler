/**
 */
package boa;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see boa.BoaFactory
 * @model kind="package"
 * @generated
 */
public interface BoaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "boa";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/boa";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "boa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BoaPackage eINSTANCE = boa.impl.BoaPackageImpl.init();

	/**
	 * The meta object id for the '{@link boa.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.FileImpl
	 * @see boa.impl.BoaPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 0;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__COMMANDS = 0;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boa.impl.TopLevelCmdImpl <em>Top Level Cmd</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.TopLevelCmdImpl
	 * @see boa.impl.BoaPackageImpl#getTopLevelCmd()
	 * @generated
	 */
	int TOP_LEVEL_CMD = 1;

	/**
	 * The number of structural features of the '<em>Top Level Cmd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CMD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Top Level Cmd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CMD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boa.impl.ExprImpl <em>Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ExprImpl
	 * @see boa.impl.BoaPackageImpl#getExpr()
	 * @generated
	 */
	int EXPR = 2;

	/**
	 * The number of structural features of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FEATURE_COUNT = TOP_LEVEL_CMD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_OPERATION_COUNT = TOP_LEVEL_CMD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.DefImpl <em>Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.DefImpl
	 * @see boa.impl.BoaPackageImpl#getDef()
	 * @generated
	 */
	int DEF = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF__NAME = TOP_LEVEL_CMD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF__EXPR = TOP_LEVEL_CMD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_FEATURE_COUNT = TOP_LEVEL_CMD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEF_OPERATION_COUNT = TOP_LEVEL_CMD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.AppImpl <em>App</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.AppImpl
	 * @see boa.impl.BoaPackageImpl#getApp()
	 * @generated
	 */
	int APP = 4;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>App</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.VarImpl <em>Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.VarImpl
	 * @see boa.impl.BoaPackageImpl#getVar()
	 * @generated
	 */
	int VAR = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__NAME = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ThisImpl <em>This</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ThisImpl
	 * @see boa.impl.BoaPackageImpl#getThis()
	 * @generated
	 */
	int THIS = 6;

	/**
	 * The number of structural features of the '<em>This</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>This</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.BoolImpl <em>Bool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.BoolImpl
	 * @see boa.impl.BoaPackageImpl#getBool()
	 * @generated
	 */
	int BOOL = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.IntImpl <em>Int</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.IntImpl
	 * @see boa.impl.BoaPackageImpl#getInt()
	 * @generated
	 */
	int INT = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.SkipImpl <em>Skip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.SkipImpl
	 * @see boa.impl.BoaPackageImpl#getSkip()
	 * @generated
	 */
	int SKIP = 9;

	/**
	 * The number of structural features of the '<em>Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ProjectImpl
	 * @see boa.impl.BoaPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 10;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__EXP = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.BObjectImpl <em>BObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.BObjectImpl
	 * @see boa.impl.BoaPackageImpl#getBObject()
	 * @generated
	 */
	int BOBJECT = 11;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOBJECT__FIELDS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOBJECT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>BObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOBJECT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.FieldImpl
	 * @see boa.impl.BoaPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boa.impl.CopyImpl <em>Copy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.CopyImpl
	 * @see boa.impl.BoaPackageImpl#getCopy()
	 * @generated
	 */
	int COPY = 13;

	/**
	 * The feature id for the '<em><b>Copy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY__COPY = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Copy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Copy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.WithImpl <em>With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.WithImpl
	 * @see boa.impl.BoaPackageImpl#getWith()
	 * @generated
	 */
	int WITH = 14;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ArithOpImpl <em>Arith Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ArithOpImpl
	 * @see boa.impl.BoaPackageImpl#getArithOp()
	 * @generated
	 */
	int ARITH_OP = 15;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Arith Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Arith Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.NotImpl
	 * @see boa.impl.BoaPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.CmpOpImpl <em>Cmp Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.CmpOpImpl
	 * @see boa.impl.BoaPackageImpl#getCmpOp()
	 * @generated
	 */
	int CMP_OP = 17;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cmp Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cmp Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.BoolOpImpl <em>Bool Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.BoolOpImpl
	 * @see boa.impl.BoaPackageImpl#getBoolOp()
	 * @generated
	 */
	int BOOL_OP = 18;

	/**
	 * The number of structural features of the '<em>Bool Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bool Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.IfImpl
	 * @see boa.impl.BoaPackageImpl#getIf()
	 * @generated
	 */
	int IF = 19;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__COND = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Thn</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__THN = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Els</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELS = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.LetImpl <em>Let</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.LetImpl
	 * @see boa.impl.BoaPackageImpl#getLet()
	 * @generated
	 */
	int LET = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__NAME = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__LHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__RHS = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Let</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Let</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.FunImpl <em>Fun</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.FunImpl
	 * @see boa.impl.BoaPackageImpl#getFun()
	 * @generated
	 */
	int FUN = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN__NAME = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN__BODY = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fun</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Fun</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUN_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.AssignImpl <em>Assign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.AssignImpl
	 * @see boa.impl.BoaPackageImpl#getAssign()
	 * @generated
	 */
	int ASSIGN = 22;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__NAME = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ArithOpPlusImpl <em>Arith Op Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ArithOpPlusImpl
	 * @see boa.impl.BoaPackageImpl#getArithOpPlus()
	 * @generated
	 */
	int ARITH_OP_PLUS = 23;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_PLUS__LHS = ARITH_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_PLUS__RHS = ARITH_OP__RHS;

	/**
	 * The number of structural features of the '<em>Arith Op Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_PLUS_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arith Op Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_PLUS_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ArithOpMinusImpl <em>Arith Op Minus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ArithOpMinusImpl
	 * @see boa.impl.BoaPackageImpl#getArithOpMinus()
	 * @generated
	 */
	int ARITH_OP_MINUS = 24;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_MINUS__LHS = ARITH_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_MINUS__RHS = ARITH_OP__RHS;

	/**
	 * The number of structural features of the '<em>Arith Op Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_MINUS_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arith Op Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_MINUS_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ArithOpTimesImpl <em>Arith Op Times</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ArithOpTimesImpl
	 * @see boa.impl.BoaPackageImpl#getArithOpTimes()
	 * @generated
	 */
	int ARITH_OP_TIMES = 25;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_TIMES__LHS = ARITH_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_TIMES__RHS = ARITH_OP__RHS;

	/**
	 * The number of structural features of the '<em>Arith Op Times</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_TIMES_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arith Op Times</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_TIMES_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ArithOpDivideImpl <em>Arith Op Divide</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ArithOpDivideImpl
	 * @see boa.impl.BoaPackageImpl#getArithOpDivide()
	 * @generated
	 */
	int ARITH_OP_DIVIDE = 26;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_DIVIDE__LHS = ARITH_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_DIVIDE__RHS = ARITH_OP__RHS;

	/**
	 * The number of structural features of the '<em>Arith Op Divide</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_DIVIDE_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arith Op Divide</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_DIVIDE_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.ArithOpRemainderImpl <em>Arith Op Remainder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.ArithOpRemainderImpl
	 * @see boa.impl.BoaPackageImpl#getArithOpRemainder()
	 * @generated
	 */
	int ARITH_OP_REMAINDER = 27;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_REMAINDER__LHS = ARITH_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_REMAINDER__RHS = ARITH_OP__RHS;

	/**
	 * The number of structural features of the '<em>Arith Op Remainder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_REMAINDER_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arith Op Remainder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_OP_REMAINDER_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.BoolOpAndImpl <em>Bool Op And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.BoolOpAndImpl
	 * @see boa.impl.BoaPackageImpl#getBoolOpAnd()
	 * @generated
	 */
	int BOOL_OP_AND = 28;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_AND__LHS = BOOL_OP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_AND__RHS = BOOL_OP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bool Op And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_AND_FEATURE_COUNT = BOOL_OP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bool Op And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_AND_OPERATION_COUNT = BOOL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.BoolOpOrImpl <em>Bool Op Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.BoolOpOrImpl
	 * @see boa.impl.BoaPackageImpl#getBoolOpOr()
	 * @generated
	 */
	int BOOL_OP_OR = 29;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_OR__LHS = BOOL_OP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_OR__RHS = BOOL_OP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bool Op Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_OR_FEATURE_COUNT = BOOL_OP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bool Op Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_OP_OR_OPERATION_COUNT = BOOL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.SeqImpl <em>Seq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.SeqImpl
	 * @see boa.impl.BoaPackageImpl#getSeq()
	 * @generated
	 */
	int SEQ = 30;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Seq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Seq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.CmpOpEqualImpl <em>Cmp Op Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.CmpOpEqualImpl
	 * @see boa.impl.BoaPackageImpl#getCmpOpEqual()
	 * @generated
	 */
	int CMP_OP_EQUAL = 31;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_EQUAL__LHS = CMP_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_EQUAL__RHS = CMP_OP__RHS;

	/**
	 * The number of structural features of the '<em>Cmp Op Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_EQUAL_FEATURE_COUNT = CMP_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cmp Op Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_EQUAL_OPERATION_COUNT = CMP_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.CmpOpUnequalImpl <em>Cmp Op Unequal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.CmpOpUnequalImpl
	 * @see boa.impl.BoaPackageImpl#getCmpOpUnequal()
	 * @generated
	 */
	int CMP_OP_UNEQUAL = 32;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_UNEQUAL__LHS = CMP_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_UNEQUAL__RHS = CMP_OP__RHS;

	/**
	 * The number of structural features of the '<em>Cmp Op Unequal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_UNEQUAL_FEATURE_COUNT = CMP_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cmp Op Unequal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_UNEQUAL_OPERATION_COUNT = CMP_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa.impl.CmpOpLessImpl <em>Cmp Op Less</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa.impl.CmpOpLessImpl
	 * @see boa.impl.BoaPackageImpl#getCmpOpLess()
	 * @generated
	 */
	int CMP_OP_LESS = 33;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_LESS__LHS = CMP_OP__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_LESS__RHS = CMP_OP__RHS;

	/**
	 * The number of structural features of the '<em>Cmp Op Less</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_LESS_FEATURE_COUNT = CMP_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cmp Op Less</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMP_OP_LESS_OPERATION_COUNT = CMP_OP_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link boa.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see boa.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the containment reference list '{@link boa.File#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see boa.File#getCommands()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_Commands();

	/**
	 * Returns the meta object for class '{@link boa.TopLevelCmd <em>Top Level Cmd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level Cmd</em>'.
	 * @see boa.TopLevelCmd
	 * @generated
	 */
	EClass getTopLevelCmd();

	/**
	 * Returns the meta object for class '{@link boa.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr</em>'.
	 * @see boa.Expr
	 * @generated
	 */
	EClass getExpr();

	/**
	 * Returns the meta object for class '{@link boa.Def <em>Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def</em>'.
	 * @see boa.Def
	 * @generated
	 */
	EClass getDef();

	/**
	 * Returns the meta object for the attribute '{@link boa.Def#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Def#getName()
	 * @see #getDef()
	 * @generated
	 */
	EAttribute getDef_Name();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Def#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see boa.Def#getExpr()
	 * @see #getDef()
	 * @generated
	 */
	EReference getDef_Expr();

	/**
	 * Returns the meta object for class '{@link boa.App <em>App</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App</em>'.
	 * @see boa.App
	 * @generated
	 */
	EClass getApp();

	/**
	 * Returns the meta object for the containment reference '{@link boa.App#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.App#getLhs()
	 * @see #getApp()
	 * @generated
	 */
	EReference getApp_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.App#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.App#getRhs()
	 * @see #getApp()
	 * @generated
	 */
	EReference getApp_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.Var <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var</em>'.
	 * @see boa.Var
	 * @generated
	 */
	EClass getVar();

	/**
	 * Returns the meta object for the attribute '{@link boa.Var#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Var#getName()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Name();

	/**
	 * Returns the meta object for class '{@link boa.This <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This</em>'.
	 * @see boa.This
	 * @generated
	 */
	EClass getThis();

	/**
	 * Returns the meta object for class '{@link boa.Bool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool</em>'.
	 * @see boa.Bool
	 * @generated
	 */
	EClass getBool();

	/**
	 * Returns the meta object for the attribute '{@link boa.Bool#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see boa.Bool#isValue()
	 * @see #getBool()
	 * @generated
	 */
	EAttribute getBool_Value();

	/**
	 * Returns the meta object for class '{@link boa.Int <em>Int</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int</em>'.
	 * @see boa.Int
	 * @generated
	 */
	EClass getInt();

	/**
	 * Returns the meta object for the attribute '{@link boa.Int#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see boa.Int#getValue()
	 * @see #getInt()
	 * @generated
	 */
	EAttribute getInt_Value();

	/**
	 * Returns the meta object for class '{@link boa.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip</em>'.
	 * @see boa.Skip
	 * @generated
	 */
	EClass getSkip();

	/**
	 * Returns the meta object for class '{@link boa.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see boa.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Project#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see boa.Project#getExp()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Exp();

	/**
	 * Returns the meta object for the attribute '{@link boa.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for class '{@link boa.BObject <em>BObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BObject</em>'.
	 * @see boa.BObject
	 * @generated
	 */
	EClass getBObject();

	/**
	 * Returns the meta object for the containment reference list '{@link boa.BObject#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see boa.BObject#getFields()
	 * @see #getBObject()
	 * @generated
	 */
	EReference getBObject_Fields();

	/**
	 * Returns the meta object for class '{@link boa.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see boa.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link boa.Field#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Field#getName()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Name();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Field#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see boa.Field#getValue()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_Value();

	/**
	 * Returns the meta object for class '{@link boa.Copy <em>Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copy</em>'.
	 * @see boa.Copy
	 * @generated
	 */
	EClass getCopy();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Copy#getCopy <em>Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Copy</em>'.
	 * @see boa.Copy#getCopy()
	 * @see #getCopy()
	 * @generated
	 */
	EReference getCopy_Copy();

	/**
	 * Returns the meta object for class '{@link boa.With <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With</em>'.
	 * @see boa.With
	 * @generated
	 */
	EClass getWith();

	/**
	 * Returns the meta object for the containment reference '{@link boa.With#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.With#getLhs()
	 * @see #getWith()
	 * @generated
	 */
	EReference getWith_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.With#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.With#getRhs()
	 * @see #getWith()
	 * @generated
	 */
	EReference getWith_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.ArithOp <em>Arith Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Op</em>'.
	 * @see boa.ArithOp
	 * @generated
	 */
	EClass getArithOp();

	/**
	 * Returns the meta object for the containment reference '{@link boa.ArithOp#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.ArithOp#getLhs()
	 * @see #getArithOp()
	 * @generated
	 */
	EReference getArithOp_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.ArithOp#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.ArithOp#getRhs()
	 * @see #getArithOp()
	 * @generated
	 */
	EReference getArithOp_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see boa.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Not#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see boa.Not#getValue()
	 * @see #getNot()
	 * @generated
	 */
	EReference getNot_Value();

	/**
	 * Returns the meta object for class '{@link boa.CmpOp <em>Cmp Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmp Op</em>'.
	 * @see boa.CmpOp
	 * @generated
	 */
	EClass getCmpOp();

	/**
	 * Returns the meta object for the containment reference '{@link boa.CmpOp#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.CmpOp#getLhs()
	 * @see #getCmpOp()
	 * @generated
	 */
	EReference getCmpOp_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.CmpOp#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.CmpOp#getRhs()
	 * @see #getCmpOp()
	 * @generated
	 */
	EReference getCmpOp_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.BoolOp <em>Bool Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Op</em>'.
	 * @see boa.BoolOp
	 * @generated
	 */
	EClass getBoolOp();

	/**
	 * Returns the meta object for class '{@link boa.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see boa.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference '{@link boa.If#getCond <em>Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond</em>'.
	 * @see boa.If#getCond()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Cond();

	/**
	 * Returns the meta object for the containment reference '{@link boa.If#getThn <em>Thn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thn</em>'.
	 * @see boa.If#getThn()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Thn();

	/**
	 * Returns the meta object for the containment reference '{@link boa.If#getEls <em>Els</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Els</em>'.
	 * @see boa.If#getEls()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Els();

	/**
	 * Returns the meta object for class '{@link boa.Let <em>Let</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let</em>'.
	 * @see boa.Let
	 * @generated
	 */
	EClass getLet();

	/**
	 * Returns the meta object for the attribute '{@link boa.Let#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Let#getName()
	 * @see #getLet()
	 * @generated
	 */
	EAttribute getLet_Name();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Let#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.Let#getLhs()
	 * @see #getLet()
	 * @generated
	 */
	EReference getLet_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Let#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.Let#getRhs()
	 * @see #getLet()
	 * @generated
	 */
	EReference getLet_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.Fun <em>Fun</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fun</em>'.
	 * @see boa.Fun
	 * @generated
	 */
	EClass getFun();

	/**
	 * Returns the meta object for the attribute '{@link boa.Fun#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Fun#getName()
	 * @see #getFun()
	 * @generated
	 */
	EAttribute getFun_Name();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Fun#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see boa.Fun#getBody()
	 * @see #getFun()
	 * @generated
	 */
	EReference getFun_Body();

	/**
	 * Returns the meta object for class '{@link boa.Assign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign</em>'.
	 * @see boa.Assign
	 * @generated
	 */
	EClass getAssign();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Assign#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.Assign#getLhs()
	 * @see #getAssign()
	 * @generated
	 */
	EReference getAssign_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Assign#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.Assign#getRhs()
	 * @see #getAssign()
	 * @generated
	 */
	EReference getAssign_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link boa.Assign#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa.Assign#getName()
	 * @see #getAssign()
	 * @generated
	 */
	EAttribute getAssign_Name();

	/**
	 * Returns the meta object for class '{@link boa.ArithOpPlus <em>Arith Op Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Op Plus</em>'.
	 * @see boa.ArithOpPlus
	 * @generated
	 */
	EClass getArithOpPlus();

	/**
	 * Returns the meta object for class '{@link boa.ArithOpMinus <em>Arith Op Minus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Op Minus</em>'.
	 * @see boa.ArithOpMinus
	 * @generated
	 */
	EClass getArithOpMinus();

	/**
	 * Returns the meta object for class '{@link boa.ArithOpTimes <em>Arith Op Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Op Times</em>'.
	 * @see boa.ArithOpTimes
	 * @generated
	 */
	EClass getArithOpTimes();

	/**
	 * Returns the meta object for class '{@link boa.ArithOpDivide <em>Arith Op Divide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Op Divide</em>'.
	 * @see boa.ArithOpDivide
	 * @generated
	 */
	EClass getArithOpDivide();

	/**
	 * Returns the meta object for class '{@link boa.ArithOpRemainder <em>Arith Op Remainder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Op Remainder</em>'.
	 * @see boa.ArithOpRemainder
	 * @generated
	 */
	EClass getArithOpRemainder();

	/**
	 * Returns the meta object for class '{@link boa.BoolOpAnd <em>Bool Op And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Op And</em>'.
	 * @see boa.BoolOpAnd
	 * @generated
	 */
	EClass getBoolOpAnd();

	/**
	 * Returns the meta object for the containment reference '{@link boa.BoolOpAnd#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.BoolOpAnd#getLhs()
	 * @see #getBoolOpAnd()
	 * @generated
	 */
	EReference getBoolOpAnd_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.BoolOpAnd#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.BoolOpAnd#getRhs()
	 * @see #getBoolOpAnd()
	 * @generated
	 */
	EReference getBoolOpAnd_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.BoolOpOr <em>Bool Op Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Op Or</em>'.
	 * @see boa.BoolOpOr
	 * @generated
	 */
	EClass getBoolOpOr();

	/**
	 * Returns the meta object for the containment reference '{@link boa.BoolOpOr#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.BoolOpOr#getLhs()
	 * @see #getBoolOpOr()
	 * @generated
	 */
	EReference getBoolOpOr_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.BoolOpOr#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.BoolOpOr#getRhs()
	 * @see #getBoolOpOr()
	 * @generated
	 */
	EReference getBoolOpOr_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.Seq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seq</em>'.
	 * @see boa.Seq
	 * @generated
	 */
	EClass getSeq();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Seq#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see boa.Seq#getLhs()
	 * @see #getSeq()
	 * @generated
	 */
	EReference getSeq_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link boa.Seq#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see boa.Seq#getRhs()
	 * @see #getSeq()
	 * @generated
	 */
	EReference getSeq_Rhs();

	/**
	 * Returns the meta object for class '{@link boa.CmpOpEqual <em>Cmp Op Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmp Op Equal</em>'.
	 * @see boa.CmpOpEqual
	 * @generated
	 */
	EClass getCmpOpEqual();

	/**
	 * Returns the meta object for class '{@link boa.CmpOpUnequal <em>Cmp Op Unequal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmp Op Unequal</em>'.
	 * @see boa.CmpOpUnequal
	 * @generated
	 */
	EClass getCmpOpUnequal();

	/**
	 * Returns the meta object for class '{@link boa.CmpOpLess <em>Cmp Op Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmp Op Less</em>'.
	 * @see boa.CmpOpLess
	 * @generated
	 */
	EClass getCmpOpLess();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BoaFactory getBoaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link boa.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.FileImpl
		 * @see boa.impl.BoaPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE__COMMANDS = eINSTANCE.getFile_Commands();

		/**
		 * The meta object literal for the '{@link boa.impl.TopLevelCmdImpl <em>Top Level Cmd</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.TopLevelCmdImpl
		 * @see boa.impl.BoaPackageImpl#getTopLevelCmd()
		 * @generated
		 */
		EClass TOP_LEVEL_CMD = eINSTANCE.getTopLevelCmd();

		/**
		 * The meta object literal for the '{@link boa.impl.ExprImpl <em>Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ExprImpl
		 * @see boa.impl.BoaPackageImpl#getExpr()
		 * @generated
		 */
		EClass EXPR = eINSTANCE.getExpr();

		/**
		 * The meta object literal for the '{@link boa.impl.DefImpl <em>Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.DefImpl
		 * @see boa.impl.BoaPackageImpl#getDef()
		 * @generated
		 */
		EClass DEF = eINSTANCE.getDef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEF__NAME = eINSTANCE.getDef_Name();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF__EXPR = eINSTANCE.getDef_Expr();

		/**
		 * The meta object literal for the '{@link boa.impl.AppImpl <em>App</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.AppImpl
		 * @see boa.impl.BoaPackageImpl#getApp()
		 * @generated
		 */
		EClass APP = eINSTANCE.getApp();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP__LHS = eINSTANCE.getApp_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP__RHS = eINSTANCE.getApp_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.VarImpl <em>Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.VarImpl
		 * @see boa.impl.BoaPackageImpl#getVar()
		 * @generated
		 */
		EClass VAR = eINSTANCE.getVar();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__NAME = eINSTANCE.getVar_Name();

		/**
		 * The meta object literal for the '{@link boa.impl.ThisImpl <em>This</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ThisImpl
		 * @see boa.impl.BoaPackageImpl#getThis()
		 * @generated
		 */
		EClass THIS = eINSTANCE.getThis();

		/**
		 * The meta object literal for the '{@link boa.impl.BoolImpl <em>Bool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.BoolImpl
		 * @see boa.impl.BoaPackageImpl#getBool()
		 * @generated
		 */
		EClass BOOL = eINSTANCE.getBool();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL__VALUE = eINSTANCE.getBool_Value();

		/**
		 * The meta object literal for the '{@link boa.impl.IntImpl <em>Int</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.IntImpl
		 * @see boa.impl.BoaPackageImpl#getInt()
		 * @generated
		 */
		EClass INT = eINSTANCE.getInt();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT__VALUE = eINSTANCE.getInt_Value();

		/**
		 * The meta object literal for the '{@link boa.impl.SkipImpl <em>Skip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.SkipImpl
		 * @see boa.impl.BoaPackageImpl#getSkip()
		 * @generated
		 */
		EClass SKIP = eINSTANCE.getSkip();

		/**
		 * The meta object literal for the '{@link boa.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ProjectImpl
		 * @see boa.impl.BoaPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__EXP = eINSTANCE.getProject_Exp();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '{@link boa.impl.BObjectImpl <em>BObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.BObjectImpl
		 * @see boa.impl.BoaPackageImpl#getBObject()
		 * @generated
		 */
		EClass BOBJECT = eINSTANCE.getBObject();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOBJECT__FIELDS = eINSTANCE.getBObject_Fields();

		/**
		 * The meta object literal for the '{@link boa.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.FieldImpl
		 * @see boa.impl.BoaPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__NAME = eINSTANCE.getField_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__VALUE = eINSTANCE.getField_Value();

		/**
		 * The meta object literal for the '{@link boa.impl.CopyImpl <em>Copy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.CopyImpl
		 * @see boa.impl.BoaPackageImpl#getCopy()
		 * @generated
		 */
		EClass COPY = eINSTANCE.getCopy();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COPY__COPY = eINSTANCE.getCopy_Copy();

		/**
		 * The meta object literal for the '{@link boa.impl.WithImpl <em>With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.WithImpl
		 * @see boa.impl.BoaPackageImpl#getWith()
		 * @generated
		 */
		EClass WITH = eINSTANCE.getWith();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH__LHS = eINSTANCE.getWith_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH__RHS = eINSTANCE.getWith_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.ArithOpImpl <em>Arith Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ArithOpImpl
		 * @see boa.impl.BoaPackageImpl#getArithOp()
		 * @generated
		 */
		EClass ARITH_OP = eINSTANCE.getArithOp();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITH_OP__LHS = eINSTANCE.getArithOp_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITH_OP__RHS = eINSTANCE.getArithOp_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.NotImpl
		 * @see boa.impl.BoaPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__VALUE = eINSTANCE.getNot_Value();

		/**
		 * The meta object literal for the '{@link boa.impl.CmpOpImpl <em>Cmp Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.CmpOpImpl
		 * @see boa.impl.BoaPackageImpl#getCmpOp()
		 * @generated
		 */
		EClass CMP_OP = eINSTANCE.getCmpOp();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CMP_OP__LHS = eINSTANCE.getCmpOp_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CMP_OP__RHS = eINSTANCE.getCmpOp_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.BoolOpImpl <em>Bool Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.BoolOpImpl
		 * @see boa.impl.BoaPackageImpl#getBoolOp()
		 * @generated
		 */
		EClass BOOL_OP = eINSTANCE.getBoolOp();

		/**
		 * The meta object literal for the '{@link boa.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.IfImpl
		 * @see boa.impl.BoaPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__COND = eINSTANCE.getIf_Cond();

		/**
		 * The meta object literal for the '<em><b>Thn</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__THN = eINSTANCE.getIf_Thn();

		/**
		 * The meta object literal for the '<em><b>Els</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELS = eINSTANCE.getIf_Els();

		/**
		 * The meta object literal for the '{@link boa.impl.LetImpl <em>Let</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.LetImpl
		 * @see boa.impl.BoaPackageImpl#getLet()
		 * @generated
		 */
		EClass LET = eINSTANCE.getLet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LET__NAME = eINSTANCE.getLet_Name();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET__LHS = eINSTANCE.getLet_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET__RHS = eINSTANCE.getLet_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.FunImpl <em>Fun</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.FunImpl
		 * @see boa.impl.BoaPackageImpl#getFun()
		 * @generated
		 */
		EClass FUN = eINSTANCE.getFun();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUN__NAME = eINSTANCE.getFun_Name();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUN__BODY = eINSTANCE.getFun_Body();

		/**
		 * The meta object literal for the '{@link boa.impl.AssignImpl <em>Assign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.AssignImpl
		 * @see boa.impl.BoaPackageImpl#getAssign()
		 * @generated
		 */
		EClass ASSIGN = eINSTANCE.getAssign();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__LHS = eINSTANCE.getAssign_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__RHS = eINSTANCE.getAssign_Rhs();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN__NAME = eINSTANCE.getAssign_Name();

		/**
		 * The meta object literal for the '{@link boa.impl.ArithOpPlusImpl <em>Arith Op Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ArithOpPlusImpl
		 * @see boa.impl.BoaPackageImpl#getArithOpPlus()
		 * @generated
		 */
		EClass ARITH_OP_PLUS = eINSTANCE.getArithOpPlus();

		/**
		 * The meta object literal for the '{@link boa.impl.ArithOpMinusImpl <em>Arith Op Minus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ArithOpMinusImpl
		 * @see boa.impl.BoaPackageImpl#getArithOpMinus()
		 * @generated
		 */
		EClass ARITH_OP_MINUS = eINSTANCE.getArithOpMinus();

		/**
		 * The meta object literal for the '{@link boa.impl.ArithOpTimesImpl <em>Arith Op Times</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ArithOpTimesImpl
		 * @see boa.impl.BoaPackageImpl#getArithOpTimes()
		 * @generated
		 */
		EClass ARITH_OP_TIMES = eINSTANCE.getArithOpTimes();

		/**
		 * The meta object literal for the '{@link boa.impl.ArithOpDivideImpl <em>Arith Op Divide</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ArithOpDivideImpl
		 * @see boa.impl.BoaPackageImpl#getArithOpDivide()
		 * @generated
		 */
		EClass ARITH_OP_DIVIDE = eINSTANCE.getArithOpDivide();

		/**
		 * The meta object literal for the '{@link boa.impl.ArithOpRemainderImpl <em>Arith Op Remainder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.ArithOpRemainderImpl
		 * @see boa.impl.BoaPackageImpl#getArithOpRemainder()
		 * @generated
		 */
		EClass ARITH_OP_REMAINDER = eINSTANCE.getArithOpRemainder();

		/**
		 * The meta object literal for the '{@link boa.impl.BoolOpAndImpl <em>Bool Op And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.BoolOpAndImpl
		 * @see boa.impl.BoaPackageImpl#getBoolOpAnd()
		 * @generated
		 */
		EClass BOOL_OP_AND = eINSTANCE.getBoolOpAnd();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_OP_AND__LHS = eINSTANCE.getBoolOpAnd_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_OP_AND__RHS = eINSTANCE.getBoolOpAnd_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.BoolOpOrImpl <em>Bool Op Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.BoolOpOrImpl
		 * @see boa.impl.BoaPackageImpl#getBoolOpOr()
		 * @generated
		 */
		EClass BOOL_OP_OR = eINSTANCE.getBoolOpOr();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_OP_OR__LHS = eINSTANCE.getBoolOpOr_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_OP_OR__RHS = eINSTANCE.getBoolOpOr_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.SeqImpl <em>Seq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.SeqImpl
		 * @see boa.impl.BoaPackageImpl#getSeq()
		 * @generated
		 */
		EClass SEQ = eINSTANCE.getSeq();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQ__LHS = eINSTANCE.getSeq_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQ__RHS = eINSTANCE.getSeq_Rhs();

		/**
		 * The meta object literal for the '{@link boa.impl.CmpOpEqualImpl <em>Cmp Op Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.CmpOpEqualImpl
		 * @see boa.impl.BoaPackageImpl#getCmpOpEqual()
		 * @generated
		 */
		EClass CMP_OP_EQUAL = eINSTANCE.getCmpOpEqual();

		/**
		 * The meta object literal for the '{@link boa.impl.CmpOpUnequalImpl <em>Cmp Op Unequal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.CmpOpUnequalImpl
		 * @see boa.impl.BoaPackageImpl#getCmpOpUnequal()
		 * @generated
		 */
		EClass CMP_OP_UNEQUAL = eINSTANCE.getCmpOpUnequal();

		/**
		 * The meta object literal for the '{@link boa.impl.CmpOpLessImpl <em>Cmp Op Less</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa.impl.CmpOpLessImpl
		 * @see boa.impl.BoaPackageImpl#getCmpOpLess()
		 * @generated
		 */
		EClass CMP_OP_LESS = eINSTANCE.getCmpOpLess();

	}

} //BoaPackage
