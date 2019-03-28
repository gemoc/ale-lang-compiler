package org.eclipse.emf.ecoretools.ale.compiler.visitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorNamingUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class VisitorTypeSystemUtil {
  private final Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  @Extension
  private VisitorNamingUtils vnu;
  
  @Extension
  private EcoreUtils ecoreUtils = new EcoreUtils();
  
  private final String packageRoot;
  
  public VisitorTypeSystemUtil(final Map<String, Pair<EPackage, GenModel>> syntaxes, final VisitorNamingUtils vnu, final String packageRoot) {
    this.syntaxes = syntaxes;
    this.vnu = vnu;
    this.packageRoot = packageRoot;
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
          _xifexpression_1 = ClassName.get(this.vnu.classInterfacePackageName(((EClass)e), this.packageRoot), ((EClass)e).getName());
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
            ClassName _xifexpression_2 = null;
            if ((gclass instanceof GenClass)) {
              _xifexpression_2 = ClassName.get(((GenClass)gclass).getQualifiedInterfaceName(), ((GenClass)gclass).getName());
            } else {
              ClassName _xifexpression_3 = null;
              if ((gclass instanceof GenEnum)) {
                _xifexpression_3 = ClassName.get(((GenEnum)gclass).getGenPackage().getInterfacePackageName(), ((GenEnum)gclass).getName());
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_1 = _xifexpression_2;
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
