/**
 */
package boa.impl;

import boa.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BoaFactoryImpl extends EFactoryImpl implements BoaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BoaFactory init() {
		try {
			BoaFactory theBoaFactory = (BoaFactory)EPackage.Registry.INSTANCE.getEFactory(BoaPackage.eNS_URI);
			if (theBoaFactory != null) {
				return theBoaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BoaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BoaPackage.FILE: return createFile();
			case BoaPackage.DEF: return createDef();
			case BoaPackage.APP: return createApp();
			case BoaPackage.VAR: return createVar();
			case BoaPackage.THIS: return createThis();
			case BoaPackage.BOOL: return createBool();
			case BoaPackage.INT: return createInt();
			case BoaPackage.SKIP: return createSkip();
			case BoaPackage.PROJECT: return createProject();
			case BoaPackage.BOBJECT: return createBObject();
			case BoaPackage.FIELD: return createField();
			case BoaPackage.COPY: return createCopy();
			case BoaPackage.WITH: return createWith();
			case BoaPackage.NOT: return createNot();
			case BoaPackage.IF: return createIf();
			case BoaPackage.LET: return createLet();
			case BoaPackage.FUN: return createFun();
			case BoaPackage.ASSIGN: return createAssign();
			case BoaPackage.ARITH_OP_PLUS: return createArithOpPlus();
			case BoaPackage.ARITH_OP_MINUS: return createArithOpMinus();
			case BoaPackage.ARITH_OP_TIMES: return createArithOpTimes();
			case BoaPackage.ARITH_OP_DIVIDE: return createArithOpDivide();
			case BoaPackage.ARITH_OP_REMAINDER: return createArithOpRemainder();
			case BoaPackage.BOOL_OP_AND: return createBoolOpAnd();
			case BoaPackage.BOOL_OP_OR: return createBoolOpOr();
			case BoaPackage.SEQ: return createSeq();
			case BoaPackage.CMP_OP_EQUAL: return createCmpOpEqual();
			case BoaPackage.CMP_OP_UNEQUAL: return createCmpOpUnequal();
			case BoaPackage.CMP_OP_LESS: return createCmpOpLess();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Def createDef() {
		DefImpl def = new DefImpl();
		return def;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public App createApp() {
		AppImpl app = new AppImpl();
		return app;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Var createVar() {
		VarImpl var = new VarImpl();
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public This createThis() {
		ThisImpl this_ = new ThisImpl();
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bool createBool() {
		BoolImpl bool = new BoolImpl();
		return bool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Int createInt() {
		IntImpl int_ = new IntImpl();
		return int_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Skip createSkip() {
		SkipImpl skip = new SkipImpl();
		return skip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BObject createBObject() {
		BObjectImpl bObject = new BObjectImpl();
		return bObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Copy createCopy() {
		CopyImpl copy = new CopyImpl();
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public With createWith() {
		WithImpl with = new WithImpl();
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Let createLet() {
		LetImpl let = new LetImpl();
		return let;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fun createFun() {
		FunImpl fun = new FunImpl();
		return fun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assign createAssign() {
		AssignImpl assign = new AssignImpl();
		return assign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithOpPlus createArithOpPlus() {
		ArithOpPlusImpl arithOpPlus = new ArithOpPlusImpl();
		return arithOpPlus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithOpMinus createArithOpMinus() {
		ArithOpMinusImpl arithOpMinus = new ArithOpMinusImpl();
		return arithOpMinus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithOpTimes createArithOpTimes() {
		ArithOpTimesImpl arithOpTimes = new ArithOpTimesImpl();
		return arithOpTimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithOpDivide createArithOpDivide() {
		ArithOpDivideImpl arithOpDivide = new ArithOpDivideImpl();
		return arithOpDivide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithOpRemainder createArithOpRemainder() {
		ArithOpRemainderImpl arithOpRemainder = new ArithOpRemainderImpl();
		return arithOpRemainder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolOpAnd createBoolOpAnd() {
		BoolOpAndImpl boolOpAnd = new BoolOpAndImpl();
		return boolOpAnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolOpOr createBoolOpOr() {
		BoolOpOrImpl boolOpOr = new BoolOpOrImpl();
		return boolOpOr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seq createSeq() {
		SeqImpl seq = new SeqImpl();
		return seq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmpOpEqual createCmpOpEqual() {
		CmpOpEqualImpl cmpOpEqual = new CmpOpEqualImpl();
		return cmpOpEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmpOpUnequal createCmpOpUnequal() {
		CmpOpUnequalImpl cmpOpUnequal = new CmpOpUnequalImpl();
		return cmpOpUnequal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmpOpLess createCmpOpLess() {
		CmpOpLessImpl cmpOpLess = new CmpOpLessImpl();
		return cmpOpLess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoaPackage getBoaPackage() {
		return (BoaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BoaPackage getPackage() {
		return BoaPackage.eINSTANCE;
	}

} //BoaFactoryImpl
