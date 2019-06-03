/**
 */
package org.tetrabox.minijava.dynamic.minijavadynamicdata.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MinijavadynamicdataFactoryImpl extends EFactoryImpl implements MinijavadynamicdataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MinijavadynamicdataFactory init() {
		try {
			MinijavadynamicdataFactory theMinijavadynamicdataFactory = (MinijavadynamicdataFactory)EPackage.Registry.INSTANCE.getEFactory(MinijavadynamicdataPackage.eNS_URI);
			if (theMinijavadynamicdataFactory != null) {
				return theMinijavadynamicdataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MinijavadynamicdataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinijavadynamicdataFactoryImpl() {
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
			case MinijavadynamicdataPackage.CONTEXT: return createContext();
			case MinijavadynamicdataPackage.VALUE: return createValue();
			case MinijavadynamicdataPackage.INTEGER_VALUE: return createIntegerValue();
			case MinijavadynamicdataPackage.SYMBOL_BINDING: return createSymbolBinding();
			case MinijavadynamicdataPackage.FIELD_BINDING: return createFieldBinding();
			case MinijavadynamicdataPackage.STRING_VALUE: return createStringValue();
			case MinijavadynamicdataPackage.BOOLEAN_VALUE: return createBooleanValue();
			case MinijavadynamicdataPackage.OUTPUT_STREAM: return createOutputStream();
			case MinijavadynamicdataPackage.STATE: return createState();
			case MinijavadynamicdataPackage.FRAME: return createFrame();
			case MinijavadynamicdataPackage.NULL_VALUE: return createNullValue();
			case MinijavadynamicdataPackage.NEW_CALL: return createNewCall();
			case MinijavadynamicdataPackage.METHOD_CALL2: return createMethodCall2();
			case MinijavadynamicdataPackage.OBJECT_INSTANCE: return createObjectInstance();
			case MinijavadynamicdataPackage.ARRAY_INSTANCE: return createArrayInstance();
			case MinijavadynamicdataPackage.OBJECT_REF_VALUE: return createObjectRefValue();
			case MinijavadynamicdataPackage.ARRAY_REF_VALUE: return createArrayRefValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerValue createIntegerValue() {
		IntegerValueImpl integerValue = new IntegerValueImpl();
		return integerValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolBinding createSymbolBinding() {
		SymbolBindingImpl symbolBinding = new SymbolBindingImpl();
		return symbolBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldBinding createFieldBinding() {
		FieldBindingImpl fieldBinding = new FieldBindingImpl();
		return fieldBinding;
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
	public BooleanValue createBooleanValue() {
		BooleanValueImpl booleanValue = new BooleanValueImpl();
		return booleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputStream createOutputStream() {
		OutputStreamImpl outputStream = new OutputStreamImpl();
		return outputStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Frame createFrame() {
		FrameImpl frame = new FrameImpl();
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullValue createNullValue() {
		NullValueImpl nullValue = new NullValueImpl();
		return nullValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewCall createNewCall() {
		NewCallImpl newCall = new NewCallImpl();
		return newCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodCall2 createMethodCall2() {
		MethodCall2Impl methodCall2 = new MethodCall2Impl();
		return methodCall2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectInstance createObjectInstance() {
		ObjectInstanceImpl objectInstance = new ObjectInstanceImpl();
		return objectInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayInstance createArrayInstance() {
		ArrayInstanceImpl arrayInstance = new ArrayInstanceImpl();
		return arrayInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectRefValue createObjectRefValue() {
		ObjectRefValueImpl objectRefValue = new ObjectRefValueImpl();
		return objectRefValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayRefValue createArrayRefValue() {
		ArrayRefValueImpl arrayRefValue = new ArrayRefValueImpl();
		return arrayRefValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinijavadynamicdataPackage getMinijavadynamicdataPackage() {
		return (MinijavadynamicdataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MinijavadynamicdataPackage getPackage() {
		return MinijavadynamicdataPackage.eINSTANCE;
	}

} //MinijavadynamicdataFactoryImpl
