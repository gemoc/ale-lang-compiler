/**
 */
package imp.model.imp.impl;

import imp.model.imp.ArrayDecl;
import imp.model.imp.ArrayValue;
import imp.model.imp.Assignment;
import imp.model.imp.AttributeDecl;
import imp.model.imp.Binary;
import imp.model.imp.BinaryOp;
import imp.model.imp.Block;
import imp.model.imp.BoolConst;
import imp.model.imp.BoolValue;
import imp.model.imp.Declaration;
import imp.model.imp.If;
import imp.model.imp.ImpFactory;
import imp.model.imp.ImpPackage;
import imp.model.imp.IntConst;
import imp.model.imp.IntValue;
import imp.model.imp.MethodDecl;
import imp.model.imp.NewClass;
import imp.model.imp.ParamDecl;
import imp.model.imp.Print;
import imp.model.imp.Program;
import imp.model.imp.Project;
import imp.model.imp.Return;
import imp.model.imp.Skip;
import imp.model.imp.Store;
import imp.model.imp.StringConst;
import imp.model.imp.StringValue;
import imp.model.imp.This;
import imp.model.imp.Unary;
import imp.model.imp.UnaryOp;
import imp.model.imp.Value;
import imp.model.imp.VarRef;
import imp.model.imp.While;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ImpFactoryImpl extends EFactoryImpl implements ImpFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImpFactory init() {
		try {
			ImpFactory theImpFactory = (ImpFactory) EPackage.Registry.INSTANCE.getEFactory(ImpPackage.eNS_URI);
			if (theImpFactory != null) {
				return theImpFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImpFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpFactoryImpl() {
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
		case ImpPackage.SKIP:
			return createSkip();
		case ImpPackage.DECLARATION:
			return createDeclaration();
		case ImpPackage.BLOCK:
			return createBlock();
		case ImpPackage.IF:
			return createIf();
		case ImpPackage.WHILE:
			return createWhile();
		case ImpPackage.INT_CONST:
			return createIntConst();
		case ImpPackage.UNARY:
			return createUnary();
		case ImpPackage.BINARY:
			return createBinary();
		case ImpPackage.STORE:
			return createStore();
		case ImpPackage.STRING_TO_VALUE_MAP:
			return (EObject) createStringToValueMap();
		case ImpPackage.INT_VALUE:
			return createIntValue();
		case ImpPackage.BOOL_VALUE:
			return createBoolValue();
		case ImpPackage.ARRAY_VALUE:
			return createArrayValue();
		case ImpPackage.ARRAY_DECL:
			return createArrayDecl();
		case ImpPackage.BOOL_CONST:
			return createBoolConst();
		case ImpPackage.PROGRAM:
			return createProgram();
		case ImpPackage.METHOD_DECL:
			return createMethodDecl();
		case ImpPackage.RETURN:
			return createReturn();
		case ImpPackage.PRINT:
			return createPrint();
		case ImpPackage.STRING_CONST:
			return createStringConst();
		case ImpPackage.STRING_VALUE:
			return createStringValue();
		case ImpPackage.PARAM_DECL:
			return createParamDecl();
		case ImpPackage.CLASS:
			return createClass();
		case ImpPackage.ATTRIBUTE_DECL:
			return createAttributeDecl();
		case ImpPackage.THIS:
			return createThis();
		case ImpPackage.NEW_CLASS:
			return createNewClass();
		case ImpPackage.ASSIGNMENT:
			return createAssignment();
		case ImpPackage.PROJECT:
			return createProject();
		case ImpPackage.VAR_REF:
			return createVarRef();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ImpPackage.UNARY_OP:
			return createUnaryOpFromString(eDataType, initialValue);
		case ImpPackage.BINARY_OP:
			return createBinaryOpFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ImpPackage.UNARY_OP:
			return convertUnaryOpToString(eDataType, instanceValue);
		case ImpPackage.BINARY_OP:
			return convertBinaryOpToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public Declaration createDeclaration() {
		DeclarationImpl declaration = new DeclarationImpl();
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
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
	public While createWhile() {
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntConst createIntConst() {
		IntConstImpl intConst = new IntConstImpl();
		return intConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unary createUnary() {
		UnaryImpl unary = new UnaryImpl();
		return unary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binary createBinary() {
		BinaryImpl binary = new BinaryImpl();
		return binary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Store createStore() {
		StoreImpl store = new StoreImpl();
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Value> createStringToValueMap() {
		StringToValueMapImpl stringToValueMap = new StringToValueMapImpl();
		return stringToValueMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntValue createIntValue() {
		IntValueImpl intValue = new IntValueImpl();
		return intValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolValue createBoolValue() {
		BoolValueImpl boolValue = new BoolValueImpl();
		return boolValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayValue createArrayValue() {
		ArrayValueImpl arrayValue = new ArrayValueImpl();
		return arrayValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayDecl createArrayDecl() {
		ArrayDeclImpl arrayDecl = new ArrayDeclImpl();
		return arrayDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolConst createBoolConst() {
		BoolConstImpl boolConst = new BoolConstImpl();
		return boolConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodDecl createMethodDecl() {
		MethodDeclImpl methodDecl = new MethodDeclImpl();
		return methodDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn() {
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Print createPrint() {
		PrintImpl print = new PrintImpl();
		return print;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringConst createStringConst() {
		StringConstImpl stringConst = new StringConstImpl();
		return stringConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValue createStringValue() {
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamDecl createParamDecl() {
		ParamDeclImpl paramDecl = new ParamDeclImpl();
		return paramDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public imp.model.imp.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDecl createAttributeDecl() {
		AttributeDeclImpl attributeDecl = new AttributeDeclImpl();
		return attributeDecl;
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
	public NewClass createNewClass() {
		NewClassImpl newClass = new NewClassImpl();
		return newClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
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
	public VarRef createVarRef() {
		VarRefImpl varRef = new VarRefImpl();
		return varRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOp createUnaryOpFromString(EDataType eDataType, String initialValue) {
		UnaryOp result = UnaryOp.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOp createBinaryOpFromString(EDataType eDataType, String initialValue) {
		BinaryOp result = BinaryOp.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryOpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpPackage getImpPackage() {
		return (ImpPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImpPackage getPackage() {
		return ImpPackage.eINSTANCE;
	}

} //ImpFactoryImpl
