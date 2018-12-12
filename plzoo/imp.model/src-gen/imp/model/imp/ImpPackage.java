/**
 */
package imp.model.imp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see imp.model.imp.ImpFactory
 * @model kind="package"
 * @generated
 */
public interface ImpPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "imp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/imp";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "imp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpPackage eINSTANCE = imp.model.imp.impl.ImpPackageImpl.init();

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.StmtImpl <em>Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.StmtImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getStmt()
	 * @generated
	 */
	int STMT = 0;

	/**
	 * The number of structural features of the '<em>Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STMT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STMT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.SkipImpl <em>Skip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.SkipImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getSkip()
	 * @generated
	 */
	int SKIP = 1;

	/**
	 * The number of structural features of the '<em>Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_FEATURE_COUNT = STMT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.DeclarationImpl <em>Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.DeclarationImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getDeclaration()
	 * @generated
	 */
	int DECLARATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__NAME = STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__EXP = STMT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__INDEX = STMT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_FEATURE_COUNT = STMT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ExprImpl <em>Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ExprImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getExpr()
	 * @generated
	 */
	int EXPR = 3;

	/**
	 * The number of structural features of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FEATURE_COUNT = STMT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.BlockImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 4;

	/**
	 * The feature id for the '<em><b>Stmts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__STMTS = STMT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.IfImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getIf()
	 * @generated
	 */
	int IF = 5;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__COND = STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__LHS = STMT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__RHS = STMT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = STMT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.WhileImpl <em>While</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.WhileImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getWhile()
	 * @generated
	 */
	int WHILE = 6;

	/**
	 * The feature id for the '<em><b>Cond</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__COND = STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__BODY = STMT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_FEATURE_COUNT = STMT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.IntConstImpl <em>Int Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.IntConstImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getIntConst()
	 * @generated
	 */
	int INT_CONST = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONST__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONST_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_CONST_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.UnaryImpl <em>Unary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.UnaryImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getUnary()
	 * @generated
	 */
	int UNARY = 8;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY__OP = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY__EXPR = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.BinaryImpl <em>Binary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.BinaryImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getBinary()
	 * @generated
	 */
	int BINARY = 9;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY__OP = EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.StoreImpl <em>Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.StoreImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getStore()
	 * @generated
	 */
	int STORE = 10;

	/**
	 * The feature id for the '<em><b>Values</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__VALUES = 0;

	/**
	 * The number of structural features of the '<em>Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.StringToValueMapImpl <em>String To Value Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.StringToValueMapImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getStringToValueMap()
	 * @generated
	 */
	int STRING_TO_VALUE_MAP = 11;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_VALUE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_VALUE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Value Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_VALUE_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Value Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_VALUE_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ValueImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 12;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.IntValueImpl <em>Int Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.IntValueImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getIntValue()
	 * @generated
	 */
	int INT_VALUE = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.BoolValueImpl <em>Bool Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.BoolValueImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getBoolValue()
	 * @generated
	 */
	int BOOL_VALUE = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ArrayValueImpl <em>Array Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ArrayValueImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getArrayValue()
	 * @generated
	 */
	int ARRAY_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_VALUE__VALUES = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ArrayDeclImpl <em>Array Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ArrayDeclImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getArrayDecl()
	 * @generated
	 */
	int ARRAY_DECL = 16;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DECL__VALUES = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DECL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DECL_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.BoolConstImpl <em>Bool Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.BoolConstImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getBoolConst()
	 * @generated
	 */
	int BOOL_CONST = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_CONST__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_CONST_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bool Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_CONST_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ProgramImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 18;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__METHODS = 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__CLASSES = 1;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.MemberImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 33;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.MethodDeclImpl <em>Method Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.MethodDeclImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getMethodDecl()
	 * @generated
	 */
	int METHOD_DECL = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECL__NAME = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stmt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECL__STMT = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECL__PARAMS = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECL_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Method Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECL_OPERATION_COUNT = MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ReturnImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 20;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__EXPR = STMT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.PrintImpl <em>Print</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.PrintImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getPrint()
	 * @generated
	 */
	int PRINT = 21;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__EXPR = STMT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Print</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.StringConstImpl <em>String Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.StringConstImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getStringConst()
	 * @generated
	 */
	int STRING_CONST = 22;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONST__VALUE = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONST_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CONST_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.StringValueImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 23;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.NamedElementImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 25;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.SymbolImpl <em>Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.SymbolImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getSymbol()
	 * @generated
	 */
	int SYMBOL = 32;

	/**
	 * The number of structural features of the '<em>Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ParamDeclImpl <em>Param Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ParamDeclImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getParamDecl()
	 * @generated
	 */
	int PARAM_DECL = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECL__NAME = SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Param Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECL_FEATURE_COUNT = SYMBOL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Param Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECL_OPERATION_COUNT = SYMBOL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ClassImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__METHODS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.AttributeDeclImpl <em>Attribute Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.AttributeDeclImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getAttributeDecl()
	 * @generated
	 */
	int ATTRIBUTE_DECL = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DECL__NAME = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DECL_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DECL_OPERATION_COUNT = MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ThisImpl <em>This</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ThisImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getThis()
	 * @generated
	 */
	int THIS = 28;

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
	 * The meta object id for the '{@link imp.model.imp.impl.NewClassImpl <em>New Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.NewClassImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getNewClass()
	 * @generated
	 */
	int NEW_CLASS = 29;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CLASS__CLASS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CLASS_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>New Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CLASS_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.AssignmentImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 30;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__LHS = STMT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__RHS = STMT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = STMT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.ProjectImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 31;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LHS = EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__RHS = EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ismethodcall</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ISMETHODCALL = EXPR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PARAMS = EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.impl.VarRefImpl <em>Var Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.impl.VarRefImpl
	 * @see imp.model.imp.impl.ImpPackageImpl#getVarRef()
	 * @generated
	 */
	int VAR_REF = 34;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_REF__REF = EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_REF_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Var Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_REF_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link imp.model.imp.UnaryOp <em>Unary Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.UnaryOp
	 * @see imp.model.imp.impl.ImpPackageImpl#getUnaryOp()
	 * @generated
	 */
	int UNARY_OP = 35;

	/**
	 * The meta object id for the '{@link imp.model.imp.BinaryOp <em>Binary Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see imp.model.imp.BinaryOp
	 * @see imp.model.imp.impl.ImpPackageImpl#getBinaryOp()
	 * @generated
	 */
	int BINARY_OP = 36;

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Stmt <em>Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stmt</em>'.
	 * @see imp.model.imp.Stmt
	 * @generated
	 */
	EClass getStmt();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip</em>'.
	 * @see imp.model.imp.Skip
	 * @generated
	 */
	EClass getSkip();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration</em>'.
	 * @see imp.model.imp.Declaration
	 * @generated
	 */
	EClass getDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.Declaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see imp.model.imp.Declaration#getName()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Declaration#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see imp.model.imp.Declaration#getExp()
	 * @see #getDeclaration()
	 * @generated
	 */
	EReference getDeclaration_Exp();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Declaration#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see imp.model.imp.Declaration#getIndex()
	 * @see #getDeclaration()
	 * @generated
	 */
	EReference getDeclaration_Index();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Expr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr</em>'.
	 * @see imp.model.imp.Expr
	 * @generated
	 */
	EClass getExpr();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see imp.model.imp.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.Block#getStmts <em>Stmts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stmts</em>'.
	 * @see imp.model.imp.Block#getStmts()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Stmts();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see imp.model.imp.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.If#getCond <em>Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond</em>'.
	 * @see imp.model.imp.If#getCond()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Cond();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.If#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see imp.model.imp.If#getLhs()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.If#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see imp.model.imp.If#getRhs()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Rhs();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While</em>'.
	 * @see imp.model.imp.While
	 * @generated
	 */
	EClass getWhile();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.While#getCond <em>Cond</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cond</em>'.
	 * @see imp.model.imp.While#getCond()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Cond();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.While#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see imp.model.imp.While#getBody()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Body();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.IntConst <em>Int Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Const</em>'.
	 * @see imp.model.imp.IntConst
	 * @generated
	 */
	EClass getIntConst();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.IntConst#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see imp.model.imp.IntConst#getValue()
	 * @see #getIntConst()
	 * @generated
	 */
	EAttribute getIntConst_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Unary <em>Unary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary</em>'.
	 * @see imp.model.imp.Unary
	 * @generated
	 */
	EClass getUnary();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.Unary#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see imp.model.imp.Unary#getOp()
	 * @see #getUnary()
	 * @generated
	 */
	EAttribute getUnary_Op();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Unary#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see imp.model.imp.Unary#getExpr()
	 * @see #getUnary()
	 * @generated
	 */
	EReference getUnary_Expr();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Binary <em>Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary</em>'.
	 * @see imp.model.imp.Binary
	 * @generated
	 */
	EClass getBinary();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Binary#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see imp.model.imp.Binary#getLhs()
	 * @see #getBinary()
	 * @generated
	 */
	EReference getBinary_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Binary#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see imp.model.imp.Binary#getRhs()
	 * @see #getBinary()
	 * @generated
	 */
	EReference getBinary_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.Binary#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see imp.model.imp.Binary#getOp()
	 * @see #getBinary()
	 * @generated
	 */
	EAttribute getBinary_Op();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Store</em>'.
	 * @see imp.model.imp.Store
	 * @generated
	 */
	EClass getStore();

	/**
	 * Returns the meta object for the map '{@link imp.model.imp.Store#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Values</em>'.
	 * @see imp.model.imp.Store#getValues()
	 * @see #getStore()
	 * @generated
	 */
	EReference getStore_Values();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Value Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Value Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="imp.model.imp.Value" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getStringToValueMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToValueMap()
	 * @generated
	 */
	EAttribute getStringToValueMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToValueMap()
	 * @generated
	 */
	EReference getStringToValueMap_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see imp.model.imp.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Value</em>'.
	 * @see imp.model.imp.IntValue
	 * @generated
	 */
	EClass getIntValue();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.IntValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see imp.model.imp.IntValue#getValue()
	 * @see #getIntValue()
	 * @generated
	 */
	EAttribute getIntValue_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Value</em>'.
	 * @see imp.model.imp.BoolValue
	 * @generated
	 */
	EClass getBoolValue();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.BoolValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see imp.model.imp.BoolValue#isValue()
	 * @see #getBoolValue()
	 * @generated
	 */
	EAttribute getBoolValue_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.ArrayValue <em>Array Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Value</em>'.
	 * @see imp.model.imp.ArrayValue
	 * @generated
	 */
	EClass getArrayValue();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.ArrayValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see imp.model.imp.ArrayValue#getValues()
	 * @see #getArrayValue()
	 * @generated
	 */
	EReference getArrayValue_Values();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.ArrayDecl <em>Array Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Decl</em>'.
	 * @see imp.model.imp.ArrayDecl
	 * @generated
	 */
	EClass getArrayDecl();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.ArrayDecl#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see imp.model.imp.ArrayDecl#getValues()
	 * @see #getArrayDecl()
	 * @generated
	 */
	EReference getArrayDecl_Values();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.BoolConst <em>Bool Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Const</em>'.
	 * @see imp.model.imp.BoolConst
	 * @generated
	 */
	EClass getBoolConst();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.BoolConst#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see imp.model.imp.BoolConst#isValue()
	 * @see #getBoolConst()
	 * @generated
	 */
	EAttribute getBoolConst_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see imp.model.imp.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.Program#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see imp.model.imp.Program#getMethods()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.Program#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see imp.model.imp.Program#getClasses()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Classes();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.MethodDecl <em>Method Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Decl</em>'.
	 * @see imp.model.imp.MethodDecl
	 * @generated
	 */
	EClass getMethodDecl();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.MethodDecl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see imp.model.imp.MethodDecl#getName()
	 * @see #getMethodDecl()
	 * @generated
	 */
	EAttribute getMethodDecl_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.MethodDecl#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see imp.model.imp.MethodDecl#getParams()
	 * @see #getMethodDecl()
	 * @generated
	 */
	EReference getMethodDecl_Params();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.MethodDecl#getStmt <em>Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stmt</em>'.
	 * @see imp.model.imp.MethodDecl#getStmt()
	 * @see #getMethodDecl()
	 * @generated
	 */
	EReference getMethodDecl_Stmt();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return</em>'.
	 * @see imp.model.imp.Return
	 * @generated
	 */
	EClass getReturn();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Return#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see imp.model.imp.Return#getExpr()
	 * @see #getReturn()
	 * @generated
	 */
	EReference getReturn_Expr();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print</em>'.
	 * @see imp.model.imp.Print
	 * @generated
	 */
	EClass getPrint();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Print#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see imp.model.imp.Print#getExpr()
	 * @see #getPrint()
	 * @generated
	 */
	EReference getPrint_Expr();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.StringConst <em>String Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Const</em>'.
	 * @see imp.model.imp.StringConst
	 * @generated
	 */
	EClass getStringConst();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.StringConst#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see imp.model.imp.StringConst#getValue()
	 * @see #getStringConst()
	 * @generated
	 */
	EAttribute getStringConst_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see imp.model.imp.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see imp.model.imp.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.ParamDecl <em>Param Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Decl</em>'.
	 * @see imp.model.imp.ParamDecl
	 * @generated
	 */
	EClass getParamDecl();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.ParamDecl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see imp.model.imp.ParamDecl#getName()
	 * @see #getParamDecl()
	 * @generated
	 */
	EAttribute getParamDecl_Name();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see imp.model.imp.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see imp.model.imp.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.Class#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see imp.model.imp.Class#getName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see imp.model.imp.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.Class#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see imp.model.imp.Class#getMethods()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Methods();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.AttributeDecl <em>Attribute Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Decl</em>'.
	 * @see imp.model.imp.AttributeDecl
	 * @generated
	 */
	EClass getAttributeDecl();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.AttributeDecl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see imp.model.imp.AttributeDecl#getName()
	 * @see #getAttributeDecl()
	 * @generated
	 */
	EAttribute getAttributeDecl_Name();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.This <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This</em>'.
	 * @see imp.model.imp.This
	 * @generated
	 */
	EClass getThis();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.NewClass <em>New Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Class</em>'.
	 * @see imp.model.imp.NewClass
	 * @generated
	 */
	EClass getNewClass();

	/**
	 * Returns the meta object for the reference '{@link imp.model.imp.NewClass#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see imp.model.imp.NewClass#getClass_()
	 * @see #getNewClass()
	 * @generated
	 */
	EReference getNewClass_Class();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see imp.model.imp.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Assignment#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see imp.model.imp.Assignment#getLhs()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Assignment#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see imp.model.imp.Assignment#getRhs()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Rhs();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see imp.model.imp.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the containment reference '{@link imp.model.imp.Project#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see imp.model.imp.Project#getLhs()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Lhs();

	/**
	 * Returns the meta object for the reference '{@link imp.model.imp.Project#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rhs</em>'.
	 * @see imp.model.imp.Project#getRhs()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Rhs();

	/**
	 * Returns the meta object for the attribute '{@link imp.model.imp.Project#isIsmethodcall <em>Ismethodcall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ismethodcall</em>'.
	 * @see imp.model.imp.Project#isIsmethodcall()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Ismethodcall();

	/**
	 * Returns the meta object for the containment reference list '{@link imp.model.imp.Project#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see imp.model.imp.Project#getParams()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Params();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol</em>'.
	 * @see imp.model.imp.Symbol
	 * @generated
	 */
	EClass getSymbol();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see imp.model.imp.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for class '{@link imp.model.imp.VarRef <em>Var Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Ref</em>'.
	 * @see imp.model.imp.VarRef
	 * @generated
	 */
	EClass getVarRef();

	/**
	 * Returns the meta object for the reference '{@link imp.model.imp.VarRef#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see imp.model.imp.VarRef#getRef()
	 * @see #getVarRef()
	 * @generated
	 */
	EReference getVarRef_Ref();

	/**
	 * Returns the meta object for enum '{@link imp.model.imp.UnaryOp <em>Unary Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Op</em>'.
	 * @see imp.model.imp.UnaryOp
	 * @generated
	 */
	EEnum getUnaryOp();

	/**
	 * Returns the meta object for enum '{@link imp.model.imp.BinaryOp <em>Binary Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Op</em>'.
	 * @see imp.model.imp.BinaryOp
	 * @generated
	 */
	EEnum getBinaryOp();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImpFactory getImpFactory();

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
		 * The meta object literal for the '{@link imp.model.imp.impl.StmtImpl <em>Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.StmtImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getStmt()
		 * @generated
		 */
		EClass STMT = eINSTANCE.getStmt();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.SkipImpl <em>Skip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.SkipImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getSkip()
		 * @generated
		 */
		EClass SKIP = eINSTANCE.getSkip();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.DeclarationImpl <em>Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.DeclarationImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getDeclaration()
		 * @generated
		 */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__NAME = eINSTANCE.getDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATION__EXP = eINSTANCE.getDeclaration_Exp();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATION__INDEX = eINSTANCE.getDeclaration_Index();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ExprImpl <em>Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ExprImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getExpr()
		 * @generated
		 */
		EClass EXPR = eINSTANCE.getExpr();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.BlockImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Stmts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__STMTS = eINSTANCE.getBlock_Stmts();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.IfImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getIf()
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
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__LHS = eINSTANCE.getIf_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__RHS = eINSTANCE.getIf_Rhs();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.WhileImpl <em>While</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.WhileImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getWhile()
		 * @generated
		 */
		EClass WHILE = eINSTANCE.getWhile();

		/**
		 * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__COND = eINSTANCE.getWhile_Cond();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__BODY = eINSTANCE.getWhile_Body();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.IntConstImpl <em>Int Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.IntConstImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getIntConst()
		 * @generated
		 */
		EClass INT_CONST = eINSTANCE.getIntConst();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_CONST__VALUE = eINSTANCE.getIntConst_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.UnaryImpl <em>Unary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.UnaryImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getUnary()
		 * @generated
		 */
		EClass UNARY = eINSTANCE.getUnary();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY__OP = eINSTANCE.getUnary_Op();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY__EXPR = eINSTANCE.getUnary_Expr();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.BinaryImpl <em>Binary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.BinaryImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getBinary()
		 * @generated
		 */
		EClass BINARY = eINSTANCE.getBinary();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY__LHS = eINSTANCE.getBinary_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY__RHS = eINSTANCE.getBinary_Rhs();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY__OP = eINSTANCE.getBinary_Op();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.StoreImpl <em>Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.StoreImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getStore()
		 * @generated
		 */
		EClass STORE = eINSTANCE.getStore();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORE__VALUES = eINSTANCE.getStore_Values();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.StringToValueMapImpl <em>String To Value Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.StringToValueMapImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getStringToValueMap()
		 * @generated
		 */
		EClass STRING_TO_VALUE_MAP = eINSTANCE.getStringToValueMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_VALUE_MAP__KEY = eINSTANCE.getStringToValueMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_VALUE_MAP__VALUE = eINSTANCE.getStringToValueMap_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ValueImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.IntValueImpl <em>Int Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.IntValueImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getIntValue()
		 * @generated
		 */
		EClass INT_VALUE = eINSTANCE.getIntValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_VALUE__VALUE = eINSTANCE.getIntValue_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.BoolValueImpl <em>Bool Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.BoolValueImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getBoolValue()
		 * @generated
		 */
		EClass BOOL_VALUE = eINSTANCE.getBoolValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_VALUE__VALUE = eINSTANCE.getBoolValue_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ArrayValueImpl <em>Array Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ArrayValueImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getArrayValue()
		 * @generated
		 */
		EClass ARRAY_VALUE = eINSTANCE.getArrayValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_VALUE__VALUES = eINSTANCE.getArrayValue_Values();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ArrayDeclImpl <em>Array Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ArrayDeclImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getArrayDecl()
		 * @generated
		 */
		EClass ARRAY_DECL = eINSTANCE.getArrayDecl();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_DECL__VALUES = eINSTANCE.getArrayDecl_Values();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.BoolConstImpl <em>Bool Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.BoolConstImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getBoolConst()
		 * @generated
		 */
		EClass BOOL_CONST = eINSTANCE.getBoolConst();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_CONST__VALUE = eINSTANCE.getBoolConst_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ProgramImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__METHODS = eINSTANCE.getProgram_Methods();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__CLASSES = eINSTANCE.getProgram_Classes();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.MethodDeclImpl <em>Method Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.MethodDeclImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getMethodDecl()
		 * @generated
		 */
		EClass METHOD_DECL = eINSTANCE.getMethodDecl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_DECL__NAME = eINSTANCE.getMethodDecl_Name();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_DECL__PARAMS = eINSTANCE.getMethodDecl_Params();

		/**
		 * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_DECL__STMT = eINSTANCE.getMethodDecl_Stmt();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ReturnImpl <em>Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ReturnImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getReturn()
		 * @generated
		 */
		EClass RETURN = eINSTANCE.getReturn();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN__EXPR = eINSTANCE.getReturn_Expr();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.PrintImpl <em>Print</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.PrintImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getPrint()
		 * @generated
		 */
		EClass PRINT = eINSTANCE.getPrint();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINT__EXPR = eINSTANCE.getPrint_Expr();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.StringConstImpl <em>String Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.StringConstImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getStringConst()
		 * @generated
		 */
		EClass STRING_CONST = eINSTANCE.getStringConst();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_CONST__VALUE = eINSTANCE.getStringConst_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.StringValueImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ParamDeclImpl <em>Param Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ParamDeclImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getParamDecl()
		 * @generated
		 */
		EClass PARAM_DECL = eINSTANCE.getParamDecl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_DECL__NAME = eINSTANCE.getParamDecl_Name();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.NamedElementImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ClassImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__NAME = eINSTANCE.getClass_Name();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__METHODS = eINSTANCE.getClass_Methods();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.AttributeDeclImpl <em>Attribute Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.AttributeDeclImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getAttributeDecl()
		 * @generated
		 */
		EClass ATTRIBUTE_DECL = eINSTANCE.getAttributeDecl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DECL__NAME = eINSTANCE.getAttributeDecl_Name();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ThisImpl <em>This</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ThisImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getThis()
		 * @generated
		 */
		EClass THIS = eINSTANCE.getThis();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.NewClassImpl <em>New Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.NewClassImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getNewClass()
		 * @generated
		 */
		EClass NEW_CLASS = eINSTANCE.getNewClass();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_CLASS__CLASS = eINSTANCE.getNewClass_Class();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.AssignmentImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__LHS = eINSTANCE.getAssignment_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__RHS = eINSTANCE.getAssignment_Rhs();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.ProjectImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__LHS = eINSTANCE.getProject_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__RHS = eINSTANCE.getProject_Rhs();

		/**
		 * The meta object literal for the '<em><b>Ismethodcall</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__ISMETHODCALL = eINSTANCE.getProject_Ismethodcall();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__PARAMS = eINSTANCE.getProject_Params();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.SymbolImpl <em>Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.SymbolImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getSymbol()
		 * @generated
		 */
		EClass SYMBOL = eINSTANCE.getSymbol();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.MemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.MemberImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '{@link imp.model.imp.impl.VarRefImpl <em>Var Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.impl.VarRefImpl
		 * @see imp.model.imp.impl.ImpPackageImpl#getVarRef()
		 * @generated
		 */
		EClass VAR_REF = eINSTANCE.getVarRef();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_REF__REF = eINSTANCE.getVarRef_Ref();

		/**
		 * The meta object literal for the '{@link imp.model.imp.UnaryOp <em>Unary Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.UnaryOp
		 * @see imp.model.imp.impl.ImpPackageImpl#getUnaryOp()
		 * @generated
		 */
		EEnum UNARY_OP = eINSTANCE.getUnaryOp();

		/**
		 * The meta object literal for the '{@link imp.model.imp.BinaryOp <em>Binary Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see imp.model.imp.BinaryOp
		 * @see imp.model.imp.impl.ImpPackageImpl#getBinaryOp()
		 * @generated
		 */
		EEnum BINARY_OP = eINSTANCE.getBinaryOp();

	}

} //ImpPackage
