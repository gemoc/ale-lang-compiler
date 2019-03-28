package org.eclipse.emf.ecoretools.ale.compiler.emfswitch;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.SwitchNamingUtils;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class TypeSystemUtils {
  private final Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  @Extension
  private EcoreUtils ecoreUtils = new EcoreUtils();
  
  @Extension
  private SwitchNamingUtils namingUtils = new SwitchNamingUtils();
  
  private final String packageRoot;
  
  private final BaseValidator base;
  
  private List<ALESwitchImplementationCompiler.ResolvedClass> resolved;
  
  public TypeSystemUtils(final Map<String, Pair<EPackage, GenModel>> syntaxes, final String packageRoot, final BaseValidator base, final List<ALESwitchImplementationCompiler.ResolvedClass> resolved) {
    this.syntaxes = syntaxes;
    this.packageRoot = packageRoot;
    this.base = base;
    this.resolved = resolved;
  }
  
  protected TypeName _solveType(final EClass type) {
    return this.resolveType(type);
  }
  
  protected TypeName _solveType(final EDataType edt) {
    return TypeName.get(edt.getInstanceClass());
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
        return Boolean.valueOf(IterableExtensions.<EClassifier>exists(this.ecoreUtils.getAllClassifiers(it.getKey()), _function_1));
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
                return Boolean.valueOf(IterableExtensions.<EClass>exists(this.ecoreUtils.getAllClasses(v.getKey()), _function_2));
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
      final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
        ExtendedClass _aleCls = it.getAleCls();
        return Boolean.valueOf(Objects.equal(_aleCls, aleClass));
      };
      final EClassifier ecls = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function)).eCls;
      final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function_1 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
        return Boolean.valueOf((Objects.equal(it.eCls, ecls) || ((EClass) it.eCls).isSuperTypeOf(((EClass) ecls))));
      };
      final Function1<ALESwitchImplementationCompiler.ResolvedClass, ExtendedClass> _function_2 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
        return it.getAleCls();
      };
      final Function1<ExtendedClass, Boolean> _function_3 = (ExtendedClass it) -> {
        return Boolean.valueOf((it != null));
      };
      _xblockexpression = IterableExtensions.<ExtendedClass>filter(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass, ExtendedClass>map(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function_1), _function_2), _function_3);
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
