package org.eclipse.emf.ecoretools.ale.compiler.revisitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import javax.lang.model.element.Modifier;
import org.eclipse.acceleo.query.ast.And;
import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.ast.BooleanLiteral;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.CallType;
import org.eclipse.acceleo.query.ast.EnumLiteral;
import org.eclipse.acceleo.query.ast.ErrorBinding;
import org.eclipse.acceleo.query.ast.ErrorCall;
import org.eclipse.acceleo.query.ast.ErrorConditional;
import org.eclipse.acceleo.query.ast.ErrorExpression;
import org.eclipse.acceleo.query.ast.ErrorStringLiteral;
import org.eclipse.acceleo.query.ast.ErrorTypeLiteral;
import org.eclipse.acceleo.query.ast.ErrorVariableDeclaration;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.ast.Implies;
import org.eclipse.acceleo.query.ast.IntegerLiteral;
import org.eclipse.acceleo.query.ast.Lambda;
import org.eclipse.acceleo.query.ast.Let;
import org.eclipse.acceleo.query.ast.NullLiteral;
import org.eclipse.acceleo.query.ast.Or;
import org.eclipse.acceleo.query.ast.RealLiteral;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.acceleo.query.ast.SetInExtensionLiteral;
import org.eclipse.acceleo.query.ast.StringLiteral;
import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.RevisitorNamingUtils;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.IValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class ALERevisitorImplementationCompiler {
  @Data
  public static class ResolvedClass {
    private final ExtendedClass aleCls;
    
    public final EClassifier eCls;
    
    public ResolvedClass(final ExtendedClass aleCls, final EClassifier eCls) {
      super();
      this.aleCls = aleCls;
      this.eCls = eCls;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.aleCls== null) ? 0 : this.aleCls.hashCode());
      return prime * result + ((this.eCls== null) ? 0 : this.eCls.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      ALERevisitorImplementationCompiler.ResolvedClass other = (ALERevisitorImplementationCompiler.ResolvedClass) obj;
      if (this.aleCls == null) {
        if (other.aleCls != null)
          return false;
      } else if (!this.aleCls.equals(other.aleCls))
        return false;
      if (this.eCls == null) {
        if (other.eCls != null)
          return false;
      } else if (!this.eCls.equals(other.eCls))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("aleCls", this.aleCls);
      b.add("eCls", this.eCls);
      return b.toString();
    }
    
    @Pure
    public ExtendedClass getAleCls() {
      return this.aleCls;
    }
    
    @Pure
    public EClassifier getECls() {
      return this.eCls;
    }
  }
  
  @Extension
  private RevisitorNamingUtils _revisitorNamingUtils = new RevisitorNamingUtils();
  
  @Extension
  private EcoreUtils _ecoreUtils = new EcoreUtils();
  
  private List<ParseResult<ModelUnit>> parsedSemantics;
  
  private final IQueryEnvironment queryEnvironment;
  
  private final Map<String, Class<?>> registeredServices = CollectionLiterals.<String, Class<?>>newHashMap();
  
  private final JavaExtensionsManager javaExtensions;
  
  private Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private Dsl dsl;
  
  private List<ALERevisitorImplementationCompiler.ResolvedClass> resolved;
  
  private BaseValidator base;
  
  public ALERevisitorImplementationCompiler() {
    this.queryEnvironment = this.createQueryEnvironment(false, null);
    this.queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
    this.queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
    this.javaExtensions = JavaExtensionsManager.createManagerWithOverride();
    this.javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {
      @Override
      public void loaded(final String arg0, final Class<?> arg1) {
        ALERevisitorImplementationCompiler.this.registeredServices.put(arg0, arg1);
      }
      
      @Override
      public void notFound(final String arg0) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(arg0);
        _builder.append(" not found during services registration");
        throw new RuntimeException(_builder.toString());
      }
      
      @Override
      public void unloaded(final String arg0, final Class<?> arg1) {
        ALERevisitorImplementationCompiler.this.registeredServices.remove(arg0);
      }
    });
  }
  
  public IStatus compile(final String projectName, final File projectRoot, final Dsl dsl) {
    IStatus _xblockexpression = null;
    {
      this.dsl = dsl;
      this.parsedSemantics = new DslBuilder(this.queryEnvironment).parse(dsl);
      this.registerServices(projectName);
      this.compile(projectRoot);
      _xblockexpression = Status.OK_STATUS;
    }
    return _xblockexpression;
  }
  
  public void registerServices(final String projectName) {
    this.javaExtensions.updateScope(CollectionLiterals.<String>newHashSet(), Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(projectName)));
    final Function1<ParseResult<ModelUnit>, ModelUnit> _function = (ParseResult<ModelUnit> it) -> {
      return it.getRoot();
    };
    final Function1<ModelUnit, Boolean> _function_1 = (ModelUnit it) -> {
      return Boolean.valueOf((it != null));
    };
    final Function1<ModelUnit, EList<String>> _function_2 = (ModelUnit it) -> {
      return it.getServices();
    };
    Iterable<String> _flatten = Iterables.<String>concat(IterableExtensions.<ModelUnit, EList<String>>map(IterableExtensions.<ModelUnit>filter(ListExtensions.<ParseResult<ModelUnit>, ModelUnit>map(this.parsedSemantics, _function), _function_1), _function_2));
    String _name = TrigoServices.class.getName();
    final Iterable<String> services = Iterables.<String>concat(_flatten, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name)));
    this.registerServices(IterableExtensions.<String>toList(services));
  }
  
  public void registerServices(final List<String> services) {
    final Consumer<String> _function = (String it) -> {
      this.javaExtensions.addImport(it);
    };
    services.forEach(_function);
    this.javaExtensions.reloadIfNeeded();
  }
  
  private IQueryEnvironment createQueryEnvironment(final boolean b, final Object object) {
    IQueryEnvironment _xblockexpression = null;
    {
      final IQueryEnvironment newEnv = new ExtensionEnvironment();
      newEnv.registerEPackage(EcorePackage.eINSTANCE);
      newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), 
        EStringToStringMapEntryImpl.class);
      _xblockexpression = newEnv;
    }
    return _xblockexpression;
  }
  
  private void compile(final File projectRoot) {
    try {
      final File compileDirectory = new File(projectRoot, "revisitor-comp");
      boolean _exists = compileDirectory.exists();
      if (_exists) {
        final Function<Path, File> _function = (Path it) -> {
          return it.toFile();
        };
        final Consumer<File> _function_1 = (File it) -> {
          it.delete();
        };
        Files.walk(compileDirectory.toPath()).sorted(Comparator.<Path>reverseOrder()).<File>map(_function).forEach(_function_1);
      }
      TypeValidator _typeValidator = new TypeValidator();
      BaseValidator _baseValidator = new BaseValidator(this.queryEnvironment, Collections.<IValidator>unmodifiableList(CollectionLiterals.<IValidator>newArrayList(_typeValidator)));
      this.base = _baseValidator;
      this.base.validate(this.parsedSemantics);
      final ArrayList<ExtendedClass> aleClasses = CollectionLiterals.<ExtendedClass>newArrayList();
      for (final ParseResult<ModelUnit> pr : this.parsedSemantics) {
        {
          ModelUnit root = pr.getRoot();
          EList<ExtendedClass> _classExtensions = root.getClassExtensions();
          Iterables.<ExtendedClass>addAll(aleClasses, _classExtensions);
        }
      }
      final Function1<String, String> _function_2 = (String it) -> {
        return it;
      };
      final Function1<String, Pair<EPackage, GenModel>> _function_3 = (String it) -> {
        EPackage _loadEPackage = this._ecoreUtils.loadEPackage(it);
        GenModel _loadGenmodel = this._ecoreUtils.loadGenmodel(it.replaceAll(".ecore$", ".genmodel"));
        return Pair.<EPackage, GenModel>of(_loadEPackage, _loadGenmodel);
      };
      this.syntaxes = IterableExtensions.<String, String, Pair<EPackage, GenModel>>toMap(this.dsl.getAllSyntaxes(), _function_2, _function_3);
      final Pair<EPackage, GenModel> tmp = this.syntaxes.get(IterableExtensions.<String>head(this.dsl.getAllSyntaxes()));
      final EPackage syntax = tmp.getKey();
      final GenPackage genSyntax = IterableExtensions.<GenPackage>head(tmp.getValue().getGenPackages());
      this.resolved = this.resolve(aleClasses, syntax);
      final String interfaceName = this._revisitorNamingUtils.getRevisitorImplementationClass(this.dsl);
      Comparator<ALERevisitorImplementationCompiler.ResolvedClass> _comparing = Comparator.<ALERevisitorImplementationCompiler.ResolvedClass, String>comparing(new Function<ALERevisitorImplementationCompiler.ResolvedClass, String>() {
        @Override
        public String apply(final ALERevisitorImplementationCompiler.ResolvedClass arg0) {
          return arg0.eCls.getName();
        }
      });
      final Comparator<ALERevisitorImplementationCompiler.ResolvedClass> comparator = _comparing.<String>thenComparing(new Function<ALERevisitorImplementationCompiler.ResolvedClass, String>() {
        @Override
        public String apply(final ALERevisitorImplementationCompiler.ResolvedClass arg0) {
          return arg0.eCls.getEPackage().getName();
        }
      });
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        String _instanceClassName = it.eCls.getInstanceClassName();
        return Boolean.valueOf((!Objects.equal(_instanceClassName, "java.util.Map$Entry")));
      };
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function_5 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        return Boolean.valueOf((it.eCls instanceof EClass));
      };
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, ClassName> _function_6 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        return this._revisitorNamingUtils.getRevisitorOperationInterfaceClassName(this.dsl, ((EClass) it.eCls));
      };
      final List<ClassName> typeParams = ListExtensions.<ALERevisitorImplementationCompiler.ResolvedClass, ClassName>map(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>sortWith(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4), _function_5), comparator), _function_6);
      final ParameterizedTypeName fullInterfaceType = ParameterizedTypeName.get(
        ClassName.get(this._revisitorNamingUtils.getRevisitorPackageFqn(genSyntax), this._revisitorNamingUtils.getRevisitorInterfaceName(genSyntax)), ((TypeName[])Conversions.unwrapArray(typeParams, TypeName.class)));
      final Function1<EClass, Boolean> _function_7 = (EClass it) -> {
        String _instanceClassName = it.getInstanceClassName();
        return Boolean.valueOf((!Objects.equal(_instanceClassName, "java.util.Map$Entry")));
      };
      final Function1<EClass, MethodSpec> _function_8 = (EClass it) -> {
        TypeName _solveType = this.solveType(it);
        MethodSpec.Builder _addParameter = MethodSpec.methodBuilder(this._revisitorNamingUtils.getDenotationName(it)).returns(this._revisitorNamingUtils.getRevisitorOperationInterfaceClassName(this.dsl, it)).addParameter(((TypeName) _solveType), "it");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return new $T(it, this);");
        _builder.newLine();
        return _addParameter.addCode(_builder.toString(), 
          this._revisitorNamingUtils.getRevisitorOperationImplementationClassName(this.dsl, it)).addModifiers(Modifier.DEFAULT, Modifier.PUBLIC).build();
      };
      final TypeSpec revisitorInterface = TypeSpec.interfaceBuilder(interfaceName).addSuperinterface(fullInterfaceType).addModifiers(Modifier.PUBLIC).addMethods(IterableExtensions.<EClass, MethodSpec>map(IterableExtensions.<EClass>filter(this._ecoreUtils.getAllClasses(syntax), _function_7), _function_8)).build();
      final JavaFile javaFile = JavaFile.builder(this._revisitorNamingUtils.getRevisitorImplementationPackage(this.dsl), revisitorInterface).indent("\t").build();
      javaFile.writeTo(compileDirectory);
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function_9 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        return Boolean.valueOf(((!Objects.equal(it.eCls.getInstanceClassName(), "java.util.Map$Entry")) && (it.eCls instanceof EClass)));
      };
      final Consumer<ALERevisitorImplementationCompiler.ResolvedClass> _function_10 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        try {
          final Function1<EClass, ClassName> _function_11 = (EClass it_1) -> {
            return this._revisitorNamingUtils.getRevisitorOperationInterfaceClassName(this.dsl, it_1);
          };
          TypeSpec.Builder _addModifiers = TypeSpec.interfaceBuilder(this._revisitorNamingUtils.getRevisitorOperationInterfaceClassName(((EClass) it.eCls))).addSuperinterfaces(ListExtensions.<EClass, ClassName>map(((EClass) it.eCls).getESuperTypes(), _function_11)).addModifiers(Modifier.PUBLIC);
          List<MethodSpec> _elvis = null;
          ExtendedClass _aleCls = it.aleCls;
          EList<Method> _methods = null;
          if (_aleCls!=null) {
            _methods=_aleCls.getMethods();
          }
          List<MethodSpec> _map = null;
          if (_methods!=null) {
            final Function1<Method, MethodSpec> _function_12 = (Method it_1) -> {
              final Function1<EParameter, ParameterSpec> _function_13 = (EParameter it_2) -> {
                ParameterSpec _xifexpression = null;
                Class<?> _instanceClass = it_2.getEType().getInstanceClass();
                boolean _tripleNotEquals = (_instanceClass != null);
                if (_tripleNotEquals) {
                  _xifexpression = ParameterSpec.builder(it_2.getEType().getInstanceClass(), it_2.getName()).build();
                } else {
                  _xifexpression = ParameterSpec.builder(this.resolveType(it_2.getEType()), it_2.getName()).build();
                }
                return _xifexpression;
              };
              return this.returnType(MethodSpec.methodBuilder(it_1.getOperationRef().getName()).addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT), it_1.getOperationRef().getEType()).addParameters(ListExtensions.<EParameter, ParameterSpec>map(it_1.getOperationRef().getEParameters(), _function_13)).build();
            };
            _map=ListExtensions.<Method, MethodSpec>map(_methods, _function_12);
          }
          if (_map != null) {
            _elvis = _map;
          } else {
            ArrayList<MethodSpec> _newArrayList = CollectionLiterals.<MethodSpec>newArrayList();
            _elvis = _newArrayList;
          }
          final TypeSpec operationInterface = _addModifiers.addMethods(_elvis).build();
          StringConcatenation _builder = new StringConcatenation();
          String _revisitorOperationInterfacePackage = this._revisitorNamingUtils.getRevisitorOperationInterfacePackage(this.dsl);
          _builder.append(_revisitorOperationInterfacePackage);
          final JavaFile operationInterfaceFile = JavaFile.builder(_builder.toString(), operationInterface).indent("\t").build();
          operationInterfaceFile.writeTo(compileDirectory);
          final FieldSpec revField = FieldSpec.builder(fullInterfaceType, "rev", Modifier.PRIVATE).build();
          final FieldSpec objField = FieldSpec.builder(ClassName.get(this.getEcoreInterfacesPackage(), it.eCls.getName()), "obj", 
            Modifier.PRIVATE).build();
          ClassName _get = ClassName.get(operationInterfaceFile.packageName, operationInterface.name);
          final Function0<Boolean> _function_13 = () -> {
            boolean _isEmpty = ((EClass) it.eCls).getESuperTypes().isEmpty();
            return Boolean.valueOf((!_isEmpty));
          };
          MethodSpec.Builder _addConditionalStatement = this.<Object>addConditionalStatement(MethodSpec.constructorBuilder().addParameter(objField.type, "obj").addParameter(revField.type, 
            "rev"), _function_13, "super(obj, rev)");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("this.obj = obj");
          MethodSpec.Builder _addStatement = _addConditionalStatement.addStatement(_builder_1.toString());
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("this.rev = rev");
          TypeSpec.Builder _addModifiers_1 = this.superOperationImpl(TypeSpec.classBuilder(this._revisitorNamingUtils.getRevisitorOperationImplementationClassName(((EClass) it.eCls))).addSuperinterfaces(
            Collections.<TypeName>unmodifiableList(CollectionLiterals.<TypeName>newArrayList(_get))), 
            IterableExtensions.<EClass>head(((EClass) it.eCls).getESuperTypes())).addField(revField).addField(objField).addModifiers(Modifier.PUBLIC).addMethod(
            _addStatement.addStatement(_builder_2.toString()).addModifiers(
              Modifier.PUBLIC).build()).addModifiers(Modifier.PUBLIC);
          List<MethodSpec> _elvis_1 = null;
          ExtendedClass _aleCls_1 = it.aleCls;
          EList<Method> _methods_1 = null;
          if (_aleCls_1!=null) {
            _methods_1=_aleCls_1.getMethods();
          }
          List<MethodSpec> _map_1 = null;
          if (_methods_1!=null) {
            final Function1<Method, MethodSpec> _function_14 = (Method it_1) -> {
              final Function1<EParameter, ParameterSpec> _function_15 = (EParameter it_2) -> {
                ParameterSpec _xifexpression = null;
                Class<?> _instanceClass = it_2.getEType().getInstanceClass();
                boolean _tripleNotEquals = (_instanceClass != null);
                if (_tripleNotEquals) {
                  _xifexpression = ParameterSpec.builder(it_2.getEType().getInstanceClass(), it_2.getName()).build();
                } else {
                  _xifexpression = ParameterSpec.builder(this.resolveType(it_2.getEType()), it_2.getName()).build();
                }
                return _xifexpression;
              };
              return this.closeMethod(this.compileBody(this.openMethod(this.returnType(MethodSpec.methodBuilder(it_1.getOperationRef().getName()).addModifiers(Modifier.PUBLIC), 
                it_1.getOperationRef().getEType()).addParameters(ListExtensions.<EParameter, ParameterSpec>map(it_1.getOperationRef().getEParameters(), _function_15)), it_1.getOperationRef().getEType()), it_1.getBody()), 
                it_1.getOperationRef().getEType()).build();
            };
            _map_1=ListExtensions.<Method, MethodSpec>map(_methods_1, _function_14);
          }
          if (_map_1 != null) {
            _elvis_1 = _map_1;
          } else {
            ArrayList<MethodSpec> _newArrayList_1 = CollectionLiterals.<MethodSpec>newArrayList();
            _elvis_1 = _newArrayList_1;
          }
          final TypeSpec operationImplementation = _addModifiers_1.addMethods(_elvis_1).build();
          StringConcatenation _builder_3 = new StringConcatenation();
          String _revisitorOperationImplementationPackage = this._revisitorNamingUtils.getRevisitorOperationImplementationPackage(this.dsl);
          _builder_3.append(_revisitorOperationImplementationPackage);
          final JavaFile operationImplementationFile = JavaFile.builder(_builder_3.toString(), operationImplementation).build();
          operationImplementationFile.writeTo(compileDirectory);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            InputOutput.<ALERevisitorImplementationCompiler.ResolvedClass>println(it);
            e.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      };
      IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function_9).forEach(_function_10);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public MethodSpec.Builder openMethod(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("$T result");
      _xifexpression = builder.addStatement(_builder.toString(), this.resolveType2(type));
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public MethodSpec.Builder closeMethod(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      _xifexpression = builder.addStatement("return result");
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeatureAssignment body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final IType t = IterableExtensions.<IType>head(this.infereType(body.getTarget()));
      MethodSpec.Builder _xifexpression = null;
      if (((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
        StringConcatenation _builder = new StringConcatenation();
        CodeBlock _compileExpression = this.compileExpression(body.getTarget());
        _builder.append(_compileExpression);
        _builder.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
        _builder.append(_firstUpper);
        _builder.append("().add(");
        CodeBlock _compileExpression_1 = this.compileExpression(body.getValue());
        _builder.append(_compileExpression_1);
        _builder.append(")");
        _xifexpression = builderSeed.addStatement(_builder.toString());
      } else {
        MethodSpec.Builder _xifexpression_1 = null;
        if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
          StringConcatenation _builder_1 = new StringConcatenation();
          CodeBlock _compileExpression_2 = this.compileExpression(body.getTarget());
          _builder_1.append(_compileExpression_2);
          _builder_1.append(".set");
          String _firstUpper_1 = StringExtensions.toFirstUpper(body.getTargetFeature());
          _builder_1.append(_firstUpper_1);
          _builder_1.append("(");
          CodeBlock _compileExpression_3 = this.compileExpression(body.getValue());
          _builder_1.append(_compileExpression_3);
          _builder_1.append(")");
          _xifexpression_1 = builderSeed.addStatement(_builder_1.toString());
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          CodeBlock _compileExpression_4 = this.compileExpression(body.getTarget());
          _builder_2.append(_compileExpression_4);
          _builder_2.append(".");
          String _targetFeature = body.getTargetFeature();
          _builder_2.append(_targetFeature);
          _builder_2.append(" = ");
          CodeBlock _compileExpression_5 = this.compileExpression(body.getValue());
          _builder_2.append(_compileExpression_5);
          _xifexpression_1 = builderSeed.addStatement(_builder_2.toString());
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeatureInsert body) {
    StringConcatenation _builder = new StringConcatenation();
    CodeBlock _compileExpression = this.compileExpression(body.getTarget());
    _builder.append(_compileExpression);
    _builder.append(".get");
    String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
    _builder.append(_firstUpper);
    _builder.append("().add(");
    CodeBlock _compileExpression_1 = this.compileExpression(body.getValue());
    _builder.append(_compileExpression_1);
    _builder.append(")");
    return builderSeed.addStatement(_builder.toString());
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeatureRemove body) {
    StringConcatenation _builder = new StringConcatenation();
    CodeBlock _compileExpression = this.compileExpression(body.getTarget());
    _builder.append(_compileExpression);
    _builder.append(".get");
    String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
    _builder.append(_firstUpper);
    _builder.append("().remove(");
    CodeBlock _compileExpression_1 = this.compileExpression(body.getValue());
    _builder.append(_compileExpression_1);
    _builder.append(")");
    return builderSeed.addStatement(_builder.toString());
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final VariableAssignment body) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = body.getName();
    _builder.append(_name);
    _builder.append(" = $L");
    return builderSeed.addStatement(_builder.toString(), this.compileExpression(body.getValue()));
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final VariableDeclaration body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final IType inft = IterableExtensions.<IType>head(this.infereType(body.getInitialValue()));
      MethodSpec.Builder _xifexpression = null;
      if ((inft instanceof SequenceType)) {
        MethodSpec.Builder _xblockexpression_1 = null;
        {
          Object _type = ((SequenceType)inft).getCollectionType().getType();
          final ParameterizedTypeName t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"), 
            ClassName.get(((Class<?>) _type)));
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("$T $L = (($T) ($L))");
          _xblockexpression_1 = builderSeed.addStatement(_builder.toString(), t, body.getName(), t, this.compileExpression(body.getInitialValue()));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        MethodSpec.Builder _xblockexpression_2 = null;
        {
          final TypeName t = this.solveType(body.getType());
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("$T $L = (($T) ($L))");
          _xblockexpression_2 = builderSeed.addStatement(_builder.toString(), t, body.getName(), t, this.compileExpression(body.getInitialValue()));
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final Block body) {
    final Function2<MethodSpec.Builder, Statement, MethodSpec.Builder> _function = (MethodSpec.Builder builder, Statement statement) -> {
      return this.compileBody(builder, statement);
    };
    return IterableExtensions.<Statement, MethodSpec.Builder>fold(body.getStatements(), builderSeed, _function);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final ExpressionStatement body) {
    return builderSeed.addStatement(this.compileExpression(body.getExpression()));
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeaturePut body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new $T(\"FeaturePut not implemented\")");
    return builderSeed.addStatement(_builder.toString(), RuntimeException.class);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final ForEach body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      IType _head = IterableExtensions.<IType>head(this.infereType(body.getCollectionExpression()));
      final SequenceType lt = ((SequenceType) _head);
      MethodSpec.Builder _xifexpression = null;
      Object _type = lt.getCollectionType().getType();
      if ((_type instanceof EClass)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("for($T $L: ");
        CodeBlock _compileExpression = this.compileExpression(body.getCollectionExpression());
        _builder.append(_compileExpression);
        _builder.append(")");
        Object _type_1 = lt.getCollectionType().getType();
        _xifexpression = this.compileBody(builderSeed.beginControlFlow(_builder.toString(), 
          this.solveType(((EClass) _type_1)), body.getVariable()), body.getBody()).endControlFlow();
      } else {
        MethodSpec.Builder _xblockexpression_1 = null;
        {
          final TypeName iteratorType = this.resolveType2(lt.getCollectionType().getType());
          final String iteratorName = body.getVariable();
          final CodeBlock iterable = this.compileExpression(body.getCollectionExpression());
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("for($T $L: $L)");
          _xblockexpression_1 = this.compileBody(builderSeed.beginControlFlow(_builder_1.toString(), iteratorType, iteratorName, iterable), body.getBody()).endControlFlow();
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final If body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if($L)");
      MethodSpec.Builder ret = this.compileBody(builderSeed.beginControlFlow(_builder.toString(), this.compileExpression(IterableExtensions.<ConditionalBlock>head(body.getBlocks()).getCondition())), 
        IterableExtensions.<ConditionalBlock>head(body.getBlocks()).getBlock()).endControlFlow();
      Iterable<ConditionalBlock> _tail = IterableExtensions.<ConditionalBlock>tail(body.getBlocks());
      for (final ConditionalBlock x : _tail) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("else if ($L");
        ret = this.compileBody(ret.beginControlFlow(_builder_1.toString(), this.compileExpression(x.getCondition())), x.getBlock()).endControlFlow();
      }
      Block _else = body.getElse();
      boolean _tripleNotEquals = (_else != null);
      if (_tripleNotEquals) {
        ret = this.compileBody(ret.beginControlFlow("else"), body.getElse()).endControlFlow();
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final ConditionalBlock body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new $T(\"ConditionalBlock not implemented\")");
    return builderSeed.addStatement(_builder.toString(), RuntimeException.class);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final While body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final MethodSpec.Builder a = builderSeed.beginControlFlow("while ($L)", this.compileExpression(body.getCondition()));
      _xblockexpression = this.compileBody(a, body.getBody()).endControlFlow();
    }
    return _xblockexpression;
  }
  
  protected TypeName _resolveType2(final Object type) {
    return null;
  }
  
  protected TypeName _resolveType2(final Class<?> clazz) {
    return TypeName.get(clazz);
  }
  
  protected TypeName _resolveType2(final EClassifier type) {
    TypeName _xifexpression = null;
    Class<?> _instanceClass = type.getInstanceClass();
    boolean _tripleNotEquals = (_instanceClass != null);
    if (_tripleNotEquals) {
      _xifexpression = TypeName.get(type.getInstanceClass());
    } else {
      _xifexpression = this.resolveType(type);
    }
    return _xifexpression;
  }
  
  protected CodeBlock _compileExpression(final Call call) {
    CodeBlock _switchResult = null;
    String _serviceName = call.getServiceName();
    if (_serviceName != null) {
      switch (_serviceName) {
        case "not":
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("!($L)");
          _switchResult = CodeBlock.of(_builder.toString(), this.compileExpression(call.getArguments().get(0)));
          break;
        case "greaterThan":
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("($L) > ($L)");
          _switchResult = CodeBlock.of(_builder_1.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "differs":
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("($L) != ($L)");
          _switchResult = CodeBlock.of(_builder_2.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "sub":
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("($L) - ($L)");
          _switchResult = CodeBlock.of(_builder_3.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "add":
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("($L) + ($L)");
          _switchResult = CodeBlock.of(_builder_4.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "divOp":
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("($L) / ($L)");
          _switchResult = CodeBlock.of(_builder_5.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "equals":
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("$T.equals(($L), ($L))");
          _switchResult = CodeBlock.of(_builder_6.toString(), ClassName.get(java.util.Objects.class), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "lessThan":
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("($L) < ($L)");
          _switchResult = CodeBlock.of(_builder_7.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "lessThanEqual":
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("($L) <= ($L)");
          _switchResult = CodeBlock.of(_builder_8.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "greaterThanEqual":
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("($L) >= ($L)");
          _switchResult = CodeBlock.of(_builder_9.toString(), this.compileExpression(call.getArguments().get(0)), 
            this.compileExpression(call.getArguments().get(1)));
          break;
        case "mult":
          StringConcatenation _builder_10 = new StringConcatenation();
          _builder_10.append("(");
          CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0));
          _builder_10.append(_compileExpression);
          _builder_10.append(") * (");
          CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1));
          _builder_10.append(_compileExpression_1);
          _builder_10.append(")");
          _switchResult = CodeBlock.of(_builder_10.toString());
          break;
        case "unaryMin":
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append("-(");
          CodeBlock _compileExpression_2 = this.compileExpression(call.getArguments().get(0));
          _builder_11.append(_compileExpression_2);
          _builder_11.append(")");
          _switchResult = CodeBlock.of(_builder_11.toString());
          break;
        case "first":
          CodeBlock _xifexpression = null;
          CallType _type = call.getType();
          boolean _equals = Objects.equal(_type, CallType.COLLECTIONCALL);
          if (_equals) {
            StringConcatenation _builder_12 = new StringConcatenation();
            _builder_12.append("$T.head($L)");
            _xifexpression = CodeBlock.of(_builder_12.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_13 = new StringConcatenation();
            _builder_13.append("/*FIRST ");
            _builder_13.append(call);
            _builder_13.append("*/");
            _xifexpression = CodeBlock.of(_builder_13.toString());
          }
          _switchResult = _xifexpression;
          break;
        case "size":
          CodeBlock _xifexpression_1 = null;
          CallType _type_1 = call.getType();
          boolean _equals_1 = Objects.equal(_type_1, CallType.COLLECTIONCALL);
          if (_equals_1) {
            StringConcatenation _builder_14 = new StringConcatenation();
            _builder_14.append("$T.size($L)");
            _xifexpression_1 = CodeBlock.of(_builder_14.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_15 = new StringConcatenation();
            _builder_15.append("/*FIRST ");
            _builder_15.append(call);
            _builder_15.append("*/");
            _xifexpression_1 = CodeBlock.of(_builder_15.toString());
          }
          _switchResult = _xifexpression_1;
          break;
        case "at":
          CodeBlock _xifexpression_2 = null;
          CallType _type_2 = call.getType();
          boolean _equals_2 = Objects.equal(_type_2, CallType.COLLECTIONCALL);
          if (_equals_2) {
            StringConcatenation _builder_16 = new StringConcatenation();
            _builder_16.append("$T.get($L, $L)");
            _xifexpression_2 = CodeBlock.of(_builder_16.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_17 = new StringConcatenation();
            _builder_17.append("/*FIRST ");
            _builder_17.append(call);
            _builder_17.append("*/");
            _xifexpression_2 = CodeBlock.of(_builder_17.toString());
          }
          _switchResult = _xifexpression_2;
          break;
        case "select":
          CodeBlock _xifexpression_3 = null;
          CallType _type_3 = call.getType();
          boolean _equals_3 = Objects.equal(_type_3, CallType.COLLECTIONCALL);
          if (_equals_3) {
            StringConcatenation _builder_18 = new StringConcatenation();
            _builder_18.append("$T.select($L, $L)");
            _xifexpression_3 = CodeBlock.of(_builder_18.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_19 = new StringConcatenation();
            _builder_19.append("/*FIRST ");
            _builder_19.append(call);
            _builder_19.append("*/");
            _xifexpression_3 = CodeBlock.of(_builder_19.toString());
          }
          _switchResult = _xifexpression_3;
          break;
        case "filter":
          CodeBlock _xifexpression_4 = null;
          CallType _type_4 = call.getType();
          boolean _equals_4 = Objects.equal(_type_4, CallType.COLLECTIONCALL);
          if (_equals_4) {
            CodeBlock _xblockexpression = null;
            {
              final IType t = IterableExtensions.<IType>head(this.infereType(call.getArguments().get(1)));
              CodeBlock _xifexpression_5 = null;
              if ((t instanceof EClassifierType)) {
                StringConcatenation _builder_20 = new StringConcatenation();
                _builder_20.append("$T.select($L, it -> it instanceof $L)");
                _xifexpression_5 = CodeBlock.of(_builder_20.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
              } else {
                StringConcatenation _builder_21 = new StringConcatenation();
                _builder_21.append("$T.select($L, $L)");
                _xifexpression_5 = CodeBlock.of(_builder_21.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
              }
              _xblockexpression = _xifexpression_5;
            }
            _xifexpression_4 = _xblockexpression;
          } else {
            StringConcatenation _builder_20 = new StringConcatenation();
            _builder_20.append("/*FIRST ");
            _builder_20.append(call);
            _builder_20.append("*/");
            _xifexpression_4 = CodeBlock.of(_builder_20.toString());
          }
          _switchResult = _xifexpression_4;
          break;
        case "exists":
          CodeBlock _xifexpression_5 = null;
          CallType _type_5 = call.getType();
          boolean _equals_5 = Objects.equal(_type_5, CallType.COLLECTIONCALL);
          if (_equals_5) {
            StringConcatenation _builder_21 = new StringConcatenation();
            _builder_21.append("$T.exists($L, $L)");
            _xifexpression_5 = CodeBlock.of(_builder_21.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_22 = new StringConcatenation();
            _builder_22.append("/*FIRST ");
            _builder_22.append(call);
            _builder_22.append("*/");
            _xifexpression_5 = CodeBlock.of(_builder_22.toString());
          }
          _switchResult = _xifexpression_5;
          break;
        case "isEmpty":
          CodeBlock _xifexpression_6 = null;
          CallType _type_6 = call.getType();
          boolean _equals_6 = Objects.equal(_type_6, CallType.COLLECTIONCALL);
          if (_equals_6) {
            StringConcatenation _builder_23 = new StringConcatenation();
            _builder_23.append("$T.isEmpty($L)");
            _xifexpression_6 = CodeBlock.of(_builder_23.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_24 = new StringConcatenation();
            _builder_24.append("/*FIRST ");
            _builder_24.append(call);
            _builder_24.append("*/");
            _xifexpression_6 = CodeBlock.of(_builder_24.toString());
          }
          _switchResult = _xifexpression_6;
          break;
        case "oclIsKindOf":
          CodeBlock _xifexpression_7 = null;
          CallType _type_7 = call.getType();
          boolean _equals_7 = Objects.equal(_type_7, CallType.CALLORAPPLY);
          if (_equals_7) {
            StringConcatenation _builder_25 = new StringConcatenation();
            _builder_25.append("$L instanceof $L");
            _xifexpression_7 = CodeBlock.of(_builder_25.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_26 = new StringConcatenation();
            _builder_26.append("/*OCLISKINDOF*/");
            _xifexpression_7 = CodeBlock.of(_builder_26.toString());
          }
          _switchResult = _xifexpression_7;
          break;
        case "log":
          CodeBlock _xifexpression_8 = null;
          CallType _type_8 = call.getType();
          boolean _equals_8 = Objects.equal(_type_8, CallType.CALLORAPPLY);
          if (_equals_8) {
            StringConcatenation _builder_27 = new StringConcatenation();
            _builder_27.append("$T.log($L)");
            _xifexpression_8 = CodeBlock.of(_builder_27.toString(), 
              ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService"), 
              this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_28 = new StringConcatenation();
            _builder_28.append("/*OCLISKINDOF*/");
            _xifexpression_8 = CodeBlock.of(_builder_28.toString());
          }
          _switchResult = _xifexpression_8;
          break;
        default:
          CodeBlock _xifexpression_9 = null;
          CallType _type_9 = call.getType();
          boolean _equals_9 = Objects.equal(_type_9, CallType.CALLORAPPLY);
          if (_equals_9) {
            CodeBlock _xifexpression_10 = null;
            String _serviceName_1 = call.getServiceName();
            boolean _equals_10 = Objects.equal(_serviceName_1, "aqlFeatureAccess");
            if (_equals_10) {
              CodeBlock _xblockexpression_1 = null;
              {
                final IType t = IterableExtensions.<IType>head(this.infereType(call));
                CodeBlock _xifexpression_11 = null;
                if (((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
                  StringConcatenation _builder_29 = new StringConcatenation();
                  CodeBlock _compileExpression_3 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                  _builder_29.append(_compileExpression_3);
                  _builder_29.append(".get");
                  Expression _get = call.getArguments().get(1);
                  String _firstUpper = StringExtensions.toFirstUpper(((StringLiteral) _get).getValue());
                  _builder_29.append(_firstUpper);
                  _builder_29.append("()");
                  _xifexpression_11 = CodeBlock.of(_builder_29.toString());
                } else {
                  CodeBlock _xifexpression_12 = null;
                  if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
                    CodeBlock _xifexpression_13 = null;
                    if (((t.getType() instanceof EDataType) && (Objects.equal(((EDataType) t.getType()).getInstanceClass(), Boolean.class) || 
                      Objects.equal(((EDataType) t.getType()).getInstanceClass(), boolean.class)))) {
                      StringConcatenation _builder_30 = new StringConcatenation();
                      CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                      _builder_30.append(_compileExpression_4);
                      _builder_30.append(".is");
                      Expression _get_1 = call.getArguments().get(1);
                      String _firstUpper_1 = StringExtensions.toFirstUpper(((StringLiteral) _get_1).getValue());
                      _builder_30.append(_firstUpper_1);
                      _builder_30.append("()");
                      _xifexpression_13 = CodeBlock.of(_builder_30.toString());
                    } else {
                      StringConcatenation _builder_31 = new StringConcatenation();
                      CodeBlock _compileExpression_5 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                      _builder_31.append(_compileExpression_5);
                      _builder_31.append(".get");
                      Expression _get_2 = call.getArguments().get(1);
                      String _firstUpper_2 = StringExtensions.toFirstUpper(((StringLiteral) _get_2).getValue());
                      _builder_31.append(_firstUpper_2);
                      _builder_31.append("()");
                      _xifexpression_13 = CodeBlock.of(_builder_31.toString());
                    }
                    _xifexpression_12 = _xifexpression_13;
                  } else {
                    StringConcatenation _builder_32 = new StringConcatenation();
                    CodeBlock _compileExpression_6 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                    _builder_32.append(_compileExpression_6);
                    _builder_32.append(".");
                    {
                      Expression _get_3 = call.getArguments().get(1);
                      if ((_get_3 instanceof StringLiteral)) {
                        _builder_32.append("get");
                        Expression _get_4 = call.getArguments().get(1);
                        String _firstUpper_3 = StringExtensions.toFirstUpper(((StringLiteral) _get_4).getValue());
                        _builder_32.append(_firstUpper_3);
                        _builder_32.append("()");
                      } else {
                        CodeBlock _compileExpression_7 = this.compileExpression(call.getArguments().get(1));
                        _builder_32.append(_compileExpression_7);
                      }
                    }
                    _xifexpression_12 = CodeBlock.of(_builder_32.toString());
                  }
                  _xifexpression_11 = _xifexpression_12;
                }
                _xblockexpression_1 = _xifexpression_11;
              }
              _xifexpression_10 = _xblockexpression_1;
            } else {
              CodeBlock _xifexpression_11 = null;
              String _serviceName_2 = call.getServiceName();
              boolean _equals_11 = Objects.equal(_serviceName_2, "create");
              if (_equals_11) {
                CodeBlock _xblockexpression_2 = null;
                {
                  final Expression e = call.getArguments().get(0);
                  final IType t = IterableExtensions.<IType>head(this.infereType(e));
                  final GenModel gm = this.findGenModelFromExpression(e);
                  StringConcatenation _builder_29 = new StringConcatenation();
                  _builder_29.append("$T.eINSTANCE.create");
                  Object _type_10 = t.getType();
                  String _name = ((EClass) _type_10).getName();
                  _builder_29.append(_name);
                  _builder_29.append("()");
                  String _qualifiedPackageName = IterableExtensions.<GenPackage>head(gm.getGenPackages()).getQualifiedPackageName();
                  StringConcatenation _builder_30 = new StringConcatenation();
                  String _firstUpper = StringExtensions.toFirstUpper(this._ecoreUtils.getEPackage(gm).getName());
                  _builder_30.append(_firstUpper);
                  _builder_30.append("Factory");
                  _xblockexpression_2 = CodeBlock.of(_builder_29.toString(), ClassName.get(_qualifiedPackageName, _builder_30.toString()));
                }
                _xifexpression_11 = _xblockexpression_2;
              } else {
                CodeBlock _xblockexpression_3 = null;
                {
                  final Expression argumentsh = IterableExtensions.<Expression>head(call.getArguments());
                  final Set<IType> ts = this.infereType(argumentsh);
                  final IType t = IterableExtensions.<IType>head(ts);
                  final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
                    boolean _xifexpression_12 = false;
                    Object _type_10 = t.getType();
                    if ((_type_10 instanceof EClass)) {
                      boolean _xblockexpression_4 = false;
                      {
                        Object _type_11 = t.getType();
                        final EClass tecls = ((EClass) _type_11);
                        _xblockexpression_4 = (Objects.equal(it.getECls().getName(), tecls.getName()) && Objects.equal(it.getECls().getEPackage().getName(), tecls.getEPackage().getName()));
                      }
                      _xifexpression_12 = _xblockexpression_4;
                    } else {
                      _xifexpression_12 = false;
                    }
                    return Boolean.valueOf(_xifexpression_12);
                  };
                  final ALERevisitorImplementationCompiler.ResolvedClass re = IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function));
                  CodeBlock _xifexpression_12 = null;
                  if ((re != null)) {
                    CodeBlock _xblockexpression_4 = null;
                    {
                      final Iterable<Method> allMethods = this.allMethods(re.getAleCls());
                      final Function1<Method, Boolean> _function_1 = (Method it) -> {
                        String _name = it.getOperationRef().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final boolean methodExist = IterableExtensions.<Method>exists(allMethods, _function_1);
                      CodeBlock _xifexpression_13 = null;
                      if (methodExist) {
                        CodeBlock _xblockexpression_5 = null;
                        {
                          Pair<String, String> _mappedTo = Pair.<String, String>of("dispatch", "$");
                          TypeName _resolveType2 = this.resolveType2(t.getType());
                          Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("callerType", _resolveType2);
                          final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1);
                          final Consumer<Pair<Expression, Integer>> _function_2 = (Pair<Expression, Integer> it) -> {
                            Integer _value = it.getValue();
                            String _plus = ("paramType" + _value);
                            hm.put(_plus, this.resolveType2(IterableExtensions.<IType>head(this.infereType(it.getKey())).getType()));
                          };
                          this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments())).forEach(_function_2);
                          CodeBlock.Builder _builder_29 = CodeBlock.builder();
                          StringConcatenation _builder_30 = new StringConcatenation();
                          _builder_30.append("rev.$dispatch:L(($callerType:T)");
                          CodeBlock _compileExpression_3 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                          _builder_30.append(_compileExpression_3);
                          _builder_30.append(").");
                          String _serviceName_3 = call.getServiceName();
                          _builder_30.append(_serviceName_3);
                          _builder_30.append("(");
                          {
                            Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                            boolean _hasElements = false;
                            for(final Pair<Expression, Integer> param : _enumerate) {
                              if (!_hasElements) {
                                _hasElements = true;
                              } else {
                                _builder_30.appendImmediate(",", "");
                              }
                              _builder_30.append("(($paramType");
                              Integer _value = param.getValue();
                              _builder_30.append(_value);
                              _builder_30.append(":T)");
                              CodeBlock _compileExpression_4 = this.compileExpression(param.getKey());
                              _builder_30.append(_compileExpression_4);
                              _builder_30.append(")");
                            }
                          }
                          _builder_30.append(")");
                          _xblockexpression_5 = _builder_29.addNamed(_builder_30.toString(), hm).build();
                        }
                        _xifexpression_13 = _xblockexpression_5;
                      } else {
                        CodeBlock _xblockexpression_6 = null;
                        {
                          final Function1<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>> _function_2 = (Map.Entry<String, Class<?>> e) -> {
                            final Function1<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>> _function_3 = (java.lang.reflect.Method it) -> {
                              String _key = e.getKey();
                              return Pair.<String, java.lang.reflect.Method>of(_key, it);
                            };
                            return ListExtensions.<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>>map(((List<java.lang.reflect.Method>)Conversions.doWrapArray(e.getValue().getMethods())), _function_3);
                          };
                          final List<Pair<String, java.lang.reflect.Method>> methods = IterableExtensions.<Pair<String, java.lang.reflect.Method>>toList(Iterables.<Pair<String, java.lang.reflect.Method>>concat(IterableExtensions.<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>>map(this.registeredServices.entrySet(), _function_2)));
                          final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                            return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                          };
                          final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_4 = (Pair<String, java.lang.reflect.Method> it) -> {
                            String _name = it.getValue().getName();
                            String _serviceName_3 = call.getServiceName();
                            return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                          };
                          final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_3), _function_4));
                          CodeBlock _xifexpression_14 = null;
                          if ((candidate != null)) {
                            StringConcatenation _builder_29 = new StringConcatenation();
                            String _key = candidate.getKey();
                            _builder_29.append(_key);
                            _builder_29.append(".");
                            String _name = candidate.getValue().getName();
                            _builder_29.append(_name);
                            _builder_29.append("(");
                            {
                              EList<Expression> _arguments = call.getArguments();
                              boolean _hasElements = false;
                              for(final Expression p : _arguments) {
                                if (!_hasElements) {
                                  _hasElements = true;
                                } else {
                                  _builder_29.appendImmediate(", ", "");
                                }
                                CodeBlock _compileExpression_3 = this.compileExpression(p);
                                _builder_29.append(_compileExpression_3);
                              }
                            }
                            _builder_29.append(")");
                            _xifexpression_14 = CodeBlock.of(_builder_29.toString());
                          } else {
                            StringConcatenation _builder_30 = new StringConcatenation();
                            CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                            _builder_30.append(_compileExpression_4);
                            _builder_30.append(".");
                            String _serviceName_3 = call.getServiceName();
                            _builder_30.append(_serviceName_3);
                            _builder_30.append("(");
                            {
                              Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                              boolean _hasElements_1 = false;
                              for(final Expression param : _tail) {
                                if (!_hasElements_1) {
                                  _hasElements_1 = true;
                                } else {
                                  _builder_30.appendImmediate(",", "");
                                }
                                CodeBlock _compileExpression_5 = this.compileExpression(param);
                                _builder_30.append(_compileExpression_5);
                              }
                            }
                            _builder_30.append(")");
                            _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                          }
                          _xblockexpression_6 = _xifexpression_14;
                        }
                        _xifexpression_13 = _xblockexpression_6;
                      }
                      _xblockexpression_4 = _xifexpression_13;
                    }
                    _xifexpression_12 = _xblockexpression_4;
                  } else {
                    CodeBlock _xblockexpression_5 = null;
                    {
                      final Function1<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>> _function_1 = (Map.Entry<String, Class<?>> e) -> {
                        final Function1<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>> _function_2 = (java.lang.reflect.Method it) -> {
                          String _key = e.getKey();
                          return Pair.<String, java.lang.reflect.Method>of(_key, it);
                        };
                        return ListExtensions.<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>>map(((List<java.lang.reflect.Method>)Conversions.doWrapArray(e.getValue().getMethods())), _function_2);
                      };
                      final Iterable<Pair<String, java.lang.reflect.Method>> methods = Iterables.<Pair<String, java.lang.reflect.Method>>concat(IterableExtensions.<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>>map(this.registeredServices.entrySet(), _function_1));
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_2 = (Pair<String, java.lang.reflect.Method> it) -> {
                        return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                      };
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                        String _name = it.getValue().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_2), _function_3));
                      CodeBlock _xifexpression_13 = null;
                      if ((candidate != null)) {
                        StringConcatenation _builder_29 = new StringConcatenation();
                        String _key = candidate.getKey();
                        _builder_29.append(_key);
                        _builder_29.append(".");
                        String _name = candidate.getValue().getName();
                        _builder_29.append(_name);
                        _builder_29.append("(");
                        {
                          EList<Expression> _arguments = call.getArguments();
                          boolean _hasElements = false;
                          for(final Expression p : _arguments) {
                            if (!_hasElements) {
                              _hasElements = true;
                            } else {
                              _builder_29.appendImmediate(", ", "");
                            }
                            CodeBlock _compileExpression_3 = this.compileExpression(p);
                            _builder_29.append(_compileExpression_3);
                          }
                        }
                        _builder_29.append(")");
                        _xifexpression_13 = CodeBlock.of(_builder_29.toString());
                      } else {
                        StringConcatenation _builder_30 = new StringConcatenation();
                        CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                        _builder_30.append(_compileExpression_4);
                        _builder_30.append(".");
                        String _serviceName_3 = call.getServiceName();
                        _builder_30.append(_serviceName_3);
                        _builder_30.append("(");
                        {
                          Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                          boolean _hasElements_1 = false;
                          for(final Expression param : _tail) {
                            if (!_hasElements_1) {
                              _hasElements_1 = true;
                            } else {
                              _builder_30.appendImmediate(",", "");
                            }
                            CodeBlock _compileExpression_5 = this.compileExpression(param);
                            _builder_30.append(_compileExpression_5);
                          }
                        }
                        _builder_30.append(")");
                        _xifexpression_13 = CodeBlock.of(_builder_30.toString());
                      }
                      _xblockexpression_5 = _xifexpression_13;
                    }
                    _xifexpression_12 = _xblockexpression_5;
                  }
                  _xblockexpression_3 = _xifexpression_12;
                }
                _xifexpression_11 = _xblockexpression_3;
              }
              _xifexpression_10 = _xifexpression_11;
            }
            _xifexpression_9 = _xifexpression_10;
          } else {
            StringConcatenation _builder_29 = new StringConcatenation();
            _builder_29.append("/*Call ");
            _builder_29.append(call);
            _builder_29.append("*/");
            _xifexpression_9 = CodeBlock.of(_builder_29.toString());
          }
          _switchResult = _xifexpression_9;
          break;
      }
    } else {
      CodeBlock _xifexpression_9 = null;
      CallType _type_9 = call.getType();
      boolean _equals_9 = Objects.equal(_type_9, CallType.CALLORAPPLY);
      if (_equals_9) {
        CodeBlock _xifexpression_10 = null;
        String _serviceName_1 = call.getServiceName();
        boolean _equals_10 = Objects.equal(_serviceName_1, "aqlFeatureAccess");
        if (_equals_10) {
          CodeBlock _xblockexpression_1 = null;
          {
            final IType t = IterableExtensions.<IType>head(this.infereType(call));
            CodeBlock _xifexpression_11 = null;
            if (((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
              StringConcatenation _builder_29 = new StringConcatenation();
              CodeBlock _compileExpression_3 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
              _builder_29.append(_compileExpression_3);
              _builder_29.append(".get");
              Expression _get = call.getArguments().get(1);
              String _firstUpper = StringExtensions.toFirstUpper(((StringLiteral) _get).getValue());
              _builder_29.append(_firstUpper);
              _builder_29.append("()");
              _xifexpression_11 = CodeBlock.of(_builder_29.toString());
            } else {
              CodeBlock _xifexpression_12 = null;
              if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
                CodeBlock _xifexpression_13 = null;
                if (((t.getType() instanceof EDataType) && (Objects.equal(((EDataType) t.getType()).getInstanceClass(), Boolean.class) || 
                  Objects.equal(((EDataType) t.getType()).getInstanceClass(), boolean.class)))) {
                  StringConcatenation _builder_30 = new StringConcatenation();
                  CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                  _builder_30.append(_compileExpression_4);
                  _builder_30.append(".is");
                  Expression _get_1 = call.getArguments().get(1);
                  String _firstUpper_1 = StringExtensions.toFirstUpper(((StringLiteral) _get_1).getValue());
                  _builder_30.append(_firstUpper_1);
                  _builder_30.append("()");
                  _xifexpression_13 = CodeBlock.of(_builder_30.toString());
                } else {
                  StringConcatenation _builder_31 = new StringConcatenation();
                  CodeBlock _compileExpression_5 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                  _builder_31.append(_compileExpression_5);
                  _builder_31.append(".get");
                  Expression _get_2 = call.getArguments().get(1);
                  String _firstUpper_2 = StringExtensions.toFirstUpper(((StringLiteral) _get_2).getValue());
                  _builder_31.append(_firstUpper_2);
                  _builder_31.append("()");
                  _xifexpression_13 = CodeBlock.of(_builder_31.toString());
                }
                _xifexpression_12 = _xifexpression_13;
              } else {
                StringConcatenation _builder_32 = new StringConcatenation();
                CodeBlock _compileExpression_6 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                _builder_32.append(_compileExpression_6);
                _builder_32.append(".");
                {
                  Expression _get_3 = call.getArguments().get(1);
                  if ((_get_3 instanceof StringLiteral)) {
                    _builder_32.append("get");
                    Expression _get_4 = call.getArguments().get(1);
                    String _firstUpper_3 = StringExtensions.toFirstUpper(((StringLiteral) _get_4).getValue());
                    _builder_32.append(_firstUpper_3);
                    _builder_32.append("()");
                  } else {
                    CodeBlock _compileExpression_7 = this.compileExpression(call.getArguments().get(1));
                    _builder_32.append(_compileExpression_7);
                  }
                }
                _xifexpression_12 = CodeBlock.of(_builder_32.toString());
              }
              _xifexpression_11 = _xifexpression_12;
            }
            _xblockexpression_1 = _xifexpression_11;
          }
          _xifexpression_10 = _xblockexpression_1;
        } else {
          CodeBlock _xifexpression_11 = null;
          String _serviceName_2 = call.getServiceName();
          boolean _equals_11 = Objects.equal(_serviceName_2, "create");
          if (_equals_11) {
            CodeBlock _xblockexpression_2 = null;
            {
              final Expression e = call.getArguments().get(0);
              final IType t = IterableExtensions.<IType>head(this.infereType(e));
              final GenModel gm = this.findGenModelFromExpression(e);
              StringConcatenation _builder_29 = new StringConcatenation();
              _builder_29.append("$T.eINSTANCE.create");
              Object _type_10 = t.getType();
              String _name = ((EClass) _type_10).getName();
              _builder_29.append(_name);
              _builder_29.append("()");
              String _qualifiedPackageName = IterableExtensions.<GenPackage>head(gm.getGenPackages()).getQualifiedPackageName();
              StringConcatenation _builder_30 = new StringConcatenation();
              String _firstUpper = StringExtensions.toFirstUpper(this._ecoreUtils.getEPackage(gm).getName());
              _builder_30.append(_firstUpper);
              _builder_30.append("Factory");
              _xblockexpression_2 = CodeBlock.of(_builder_29.toString(), ClassName.get(_qualifiedPackageName, _builder_30.toString()));
            }
            _xifexpression_11 = _xblockexpression_2;
          } else {
            CodeBlock _xblockexpression_3 = null;
            {
              final Expression argumentsh = IterableExtensions.<Expression>head(call.getArguments());
              final Set<IType> ts = this.infereType(argumentsh);
              final IType t = IterableExtensions.<IType>head(ts);
              final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
                boolean _xifexpression_12 = false;
                Object _type_10 = t.getType();
                if ((_type_10 instanceof EClass)) {
                  boolean _xblockexpression_4 = false;
                  {
                    Object _type_11 = t.getType();
                    final EClass tecls = ((EClass) _type_11);
                    _xblockexpression_4 = (Objects.equal(it.getECls().getName(), tecls.getName()) && Objects.equal(it.getECls().getEPackage().getName(), tecls.getEPackage().getName()));
                  }
                  _xifexpression_12 = _xblockexpression_4;
                } else {
                  _xifexpression_12 = false;
                }
                return Boolean.valueOf(_xifexpression_12);
              };
              final ALERevisitorImplementationCompiler.ResolvedClass re = IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function));
              CodeBlock _xifexpression_12 = null;
              if ((re != null)) {
                CodeBlock _xblockexpression_4 = null;
                {
                  final Iterable<Method> allMethods = this.allMethods(re.getAleCls());
                  final Function1<Method, Boolean> _function_1 = (Method it) -> {
                    String _name = it.getOperationRef().getName();
                    String _serviceName_3 = call.getServiceName();
                    return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                  };
                  final boolean methodExist = IterableExtensions.<Method>exists(allMethods, _function_1);
                  CodeBlock _xifexpression_13 = null;
                  if (methodExist) {
                    CodeBlock _xblockexpression_5 = null;
                    {
                      Pair<String, String> _mappedTo = Pair.<String, String>of("dispatch", "$");
                      TypeName _resolveType2 = this.resolveType2(t.getType());
                      Pair<String, TypeName> _mappedTo_1 = Pair.<String, TypeName>of("callerType", _resolveType2);
                      final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1);
                      final Consumer<Pair<Expression, Integer>> _function_2 = (Pair<Expression, Integer> it) -> {
                        Integer _value = it.getValue();
                        String _plus = ("paramType" + _value);
                        hm.put(_plus, this.resolveType2(IterableExtensions.<IType>head(this.infereType(it.getKey())).getType()));
                      };
                      this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments())).forEach(_function_2);
                      CodeBlock.Builder _builder_29 = CodeBlock.builder();
                      StringConcatenation _builder_30 = new StringConcatenation();
                      _builder_30.append("rev.$dispatch:L(($callerType:T)");
                      CodeBlock _compileExpression_3 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                      _builder_30.append(_compileExpression_3);
                      _builder_30.append(").");
                      String _serviceName_3 = call.getServiceName();
                      _builder_30.append(_serviceName_3);
                      _builder_30.append("(");
                      {
                        Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                        boolean _hasElements = false;
                        for(final Pair<Expression, Integer> param : _enumerate) {
                          if (!_hasElements) {
                            _hasElements = true;
                          } else {
                            _builder_30.appendImmediate(",", "");
                          }
                          _builder_30.append("(($paramType");
                          Integer _value = param.getValue();
                          _builder_30.append(_value);
                          _builder_30.append(":T)");
                          CodeBlock _compileExpression_4 = this.compileExpression(param.getKey());
                          _builder_30.append(_compileExpression_4);
                          _builder_30.append(")");
                        }
                      }
                      _builder_30.append(")");
                      _xblockexpression_5 = _builder_29.addNamed(_builder_30.toString(), hm).build();
                    }
                    _xifexpression_13 = _xblockexpression_5;
                  } else {
                    CodeBlock _xblockexpression_6 = null;
                    {
                      final Function1<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>> _function_2 = (Map.Entry<String, Class<?>> e) -> {
                        final Function1<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>> _function_3 = (java.lang.reflect.Method it) -> {
                          String _key = e.getKey();
                          return Pair.<String, java.lang.reflect.Method>of(_key, it);
                        };
                        return ListExtensions.<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>>map(((List<java.lang.reflect.Method>)Conversions.doWrapArray(e.getValue().getMethods())), _function_3);
                      };
                      final List<Pair<String, java.lang.reflect.Method>> methods = IterableExtensions.<Pair<String, java.lang.reflect.Method>>toList(Iterables.<Pair<String, java.lang.reflect.Method>>concat(IterableExtensions.<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>>map(this.registeredServices.entrySet(), _function_2)));
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                        return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                      };
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_4 = (Pair<String, java.lang.reflect.Method> it) -> {
                        String _name = it.getValue().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_3), _function_4));
                      CodeBlock _xifexpression_14 = null;
                      if ((candidate != null)) {
                        StringConcatenation _builder_29 = new StringConcatenation();
                        String _key = candidate.getKey();
                        _builder_29.append(_key);
                        _builder_29.append(".");
                        String _name = candidate.getValue().getName();
                        _builder_29.append(_name);
                        _builder_29.append("(");
                        {
                          EList<Expression> _arguments = call.getArguments();
                          boolean _hasElements = false;
                          for(final Expression p : _arguments) {
                            if (!_hasElements) {
                              _hasElements = true;
                            } else {
                              _builder_29.appendImmediate(", ", "");
                            }
                            CodeBlock _compileExpression_3 = this.compileExpression(p);
                            _builder_29.append(_compileExpression_3);
                          }
                        }
                        _builder_29.append(")");
                        _xifexpression_14 = CodeBlock.of(_builder_29.toString());
                      } else {
                        StringConcatenation _builder_30 = new StringConcatenation();
                        CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                        _builder_30.append(_compileExpression_4);
                        _builder_30.append(".");
                        String _serviceName_3 = call.getServiceName();
                        _builder_30.append(_serviceName_3);
                        _builder_30.append("(");
                        {
                          Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                          boolean _hasElements_1 = false;
                          for(final Expression param : _tail) {
                            if (!_hasElements_1) {
                              _hasElements_1 = true;
                            } else {
                              _builder_30.appendImmediate(",", "");
                            }
                            CodeBlock _compileExpression_5 = this.compileExpression(param);
                            _builder_30.append(_compileExpression_5);
                          }
                        }
                        _builder_30.append(")");
                        _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                      }
                      _xblockexpression_6 = _xifexpression_14;
                    }
                    _xifexpression_13 = _xblockexpression_6;
                  }
                  _xblockexpression_4 = _xifexpression_13;
                }
                _xifexpression_12 = _xblockexpression_4;
              } else {
                CodeBlock _xblockexpression_5 = null;
                {
                  final Function1<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>> _function_1 = (Map.Entry<String, Class<?>> e) -> {
                    final Function1<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>> _function_2 = (java.lang.reflect.Method it) -> {
                      String _key = e.getKey();
                      return Pair.<String, java.lang.reflect.Method>of(_key, it);
                    };
                    return ListExtensions.<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>>map(((List<java.lang.reflect.Method>)Conversions.doWrapArray(e.getValue().getMethods())), _function_2);
                  };
                  final Iterable<Pair<String, java.lang.reflect.Method>> methods = Iterables.<Pair<String, java.lang.reflect.Method>>concat(IterableExtensions.<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>>map(this.registeredServices.entrySet(), _function_1));
                  final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_2 = (Pair<String, java.lang.reflect.Method> it) -> {
                    return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                  };
                  final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                    String _name = it.getValue().getName();
                    String _serviceName_3 = call.getServiceName();
                    return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                  };
                  final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_2), _function_3));
                  CodeBlock _xifexpression_13 = null;
                  if ((candidate != null)) {
                    StringConcatenation _builder_29 = new StringConcatenation();
                    String _key = candidate.getKey();
                    _builder_29.append(_key);
                    _builder_29.append(".");
                    String _name = candidate.getValue().getName();
                    _builder_29.append(_name);
                    _builder_29.append("(");
                    {
                      EList<Expression> _arguments = call.getArguments();
                      boolean _hasElements = false;
                      for(final Expression p : _arguments) {
                        if (!_hasElements) {
                          _hasElements = true;
                        } else {
                          _builder_29.appendImmediate(", ", "");
                        }
                        CodeBlock _compileExpression_3 = this.compileExpression(p);
                        _builder_29.append(_compileExpression_3);
                      }
                    }
                    _builder_29.append(")");
                    _xifexpression_13 = CodeBlock.of(_builder_29.toString());
                  } else {
                    StringConcatenation _builder_30 = new StringConcatenation();
                    CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                    _builder_30.append(_compileExpression_4);
                    _builder_30.append(".");
                    String _serviceName_3 = call.getServiceName();
                    _builder_30.append(_serviceName_3);
                    _builder_30.append("(");
                    {
                      Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                      boolean _hasElements_1 = false;
                      for(final Expression param : _tail) {
                        if (!_hasElements_1) {
                          _hasElements_1 = true;
                        } else {
                          _builder_30.appendImmediate(",", "");
                        }
                        CodeBlock _compileExpression_5 = this.compileExpression(param);
                        _builder_30.append(_compileExpression_5);
                      }
                    }
                    _builder_30.append(")");
                    _xifexpression_13 = CodeBlock.of(_builder_30.toString());
                  }
                  _xblockexpression_5 = _xifexpression_13;
                }
                _xifexpression_12 = _xblockexpression_5;
              }
              _xblockexpression_3 = _xifexpression_12;
            }
            _xifexpression_11 = _xblockexpression_3;
          }
          _xifexpression_10 = _xifexpression_11;
        }
        _xifexpression_9 = _xifexpression_10;
      } else {
        StringConcatenation _builder_29 = new StringConcatenation();
        _builder_29.append("/*Call ");
        _builder_29.append(call);
        _builder_29.append("*/");
        _xifexpression_9 = CodeBlock.of(_builder_29.toString());
      }
      _switchResult = _xifexpression_9;
    }
    return _switchResult;
  }
  
  public <A extends Object> Iterable<Pair<A, Integer>> enumerate(final Iterable<A> itt) {
    Iterable<Pair<A, Integer>> _xblockexpression = null;
    {
      final PrimitiveIterator.OfInt ints = IntStream.range(0, IterableExtensions.size(itt)).iterator();
      final Function1<A, Pair<A, Integer>> _function = (A it) -> {
        Integer _next = ints.next();
        return Pair.<A, Integer>of(it, _next);
      };
      _xblockexpression = IterableExtensions.<A, Pair<A, Integer>>map(itt, _function);
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final And call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0));
    _builder.append(_compileExpression);
    _builder.append(") && (");
    CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1));
    _builder.append(_compileExpression_1);
    _builder.append("))");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorCall call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORCALL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Implies call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*IMPLIES*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Or call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0));
    _builder.append(_compileExpression);
    _builder.append(") || (");
    CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1));
    _builder.append(_compileExpression_1);
    _builder.append("))");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorConditional call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORCONDITIONAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorBinding call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORBINDING*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final EEnumLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*EENUMLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorExpression call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERROREXPRESSION*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorStringLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORSTRINGLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorTypeLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORTYPELITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorVariableDeclaration call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORVARIABLEDECLARATION*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Let call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*let*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final BooleanLiteral call) {
    String _xifexpression = null;
    boolean _isValue = call.isValue();
    if (_isValue) {
      _xifexpression = "true";
    } else {
      _xifexpression = "false";
    }
    return CodeBlock.of(_xifexpression);
  }
  
  protected CodeBlock _compileExpression(final EnumLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ENUMLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final IntegerLiteral call) {
    return CodeBlock.of(Integer.valueOf(call.getValue()).toString());
  }
  
  protected CodeBlock _compileExpression(final Lambda call) {
    CodeBlock _xblockexpression = null;
    {
      CodeBlock _compileExpression = this.compileExpression(call.getExpression());
      Pair<String, Object> _mappedTo = Pair.<String, Object>of("expr", _compileExpression);
      final Map<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo);
      Iterable<Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer>> _enumerate = this.<org.eclipse.acceleo.query.ast.VariableDeclaration>enumerate(call.getParameters());
      for (final Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer> param : _enumerate) {
        Integer _value = param.getValue();
        String _plus = ("param" + _value);
        hm.put(_plus, param.getKey().getName());
      }
      CodeBlock.Builder _builder = CodeBlock.builder();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      {
        Iterable<Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer>> _enumerate_1 = this.<org.eclipse.acceleo.query.ast.VariableDeclaration>enumerate(call.getParameters());
        boolean _hasElements = false;
        for(final Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer> p : _enumerate_1) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate(", ", "");
          }
          _builder_1.append("$param");
          Integer _value_1 = p.getValue();
          _builder_1.append(_value_1);
          _builder_1.append(":L");
        }
      }
      _builder_1.append(") -> $expr:L");
      _xblockexpression = _builder.addNamed(_builder_1.toString(), hm).build();
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final NullLiteral call) {
    return CodeBlock.of("null");
  }
  
  protected CodeBlock _compileExpression(final RealLiteral call) {
    return CodeBlock.of(Double.valueOf(call.getValue()).toString());
  }
  
  protected CodeBlock _compileExpression(final SequenceInExtensionLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$T.createEList(");
    {
      EList<Expression> _values = call.getValues();
      boolean _hasElements = false;
      for(final Expression a : _values) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        CodeBlock _compileExpression = this.compileExpression(a);
        _builder.append(_compileExpression);
      }
    }
    _builder.append(")");
    return CodeBlock.of(_builder.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"));
  }
  
  protected CodeBlock _compileExpression(final SetInExtensionLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*SETINEXTENSIONLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final StringLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _value = call.getValue();
    _builder.append(_value);
    _builder.append("\"");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final TypeLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$T");
    Object _value = call.getValue();
    return CodeBlock.of(_builder.toString(), this.solveType(((EClass) _value)));
  }
  
  protected CodeBlock _compileExpression(final Switch call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*SWITCH*/");
    return CodeBlock.of(_builder.toString());
  }
  
  public String getEcoreInterfacesPackage() {
    String _xblockexpression = null;
    {
      final GenModel gm = this.syntaxes.get(IterableExtensions.<String>head(this.dsl.getAllSyntaxes())).getValue();
      _xblockexpression = IterableExtensions.<GenPackage>head(gm.getGenPackages()).getQualifiedPackageName();
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final VarRef call) {
    String _xifexpression = null;
    String _variableName = call.getVariableName();
    boolean _equals = Objects.equal(_variableName, "self");
    if (_equals) {
      _xifexpression = "this.obj";
    } else {
      _xifexpression = call.getVariableName();
    }
    return CodeBlock.of(_xifexpression);
  }
  
  protected TypeName _solveType(final EClass type) {
    return this.resolveType(type);
  }
  
  protected TypeName _solveType(final EDataType edt) {
    return TypeName.get(edt.getInstanceClass());
  }
  
  public MethodSpec.Builder returnType(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      MethodSpec.Builder _xifexpression_1 = null;
      Class<?> _instanceClass = type.getInstanceClass();
      boolean _tripleNotEquals = (_instanceClass != null);
      if (_tripleNotEquals) {
        _xifexpression_1 = builder.returns(type.getInstanceClass());
      } else {
        _xifexpression_1 = builder.returns(this.resolveType(type));
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public List<ALERevisitorImplementationCompiler.ResolvedClass> resolve(final List<ExtendedClass> aleClasses, final EPackage syntax) {
    final Function1<EClassifier, ALERevisitorImplementationCompiler.ResolvedClass> _function = (EClassifier eClass) -> {
      ALERevisitorImplementationCompiler.ResolvedClass _xblockexpression = null;
      {
        final Function1<ExtendedClass, Boolean> _function_1 = (ExtendedClass it) -> {
          return Boolean.valueOf((Objects.equal(it.getName(), eClass.getName()) || Objects.equal(it.getName(), ((eClass.getEPackage().getName() + ".") + eClass.getName()))));
        };
        final ExtendedClass aleClass = IterableExtensions.<ExtendedClass>head(IterableExtensions.<ExtendedClass>filter(aleClasses, _function_1));
        _xblockexpression = new ALERevisitorImplementationCompiler.ResolvedClass(aleClass, eClass);
      }
      return _xblockexpression;
    };
    return ListExtensions.<EClassifier, ALERevisitorImplementationCompiler.ResolvedClass>map(this._ecoreUtils.getAllClassifiers(syntax), _function);
  }
  
  public Set<IType> infereType(final Expression exp) {
    return this.base.getPossibleTypes(exp);
  }
  
  public TypeName resolveType(final EClassifier e) {
    TypeName _xblockexpression = null;
    {
      Collection<Pair<EPackage, GenModel>> _values = this.syntaxes.values();
      Pair<EcorePackage, GenModel> _mappedTo = Pair.<EcorePackage, GenModel>of(EcorePackage.eINSTANCE, null);
      final Iterable<Pair<? extends EPackage, GenModel>> stxs = Iterables.<Pair<? extends EPackage, GenModel>>concat(_values, Collections.<Pair<EcorePackage, GenModel>>unmodifiableList(CollectionLiterals.<Pair<EcorePackage, GenModel>>newArrayList(_mappedTo)));
      final Function1<Pair<? extends EPackage, GenModel>, Boolean> _function = (Pair<? extends EPackage, GenModel> it) -> {
        final Function1<EClassifier, Boolean> _function_1 = (EClassifier it_1) -> {
          return Boolean.valueOf((Objects.equal(it_1.getName(), e.getName()) && Objects.equal(it_1.getEPackage().getName(), ((EPackage) e.eContainer()).getName())));
        };
        return Boolean.valueOf(IterableExtensions.<EClassifier>exists(this._ecoreUtils.getAllClassifiers(it.getKey()), _function_1));
      };
      final Pair<? extends EPackage, GenModel> stx = IterableExtensions.<Pair<? extends EPackage, GenModel>>head(IterableExtensions.<Pair<? extends EPackage, GenModel>>filter(stxs, _function));
      final GenModel gm = stx.getValue();
      TypeName _xifexpression = null;
      if ((gm != null)) {
        TypeName _xifexpression_1 = null;
        if ((e instanceof EClass)) {
          TypeName _xifexpression_2 = null;
          String _instanceClassName = ((EClass)e).getInstanceClassName();
          boolean _equals = Objects.equal(_instanceClassName, "java.util.Map$Entry");
          if (_equals) {
            ParameterizedTypeName _xblockexpression_1 = null;
            {
              final Function1<EStructuralFeature, Boolean> _function_1 = (EStructuralFeature it) -> {
                String _name = it.getName();
                return Boolean.valueOf(Objects.equal(_name, "key"));
              };
              final TypeName keyType = this.solveType(IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(((EClass)e).getEStructuralFeatures(), _function_1)).getEType());
              final Function1<EStructuralFeature, Boolean> _function_2 = (EStructuralFeature it) -> {
                String _name = it.getName();
                return Boolean.valueOf(Objects.equal(_name, "value"));
              };
              final TypeName valueType = this.solveType(IterableExtensions.<EStructuralFeature>head(IterableExtensions.<EStructuralFeature>filter(((EClass)e).getEStructuralFeatures(), _function_2)).getEType());
              _xblockexpression_1 = ParameterizedTypeName.get(ClassName.get(Map.Entry.class), keyType, valueType);
            }
            _xifexpression_2 = _xblockexpression_1;
          } else {
            ClassName _xblockexpression_2 = null;
            {
              final Function2<String, Pair<EPackage, GenModel>, Boolean> _function_1 = (String k, Pair<EPackage, GenModel> v) -> {
                final Function1<EClass, Boolean> _function_2 = (EClass it) -> {
                  return Boolean.valueOf((Objects.equal(it.getName(), ((EClass)e).getName()) && Objects.equal(it.getEPackage().getName(), ((EClass)e).getEPackage().getName())));
                };
                return Boolean.valueOf(IterableExtensions.<EClass>exists(this._ecoreUtils.getAllClasses(v.getKey()), _function_2));
              };
              final Function1<Pair<EPackage, GenModel>, GenModel> _function_2 = (Pair<EPackage, GenModel> it) -> {
                return it.getValue();
              };
              final Function1<GenModel, Iterable<GenClass>> _function_3 = (GenModel it) -> {
                final Function1<GenPackage, EList<GenClass>> _function_4 = (GenPackage it_1) -> {
                  return it_1.getGenClasses();
                };
                return Iterables.<GenClass>concat(ListExtensions.<GenPackage, EList<GenClass>>map(it.getGenPackages(), _function_4));
              };
              final Function1<GenClass, Boolean> _function_4 = (GenClass it) -> {
                return Boolean.valueOf((Objects.equal(it.getEcoreClass().getName(), ((EClass)e).getName()) && Objects.equal(it.getEcoreClass().getEPackage().getName(), ((EClass)e).getEPackage().getName())));
              };
              final GenClass gl = IterableExtensions.<GenClass>head(IterableExtensions.<GenClass>filter(Iterables.<GenClass>concat(IterableExtensions.<GenModel, Iterable<GenClass>>map(IterableExtensions.<Pair<EPackage, GenModel>, GenModel>map(MapExtensions.<String, Pair<EPackage, GenModel>>filter(this.syntaxes, _function_1).values(), _function_2), _function_3)), _function_4));
              _xblockexpression_2 = ClassName.get(gl.getGenPackage().getInterfacePackageName(), ((EClass)e).getName());
            }
            _xifexpression_2 = _xblockexpression_2;
          }
          _xifexpression_1 = _xifexpression_2;
        } else {
          ClassName _xblockexpression_3 = null;
          {
            final Function1<GenPackage, Iterable<GenClassifier>> _function_1 = (GenPackage it) -> {
              final Function1<GenClassifier, Boolean> _function_2 = (GenClassifier it_1) -> {
                return Boolean.valueOf((Objects.equal(it_1.getName(), e.getName()) && Objects.equal(it_1.getGenPackage().getEcorePackage().getName(), ((EPackage) e.eContainer()).getName())));
              };
              return IterableExtensions.<GenClassifier>filter(it.getGenClassifiers(), _function_2);
            };
            final GenClassifier gclass = IterableExtensions.<GenClassifier>head(Iterables.<GenClassifier>concat(ListExtensions.<GenPackage, Iterable<GenClassifier>>map(this._ecoreUtils.getAllGenPkgs(gm), _function_1)));
            ClassName _xifexpression_3 = null;
            if ((gclass instanceof GenClass)) {
              _xifexpression_3 = ClassName.get(((GenClass)gclass).getQualifiedInterfaceName(), ((GenClass)gclass).getName());
            } else {
              ClassName _xifexpression_4 = null;
              if ((gclass instanceof GenEnum)) {
                _xifexpression_4 = ClassName.get(((GenEnum)gclass).getGenPackage().getInterfacePackageName(), ((GenEnum)gclass).getName());
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xblockexpression_3 = _xifexpression_3;
          }
          _xifexpression_1 = _xblockexpression_3;
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = ClassName.get("org.eclipse.emf.ecore", e.getName());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public GenModel findGenModelFromExpression(final Expression e) {
    GenModel _xblockexpression = null;
    {
      final IType t = IterableExtensions.<IType>head(this.infereType(e));
      final Function1<Pair<EPackage, GenModel>, Boolean> _function = (Pair<EPackage, GenModel> it) -> {
        final Function1<EClass, Boolean> _function_1 = (EClass it_1) -> {
          return Boolean.valueOf((Objects.equal(it_1.getName(), ((EClassifier) t.getType()).getName()) && Objects.equal(it_1.getEPackage().getName(), ((EClassifier) t.getType()).getEPackage().getName())));
        };
        return Boolean.valueOf(IterableExtensions.<EClass>exists(this._ecoreUtils.getAllClasses(it.getKey()), _function_1));
      };
      _xblockexpression = IterableExtensions.<Pair<EPackage, GenModel>>head(IterableExtensions.<Pair<EPackage, GenModel>>filter(this.syntaxes.values(), _function)).getValue();
    }
    return _xblockexpression;
  }
  
  public TypeSpec.Builder superOperationImpl(final TypeSpec.Builder builder, final EClass clazz) {
    TypeSpec.Builder _xifexpression = null;
    if ((clazz != null)) {
      _xifexpression = builder.superclass(this._revisitorNamingUtils.getRevisitorOperationImplementationClassName(this.dsl, clazz));
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public Iterable<Method> allMethods(final ExtendedClass aleClass) {
    final Function1<ExtendedClass, EList<Method>> _function = (ExtendedClass it) -> {
      return it.getMethods();
    };
    return Iterables.<Method>concat(IterableExtensions.<ExtendedClass, EList<Method>>map(this.allParents(aleClass), _function));
  }
  
  public Iterable<ExtendedClass> allParents(final ExtendedClass aleClass) {
    Iterable<ExtendedClass> _xblockexpression = null;
    {
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        return Boolean.valueOf(Objects.equal(it.aleCls, aleClass));
      };
      final EClass ecls = ((EClass) IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function)).eCls);
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, Boolean> _function_1 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        return Boolean.valueOf((Objects.equal(it.eCls, ecls) || ((EClass) it.eCls).isSuperTypeOf(ecls)));
      };
      final Function1<ALERevisitorImplementationCompiler.ResolvedClass, ExtendedClass> _function_2 = (ALERevisitorImplementationCompiler.ResolvedClass it) -> {
        return it.aleCls;
      };
      final Function1<ExtendedClass, Boolean> _function_3 = (ExtendedClass it) -> {
        return Boolean.valueOf((it != null));
      };
      _xblockexpression = IterableExtensions.<ExtendedClass>filter(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass, ExtendedClass>map(IterableExtensions.<ALERevisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function_1), _function_2), _function_3);
    }
    return _xblockexpression;
  }
  
  public <F extends Object> MethodSpec.Builder addConditionalStatement(final MethodSpec.Builder builder, final Function0<Boolean> f, final String s) {
    MethodSpec.Builder _xifexpression = null;
    Boolean _apply = f.apply();
    if ((_apply).booleanValue()) {
      _xifexpression = builder.addStatement(s);
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public MethodSpec.Builder compileBody(final MethodSpec.Builder builderSeed, final Statement body) {
    if (body instanceof FeatureAssignment) {
      return _compileBody(builderSeed, (FeatureAssignment)body);
    } else if (body instanceof FeatureInsert) {
      return _compileBody(builderSeed, (FeatureInsert)body);
    } else if (body instanceof FeatureRemove) {
      return _compileBody(builderSeed, (FeatureRemove)body);
    } else if (body instanceof VariableAssignment) {
      return _compileBody(builderSeed, (VariableAssignment)body);
    } else if (body instanceof Block) {
      return _compileBody(builderSeed, (Block)body);
    } else if (body instanceof ConditionalBlock) {
      return _compileBody(builderSeed, (ConditionalBlock)body);
    } else if (body instanceof ExpressionStatement) {
      return _compileBody(builderSeed, (ExpressionStatement)body);
    } else if (body instanceof FeaturePut) {
      return _compileBody(builderSeed, (FeaturePut)body);
    } else if (body instanceof ForEach) {
      return _compileBody(builderSeed, (ForEach)body);
    } else if (body instanceof If) {
      return _compileBody(builderSeed, (If)body);
    } else if (body instanceof VariableDeclaration) {
      return _compileBody(builderSeed, (VariableDeclaration)body);
    } else if (body instanceof While) {
      return _compileBody(builderSeed, (While)body);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(builderSeed, body).toString());
    }
  }
  
  public TypeName resolveType2(final Object type) {
    if (type instanceof EClassifier) {
      return _resolveType2((EClassifier)type);
    } else if (type instanceof Class) {
      return _resolveType2((Class<?>)type);
    } else if (type != null) {
      return _resolveType2(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  public CodeBlock compileExpression(final EObject call) {
    if (call instanceof ErrorStringLiteral) {
      return _compileExpression((ErrorStringLiteral)call);
    } else if (call instanceof ErrorTypeLiteral) {
      return _compileExpression((ErrorTypeLiteral)call);
    } else if (call instanceof And) {
      return _compileExpression((And)call);
    } else if (call instanceof BooleanLiteral) {
      return _compileExpression((BooleanLiteral)call);
    } else if (call instanceof EnumLiteral) {
      return _compileExpression((EnumLiteral)call);
    } else if (call instanceof ErrorBinding) {
      return _compileExpression((ErrorBinding)call);
    } else if (call instanceof ErrorCall) {
      return _compileExpression((ErrorCall)call);
    } else if (call instanceof ErrorConditional) {
      return _compileExpression((ErrorConditional)call);
    } else if (call instanceof ErrorExpression) {
      return _compileExpression((ErrorExpression)call);
    } else if (call instanceof ErrorVariableDeclaration) {
      return _compileExpression((ErrorVariableDeclaration)call);
    } else if (call instanceof Implies) {
      return _compileExpression((Implies)call);
    } else if (call instanceof IntegerLiteral) {
      return _compileExpression((IntegerLiteral)call);
    } else if (call instanceof Lambda) {
      return _compileExpression((Lambda)call);
    } else if (call instanceof NullLiteral) {
      return _compileExpression((NullLiteral)call);
    } else if (call instanceof Or) {
      return _compileExpression((Or)call);
    } else if (call instanceof RealLiteral) {
      return _compileExpression((RealLiteral)call);
    } else if (call instanceof SequenceInExtensionLiteral) {
      return _compileExpression((SequenceInExtensionLiteral)call);
    } else if (call instanceof SetInExtensionLiteral) {
      return _compileExpression((SetInExtensionLiteral)call);
    } else if (call instanceof StringLiteral) {
      return _compileExpression((StringLiteral)call);
    } else if (call instanceof TypeLiteral) {
      return _compileExpression((TypeLiteral)call);
    } else if (call instanceof EEnumLiteral) {
      return _compileExpression((EEnumLiteral)call);
    } else if (call instanceof Call) {
      return _compileExpression((Call)call);
    } else if (call instanceof Let) {
      return _compileExpression((Let)call);
    } else if (call instanceof VarRef) {
      return _compileExpression((VarRef)call);
    } else if (call instanceof Switch) {
      return _compileExpression((Switch)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
  
  public TypeName solveType(final EClassifier type) {
    if (type instanceof EClass) {
      return _solveType((EClass)type);
    } else if (type instanceof EDataType) {
      return _solveType((EDataType)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
