package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import javax.lang.model.element.Modifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.JavaPoetUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorTypeSystemUtil;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class OperationInterfaceCompiler {
  @Extension
  private EcoreUtils ecoreUtils = new EcoreUtils();
  
  @Extension
  private VisitorNamingUtils namingUtils = new VisitorNamingUtils();
  
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  @Extension
  private VisitorTypeSystemUtil tsu;
  
  private final File directory;
  
  private final String packageRoot;
  
  private final Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  public OperationInterfaceCompiler(final File directory, final String packageRoot, final Map<String, Pair<EPackage, GenModel>> syntaxes) {
    this.directory = directory;
    this.packageRoot = packageRoot;
    this.syntaxes = syntaxes;
    VisitorTypeSystemUtil _visitorTypeSystemUtil = new VisitorTypeSystemUtil(syntaxes, this.namingUtils, packageRoot);
    this.tsu = _visitorTypeSystemUtil;
  }
  
  public void compile(final EClass eClass, final ExtendedClass aleClass) {
    try {
      final Function1<EClass, ClassName> _function = (EClass it) -> {
        return ClassName.get(this.namingUtils.operationInterfacePackageName(this.packageRoot, it), 
          this.namingUtils.operationInterfaceClassName(it));
      };
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_1 = (TypeSpec.Builder it) -> {
        final Function1<Method, MethodSpec> _function_2 = (Method method) -> {
          MethodSpec _xblockexpression = null;
          {
            EClassifier _eType = method.getOperationRef().getEType();
            TypeName _resolveType2 = null;
            if (_eType!=null) {
              _resolveType2=this.tsu.resolveType2(_eType);
            }
            final TypeName retType = _resolveType2;
            final Function1<MethodSpec.Builder, MethodSpec.Builder> _function_3 = (MethodSpec.Builder it_1) -> {
              return it_1.returns(retType);
            };
            final Function1<EParameter, ParameterSpec> _function_4 = (EParameter param) -> {
              ParameterSpec _xifexpression = null;
              Class<?> _instanceClass = param.getEType().getInstanceClass();
              boolean _tripleNotEquals = (_instanceClass != null);
              if (_tripleNotEquals) {
                ParameterSpec _xifexpression_1 = null;
                if (((param.getEType() instanceof EClass) && (!Objects.equal(param.getEType().getEPackage(), EcorePackage.eINSTANCE)))) {
                  EClassifier _eType_1 = param.getEType();
                  EClassifier _eType_2 = param.getEType();
                  _xifexpression_1 = ParameterSpec.builder(
                    ClassName.get(this.namingUtils.classInterfacePackageName(((EClass) _eType_1), this.packageRoot), 
                      ((EClass) _eType_2).getName()), param.getName()).build();
                } else {
                  _xifexpression_1 = ParameterSpec.builder(param.getEType().getInstanceClass(), param.getName()).build();
                }
                _xifexpression = _xifexpression_1;
              } else {
                _xifexpression = ParameterSpec.builder(this.resolveType(param.getEType()), param.getName()).build();
              }
              return _xifexpression;
            };
            _xblockexpression = this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(MethodSpec.methodBuilder(method.getOperationRef().getName()), Boolean.valueOf((retType != 
              null)), _function_3).addParameters(ListExtensions.<EParameter, ParameterSpec>map(method.getOperationRef().getEParameters(), _function_4)).addModifiers(Modifier.ABSTRACT, Modifier.PUBLIC).build();
          }
          return _xblockexpression;
        };
        return it.addMethods(ListExtensions.<Method, MethodSpec>map(aleClass.getMethods(), _function_2));
      };
      final TypeSpec factory = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(TypeSpec.interfaceBuilder(this.namingUtils.operationInterfaceClassName(eClass)).addSuperinterfaces(ListExtensions.<EClass, ClassName>map(eClass.getESuperTypes(), _function)), Boolean.valueOf((aleClass != null)), _function_1).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(this.namingUtils.operationInterfacePackageName(this.packageRoot, eClass), factory).indent("\t").build();
      javaFile.writeTo(this.directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ClassName resolveType(final EClassifier e) {
    ClassName _xblockexpression = null;
    {
      Collection<Pair<EPackage, GenModel>> _values = this.syntaxes.values();
      Pair<EcorePackage, GenModel> _mappedTo = Pair.<EcorePackage, GenModel>of(EcorePackage.eINSTANCE, null);
      final Iterable<Pair<? extends EPackage, GenModel>> stxs = Iterables.<Pair<? extends EPackage, GenModel>>concat(_values, Collections.<Pair<EcorePackage, GenModel>>unmodifiableList(CollectionLiterals.<Pair<EcorePackage, GenModel>>newArrayList(_mappedTo)));
      final Function1<Pair<? extends EPackage, GenModel>, Boolean> _function = (Pair<? extends EPackage, GenModel> it) -> {
        final Function1<EClass, Boolean> _function_1 = (EClass it_1) -> {
          return Boolean.valueOf((Objects.equal(it_1.getName(), e.getName()) && Objects.equal(it_1.getEPackage().getName(), ((EPackage) e.eContainer()).getName())));
        };
        return Boolean.valueOf(IterableExtensions.<EClass>exists(this.ecoreUtils.getAllClasses(it.getKey()), _function_1));
      };
      final Pair<? extends EPackage, GenModel> stx = IterableExtensions.<Pair<? extends EPackage, GenModel>>head(IterableExtensions.<Pair<? extends EPackage, GenModel>>filter(stxs, _function));
      final GenModel gm = stx.getValue();
      ClassName _xifexpression = null;
      if ((gm != null)) {
        ClassName _xifexpression_1 = null;
        if ((e instanceof EClass)) {
          _xifexpression_1 = ClassName.get(this.namingUtils.classInterfacePackageName(((EClass)e), this.packageRoot), ((EClass)e).getName());
        } else {
          ClassName _xblockexpression_1 = null;
          {
            final Function1<GenPackage, Iterable<GenClass>> _function_1 = (GenPackage it) -> {
              final Function1<GenClass, Boolean> _function_2 = (GenClass it_1) -> {
                return Boolean.valueOf((Objects.equal(it_1.getName(), e.getName()) && Objects.equal(it_1.getGenPackage().getEcorePackage().getName(), ((EPackage) e.eContainer()).getName())));
              };
              return IterableExtensions.<GenClass>filter(it.getGenClasses(), _function_2);
            };
            final GenClass gclass = IterableExtensions.<GenClass>head(Iterables.<GenClass>concat(ListExtensions.<GenPackage, Iterable<GenClass>>map(this.ecoreUtils.getAllGenPkgs(gm), _function_1)));
            final String[] split = gclass.getQualifiedInterfaceName().split("\\.");
            final String pkg = IterableExtensions.join(ListExtensions.<String>reverse(IterableExtensions.<String>toList(IterableExtensions.<String>tail(ListExtensions.<String>reverse(CollectionLiterals.<String>newArrayList(split))))), ".");
            final String cn = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(split)));
            _xblockexpression_1 = ClassName.get(pkg, cn);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = ClassName.get("org.eclipse.emf.ecore", e.getName());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
