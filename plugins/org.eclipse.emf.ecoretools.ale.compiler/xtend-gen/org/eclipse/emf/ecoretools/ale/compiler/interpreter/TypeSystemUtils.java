package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class TypeSystemUtils {
  private final Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  @Extension
  private EcoreUtils ecoreUtils = new EcoreUtils();
  
  @Extension
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  private final String packageRoot;
  
  private final BaseValidator base;
  
  private List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved;
  
  public TypeSystemUtils(final Map<String, Pair<EPackage, GenModel>> syntaxes, final String packageRoot, final BaseValidator base, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved) {
    this.syntaxes = syntaxes;
    this.packageRoot = packageRoot;
    this.base = base;
    this.resolved = resolved;
  }
  
  protected Object _solveType(final EClass type) {
    return this.resolveType(type);
  }
  
  protected Object _solveType(final EDataType edt) {
    Object _xifexpression = null;
    boolean _isPrimitive = edt.getInstanceClass().isPrimitive();
    if (_isPrimitive) {
      _xifexpression = edt.getInstanceClass();
    } else {
      _xifexpression = ClassName.get(edt.getInstanceClass());
    }
    return _xifexpression;
  }
  
  public ClassName resolveType(final EClassifier e) {
    ClassName _xblockexpression = null;
    {
      Collection<Pair<EPackage, GenModel>> _values = this.syntaxes.values();
      Pair<EcorePackage, GenModel> _mappedTo = Pair.<EcorePackage, GenModel>of(EcorePackage.eINSTANCE, null);
      final Iterable<Pair<? extends EPackage, GenModel>> stxs = Iterables.<Pair<? extends EPackage, GenModel>>concat(_values, Collections.<Pair<EcorePackage, GenModel>>unmodifiableList(CollectionLiterals.<Pair<EcorePackage, GenModel>>newArrayList(_mappedTo)));
      final Function1<Pair<? extends EPackage, GenModel>, Boolean> _function = (Pair<? extends EPackage, GenModel> it) -> {
        final Function1<EClassifier, Boolean> _function_1 = (EClassifier it_1) -> {
          return Boolean.valueOf((Objects.equal(it_1.getName(), e.getName()) && Objects.equal(it_1.getEPackage().getName(), ((EPackage) e.eContainer()).getName())));
        };
        return Boolean.valueOf(IterableExtensions.<EClassifier>exists(this.ecoreUtils.getAllClassifiers(it.getKey()), _function_1));
      };
      final Pair<? extends EPackage, GenModel> stx = IterableExtensions.<Pair<? extends EPackage, GenModel>>head(IterableExtensions.<Pair<? extends EPackage, GenModel>>filter(stxs, _function));
      final GenModel gm = stx.getValue();
      ClassName _xifexpression = null;
      if ((gm != null)) {
        ClassName _xifexpression_1 = null;
        if ((e instanceof EClass)) {
          _xifexpression_1 = ClassName.get(this.namingUtils.classInterfacePackageName(((EClass)e), this.packageRoot), ((EClass)e).getName());
        } else {
          ClassName _xifexpression_2 = null;
          if ((e instanceof EEnum)) {
            _xifexpression_2 = ClassName.get(this.namingUtils.classInterfacePackageName(((EEnum)e), this.packageRoot), ((EEnum)e).getName());
          } else {
            ClassName _xblockexpression_1 = null;
            {
              final Function1<GenPackage, Iterable<GenClassifier>> _function_1 = (GenPackage it) -> {
                final Function1<GenClassifier, Boolean> _function_2 = (GenClassifier it_1) -> {
                  return Boolean.valueOf((Objects.equal(it_1.getName(), e.getName()) && Objects.equal(it_1.getGenPackage().getEcorePackage().getName(), ((EPackage) e.eContainer()).getName())));
                };
                return IterableExtensions.<GenClassifier>filter(it.getGenClassifiers(), _function_2);
              };
              final GenClassifier gclass = IterableExtensions.<GenClassifier>head(Iterables.<GenClassifier>concat(ListExtensions.<GenPackage, Iterable<GenClassifier>>map(this.ecoreUtils.getAllGenPkgs(gm), _function_1)));
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
              _xblockexpression_1 = _xifexpression_3;
            }
            _xifexpression_2 = _xblockexpression_1;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = ClassName.get("org.eclipse.emf.ecore", e.getName());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Set<IType> infereType(final Expression exp) {
    return this.base.getPossibleTypes(exp);
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
      final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
        ExtendedClass _aleCls = it.getAleCls();
        return Boolean.valueOf(Objects.equal(_aleCls, aleClass));
      };
      final EClassifier ecls = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function)).eCls;
      final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function_1 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
        return Boolean.valueOf((Objects.equal(it.eCls, ecls) || (((it.eCls instanceof EClass) && (ecls instanceof EClass)) && ((EClass) it.eCls).isSuperTypeOf(((EClass) ecls)))));
      };
      final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, ExtendedClass> _function_2 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
        return it.getAleCls();
      };
      final Function1<ExtendedClass, Boolean> _function_3 = (ExtendedClass it) -> {
        return Boolean.valueOf((it != null));
      };
      _xblockexpression = IterableExtensions.<ExtendedClass>filter(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass, ExtendedClass>map(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function_1), _function_2), _function_3);
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
  
  public Object solveType(final EClassifier type) {
    if (type instanceof EClass) {
      return _solveType((EClass)type);
    } else if (type instanceof EDataType) {
      return _solveType((EDataType)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
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
}
