package org.eclipse.emf.ecoretools.ale.compiler.genmodel;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.compiler.AbstractNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.InterpreterCompilerUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.JavaPoetUtils;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EClassGetterCompiler {
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  @Extension
  private AbstractNamingUtils namingUtils;
  
  @Extension
  private InterpreterCompilerUtils icu;
  
  public EClassGetterCompiler(final AbstractNamingUtils namingUtils) {
    this.namingUtils = namingUtils;
    InterpreterCompilerUtils _interpreterCompilerUtils = new InterpreterCompilerUtils(namingUtils);
    this.icu = _interpreterCompilerUtils;
  }
  
  protected List<MethodSpec> _compileGetter(final EAttribute field, final TypeName fieldType, final String packageRoot, final EClass eClass, final Dsl dsl, final ClassName ePackageInterfaceType, final boolean isMapElement) {
    List<MethodSpec> _xblockexpression = null;
    {
      final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
      final EClassifier ert = field.getEGenericType().getERawType();
      final TypeName rt = this.icu.scopedInterfaceTypeRef(ert, packageRoot);
      List<MethodSpec> _xifexpression = null;
      if ((!isMultiple)) {
        List<MethodSpec> _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          {
            String _name = field.getEType().getName();
            boolean _equals = Objects.equal(_name, "EBoolean");
            if (_equals) {
              _builder.append("is");
            } else {
              _builder.append("get");
            }
          }
          String _firstUpper = StringExtensions.toFirstUpper(field.getName());
          _builder.append(_firstUpper);
          MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("return ");
          String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName);
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
          final MethodSpec getter = _returns.addCode(_builder_1.toString()).addModifiers(Modifier.PUBLIC).build();
          Pair<String, TypeName> _mappedTo = Pair.<String, TypeName>of("ft", fieldType);
          ClassName _get = ClassName.get(ENotificationImpl.class);
          Pair<String, ClassName> _mappedTo_1 = Pair.<String, ClassName>of("eni", _get);
          ClassName _get_1 = ClassName.get(Notification.class);
          Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("notif", _get_1);
          Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
          final HashMap<String, TypeName> hm = CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("set");
          String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
          _builder_2.append(_firstUpper_1);
          MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_2.toString());
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("new");
          String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
          _builder_3.append(_firstUpper_2);
          MethodSpec.Builder _addParameter = _methodBuilder.addParameter(fieldType, _builder_3.toString());
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("$ft:T ");
          String _normalizeVarOldName = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_4.append(_normalizeVarOldName);
          _builder_4.append(" = ");
          String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
          _builder_4.append(_normalizeVarName_1);
          _builder_4.append(";");
          _builder_4.newLineIfNotEmpty();
          {
            EClassifier _eType = field.getEType();
            if ((_eType instanceof EEnum)) {
              String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
              _builder_4.append(_normalizeVarName_2);
              _builder_4.append(" = ");
              String _normalizeVarNewName = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_4.append(_normalizeVarNewName);
              _builder_4.append(" == null ? ");
              String _upperCase = field.getName().toUpperCase();
              _builder_4.append(_upperCase);
              _builder_4.append("_EDEFAULT : ");
              String _normalizeVarNewName_1 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_4.append(_normalizeVarNewName_1);
              _builder_4.append(";");
              _builder_4.newLineIfNotEmpty();
            } else {
              String _normalizeVarName_3 = this.namingUtils.normalizeVarName(field.getName());
              _builder_4.append(_normalizeVarName_3);
              _builder_4.append(" = ");
              String _normalizeVarNewName_2 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_4.append(_normalizeVarNewName_2);
              _builder_4.append(";");
              _builder_4.newLineIfNotEmpty();
            }
          }
          _builder_4.append("if (eNotificationRequired())");
          _builder_4.newLine();
          _builder_4.append("\t");
          _builder_4.append("eNotify(new $eni:T(this, $notif:T.SET, $epit:T.");
          String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
          _builder_4.append(_normalizeUpperField, "\t");
          _builder_4.append(", old");
          String _firstUpper_3 = StringExtensions.toFirstUpper(field.getName());
          _builder_4.append(_firstUpper_3, "\t");
          _builder_4.append(", ");
          String _normalizeVarName_4 = this.namingUtils.normalizeVarName(field.getName());
          _builder_4.append(_normalizeVarName_4, "\t");
          _builder_4.append("));");
          _builder_4.newLineIfNotEmpty();
          final MethodSpec setter = _addParameter.addNamedCode(_builder_4.toString(), hm).addModifiers(Modifier.PUBLIC).build();
          _xblockexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter, setter));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        List<MethodSpec> _xblockexpression_2 = null;
        {
          ParameterizedTypeName _get = ParameterizedTypeName.get(ClassName.get(EDataTypeEList.class), rt.box());
          Pair<String, ParameterizedTypeName> _mappedTo = Pair.<String, ParameterizedTypeName>of("listtype", _get);
          Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("rt", rt);
          Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
          final HashMap<String, TypeName> hm = CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("get");
          String _firstUpper = StringExtensions.toFirstUpper(field.getName());
          _builder.append(_firstUpper);
          MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("if (");
          String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName);
          _builder_1.append(" == null) {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_1, "\t");
          _builder_1.append(" = new $listtype:T($rt:T.class, this, $epit:T.");
          String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
          _builder_1.append(_normalizeUpperField, "\t");
          _builder_1.append(");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("return ");
          String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_2);
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
          final MethodSpec getter = _returns.addNamedCode(_builder_1.toString(), hm).addModifiers(Modifier.PUBLIC).build();
          _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter));
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected List<MethodSpec> _compileGetter(final EReference field, final TypeName fieldType, final String packageRoot, final EClass eClass, final Dsl dsl, final ClassName ePackageInterfaceType, final boolean isMapElement) {
    List<MethodSpec> _xblockexpression = null;
    {
      final EClassifier ert = field.getEGenericType().getERawType();
      final TypeName rt = this.icu.scopedInterfaceTypeRef(ert, packageRoot);
      final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
      EReference _eOpposite = field.getEOpposite();
      final boolean existEOpposite = (_eOpposite != null);
      final boolean isOppositeMulti = (existEOpposite && ((field.getEOpposite().getUpperBound() > 1) || (field.getEOpposite().getUpperBound() < 0)));
      final boolean isContainment = field.isContainment();
      final boolean isOppositeContainment = (existEOpposite && field.getEOpposite().isContainment());
      List<MethodSpec> _xifexpression = null;
      if ((((existEOpposite && (!isMultiple)) && (!isContainment)) && (!isOppositeContainment))) {
        List<MethodSpec> _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("get");
          String _firstUpper = StringExtensions.toFirstUpper(field.getName());
          _builder.append(_firstUpper);
          MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(rt);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("if (");
          String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName);
          _builder_1.append(" != null && ");
          String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_1);
          _builder_1.append(".eIsProxy()) {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("$ieo:T ");
          String _normalizeVarOldName = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_1.append(_normalizeVarOldName, "\t");
          _builder_1.append(" = ($ieo:T) ");
          String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_2, "\t");
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          String _normalizeVarName_3 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_3, "\t");
          _builder_1.append(" = ($fieldType:T) eResolveProxy(");
          String _normalizeVarOldName_1 = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_1.append(_normalizeVarOldName_1, "\t");
          _builder_1.append(");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("if (");
          String _normalizeVarName_4 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_4, "\t");
          _builder_1.append(" != ");
          String _normalizeVarOldName_2 = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_1.append(_normalizeVarOldName_2, "\t");
          _builder_1.append(") {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t");
          _builder_1.append("if (eNotificationRequired())");
          _builder_1.newLine();
          _builder_1.append("\t\t\t");
          _builder_1.append("eNotify(new $eni:T(this, $notif:T.RESOLVE, $epit:T.");
          String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
          _builder_1.append(_normalizeUpperField, "\t\t\t");
          _builder_1.append(", ");
          String _normalizeVarOldName_3 = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_1.append(_normalizeVarOldName_3, "\t\t\t");
          _builder_1.append(", ");
          String _normalizeVarName_5 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_5, "\t\t\t");
          _builder_1.append("));");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("return ");
          String _normalizeVarName_6 = this.namingUtils.normalizeVarName(field.getName());
          _builder_1.append(_normalizeVarName_6);
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
          ClassName _get = ClassName.get(InternalEObject.class);
          Pair<String, ClassName> _mappedTo = Pair.<String, ClassName>of("ieo", _get);
          Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("fieldType", rt);
          ClassName _get_1 = ClassName.get(ENotificationImpl.class);
          Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("eni", _get_1);
          ClassName _get_2 = ClassName.get(Notification.class);
          Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("notif", _get_2);
          Pair<String, ClassName> _mappedTo_4 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
          final MethodSpec getter = _returns.addNamedCode(_builder_1.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4)).addModifiers(Modifier.PUBLIC).build();
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("basicGet");
          String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
          _builder_2.append(_firstUpper_1);
          MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_2.toString()).returns(rt);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("return ");
          String _normalizeVarName_7 = this.namingUtils.normalizeVarName(field.getName());
          _builder_3.append(_normalizeVarName_7);
          _builder_3.append(";");
          _builder_3.newLineIfNotEmpty();
          final MethodSpec basicGetter = _returns_1.addCode(_builder_3.toString()).addModifiers(Modifier.PUBLIC).build();
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("basicSet");
          String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
          _builder_4.append(_firstUpper_2);
          MethodSpec.Builder _returns_2 = MethodSpec.methodBuilder(_builder_4.toString()).returns(
            NotificationChain.class);
          StringConcatenation _builder_5 = new StringConcatenation();
          String _normalizeVarNewName = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_5.append(_normalizeVarNewName);
          MethodSpec.Builder _addModifiers = _returns_2.addParameter(rt, _builder_5.toString()).addParameter(NotificationChain.class, 
            "msgs").addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("$fieldType:T ");
          String _normalizeVarOldName_4 = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_6.append(_normalizeVarOldName_4);
          _builder_6.append(" = ");
          String _normalizeVarName_8 = this.namingUtils.normalizeVarName(field.getName());
          _builder_6.append(_normalizeVarName_8);
          _builder_6.append(";");
          _builder_6.newLineIfNotEmpty();
          String _normalizeVarName_9 = this.namingUtils.normalizeVarName(field.getName());
          _builder_6.append(_normalizeVarName_9);
          _builder_6.append(" = ");
          String _normalizeVarNewName_1 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_6.append(_normalizeVarNewName_1);
          _builder_6.append(";");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("if (eNotificationRequired()) {");
          _builder_6.newLine();
          _builder_6.append("\t");
          _builder_6.append("$eni:T notification = new $eni:T(this, $notif:T.SET, $epit:T.");
          String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
          _builder_6.append(_normalizeUpperField_1, "\t");
          _builder_6.append(", ");
          String _normalizeVarOldName_5 = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_6.append(_normalizeVarOldName_5, "\t");
          _builder_6.append(", ");
          String _normalizeVarNewName_2 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_6.append(_normalizeVarNewName_2, "\t");
          _builder_6.append(");");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t");
          _builder_6.append("if (msgs == null)");
          _builder_6.newLine();
          _builder_6.append("\t\t");
          _builder_6.append("msgs = notification;");
          _builder_6.newLine();
          _builder_6.append("\t");
          _builder_6.append("else");
          _builder_6.newLine();
          _builder_6.append("\t\t");
          _builder_6.append("msgs.add(notification);");
          _builder_6.newLine();
          _builder_6.append("}");
          _builder_6.newLine();
          _builder_6.append("return msgs;");
          _builder_6.newLine();
          Pair<String, TypeName> _mappedTo_5 = Pair.<String, TypeName>of("fieldType", rt);
          ClassName _get_3 = ClassName.get(ENotificationImpl.class);
          Pair<String, ClassName> _mappedTo_6 = Pair.<String, ClassName>of("eni", _get_3);
          ClassName _get_4 = ClassName.get(Notification.class);
          Pair<String, ClassName> _mappedTo_7 = Pair.<String, ClassName>of("notif", _get_4);
          Pair<String, ClassName> _mappedTo_8 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
          final MethodSpec basicSetter = _addModifiers.addNamedCode(_builder_6.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8)).build();
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("set");
          String _firstUpper_3 = StringExtensions.toFirstUpper(field.getName());
          _builder_7.append(_firstUpper_3);
          MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_7.toString());
          StringConcatenation _builder_8 = new StringConcatenation();
          String _normalizeVarNewName_3 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_8.append(_normalizeVarNewName_3);
          MethodSpec.Builder _addParameter = _methodBuilder.addParameter(rt, _builder_8.toString());
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("if (");
          String _normalizeVarNewName_4 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_9.append(_normalizeVarNewName_4);
          _builder_9.append(" != ");
          String _normalizeVarName_10 = this.namingUtils.normalizeVarName(field.getName());
          _builder_9.append(_normalizeVarName_10);
          _builder_9.append(") {");
          _builder_9.newLineIfNotEmpty();
          _builder_9.append("\t");
          _builder_9.append("$nc:T msgs = null;");
          _builder_9.newLine();
          _builder_9.append("\t");
          _builder_9.append("if (");
          String _normalizeVarName_11 = this.namingUtils.normalizeVarName(field.getName());
          _builder_9.append(_normalizeVarName_11, "\t");
          _builder_9.append(" != null)");
          _builder_9.newLineIfNotEmpty();
          _builder_9.append("\t\t");
          _builder_9.append("msgs = (($ieo:T) ");
          String _normalizeVarName_12 = this.namingUtils.normalizeVarName(field.getName());
          _builder_9.append(_normalizeVarName_12, "\t\t");
          _builder_9.append(").eInverseRemove(this, $epit:T.");
          String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
          _builder_9.append(_normalizeUpperField_2, "\t\t");
          _builder_9.append(", $fieldType:T.class, msgs);");
          _builder_9.newLineIfNotEmpty();
          _builder_9.append("\t");
          _builder_9.append("if (");
          String _normalizeVarNewName_5 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_9.append(_normalizeVarNewName_5, "\t");
          _builder_9.append(" != null)");
          _builder_9.newLineIfNotEmpty();
          _builder_9.append("\t\t");
          _builder_9.append("msgs = (($ieo:T) ");
          String _normalizeVarNewName_6 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_9.append(_normalizeVarNewName_6, "\t\t");
          _builder_9.append(").eInverseAdd(this, $epit:T.");
          String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
          _builder_9.append(_normalizeUpperField_3, "\t\t");
          _builder_9.append(", $fieldType:T.class, msgs);");
          _builder_9.newLineIfNotEmpty();
          _builder_9.append("\t");
          _builder_9.append("msgs = basicSet");
          String _firstUpper_4 = StringExtensions.toFirstUpper(field.getName());
          _builder_9.append(_firstUpper_4, "\t");
          _builder_9.append("(");
          String _normalizeVarNewName_7 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_9.append(_normalizeVarNewName_7, "\t");
          _builder_9.append(", msgs);");
          _builder_9.newLineIfNotEmpty();
          _builder_9.append("\t");
          _builder_9.append("if (msgs != null)");
          _builder_9.newLine();
          _builder_9.append("\t\t");
          _builder_9.append("msgs.dispatch();");
          _builder_9.newLine();
          _builder_9.append("} else if (eNotificationRequired())");
          _builder_9.newLine();
          _builder_9.append("\t");
          _builder_9.append("eNotify(new $eni:T(this, $notif:T.SET, $epit:T.");
          String _normalizeUpperField_4 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
          _builder_9.append(_normalizeUpperField_4, "\t");
          _builder_9.append(", ");
          String _normalizeVarNewName_8 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_9.append(_normalizeVarNewName_8, "\t");
          _builder_9.append(", ");
          String _normalizeVarNewName_9 = this.namingUtils.normalizeVarNewName(field.getName());
          _builder_9.append(_normalizeVarNewName_9, "\t");
          _builder_9.append("));");
          _builder_9.newLineIfNotEmpty();
          ClassName _get_5 = ClassName.get(NotificationChain.class);
          Pair<String, ClassName> _mappedTo_9 = Pair.<String, ClassName>of("nc", _get_5);
          ClassName _get_6 = ClassName.get(InternalEObject.class);
          Pair<String, ClassName> _mappedTo_10 = Pair.<String, ClassName>of("ieo", _get_6);
          Pair<String, ClassName> _mappedTo_11 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
          Pair<String, TypeName> _mappedTo_12 = Pair.<String, TypeName>of("fieldType", rt);
          ClassName _get_7 = ClassName.get(ENotificationImpl.class);
          Pair<String, ClassName> _mappedTo_13 = Pair.<String, ClassName>of("eni", _get_7);
          ClassName _get_8 = ClassName.get(Notification.class);
          Pair<String, ClassName> _mappedTo_14 = Pair.<String, ClassName>of("notif", _get_8);
          final MethodSpec setter = _addParameter.addNamedCode(_builder_9.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo_9, _mappedTo_10, _mappedTo_11, _mappedTo_12, _mappedTo_13, _mappedTo_14)).addModifiers(Modifier.PUBLIC).build();
          _xblockexpression_1 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter, basicGetter, basicSetter, setter));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        List<MethodSpec> _xifexpression_1 = null;
        if ((((existEOpposite && (!isMultiple)) && (!isContainment)) && isOppositeContainment)) {
          List<MethodSpec> _xblockexpression_2 = null;
          {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("get");
            String _firstUpper = StringExtensions.toFirstUpper(field.getName());
            _builder.append(_firstUpper);
            MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(rt);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("if (eContainerFeatureID() != $epit:T.");
            String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_1.append(_normalizeUpperField);
            _builder_1.append(")");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            _builder_1.append("return null;");
            _builder_1.newLine();
            _builder_1.append("return ($fieldType:T) eInternalContainer();");
            _builder_1.newLine();
            Pair<String, TypeName> _mappedTo = Pair.<String, TypeName>of("fieldType", rt);
            Pair<String, ClassName> _mappedTo_1 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
            final MethodSpec getter = _returns.addNamedCode(_builder_1.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1)).addModifiers(Modifier.PUBLIC).build();
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("basicSet");
            String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
            _builder_2.append(_firstUpper_1);
            MethodSpec.Builder _addParameter = MethodSpec.methodBuilder(_builder_2.toString()).returns(NotificationChain.class).addParameter(rt, this.namingUtils.normalizeVarNewName(field.getName())).addParameter(NotificationChain.class, "msgs");
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("msgs = eBasicSetContainer(($ieo:T) ");
            String _normalizeVarNewName = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_3.append(_normalizeVarNewName);
            _builder_3.append(", $epit:T.");
            String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_3.append(_normalizeUpperField_1);
            _builder_3.append(", msgs);");
            _builder_3.newLineIfNotEmpty();
            _builder_3.append("return msgs;");
            _builder_3.newLine();
            Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
            ClassName _get = ClassName.get(InternalEObject.class);
            Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("ieo", _get);
            final MethodSpec basicSetter = _addParameter.addNamedCode(_builder_3.toString(), CollectionLiterals.<String, ClassName>newHashMap(_mappedTo_2, _mappedTo_3)).addModifiers(Modifier.PUBLIC).build();
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("set");
            String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
            _builder_4.append(_firstUpper_2);
            MethodSpec.Builder _addParameter_1 = MethodSpec.methodBuilder(_builder_4.toString()).addParameter(rt, this.namingUtils.normalizeVarNewName(field.getName()));
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("if (");
            String _normalizeVarNewName_1 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_1);
            _builder_5.append(" != eInternalContainer() || (eContainerFeatureID() != $epit:T.");
            String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_5.append(_normalizeUpperField_2);
            _builder_5.append(" && ");
            String _normalizeVarNewName_2 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_2);
            _builder_5.append(" != null)) {");
            _builder_5.newLineIfNotEmpty();
            _builder_5.append("\t");
            _builder_5.append("if ($eu:T.isAncestor(this, ");
            String _normalizeVarNewName_3 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_3, "\t");
            _builder_5.append("))");
            _builder_5.newLineIfNotEmpty();
            _builder_5.append("\t\t");
            _builder_5.append("throw new $iae:T(\"Recursive containment not allowed for \" + toString());");
            _builder_5.newLine();
            _builder_5.append("\t");
            _builder_5.append("$nc:T msgs = null;");
            _builder_5.newLine();
            _builder_5.append("\t");
            _builder_5.append("if (eInternalContainer() != null)");
            _builder_5.newLine();
            _builder_5.append("\t\t");
            _builder_5.append("msgs = eBasicRemoveFromContainer(msgs);");
            _builder_5.newLine();
            _builder_5.append("\t");
            _builder_5.append("if (");
            String _normalizeVarNewName_4 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_4, "\t");
            _builder_5.append(" != null)");
            _builder_5.newLineIfNotEmpty();
            _builder_5.append("\t\t");
            _builder_5.append("msgs = (($ieo:T) ");
            String _normalizeVarNewName_5 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_5, "\t\t");
            _builder_5.append(").eInverseAdd(this, $epit:T.");
            String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
            _builder_5.append(_normalizeUpperField_3, "\t\t");
            _builder_5.append(", $fieldType:T.class, msgs);");
            _builder_5.newLineIfNotEmpty();
            _builder_5.append("\t");
            _builder_5.append("msgs = basicSet");
            String _firstUpper_3 = StringExtensions.toFirstUpper(field.getName());
            _builder_5.append(_firstUpper_3, "\t");
            _builder_5.append("(");
            String _normalizeVarNewName_6 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_6, "\t");
            _builder_5.append(", msgs);");
            _builder_5.newLineIfNotEmpty();
            _builder_5.append("\t");
            _builder_5.append("if (msgs != null)");
            _builder_5.newLine();
            _builder_5.append("\t\t");
            _builder_5.append("msgs.dispatch();");
            _builder_5.newLine();
            _builder_5.append("} else if (eNotificationRequired())");
            _builder_5.newLine();
            _builder_5.append("\t");
            _builder_5.append("eNotify(new $eni:T(this, $notif:T.SET, $epit:T.");
            String _normalizeUpperField_4 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_5.append(_normalizeUpperField_4, "\t");
            _builder_5.append(", ");
            String _normalizeVarNewName_7 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_7, "\t");
            _builder_5.append(", ");
            String _normalizeVarNewName_8 = this.namingUtils.normalizeVarNewName(field.getName());
            _builder_5.append(_normalizeVarNewName_8, "\t");
            _builder_5.append("));");
            _builder_5.newLineIfNotEmpty();
            Pair<String, ClassName> _mappedTo_4 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
            ClassName _get_1 = ClassName.get(EcoreUtil.class);
            Pair<String, ClassName> _mappedTo_5 = Pair.<String, ClassName>of("eu", _get_1);
            ClassName _get_2 = ClassName.get(IllegalArgumentException.class);
            Pair<String, ClassName> _mappedTo_6 = Pair.<String, ClassName>of("iae", _get_2);
            ClassName _get_3 = ClassName.get(NotificationChain.class);
            Pair<String, ClassName> _mappedTo_7 = Pair.<String, ClassName>of("nc", _get_3);
            ClassName _get_4 = ClassName.get(InternalEObject.class);
            Pair<String, ClassName> _mappedTo_8 = Pair.<String, ClassName>of("ieo", _get_4);
            Pair<String, TypeName> _mappedTo_9 = Pair.<String, TypeName>of("fieldType", rt);
            ClassName _get_5 = ClassName.get(ENotificationImpl.class);
            Pair<String, ClassName> _mappedTo_10 = Pair.<String, ClassName>of("eni", _get_5);
            ClassName _get_6 = ClassName.get(Notification.class);
            Pair<String, ClassName> _mappedTo_11 = Pair.<String, ClassName>of("notif", _get_6);
            final MethodSpec setter = _addParameter_1.addNamedCode(_builder_5.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10, _mappedTo_11)).addModifiers(Modifier.PUBLIC).build();
            _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter, basicSetter, setter));
          }
          _xifexpression_1 = _xblockexpression_2;
        } else {
          List<MethodSpec> _xifexpression_2 = null;
          if ((((existEOpposite && (!isMultiple)) && isContainment) && (!isOppositeContainment))) {
            List<MethodSpec> _xblockexpression_3 = null;
            {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("get");
              String _firstUpper = StringExtensions.toFirstUpper(field.getName());
              _builder.append(_firstUpper);
              MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(rt);
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("return ");
              String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
              _builder_1.append(_normalizeVarName);
              _builder_1.append(";");
              _builder_1.newLineIfNotEmpty();
              final MethodSpec getter = _returns.addCode(_builder_1.toString()).addModifiers(Modifier.PUBLIC).build();
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("basicSet");
              String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
              _builder_2.append(_firstUpper_1);
              MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_2.toString()).returns(
                NotificationChain.class);
              StringConcatenation _builder_3 = new StringConcatenation();
              String _normalizeVarNewName = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_3.append(_normalizeVarNewName);
              MethodSpec.Builder _addModifiers = _returns_1.addParameter(rt, _builder_3.toString()).addParameter(NotificationChain.class, 
                "msgs").addModifiers(Modifier.PUBLIC);
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("$fieldType:T ");
              String _normalizeVarOldName = this.namingUtils.normalizeVarOldName(field.getName());
              _builder_4.append(_normalizeVarOldName);
              _builder_4.append(" = ");
              String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
              _builder_4.append(_normalizeVarName_1);
              _builder_4.append(";");
              _builder_4.newLineIfNotEmpty();
              String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
              _builder_4.append(_normalizeVarName_2);
              _builder_4.append(" = ");
              String _normalizeVarNewName_1 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_4.append(_normalizeVarNewName_1);
              _builder_4.append(";");
              _builder_4.newLineIfNotEmpty();
              _builder_4.append("if (eNotificationRequired()) {");
              _builder_4.newLine();
              _builder_4.append("\t");
              _builder_4.append("$eni:T notification = new $eni:T(this, $notif:T.SET, $epit:T.");
              String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
              _builder_4.append(_normalizeUpperField, "\t");
              _builder_4.append(", ");
              String _normalizeVarOldName_1 = this.namingUtils.normalizeVarOldName(field.getName());
              _builder_4.append(_normalizeVarOldName_1, "\t");
              _builder_4.append(", ");
              String _normalizeVarNewName_2 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_4.append(_normalizeVarNewName_2, "\t");
              _builder_4.append(");");
              _builder_4.newLineIfNotEmpty();
              _builder_4.append("\t");
              _builder_4.append("if (msgs == null)");
              _builder_4.newLine();
              _builder_4.append("\t\t");
              _builder_4.append("msgs = notification;");
              _builder_4.newLine();
              _builder_4.append("\t");
              _builder_4.append("else");
              _builder_4.newLine();
              _builder_4.append("\t\t");
              _builder_4.append("msgs.add(notification);");
              _builder_4.newLine();
              _builder_4.append("}");
              _builder_4.newLine();
              _builder_4.append("return msgs;");
              _builder_4.newLine();
              Pair<String, TypeName> _mappedTo = Pair.<String, TypeName>of("fieldType", rt);
              ClassName _get = ClassName.get(ENotificationImpl.class);
              Pair<String, ClassName> _mappedTo_1 = Pair.<String, ClassName>of("eni", _get);
              ClassName _get_1 = ClassName.get(Notification.class);
              Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("notif", _get_1);
              Pair<String, ClassName> _mappedTo_3 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
              final MethodSpec basicSetter = _addModifiers.addNamedCode(_builder_4.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3)).build();
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append("set");
              String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
              _builder_5.append(_firstUpper_2);
              MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_5.toString());
              StringConcatenation _builder_6 = new StringConcatenation();
              String _normalizeVarNewName_3 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_6.append(_normalizeVarNewName_3);
              MethodSpec.Builder _addParameter = _methodBuilder.addParameter(rt, _builder_6.toString());
              StringConcatenation _builder_7 = new StringConcatenation();
              _builder_7.append("if (");
              String _normalizeVarNewName_4 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_7.append(_normalizeVarNewName_4);
              _builder_7.append(" != ");
              String _normalizeVarName_3 = this.namingUtils.normalizeVarName(field.getName());
              _builder_7.append(_normalizeVarName_3);
              _builder_7.append(") {");
              _builder_7.newLineIfNotEmpty();
              _builder_7.append("\t");
              _builder_7.append("$nc:T msgs = null;");
              _builder_7.newLine();
              _builder_7.append("\t");
              _builder_7.append("if (");
              String _normalizeVarName_4 = this.namingUtils.normalizeVarName(field.getName());
              _builder_7.append(_normalizeVarName_4, "\t");
              _builder_7.append(" != null)");
              _builder_7.newLineIfNotEmpty();
              _builder_7.append("\t\t");
              _builder_7.append("msgs = (($ieo:T) ");
              String _normalizeVarName_5 = this.namingUtils.normalizeVarName(field.getName());
              _builder_7.append(_normalizeVarName_5, "\t\t");
              _builder_7.append(").eInverseRemove(this, $epit:T.");
              String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
              _builder_7.append(_normalizeUpperField_1, "\t\t");
              _builder_7.append(", $fieldType:T.class, msgs);");
              _builder_7.newLineIfNotEmpty();
              _builder_7.append("\t");
              _builder_7.append("if (");
              String _normalizeVarNewName_5 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_7.append(_normalizeVarNewName_5, "\t");
              _builder_7.append(" != null)");
              _builder_7.newLineIfNotEmpty();
              _builder_7.append("\t\t");
              _builder_7.append("msgs = (($ieo:T) ");
              String _normalizeVarNewName_6 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_7.append(_normalizeVarNewName_6, "\t\t");
              _builder_7.append(").eInverseAdd(this, $epit:T.");
              String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
              _builder_7.append(_normalizeUpperField_2, "\t\t");
              _builder_7.append(", $fieldType:T.class, msgs);");
              _builder_7.newLineIfNotEmpty();
              _builder_7.append("\t");
              _builder_7.append("msgs = basicSet");
              String _firstUpper_3 = StringExtensions.toFirstUpper(field.getName());
              _builder_7.append(_firstUpper_3, "\t");
              _builder_7.append("(");
              String _normalizeVarNewName_7 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_7.append(_normalizeVarNewName_7, "\t");
              _builder_7.append(", msgs);");
              _builder_7.newLineIfNotEmpty();
              _builder_7.append("\t");
              _builder_7.append("if (msgs != null)");
              _builder_7.newLine();
              _builder_7.append("\t\t");
              _builder_7.append("msgs.dispatch();");
              _builder_7.newLine();
              _builder_7.append("} else if (eNotificationRequired())");
              _builder_7.newLine();
              _builder_7.append("\t");
              _builder_7.append("eNotify(new $eni:T(this, $notif:T.SET, $epit:T.");
              String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
              _builder_7.append(_normalizeUpperField_3, "\t");
              _builder_7.append(", ");
              String _normalizeVarNewName_8 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_7.append(_normalizeVarNewName_8, "\t");
              _builder_7.append(", ");
              String _normalizeVarNewName_9 = this.namingUtils.normalizeVarNewName(field.getName());
              _builder_7.append(_normalizeVarNewName_9, "\t");
              _builder_7.append("));");
              _builder_7.newLineIfNotEmpty();
              ClassName _get_2 = ClassName.get(NotificationChain.class);
              Pair<String, ClassName> _mappedTo_4 = Pair.<String, ClassName>of("nc", _get_2);
              ClassName _get_3 = ClassName.get(InternalEObject.class);
              Pair<String, ClassName> _mappedTo_5 = Pair.<String, ClassName>of("ieo", _get_3);
              Pair<String, ClassName> _mappedTo_6 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
              Pair<String, TypeName> _mappedTo_7 = Pair.<String, TypeName>of("fieldType", rt);
              ClassName _get_4 = ClassName.get(ENotificationImpl.class);
              Pair<String, ClassName> _mappedTo_8 = Pair.<String, ClassName>of("eni", _get_4);
              ClassName _get_5 = ClassName.get(Notification.class);
              Pair<String, ClassName> _mappedTo_9 = Pair.<String, ClassName>of("notif", _get_5);
              final MethodSpec setter = _addParameter.addNamedCode(_builder_7.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9)).addModifiers(Modifier.PUBLIC).build();
              _xblockexpression_3 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter, basicSetter, setter));
            }
            _xifexpression_2 = _xblockexpression_3;
          } else {
            List<MethodSpec> _xifexpression_3 = null;
            if (((((existEOpposite && isMultiple) && (!isOppositeMulti)) && (!isContainment)) && (!isOppositeContainment))) {
              List<MethodSpec> _xblockexpression_4 = null;
              {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("get");
                String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                _builder.append(_firstUpper);
                MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType);
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("if (");
                String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
                _builder_1.append(_normalizeVarName);
                _builder_1.append(" == null) {");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
                _builder_1.append(_normalizeVarName_1, "\t");
                _builder_1.append(" = new $eowrel:T($ft:T.class, this, $epit:T.");
                String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_1.append(_normalizeUpperField, "\t");
                _builder_1.append(", $epit:T.");
                String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
                _builder_1.append(_normalizeUpperField_1, "\t");
                _builder_1.append(");");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("}");
                _builder_1.newLine();
                _builder_1.append("return ");
                String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
                _builder_1.append(_normalizeVarName_2);
                _builder_1.append(";");
                _builder_1.newLineIfNotEmpty();
                ParameterizedTypeName _get = ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList.class), rt);
                Pair<String, ParameterizedTypeName> _mappedTo = Pair.<String, ParameterizedTypeName>of("eowrel", _get);
                Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("ft", rt);
                Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
                final MethodSpec getter = _returns.addNamedCode(_builder_1.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)).addModifiers(Modifier.PUBLIC).build();
                _xblockexpression_4 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter));
              }
              _xifexpression_3 = _xblockexpression_4;
            } else {
              List<MethodSpec> _xifexpression_4 = null;
              if (((((existEOpposite && isMultiple) && isOppositeMulti) && (!isContainment)) && (!isOppositeContainment))) {
                List<MethodSpec> _xblockexpression_5 = null;
                {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("get");
                  String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                  _builder.append(_firstUpper);
                  MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType);
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("if (");
                  String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
                  _builder_1.append(_normalizeVarName);
                  _builder_1.append(" == null) {");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t");
                  String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_1.append(_normalizeVarName_1, "\t");
                  _builder_1.append(" = new $eowrel:T($ft:T.class, this, $epit:T.");
                  String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_1.append(_normalizeUpperField, "\t");
                  _builder_1.append(", $epit:T.");
                  String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), field.getEOpposite().getEContainingClass().getName());
                  _builder_1.append(_normalizeUpperField_1, "\t");
                  _builder_1.append(");");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("}");
                  _builder_1.newLine();
                  _builder_1.append("return ");
                  String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_1.append(_normalizeVarName_2);
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                  ParameterizedTypeName _get = ParameterizedTypeName.get(ClassName.get(EObjectWithInverseResolvingEList.ManyInverse.class), rt);
                  Pair<String, ParameterizedTypeName> _mappedTo = Pair.<String, ParameterizedTypeName>of("eowrel", _get);
                  Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("ft", rt);
                  Pair<String, ClassName> _mappedTo_2 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
                  final MethodSpec getter = _returns.addNamedCode(_builder_1.toString(), CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)).addModifiers(Modifier.PUBLIC).build();
                  _xblockexpression_5 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter));
                }
                _xifexpression_4 = _xblockexpression_5;
              } else {
                List<MethodSpec> _xblockexpression_6 = null;
                {
                  final List<MethodSpec> setters = this.legacyCompileSetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement);
                  final MethodSpec getter = this.legacyCompileGetter(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType);
                  _xblockexpression_6 = IterableExtensions.<MethodSpec>toList(Iterables.<MethodSpec>concat(setters, Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(getter))));
                }
                _xifexpression_4 = _xblockexpression_6;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public List<MethodSpec> legacyCompileSetter(final EReference field, final TypeName fieldType, final String packageRoot, final EClass eClass, final Dsl dsl, final ClassName ePackageInterfaceType, final boolean isMapElement) {
    List<MethodSpec> _xblockexpression = null;
    {
      final EClassifier ert = field.getEGenericType().getERawType();
      final TypeName rt = this.icu.scopedInterfaceTypeRef(ert, packageRoot);
      final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
      List<MethodSpec> _xifexpression = null;
      if ((!isMultiple)) {
        List<MethodSpec> _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          String _normalizeVarNewName = this.namingUtils.normalizeVarNewName(field.getName());
          _builder.append(_normalizeVarNewName);
          final String newName = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          String _normalizeVarOldName = this.namingUtils.normalizeVarOldName(field.getName());
          _builder_1.append(_normalizeVarOldName);
          final String oldName = _builder_1.toString();
          final String name = this.namingUtils.normalizeVarName(field.getName());
          List<MethodSpec> _xifexpression_1 = null;
          EReference _eOpposite = field.getEOpposite();
          boolean _tripleNotEquals = (_eOpposite != null);
          if (_tripleNotEquals) {
            List<MethodSpec> _xifexpression_2 = null;
            boolean _isContainment = field.getEOpposite().isContainment();
            boolean _not = (!_isContainment);
            if (_not) {
              List<MethodSpec> _xblockexpression_2 = null;
              {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("set");
                String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                _builder_2.append(_firstUpper);
                MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_2.toString());
                String _property = dsl.getDslProp().getProperty("truffle", "false");
                boolean _equals = Objects.equal(_property, "true");
                final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
                  return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                };
                MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder, Boolean.valueOf(_equals), _function).addParameter(ParameterSpec.builder(fieldType, newName).build());
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("if (");
                _builder_3.append(newName);
                _builder_3.append(" != ");
                _builder_3.append(name);
                _builder_3.append(") {");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t");
                _builder_3.append("$1T msgs = null;");
                _builder_3.newLine();
                {
                  EReference _eOpposite_1 = field.getEOpposite();
                  boolean _tripleNotEquals_1 = (_eOpposite_1 != null);
                  if (_tripleNotEquals_1) {
                    _builder_3.append("\t");
                    _builder_3.append("if (");
                    _builder_3.append(name, "\t");
                    _builder_3.append(" != null)");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("msgs = (($2T) ");
                    _builder_3.append(name, "\t\t");
                    _builder_3.append(").eInverseRemove(this, $5T.");
                    EObject _eContainer = field.getEOpposite().eContainer();
                    String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), ((EClass) _eContainer).getName());
                    _builder_3.append(_normalizeUpperField, "\t\t");
                    _builder_3.append(", ");
                    _builder_3.append(rt, "\t\t");
                    _builder_3.append(".class, msgs);");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("if (");
                    _builder_3.append(newName, "\t");
                    _builder_3.append(" != null)");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("msgs = (($2T) ");
                    _builder_3.append(newName, "\t\t");
                    _builder_3.append(").eInverseAdd(this, $5T.");
                    EObject _eContainer_1 = field.getEOpposite().eContainer();
                    String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), ((EClass) _eContainer_1).getName());
                    _builder_3.append(_normalizeUpperField_1, "\t\t");
                    _builder_3.append(", ");
                    _builder_3.append(rt, "\t\t");
                    _builder_3.append(".class,");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("\t\t\t");
                    _builder_3.append("msgs);");
                    _builder_3.newLine();
                  } else {
                    _builder_3.append("\t");
                    _builder_3.append("if (");
                    _builder_3.append(name, "\t");
                    _builder_3.append(" != null)");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("msgs = (($2T) ");
                    _builder_3.append(name, "\t\t");
                    _builder_3.append(").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - $5T.");
                    String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                    _builder_3.append(_normalizeUpperField_2, "\t\t");
                    _builder_3.append(", null, msgs);");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("if (");
                    _builder_3.append(newName, "\t");
                    _builder_3.append(" != null)");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("\t");
                    _builder_3.append("\t");
                    _builder_3.append("msgs = (($2T) ");
                    _builder_3.append(newName, "\t\t");
                    _builder_3.append(").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - $5T.");
                    String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                    _builder_3.append(_normalizeUpperField_3, "\t\t");
                    _builder_3.append(", null, msgs);");
                    _builder_3.newLineIfNotEmpty();
                  }
                }
                _builder_3.append("\t");
                _builder_3.append("msgs = basicSet");
                String _firstUpper_1 = StringExtensions.toFirstUpper(name);
                _builder_3.append(_firstUpper_1, "\t");
                _builder_3.append("(");
                _builder_3.append(newName, "\t");
                _builder_3.append(", msgs);");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t");
                _builder_3.append("if (msgs != null)");
                _builder_3.newLine();
                _builder_3.append("\t\t");
                _builder_3.append("msgs.dispatch();");
                _builder_3.newLine();
                _builder_3.append("} else if (eNotificationRequired())");
                _builder_3.newLine();
                _builder_3.append("\t");
                _builder_3.append("eNotify(new $3T(this, $4T.SET, $5T.");
                String _normalizeUpperField_4 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_3.append(_normalizeUpperField_4, "\t");
                _builder_3.append(", ");
                _builder_3.append(newName, "\t");
                _builder_3.append(", ");
                _builder_3.append(newName, "\t");
                _builder_3.append("));");
                _builder_3.newLineIfNotEmpty();
                final MethodSpec setter = _addParameter.addCode(_builder_3.toString(), NotificationChain.class, InternalEObject.class, ENotificationImpl.class, Notification.class, ePackageInterfaceType).addModifiers(Modifier.PUBLIC).build();
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("basicSet");
                String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
                _builder_4.append(_firstUpper_2);
                MethodSpec.Builder _methodBuilder_1 = MethodSpec.methodBuilder(_builder_4.toString());
                String _property_1 = dsl.getDslProp().getProperty("truffle", "false");
                boolean _equals_1 = Objects.equal(_property_1, "true");
                final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_1 = (MethodSpec.Builder it) -> {
                  return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                };
                StringConcatenation _builder_5 = new StringConcatenation();
                String _normalizeVarNewName_1 = this.namingUtils.normalizeVarNewName(field.getName());
                _builder_5.append(_normalizeVarNewName_1);
                MethodSpec.Builder _addParameter_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder_1, Boolean.valueOf(_equals_1), _function_1).returns(NotificationChain.class).addParameter(
                  ParameterSpec.builder(fieldType, _builder_5.toString()).build()).addParameter(
                  ParameterSpec.builder(NotificationChain.class, "msgsp").build());
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append("$1T msgs = msgsp;");
                _builder_6.newLine();
                _builder_6.append("$2T ");
                _builder_6.append(oldName);
                _builder_6.append(" = ");
                _builder_6.append(name);
                _builder_6.append(";");
                _builder_6.newLineIfNotEmpty();
                _builder_6.append(name);
                _builder_6.append(" = ");
                _builder_6.append(newName);
                _builder_6.append(";");
                _builder_6.newLineIfNotEmpty();
                _builder_6.append("if (eNotificationRequired()) {");
                _builder_6.newLine();
                _builder_6.append("\t");
                _builder_6.append("$3T notification = new $3T(this, $4T.SET, $5T.");
                String _normalizeUpperField_5 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_6.append(_normalizeUpperField_5, "\t");
                _builder_6.append(",");
                _builder_6.newLineIfNotEmpty();
                _builder_6.append("\t\t\t");
                _builder_6.append(oldName, "\t\t\t");
                _builder_6.append(", ");
                _builder_6.append(newName, "\t\t\t");
                _builder_6.append(");");
                _builder_6.newLineIfNotEmpty();
                _builder_6.append("\t");
                _builder_6.append("if (msgs == null)");
                _builder_6.newLine();
                _builder_6.append("\t\t");
                _builder_6.append("msgs = notification;");
                _builder_6.newLine();
                _builder_6.append("\t");
                _builder_6.append("else");
                _builder_6.newLine();
                _builder_6.append("\t\t");
                _builder_6.append("msgs.add(notification);");
                _builder_6.newLine();
                _builder_6.append("}");
                _builder_6.newLine();
                _builder_6.append("return msgs;");
                _builder_6.newLine();
                final MethodSpec basicSetMethod = _addParameter_1.addCode(_builder_6.toString(), NotificationChain.class, fieldType, ENotificationImpl.class, Notification.class, ePackageInterfaceType).addModifiers(Modifier.PRIVATE).build();
                _xblockexpression_2 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(setter, basicSetMethod));
              }
              _xifexpression_2 = _xblockexpression_2;
            } else {
              List<MethodSpec> _xblockexpression_3 = null;
              {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("set");
                String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                _builder_2.append(_firstUpper);
                MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_2.toString());
                String _property = dsl.getDslProp().getProperty("truffle", "false");
                boolean _equals = Objects.equal(_property, "true");
                final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
                  return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                };
                MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder, Boolean.valueOf(_equals), _function).addParameter(ParameterSpec.builder(fieldType, newName).build());
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("if (");
                _builder_3.append(newName);
                _builder_3.append(" != eInternalContainer() || (eContainerFeatureID() != $1T.");
                String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_3.append(_normalizeUpperField);
                _builder_3.append(" && ");
                _builder_3.append(newName);
                _builder_3.append(" != null)) {");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t");
                _builder_3.append("if ($2T.isAncestor(this, ");
                _builder_3.append(newName, "\t");
                _builder_3.append("))");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t\t");
                _builder_3.append("throw new $3T(\"Recursive containment not allowed for \" + toString());");
                _builder_3.newLine();
                _builder_3.append("\t");
                _builder_3.append("$4T msgs = null;");
                _builder_3.newLine();
                _builder_3.append("\t");
                _builder_3.append("if (eInternalContainer() != null)");
                _builder_3.newLine();
                _builder_3.append("\t\t");
                _builder_3.append("msgs = eBasicRemoveFromContainer(msgs);");
                _builder_3.newLine();
                _builder_3.append("\t");
                _builder_3.append("if (");
                _builder_3.append(newName, "\t");
                _builder_3.append(" != null)");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t\t");
                _builder_3.append("msgs = (($5T)");
                _builder_3.append(newName, "\t\t");
                _builder_3.append(").eInverseAdd(this, $1T.");
                EObject _eContainer = field.eContainer();
                String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), ((EClass) _eContainer).getName());
                _builder_3.append(_normalizeUpperField_1, "\t\t");
                _builder_3.append(" , $6T.class, msgs);");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t");
                _builder_3.append("msgs = basicSet");
                String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
                _builder_3.append(_firstUpper_1, "\t");
                _builder_3.append("(");
                _builder_3.append(newName, "\t");
                _builder_3.append(", msgs);");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t");
                _builder_3.append("if (msgs != null) msgs.dispatch();");
                _builder_3.newLine();
                _builder_3.append("}");
                _builder_3.newLine();
                _builder_3.append("else if (eNotificationRequired())");
                _builder_3.newLine();
                _builder_3.append("\t");
                _builder_3.append("eNotify(new $7T(this, $8T.SET, $1T.");
                String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_3.append(_normalizeUpperField_2, "\t");
                _builder_3.append(" , ");
                _builder_3.append(newName, "\t");
                _builder_3.append(", ");
                _builder_3.append(newName, "\t");
                _builder_3.append("));");
                _builder_3.newLineIfNotEmpty();
                final MethodSpec setter = _addParameter.addCode(_builder_3.toString(), ePackageInterfaceType, EcoreUtil.class, IllegalArgumentException.class, NotificationChain.class, InternalEObject.class, fieldType, ENotificationImpl.class, Notification.class).addModifiers(Modifier.PUBLIC).build();
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("basicSet");
                String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
                _builder_4.append(_firstUpper_2);
                MethodSpec.Builder _methodBuilder_1 = MethodSpec.methodBuilder(_builder_4.toString());
                String _property_1 = dsl.getDslProp().getProperty("truffle", "false");
                boolean _equals_1 = Objects.equal(_property_1, "true");
                final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_1 = (MethodSpec.Builder it) -> {
                  return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                };
                StringConcatenation _builder_5 = new StringConcatenation();
                String _normalizeVarNewName_1 = this.namingUtils.normalizeVarNewName(field.getName());
                _builder_5.append(_normalizeVarNewName_1);
                MethodSpec.Builder _addParameter_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder_1, Boolean.valueOf(_equals_1), _function_1).returns(NotificationChain.class).addParameter(
                  ParameterSpec.builder(fieldType, _builder_5.toString()).build()).addParameter(
                  ParameterSpec.builder(NotificationChain.class, "msgs").build());
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append("msgs = eBasicSetContainer(($1T) ");
                String _normalizeVarNewName_2 = this.namingUtils.normalizeVarNewName(field.getName());
                _builder_6.append(_normalizeVarNewName_2);
                _builder_6.append(", $2T.");
                String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_6.append(_normalizeUpperField_3);
                _builder_6.append(", msgs);");
                _builder_6.newLineIfNotEmpty();
                _builder_6.append("return msgs;");
                _builder_6.newLine();
                final MethodSpec basicSetMethod = _addParameter_1.addCode(_builder_6.toString(), InternalEObject.class, ePackageInterfaceType).addModifiers(Modifier.PUBLIC).build();
                _xblockexpression_3 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(setter, basicSetMethod));
              }
              _xifexpression_2 = _xblockexpression_3;
            }
            _xifexpression_1 = _xifexpression_2;
          } else {
            List<MethodSpec> _xifexpression_3 = null;
            boolean _isContainment_1 = field.isContainment();
            if (_isContainment_1) {
              List<MethodSpec> _xblockexpression_4 = null;
              {
                EClassifier _eType = field.getEType();
                final boolean isEnum = (_eType instanceof EEnum);
                MethodSpec _xifexpression_4 = null;
                if (isMapElement) {
                  StringConcatenation _builder_2 = new StringConcatenation();
                  _builder_2.append("set");
                  String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                  _builder_2.append(_firstUpper);
                  MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder_2.toString()).returns(fieldType);
                  String _property = dsl.getDslProp().getProperty("truffle", "false");
                  boolean _equals = Objects.equal(_property, "true");
                  final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
                    return it.addAnnotation(
                      ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                  };
                  MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns, Boolean.valueOf(_equals), _function).addParameter(ParameterSpec.builder(fieldType, newName).build());
                  StringConcatenation _builder_3 = new StringConcatenation();
                  {
                    if (isEnum) {
                    }
                  }
                  _builder_3.append("$5T ");
                  _builder_3.append(oldName);
                  _builder_3.append(" = ");
                  String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
                  _builder_3.append(_normalizeVarName);
                  _builder_3.append(";");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("if (");
                  _builder_3.append(newName);
                  _builder_3.append(" != ");
                  String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_3.append(_normalizeVarName_1);
                  _builder_3.append(") {");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t");
                  _builder_3.append("$4T msgs = null;");
                  _builder_3.newLine();
                  _builder_3.append("\t");
                  _builder_3.append("if (");
                  String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_3.append(_normalizeVarName_2, "\t");
                  _builder_3.append(" != null)");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t\t");
                  _builder_3.append("msgs = (($1T) ");
                  String _normalizeVarName_3 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_3.append(_normalizeVarName_3, "\t\t");
                  _builder_3.append(").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ");
                  String _packageInterfacePackageName = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                  _builder_3.append(_packageInterfacePackageName, "\t\t");
                  _builder_3.append(".");
                  String _packageInterfaceClassName = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                  _builder_3.append(_packageInterfaceClassName, "\t\t");
                  _builder_3.append(".");
                  String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_3.append(_normalizeUpperField, "\t\t");
                  _builder_3.append(", null, msgs);");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t");
                  _builder_3.append("if (");
                  _builder_3.append(newName, "\t");
                  _builder_3.append(" != null)");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t\t");
                  _builder_3.append("msgs = (($1T)");
                  _builder_3.append(newName, "\t\t");
                  _builder_3.append(").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ");
                  String _packageInterfacePackageName_1 = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                  _builder_3.append(_packageInterfacePackageName_1, "\t\t");
                  _builder_3.append(".");
                  String _packageInterfaceClassName_1 = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                  _builder_3.append(_packageInterfaceClassName_1, "\t\t");
                  _builder_3.append(".");
                  String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_3.append(_normalizeUpperField_1, "\t\t");
                  _builder_3.append(", null, msgs);");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t");
                  _builder_3.append("msgs = basicSet");
                  String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
                  _builder_3.append(_firstUpper_1, "\t");
                  _builder_3.append("(");
                  _builder_3.append(newName, "\t");
                  _builder_3.append(", msgs);");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("\t");
                  _builder_3.append("if (msgs != null) msgs.dispatch();");
                  _builder_3.newLine();
                  _builder_3.append("}");
                  _builder_3.newLine();
                  _builder_3.append("else if (eNotificationRequired())");
                  _builder_3.newLine();
                  _builder_3.append("\t");
                  _builder_3.append("eNotify(new $2T(this, $3T.SET, ");
                  String _packageInterfacePackageName_2 = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                  _builder_3.append(_packageInterfacePackageName_2, "\t");
                  _builder_3.append(".");
                  String _packageInterfaceClassName_2 = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                  _builder_3.append(_packageInterfaceClassName_2, "\t");
                  _builder_3.append(".");
                  String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_3.append(_normalizeUpperField_2, "\t");
                  _builder_3.append(", ");
                  _builder_3.append(newName, "\t");
                  _builder_3.append(", ");
                  _builder_3.append(newName, "\t");
                  _builder_3.append("));");
                  _builder_3.newLineIfNotEmpty();
                  _builder_3.append("return ");
                  _builder_3.append(oldName);
                  _builder_3.append(";");
                  _builder_3.newLineIfNotEmpty();
                  _xifexpression_4 = _addParameter.addCode(_builder_3.toString(), InternalEObject.class, ENotificationImpl.class, Notification.class, NotificationChain.class, fieldType).addModifiers(Modifier.PUBLIC).build();
                } else {
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("set");
                  String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
                  _builder_4.append(_firstUpper_2);
                  MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_4.toString());
                  String _property_1 = dsl.getDslProp().getProperty("truffle", "false");
                  boolean _equals_1 = Objects.equal(_property_1, "true");
                  final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_1 = (MethodSpec.Builder it) -> {
                    return it.addAnnotation(
                      ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                  };
                  MethodSpec.Builder _addParameter_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder, Boolean.valueOf(_equals_1), _function_1).addParameter(ParameterSpec.builder(fieldType, newName).build());
                  StringConcatenation _builder_5 = new StringConcatenation();
                  {
                    if (isEnum) {
                    }
                  }
                  _builder_5.append("if (");
                  _builder_5.append(newName);
                  _builder_5.append(" != ");
                  String _normalizeVarName_4 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_5.append(_normalizeVarName_4);
                  _builder_5.append(") {");
                  _builder_5.newLineIfNotEmpty();
                  _builder_5.append("\t");
                  _builder_5.append("$4T msgs = null;");
                  _builder_5.newLine();
                  _builder_5.append("\t");
                  _builder_5.append("if (");
                  String _normalizeVarName_5 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_5.append(_normalizeVarName_5, "\t");
                  _builder_5.append(" != null)");
                  _builder_5.newLineIfNotEmpty();
                  _builder_5.append("\t\t");
                  _builder_5.append("msgs = (($1T) ");
                  String _normalizeVarName_6 = this.namingUtils.normalizeVarName(field.getName());
                  _builder_5.append(_normalizeVarName_6, "\t\t");
                  _builder_5.append(").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ");
                  String _packageInterfacePackageName_3 = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                  _builder_5.append(_packageInterfacePackageName_3, "\t\t");
                  _builder_5.append(".");
                  String _packageInterfaceClassName_3 = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                  _builder_5.append(_packageInterfaceClassName_3, "\t\t");
                  _builder_5.append(".");
                  String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_5.append(_normalizeUpperField_3, "\t\t");
                  _builder_5.append(", null, msgs);");
                  _builder_5.newLineIfNotEmpty();
                  _builder_5.append("\t");
                  _builder_5.append("if (");
                  _builder_5.append(newName, "\t");
                  _builder_5.append(" != null)");
                  _builder_5.newLineIfNotEmpty();
                  _builder_5.append("\t\t");
                  _builder_5.append("msgs = (($1T)");
                  _builder_5.append(newName, "\t\t");
                  _builder_5.append(").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ");
                  String _packageInterfacePackageName_4 = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                  _builder_5.append(_packageInterfacePackageName_4, "\t\t");
                  _builder_5.append(".");
                  String _packageInterfaceClassName_4 = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                  _builder_5.append(_packageInterfaceClassName_4, "\t\t");
                  _builder_5.append(".");
                  String _normalizeUpperField_4 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_5.append(_normalizeUpperField_4, "\t\t");
                  _builder_5.append(", null, msgs);");
                  _builder_5.newLineIfNotEmpty();
                  _builder_5.append("\t");
                  _builder_5.append("msgs = basicSet");
                  String _firstUpper_3 = StringExtensions.toFirstUpper(field.getName());
                  _builder_5.append(_firstUpper_3, "\t");
                  _builder_5.append("(");
                  _builder_5.append(newName, "\t");
                  _builder_5.append(", msgs);");
                  _builder_5.newLineIfNotEmpty();
                  _builder_5.append("\t");
                  _builder_5.append("if (msgs != null) msgs.dispatch();");
                  _builder_5.newLine();
                  _builder_5.append("}");
                  _builder_5.newLine();
                  _builder_5.append("else if (eNotificationRequired())");
                  _builder_5.newLine();
                  _builder_5.append("\t");
                  _builder_5.append("eNotify(new $2T(this, $3T.SET, ");
                  String _packageInterfacePackageName_5 = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                  _builder_5.append(_packageInterfacePackageName_5, "\t");
                  _builder_5.append(".");
                  String _packageInterfaceClassName_5 = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                  _builder_5.append(_packageInterfaceClassName_5, "\t");
                  _builder_5.append(".");
                  String _normalizeUpperField_5 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                  _builder_5.append(_normalizeUpperField_5, "\t");
                  _builder_5.append(", ");
                  _builder_5.append(newName, "\t");
                  _builder_5.append(", ");
                  _builder_5.append(newName, "\t");
                  _builder_5.append("));");
                  _builder_5.newLineIfNotEmpty();
                  _xifexpression_4 = _addParameter_1.addCode(_builder_5.toString(), InternalEObject.class, ENotificationImpl.class, Notification.class, NotificationChain.class).addModifiers(Modifier.PUBLIC).build();
                }
                final MethodSpec setter = _xifexpression_4;
                StringConcatenation _builder_6 = new StringConcatenation();
                _builder_6.append("basicSet");
                String _firstUpper_4 = StringExtensions.toFirstUpper(field.getName());
                _builder_6.append(_firstUpper_4);
                MethodSpec.Builder _methodBuilder_1 = MethodSpec.methodBuilder(_builder_6.toString());
                String _property_2 = dsl.getDslProp().getProperty("truffle", "false");
                boolean _equals_2 = Objects.equal(_property_2, "true");
                final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_2 = (MethodSpec.Builder it) -> {
                  return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                };
                MethodSpec.Builder _addParameter_2 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder_1, Boolean.valueOf(_equals_2), _function_2).returns(NotificationChain.class).addParameter(ParameterSpec.builder(fieldType, newName).build()).addParameter(ParameterSpec.builder(NotificationChain.class, "msgs").build());
                StringConcatenation _builder_7 = new StringConcatenation();
                _builder_7.append("$1T ");
                _builder_7.append(oldName);
                _builder_7.append(" = ");
                String _normalizeVarName_7 = this.namingUtils.normalizeVarName(field.getName());
                _builder_7.append(_normalizeVarName_7);
                _builder_7.append(";");
                _builder_7.newLineIfNotEmpty();
                String _normalizeVarName_8 = this.namingUtils.normalizeVarName(field.getName());
                _builder_7.append(_normalizeVarName_8);
                _builder_7.append(" = ");
                _builder_7.append(newName);
                _builder_7.append(";");
                _builder_7.newLineIfNotEmpty();
                _builder_7.append("if (eNotificationRequired()) {");
                _builder_7.newLine();
                _builder_7.append("\t");
                _builder_7.append("$2T notification = new $2T(this, $3T.SET, ");
                String _packageInterfacePackageName_6 = this.namingUtils.packageInterfacePackageName(eClass.getEPackage(), packageRoot);
                _builder_7.append(_packageInterfacePackageName_6, "\t");
                _builder_7.append(".");
                String _packageInterfaceClassName_6 = this.namingUtils.packageInterfaceClassName(eClass.getEPackage());
                _builder_7.append(_packageInterfaceClassName_6, "\t");
                _builder_7.append(".");
                String _normalizeUpperField_6 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                _builder_7.append(_normalizeUpperField_6, "\t");
                _builder_7.append(", ");
                _builder_7.append(oldName, "\t");
                _builder_7.append(", ");
                _builder_7.append(newName, "\t");
                _builder_7.append(");");
                _builder_7.newLineIfNotEmpty();
                _builder_7.append("\t");
                _builder_7.append("if (msgs == null) msgs = notification; else msgs.add(notification);");
                _builder_7.newLine();
                _builder_7.append("}");
                _builder_7.newLine();
                _builder_7.append("return msgs;");
                _builder_7.newLine();
                final MethodSpec basicSetter = _addParameter_2.addCode(_builder_7.toString(), fieldType, ENotificationImpl.class, Notification.class).addModifiers(Modifier.PUBLIC).build();
                _xblockexpression_4 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(setter, basicSetter));
              }
              _xifexpression_3 = _xblockexpression_4;
            } else {
              List<MethodSpec> _xblockexpression_5 = null;
              {
                final boolean isMapValueField = (((((EClass) field.eContainer()).getInstanceClass() != null) && 
                  Objects.equal(((EClass) field.eContainer()).getInstanceClass(), Map.Entry.class)) && Objects.equal(field.getName(), "value"));
                List<MethodSpec> _xifexpression_4 = null;
                if (isMapValueField) {
                  List<MethodSpec> _xblockexpression_6 = null;
                  {
                    StringConcatenation _builder_2 = new StringConcatenation();
                    _builder_2.append("set");
                    String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                    _builder_2.append(_firstUpper);
                    MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_2.toString());
                    String _property = dsl.getDslProp().getProperty("truffle", "false");
                    boolean _equals = Objects.equal(_property, "true");
                    final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
                      return it.addAnnotation(
                        ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                    };
                    MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder, Boolean.valueOf(_equals), _function).returns(fieldType).addParameter(ParameterSpec.builder(fieldType, newName).build());
                    StringConcatenation _builder_3 = new StringConcatenation();
                    _builder_3.append("$1T ");
                    _builder_3.append(oldName);
                    _builder_3.append(" = this.");
                    String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
                    _builder_3.append(_normalizeVarName);
                    _builder_3.append(";");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("this.");
                    String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
                    _builder_3.append(_normalizeVarName_1);
                    _builder_3.append(" = ");
                    _builder_3.append(newName);
                    _builder_3.append(";");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("return ");
                    _builder_3.append(oldName);
                    _builder_3.append(";");
                    _builder_3.newLineIfNotEmpty();
                    final MethodSpec setter = _addParameter.addCode(_builder_3.toString(), fieldType).addModifiers(Modifier.PUBLIC).build();
                    _xblockexpression_6 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(setter));
                  }
                  _xifexpression_4 = _xblockexpression_6;
                } else {
                  List<MethodSpec> _xblockexpression_7 = null;
                  {
                    StringConcatenation _builder_2 = new StringConcatenation();
                    _builder_2.append("set");
                    String _firstUpper = StringExtensions.toFirstUpper(field.getName());
                    _builder_2.append(_firstUpper);
                    MethodSpec.Builder _methodBuilder = MethodSpec.methodBuilder(_builder_2.toString());
                    String _property = dsl.getDslProp().getProperty("truffle", "false");
                    boolean _equals = Objects.equal(_property, "true");
                    final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
                      return it.addAnnotation(
                        ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
                    };
                    MethodSpec.Builder _addParameter = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_methodBuilder, Boolean.valueOf(_equals), _function).addParameter(ParameterSpec.builder(fieldType, newName).build());
                    StringConcatenation _builder_3 = new StringConcatenation();
                    _builder_3.append("$1T ");
                    _builder_3.append(oldName);
                    _builder_3.append(" = ");
                    String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
                    _builder_3.append(_normalizeVarName);
                    _builder_3.append(";");
                    _builder_3.newLineIfNotEmpty();
                    String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
                    _builder_3.append(_normalizeVarName_1);
                    _builder_3.append(" = ");
                    _builder_3.append(newName);
                    _builder_3.append(";");
                    _builder_3.newLineIfNotEmpty();
                    _builder_3.append("if (eNotificationRequired())");
                    _builder_3.newLine();
                    _builder_3.append("\t");
                    _builder_3.append("eNotify(new $2T(this, $3T.SET, $4T.");
                    String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
                    _builder_3.append(_normalizeUpperField, "\t");
                    _builder_3.append(", ");
                    _builder_3.append(oldName, "\t");
                    _builder_3.append(", ");
                    String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
                    _builder_3.append(_normalizeVarName_2, "\t");
                    _builder_3.append("));");
                    _builder_3.newLineIfNotEmpty();
                    final MethodSpec setter = _addParameter.addCode(_builder_3.toString(), fieldType, ENotificationImpl.class, Notification.class, ePackageInterfaceType).addModifiers(Modifier.PUBLIC).build();
                    _xblockexpression_7 = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList(setter));
                  }
                  _xifexpression_4 = _xblockexpression_7;
                }
                _xblockexpression_5 = _xifexpression_4;
              }
              _xifexpression_3 = _xblockexpression_5;
            }
            _xifexpression_1 = _xifexpression_3;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = Collections.<MethodSpec>unmodifiableList(CollectionLiterals.<MethodSpec>newArrayList());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public MethodSpec legacyCompileGetter(final EReference field, final TypeName fieldType, final String packageRoot, final EClass eClass, final Dsl dsl, final ClassName ePackageInterfaceType) {
    MethodSpec _xblockexpression = null;
    {
      final EClassifier ert = field.getEGenericType().getERawType();
      final TypeName rt = this.icu.scopedInterfaceTypeRef(ert, packageRoot);
      final boolean isMultiple = ((field.getUpperBound() > 1) || (field.getUpperBound() < 0));
      MethodSpec _xifexpression = null;
      if (isMultiple) {
        MethodSpec _xifexpression_1 = null;
        if (((ert.getInstanceClass() != null) && Objects.equal(ert.getInstanceClass(), Map.Entry.class))) {
          MethodSpec _xblockexpression_1 = null;
          {
            final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "key"));
            };
            final EStructuralFeature key = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function));
            final Function1<EStructuralFeature, Boolean> _function_1 = (EStructuralFeature it) -> {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "value"));
            };
            final EStructuralFeature value = IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>filter(field.getEType().eContents(), EStructuralFeature.class), _function_1));
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("get");
            String _firstUpper = StringExtensions.toFirstUpper(field.getName());
            _builder.append(_firstUpper);
            MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType);
            String _property = dsl.getDslProp().getProperty("truffle", "false");
            boolean _equals = Objects.equal(_property, "true");
            final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_2 = (MethodSpec.Builder it) -> {
              return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
            };
            MethodSpec.Builder _addModifiers = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns, Boolean.valueOf(_equals), _function_2).addModifiers(Modifier.PUBLIC);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("if (");
            String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
            _builder_1.append(_normalizeVarName);
            _builder_1.append(" == null) {");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
            _builder_1.append(_normalizeVarName_1, "\t");
            _builder_1.append(" = new $1T($2T.Literals.");
            EClassifier _eType = field.getEType();
            String _normalizeUpperField = this.namingUtils.normalizeUpperField(((EClass) _eType).getName());
            _builder_1.append(_normalizeUpperField, "\t");
            _builder_1.append(", $3T.class, this, $2T.");
            String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_1.append(_normalizeUpperField_1, "\t");
            _builder_1.append(");");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("}");
            _builder_1.newLine();
            _builder_1.append("return ");
            String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
            _builder_1.append(_normalizeVarName_2);
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            EClassifier _eType_1 = field.getEType();
            EClassifier _eType_2 = field.getEType();
            _xblockexpression_1 = _addModifiers.addCode(_builder_1.toString(), 
              ParameterizedTypeName.get(ClassName.get(EcoreEMap.class), this.icu.scopedInterfaceTypeRef(key.getEType(), packageRoot), 
                this.icu.scopedInterfaceTypeRef(value.getEType(), packageRoot)), ePackageInterfaceType, 
              ClassName.get(this.namingUtils.classImplementationPackageName(((EClass) _eType_1), packageRoot), 
                this.namingUtils.classImplementationClassName(((EClass) _eType_2)))).build();
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          MethodSpec _xifexpression_2 = null;
          EReference _eOpposite = field.getEOpposite();
          boolean _tripleNotEquals = (_eOpposite != null);
          if (_tripleNotEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("get");
            String _firstUpper = StringExtensions.toFirstUpper(field.getName());
            _builder.append(_firstUpper);
            MethodSpec.Builder _returns = MethodSpec.methodBuilder(_builder.toString()).returns(fieldType);
            String _property = dsl.getDslProp().getProperty("truffle", "false");
            boolean _equals = Objects.equal(_property, "true");
            final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
              return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
            };
            MethodSpec.Builder _addModifiers = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns, Boolean.valueOf(_equals), _function).addModifiers(Modifier.PUBLIC);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("if (");
            String _normalizeVarName = this.namingUtils.normalizeVarName(field.getName());
            _builder_1.append(_normalizeVarName);
            _builder_1.append(" == null) {");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            String _normalizeVarName_1 = this.namingUtils.normalizeVarName(field.getName());
            _builder_1.append(_normalizeVarName_1, "\t");
            _builder_1.append(" = new $1T($2T.class, this, $3T.");
            String _normalizeUpperField = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_1.append(_normalizeUpperField, "\t");
            _builder_1.append(", $3T.");
            EObject _eContainer = field.getEOpposite().eContainer();
            String _normalizeUpperField_1 = this.namingUtils.normalizeUpperField(field.getEOpposite().getName(), ((EClass) _eContainer).getName());
            _builder_1.append(_normalizeUpperField_1, "\t");
            _builder_1.append(");");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("}");
            _builder_1.newLine();
            _builder_1.append("return ");
            String _normalizeVarName_2 = this.namingUtils.normalizeVarName(field.getName());
            _builder_1.append(_normalizeVarName_2);
            _builder_1.append(";");
            _builder_1.newLineIfNotEmpty();
            _xifexpression_2 = _addModifiers.addCode(_builder_1.toString(), ParameterizedTypeName.get(ClassName.get(EObjectContainmentWithInverseEList.class), rt), rt, ePackageInterfaceType).build();
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("get");
            String _firstUpper_1 = StringExtensions.toFirstUpper(field.getName());
            _builder_2.append(_firstUpper_1);
            MethodSpec.Builder _returns_1 = MethodSpec.methodBuilder(_builder_2.toString()).returns(fieldType);
            String _property_1 = dsl.getDslProp().getProperty("truffle", "false");
            boolean _equals_1 = Objects.equal(_property_1, "true");
            final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_1 = (MethodSpec.Builder it) -> {
              return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
            };
            MethodSpec.Builder _addModifiers_1 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns_1, Boolean.valueOf(_equals_1), _function_1).addModifiers(Modifier.PUBLIC);
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("if (");
            String _normalizeVarName_3 = this.namingUtils.normalizeVarName(field.getName());
            _builder_3.append(_normalizeVarName_3);
            _builder_3.append(" == null) {");
            _builder_3.newLineIfNotEmpty();
            _builder_3.append("\t");
            String _normalizeVarName_4 = this.namingUtils.normalizeVarName(field.getName());
            _builder_3.append(_normalizeVarName_4, "\t");
            _builder_3.append(" = new $eoce:T($rt:T.class, this, $epit:T.");
            String _normalizeUpperField_2 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_3.append(_normalizeUpperField_2, "\t");
            _builder_3.append(");");
            _builder_3.newLineIfNotEmpty();
            _builder_3.append("}");
            _builder_3.newLine();
            _builder_3.append("return ");
            String _normalizeVarName_5 = this.namingUtils.normalizeVarName(field.getName());
            _builder_3.append(_normalizeVarName_5);
            _builder_3.append(";");
            _builder_3.newLineIfNotEmpty();
            ParameterizedTypeName _get = ParameterizedTypeName.get(ClassName.get(EObjectContainmentEList.class), rt);
            Pair<String, ParameterizedTypeName> _mappedTo = Pair.<String, ParameterizedTypeName>of("eoce", _get);
            Pair<String, ClassName> _mappedTo_1 = Pair.<String, ClassName>of("epit", ePackageInterfaceType);
            Pair<String, TypeName> _mappedTo_2 = Pair.<String, TypeName>of("rt", rt);
            _xifexpression_2 = _addModifiers_1.addNamedCode(_builder_3.toString(), 
              CollectionLiterals.<String, TypeName>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)).build();
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        MethodSpec _xifexpression_3 = null;
        if (((field.getEOpposite() != null) && field.getEOpposite().isContainment())) {
          StringConcatenation _builder_4 = new StringConcatenation();
          {
            String _name = field.getEType().getName();
            boolean _equals_2 = Objects.equal(_name, "EBoolean");
            if (_equals_2) {
              _builder_4.append("is");
            } else {
              _builder_4.append("get");
            }
          }
          String _firstUpper_2 = StringExtensions.toFirstUpper(field.getName());
          _builder_4.append(_firstUpper_2);
          MethodSpec.Builder _returns_2 = MethodSpec.methodBuilder(_builder_4.toString()).returns(fieldType);
          String _property_2 = dsl.getDslProp().getProperty("truffle", "false");
          boolean _equals_3 = Objects.equal(_property_2, "true");
          final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_2 = (MethodSpec.Builder it) -> {
            return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
          };
          MethodSpec.Builder _addModifiers_2 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns_2, Boolean.valueOf(_equals_3), _function_2).addModifiers(Modifier.PUBLIC);
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("if (eContainerFeatureID() != $1T.");
          String _normalizeUpperField_3 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
          _builder_5.append(_normalizeUpperField_3);
          _builder_5.append(") return null;");
          _builder_5.newLineIfNotEmpty();
          _builder_5.append("return ($2T)eInternalContainer();");
          _builder_5.newLine();
          _xifexpression_3 = _addModifiers_2.addCode(_builder_5.toString(), ePackageInterfaceType, fieldType).build();
        } else {
          MethodSpec _xifexpression_4 = null;
          boolean _isContainment = field.isContainment();
          if (_isContainment) {
            StringConcatenation _builder_6 = new StringConcatenation();
            {
              String _name_1 = field.getEType().getName();
              boolean _equals_4 = Objects.equal(_name_1, "EBoolean");
              if (_equals_4) {
                _builder_6.append("is");
              } else {
                _builder_6.append("get");
              }
            }
            String _firstUpper_3 = StringExtensions.toFirstUpper(field.getName());
            _builder_6.append(_firstUpper_3);
            MethodSpec.Builder _returns_3 = MethodSpec.methodBuilder(_builder_6.toString()).returns(fieldType);
            String _property_3 = dsl.getDslProp().getProperty("truffle", "false");
            boolean _equals_5 = Objects.equal(_property_3, "true");
            final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_3 = (MethodSpec.Builder it) -> {
              return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
            };
            MethodSpec.Builder _addModifiers_3 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns_3, Boolean.valueOf(_equals_5), _function_3).addModifiers(Modifier.PUBLIC);
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("return ");
            String _normalizeVarName_6 = this.namingUtils.normalizeVarName(field.getName());
            _builder_7.append(_normalizeVarName_6);
            _builder_7.append(";");
            _builder_7.newLineIfNotEmpty();
            _xifexpression_4 = _addModifiers_3.addCode(_builder_7.toString()).build();
          } else {
            StringConcatenation _builder_8 = new StringConcatenation();
            {
              String _name_2 = field.getEType().getName();
              boolean _equals_6 = Objects.equal(_name_2, "EBoolean");
              if (_equals_6) {
                _builder_8.append("is");
              } else {
                _builder_8.append("get");
              }
            }
            String _firstUpper_4 = StringExtensions.toFirstUpper(field.getName());
            _builder_8.append(_firstUpper_4);
            MethodSpec.Builder _returns_4 = MethodSpec.methodBuilder(_builder_8.toString()).returns(fieldType);
            String _property_4 = dsl.getDslProp().getProperty("truffle", "false");
            boolean _equals_7 = Objects.equal(_property_4, "true");
            final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_4 = (MethodSpec.Builder it) -> {
              return it.addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"));
            };
            MethodSpec.Builder _addModifiers_4 = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(_returns_4, Boolean.valueOf(_equals_7), _function_4).addModifiers(Modifier.PUBLIC);
            StringConcatenation _builder_9 = new StringConcatenation();
            _builder_9.append("if (");
            String _normalizeVarName_7 = this.namingUtils.normalizeVarName(field.getName());
            _builder_9.append(_normalizeVarName_7);
            _builder_9.append(" != null && ");
            String _name_3 = field.getName();
            _builder_9.append(_name_3);
            _builder_9.append(".eIsProxy()) {");
            _builder_9.newLineIfNotEmpty();
            _builder_9.append("\t");
            _builder_9.append("$T ");
            String _normalizeVarOldName = this.namingUtils.normalizeVarOldName(field.getName());
            _builder_9.append(_normalizeVarOldName, "\t");
            _builder_9.append(" = ($T) ");
            String _normalizeVarName_8 = this.namingUtils.normalizeVarName(field.getName());
            _builder_9.append(_normalizeVarName_8, "\t");
            _builder_9.append(";");
            _builder_9.newLineIfNotEmpty();
            _builder_9.append("\t");
            String _normalizeVarName_9 = this.namingUtils.normalizeVarName(field.getName());
            _builder_9.append(_normalizeVarName_9, "\t");
            _builder_9.append(" = ($T) eResolveProxy(");
            String _normalizeVarOldName_1 = this.namingUtils.normalizeVarOldName(field.getName());
            _builder_9.append(_normalizeVarOldName_1, "\t");
            _builder_9.append(");");
            _builder_9.newLineIfNotEmpty();
            _builder_9.append("\t");
            _builder_9.append("if (");
            String _normalizeVarName_10 = this.namingUtils.normalizeVarName(field.getName());
            _builder_9.append(_normalizeVarName_10, "\t");
            _builder_9.append(" != ");
            String _normalizeVarOldName_2 = this.namingUtils.normalizeVarOldName(field.getName());
            _builder_9.append(_normalizeVarOldName_2, "\t");
            _builder_9.append(") {");
            _builder_9.newLineIfNotEmpty();
            _builder_9.append("\t\t");
            _builder_9.append("if (eNotificationRequired())");
            _builder_9.newLine();
            _builder_9.append("\t\t\t");
            _builder_9.append("eNotify(new $T(this, $T.RESOLVE, $T.");
            String _normalizeUpperField_4 = this.namingUtils.normalizeUpperField(field.getName(), eClass.getName());
            _builder_9.append(_normalizeUpperField_4, "\t\t\t");
            _builder_9.append(",");
            _builder_9.newLineIfNotEmpty();
            _builder_9.append("\t\t\t\t\t");
            String _normalizeVarOldName_3 = this.namingUtils.normalizeVarOldName(field.getName());
            _builder_9.append(_normalizeVarOldName_3, "\t\t\t\t\t");
            _builder_9.append(", ");
            String _normalizeVarName_11 = this.namingUtils.normalizeVarName(field.getName());
            _builder_9.append(_normalizeVarName_11, "\t\t\t\t\t");
            _builder_9.append("));");
            _builder_9.newLineIfNotEmpty();
            _builder_9.append("\t");
            _builder_9.append("}");
            _builder_9.newLine();
            _builder_9.append("}");
            _builder_9.newLine();
            _builder_9.append("return ");
            String _normalizeVarName_12 = this.namingUtils.normalizeVarName(field.getName());
            _builder_9.append(_normalizeVarName_12);
            _builder_9.append(";");
            _builder_9.newLineIfNotEmpty();
            _xifexpression_4 = _addModifiers_4.addCode(_builder_9.toString(), TypeName.get(InternalEObject.class), TypeName.get(InternalEObject.class), fieldType, 
              TypeName.get(ENotificationImpl.class), TypeName.get(Notification.class), ePackageInterfaceType).build();
          }
          _xifexpression_3 = _xifexpression_4;
        }
        _xifexpression = _xifexpression_3;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public List<MethodSpec> compileGetter(final EStructuralFeature field, final TypeName fieldType, final String packageRoot, final EClass eClass, final Dsl dsl, final ClassName ePackageInterfaceType, final boolean isMapElement) {
    if (field instanceof EAttribute) {
      return _compileGetter((EAttribute)field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement);
    } else if (field instanceof EReference) {
      return _compileGetter((EReference)field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(field, fieldType, packageRoot, eClass, dsl, ePackageInterfaceType, isMapElement).toString());
    }
  }
}
