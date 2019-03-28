package org.eclipse.emf.ecoretools.ale.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.AlexException;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class EcoreUtils {
  private ResourceSetImpl rs = null;
  
  public void resetResourceSet() {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    this.rs = _resourceSetImpl;
  }
  
  public List<Pair<EClass, EClass>> buildExtendedFactoryNames(final List<EClass> classes) {
    List<Pair<EClass, EClass>> _xblockexpression = null;
    {
      final Function1<EClass, Pair<EClass, Iterable<EClass>>> _function = (EClass it) -> {
        Pair<EClass, Iterable<EClass>> _xblockexpression_1 = null;
        {
          final ArrayList<EClass> st = CollectionLiterals.<EClass>newArrayList();
          final Consumer<EClass> _function_1 = (EClass it_1) -> {
            st.add(it_1);
          };
          it.getEAllSuperTypes().forEach(_function_1);
          st.add(it);
          final Function1<EClass, EList<EClass>> _function_2 = (EClass it_1) -> {
            return it_1.getESuperTypes();
          };
          final Function1<EList<EClass>, Boolean> _function_3 = (EList<EClass> it_1) -> {
            int _size = it_1.size();
            return Boolean.valueOf((_size > 1));
          };
          Iterable<EClass> _flatten = Iterables.<EClass>concat(IterableExtensions.<EList<EClass>>filter(ListExtensions.<EClass, EList<EClass>>map(st, _function_2), _function_3));
          _xblockexpression_1 = Pair.<EClass, Iterable<EClass>>of(it, _flatten);
        }
        return _xblockexpression_1;
      };
      final List<Pair<EClass, Iterable<EClass>>> a = ListExtensions.<EClass, Pair<EClass, Iterable<EClass>>>map(classes, _function);
      final Function<Pair<EClass, Iterable<EClass>>, String> _function_1 = (Pair<EClass, Iterable<EClass>> t) -> {
        return t.getKey().getName();
      };
      final Function<Pair<EClass, Iterable<EClass>>, String> _function_2 = (Pair<EClass, Iterable<EClass>> t) -> {
        return t.getKey().getEPackage().getName();
      };
      final List<Pair<EClass, Iterable<EClass>>> b = IterableExtensions.<Pair<EClass, Iterable<EClass>>>sortWith(a, 
        Comparator.<Pair<EClass, Iterable<EClass>>, String>comparing(_function_1).<String>thenComparing(_function_2));
      final Function1<Pair<EClass, Iterable<EClass>>, List<Pair<EClass, EClass>>> _function_3 = (Pair<EClass, Iterable<EClass>> p) -> {
        List<Pair<EClass, EClass>> _xblockexpression_1 = null;
        {
          final List<Pair<EClass, EClass>> ret = CollectionLiterals.<Pair<EClass, EClass>>newArrayList();
          final EClass k = p.getKey();
          Pair<EClass, EClass> _mappedTo = Pair.<EClass, EClass>of(k, null);
          ret.add(_mappedTo);
          final Iterable<EClass> pv = p.getValue();
          final Function1<EClass, Pair<EClass, EClass>> _function_4 = (EClass l) -> {
            return Pair.<EClass, EClass>of(k, l);
          };
          final List<Pair<EClass, EClass>> ll = IterableExtensions.<Pair<EClass, EClass>>toList(IterableExtensions.<EClass, Pair<EClass, EClass>>map(pv, _function_4));
          ret.addAll(ll);
          _xblockexpression_1 = ret;
        }
        return _xblockexpression_1;
      };
      final List<List<Pair<EClass, EClass>>> c = ListExtensions.<Pair<EClass, Iterable<EClass>>, List<Pair<EClass, EClass>>>map(b, _function_3);
      _xblockexpression = IterableExtensions.<Pair<EClass, EClass>>toList(Iterables.<Pair<EClass, EClass>>concat(c));
    }
    return _xblockexpression;
  }
  
  public <R extends Object> Iterable<R> getComplementaryFromEPackage(final EPackage pkg, final Function1<? super Map.Entry<String, String>, ? extends List<R>> transformation) {
    Iterable<R> _xifexpression = null;
    if (((pkg != null) && IterableExtensions.<EAnnotation>exists(pkg.getEAnnotations(), ((Function1<EAnnotation, Boolean>) (EAnnotation it) -> {
      String _source = it.getSource();
      return Boolean.valueOf(Objects.equal(_source, "@BrewRequires"));
    })))) {
      final Function1<EAnnotation, Boolean> _function = (EAnnotation it) -> {
        String _source = it.getSource();
        return Boolean.valueOf(Objects.equal(_source, "@BrewRequires"));
      };
      final Function1<Map.Entry<String, String>, Boolean> _function_1 = (Map.Entry<String, String> it) -> {
        String _value = it.getValue();
        return Boolean.valueOf(Objects.equal(_value, "ecoreUrl"));
      };
      final Function1<Map.Entry<String, String>, List<R>> _function_2 = (Map.Entry<String, String> it) -> {
        return transformation.apply(it);
      };
      _xifexpression = Iterables.<R>concat(IterableExtensions.<Map.Entry<String, String>, List<R>>map(IterableExtensions.<Map.Entry<String, String>>filter(IterableExtensions.<EAnnotation>findFirst(pkg.getEAnnotations(), _function).getDetails(), _function_1), _function_2));
    } else {
      _xifexpression = Collections.<R>unmodifiableList(CollectionLiterals.<R>newArrayList());
    }
    return _xifexpression;
  }
  
  public List<EClass> sortByName(final Iterable<EClass> classes) {
    final Function<EClass, String> _function = (EClass t) -> {
      return t.getName();
    };
    final Function<EClass, String> _function_1 = (EClass t) -> {
      return t.getEPackage().getName();
    };
    return IterableExtensions.<EClass>sortWith(classes, Comparator.<EClass, String>comparing(_function).<String>thenComparing(_function_1));
  }
  
  public List<Pair<EClass, EClass>> getSubClasses(final EClass cls, final List<Pair<EClass, EClass>> classes) {
    final Function1<Pair<EClass, EClass>, Boolean> _function = (Pair<EClass, EClass> o) -> {
      boolean _xblockexpression = false;
      {
        final Function1<EClass, Boolean> _function_1 = (EClass it) -> {
          return Boolean.valueOf((Objects.equal(it.getName(), cls.getName()) && Objects.equal(it.getEPackage().getName(), cls.getEPackage().getName())));
        };
        final boolean isSuperType = IterableExtensions.<EClass>exists(o.getKey().getEAllSuperTypes(), _function_1);
        _xblockexpression = (((!Objects.equal(o.getKey(), cls)) && isSuperType) && (((o.getValue() == null) || Objects.equal(o.getValue(), cls)) || o.getValue().getEAllSuperTypes().contains(cls)));
      }
      return Boolean.valueOf(_xblockexpression);
    };
    final Iterable<Pair<EClass, EClass>> tmp = IterableExtensions.<Pair<EClass, EClass>>filter(classes, _function);
    final Function1<Pair<EClass, EClass>, EClass> _function_1 = (Pair<EClass, EClass> it) -> {
      return it.getKey();
    };
    final Function1<EClass, Pair<EClass, EClass>> _function_2 = (EClass k) -> {
      Pair<EClass, EClass> _xblockexpression = null;
      {
        final Function1<Pair<EClass, EClass>, Boolean> _function_3 = (Pair<EClass, EClass> it) -> {
          EClass _key = it.getKey();
          return Boolean.valueOf(Objects.equal(_key, k));
        };
        final Iterable<Pair<EClass, EClass>> matched = IterableExtensions.<Pair<EClass, EClass>>filter(tmp, _function_3);
        Pair<EClass, EClass> _xifexpression = null;
        int _size = IterableExtensions.size(matched);
        boolean _equals = (_size == 1);
        if (_equals) {
          _xifexpression = IterableExtensions.<Pair<EClass, EClass>>head(matched);
        } else {
          final Function1<Pair<EClass, EClass>, Boolean> _function_4 = (Pair<EClass, EClass> it) -> {
            EClass _value = it.getValue();
            return Boolean.valueOf((_value != null));
          };
          _xifexpression = IterableExtensions.<Pair<EClass, EClass>>head(IterableExtensions.<Pair<EClass, EClass>>filter(matched, _function_4));
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    };
    return IterableExtensions.<Pair<EClass, EClass>>toList(IterableExtensions.<EClass, Pair<EClass, EClass>>map(IterableExtensions.<EClass>toSet(IterableExtensions.<Pair<EClass, EClass>, EClass>map(tmp, _function_1)), _function_2));
  }
  
  public List<EClass> getAllClasses(final EPackage pkg) {
    final ArrayList<EClass> ret = CollectionLiterals.<EClass>newArrayList();
    if ((pkg != null)) {
      Iterable<EClass> _filter = Iterables.<EClass>filter(pkg.getEClassifiers(), EClass.class);
      Iterables.<EClass>addAll(ret, _filter);
      List<EClass> _allClasses = this.getAllClasses(this.getAllSubPkgs(pkg));
      Iterables.<EClass>addAll(ret, _allClasses);
      List<EClass> _allClasses_1 = this.getAllClasses(this.getReferencedPkgs(pkg));
      Iterables.<EClass>addAll(ret, _allClasses_1);
    }
    return IterableExtensions.<EClass>toList(IterableExtensions.<EClass>toSet(ret));
  }
  
  public List<EClassifier> getAllClassifiers(final EPackage pkg) {
    final ArrayList<EClassifier> ret = CollectionLiterals.<EClassifier>newArrayList();
    if ((pkg != null)) {
      EList<EClassifier> _eClassifiers = pkg.getEClassifiers();
      Iterables.<EClassifier>addAll(ret, _eClassifiers);
      List<EClassifier> _allClassifiers = this.getAllClassifiers(this.getAllSubPkgs(pkg));
      Iterables.<EClassifier>addAll(ret, _allClassifiers);
      List<EClassifier> _allClassifiers_1 = this.getAllClassifiers(this.getReferencedPkgs(pkg));
      Iterables.<EClassifier>addAll(ret, _allClassifiers_1);
    }
    return IterableExtensions.<EClassifier>toList(IterableExtensions.<EClassifier>toSet(ret));
  }
  
  public List<EClass> getAllClasses(final List<EPackage> pkgs) {
    final Function1<EPackage, List<EClass>> _function = (EPackage it) -> {
      return this.getAllClasses(it);
    };
    return IterableExtensions.<EClass>toList(IterableExtensions.<EClass>toSet(Iterables.<EClass>concat(ListExtensions.<EPackage, List<EClass>>map(pkgs, _function))));
  }
  
  public List<EClassifier> getAllClassifiers(final List<EPackage> pkgs) {
    final Function1<EPackage, List<EClassifier>> _function = (EPackage it) -> {
      return this.getAllClassifiers(it);
    };
    return IterableExtensions.<EClassifier>toList(IterableExtensions.<EClassifier>toSet(Iterables.<EClassifier>concat(ListExtensions.<EPackage, List<EClassifier>>map(pkgs, _function))));
  }
  
  public List<EPackage> getAllSubPkgs(final EPackage pkg) {
    final ArrayList<EPackage> ret = CollectionLiterals.<EPackage>newArrayList();
    this.getAllSubPkgsRec(pkg, ret);
    return ret;
  }
  
  private void getAllSubPkgsRec(final EPackage pkg, final List<EPackage> ret) {
    final Consumer<EPackage> _function = (EPackage p) -> {
      this.getAllSubPkgsRec(p, ret);
      ret.add(p);
    };
    pkg.getESubpackages().forEach(_function);
  }
  
  public List<EPackage> getDirectReferencedPkgs(final EPackage pkg) {
    final ArrayList<EPackage> ret = CollectionLiterals.<EPackage>newArrayList();
    final Function2<EObject, Collection<EStructuralFeature.Setting>, Boolean> _function = (EObject o, Collection<EStructuralFeature.Setting> s) -> {
      return Boolean.valueOf((o instanceof EClass));
    };
    final BiConsumer<EObject, Collection<EStructuralFeature.Setting>> _function_1 = (EObject cls, Collection<EStructuralFeature.Setting> s) -> {
      EObject container = cls;
      while (((container != null) && (!(container instanceof EPackage)))) {
        container = container.eContainer();
      }
      final EPackage referenced = ((EPackage) container);
      if ((((referenced != null) && (!IterableExtensions.<EPackage>exists(ret, ((Function1<EPackage, Boolean>) (EPackage it) -> {
        String _nsURI = it.getNsURI();
        String _nsURI_1 = referenced.getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      })))) && (!this.isEcore(referenced)))) {
        ret.add(referenced);
      }
    };
    MapExtensions.<EObject, Collection<EStructuralFeature.Setting>>filter(EcoreUtil.ExternalCrossReferencer.find(pkg), _function).forEach(_function_1);
    final Function1<Map.Entry<String, String>, List<EPackage>> _function_2 = (Map.Entry<String, String> it) -> {
      EPackage _loadEPackage = this.loadEPackage(it.getKey());
      return Collections.<EPackage>unmodifiableList(CollectionLiterals.<EPackage>newArrayList(_loadEPackage));
    };
    final Consumer<EPackage> _function_3 = (EPackage pp) -> {
      final Function1<EPackage, Boolean> _function_4 = (EPackage it) -> {
        String _name = pp.getName();
        String _name_1 = it.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      boolean _exists = IterableExtensions.<EPackage>exists(ret, _function_4);
      boolean _not = (!_exists);
      if (_not) {
        ret.add(pp);
      }
    };
    this.<EPackage>getComplementaryFromEPackage(pkg, _function_2).forEach(_function_3);
    return ret;
  }
  
  public List<EPackage> getReferencedPkgs(final EPackage pkg) {
    final ArrayList<EPackage> ret = CollectionLiterals.<EPackage>newArrayList();
    this.getReferencedPkgsRec(pkg, ret);
    return ret;
  }
  
  private final Map<EPackage, Map<EObject, Collection<EStructuralFeature.Setting>>> cache = CollectionLiterals.<EPackage, Map<EObject, Collection<EStructuralFeature.Setting>>>newHashMap();
  
  private void getReferencedPkgsRec(final EPackage pkg, final List<EPackage> ret) {
    boolean _containsKey = this.cache.containsKey(pkg);
    boolean _not = (!_containsKey);
    if (_not) {
      this.cache.put(pkg, EcoreUtil.ExternalCrossReferencer.find(pkg));
    }
    final Function2<EObject, Collection<EStructuralFeature.Setting>, Boolean> _function = (EObject o, Collection<EStructuralFeature.Setting> s) -> {
      return Boolean.valueOf((o instanceof EClass));
    };
    final BiConsumer<EObject, Collection<EStructuralFeature.Setting>> _function_1 = (EObject cls, Collection<EStructuralFeature.Setting> s) -> {
      EObject container = cls;
      while (((container != null) && (!(container instanceof EPackage)))) {
        container = container.eContainer();
      }
      final EPackage referenced = ((EPackage) container);
      if ((((referenced != null) && (!IterableExtensions.<EPackage>exists(ret, ((Function1<EPackage, Boolean>) (EPackage it) -> {
        String _nsURI = it.getNsURI();
        String _nsURI_1 = referenced.getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      })))) && (!this.isEcore(referenced)))) {
        ret.add(referenced);
        this.getReferencedPkgsRec(referenced, ret);
      }
    };
    MapExtensions.<EObject, Collection<EStructuralFeature.Setting>>filter(this.cache.get(pkg), _function).forEach(_function_1);
  }
  
  public boolean hasRequiredAnnotation(final EClass cls) {
    final Function1<EAnnotation, Boolean> _function = (EAnnotation it) -> {
      String _source = it.getSource();
      return Boolean.valueOf(Objects.equal(_source, "@Required"));
    };
    return IterableExtensions.<EAnnotation>exists(cls.getEAnnotations(), _function);
  }
  
  public boolean isEcore(final EPackage pkg) {
    String _nsURI = pkg.getNsURI();
    return Objects.equal(_nsURI, "http://www.eclipse.org/emf/2002/Ecore");
  }
  
  public GenClass getGenClass(final EClass cls, final GenModel gm) {
    try {
      final List<GenPackage> allPkgs = this.getAllGenPkgs(gm);
      final Function1<GenPackage, Boolean> _function = (GenPackage it) -> {
        String _nsURI = it.getEcorePackage().getNsURI();
        String _nsURI_1 = cls.getEPackage().getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      };
      final GenPackage fgm = IterableExtensions.<GenPackage>findFirst(allPkgs, _function);
      EList<GenClass> _genClasses = null;
      if (fgm!=null) {
        _genClasses=fgm.getGenClasses();
      }
      final EList<GenClass> classes = _genClasses;
      GenClass _findFirst = null;
      if (classes!=null) {
        final Function1<GenClass, Boolean> _function_1 = (GenClass it) -> {
          String _name = it.getName();
          String _name_1 = cls.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        _findFirst=IterableExtensions.<GenClass>findFirst(classes, _function_1);
      }
      final GenClass ret = _findFirst;
      if ((ret == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("No GenClass for ");
        String _name = cls.getEPackage().getName();
        _builder.append(_name);
        _builder.append(".");
        String _name_1 = cls.getName();
        _builder.append(_name_1);
        _builder.append(" in ");
        _builder.append(gm);
        throw new AlexException(_builder.toString());
      }
      return ret;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<GenPackage> getAllGenPkgs(final List<GenModel> gms) {
    final Function1<GenModel, List<GenPackage>> _function = (GenModel it) -> {
      return this.getAllGenPkgs(it);
    };
    return IterableExtensions.<GenPackage>toList(Iterables.<GenPackage>concat(ListExtensions.<GenModel, List<GenPackage>>map(gms, _function)));
  }
  
  public List<GenPackage> getAllGenPkgs(final GenModel gm) {
    final ArrayList<GenPackage> ret = CollectionLiterals.<GenPackage>newArrayList();
    this.getAllGenPkgsRec(gm, ret);
    return ret;
  }
  
  private void getAllGenPkgsRec(final GenModel gm, final List<GenPackage> ret) {
    final Function1<GenPackage, Boolean> _function = (GenPackage gp) -> {
      final Function1<GenPackage, Boolean> _function_1 = (GenPackage it) -> {
        String _nsURI = it.getEcorePackage().getNsURI();
        String _nsURI_1 = gp.getEcorePackage().getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      };
      boolean _exists = IterableExtensions.<GenPackage>exists(ret, _function_1);
      return Boolean.valueOf((!_exists));
    };
    final Consumer<GenPackage> _function_1 = (GenPackage gp) -> {
      ret.add(gp);
      this.getAllGenPkgsRec(gp, ret);
    };
    IterableExtensions.<GenPackage>filter(gm.getGenPackages(), _function).forEach(_function_1);
    final Function1<GenPackage, Boolean> _function_2 = (GenPackage gp) -> {
      return Boolean.valueOf((((gp != null) && (gp.getEcorePackage() != null)) && (!IterableExtensions.<GenPackage>exists(ret, ((Function1<GenPackage, Boolean>) (GenPackage it) -> {
        String _nsURI = it.getEcorePackage().getNsURI();
        String _nsURI_1 = gp.getEcorePackage().getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      })))));
    };
    final Consumer<GenPackage> _function_3 = (GenPackage gp) -> {
      ret.add(gp);
      this.getAllGenPkgsRec(gp.getGenModel(), ret);
      this.getAllGenPkgsRec(gp, ret);
    };
    IterableExtensions.<GenPackage>filter(gm.getUsedGenPackages(), _function_2).forEach(_function_3);
  }
  
  private void getAllGenPkgsRec(final GenPackage gp, final List<GenPackage> ret) {
    final Function1<GenPackage, Boolean> _function = (GenPackage gpp) -> {
      final Function1<GenPackage, Boolean> _function_1 = (GenPackage it) -> {
        String _nsURI = it.getEcorePackage().getNsURI();
        String _nsURI_1 = gpp.getEcorePackage().getNsURI();
        return Boolean.valueOf(Objects.equal(_nsURI, _nsURI_1));
      };
      boolean _exists = IterableExtensions.<GenPackage>exists(ret, _function_1);
      return Boolean.valueOf((!_exists));
    };
    final Consumer<GenPackage> _function_1 = (GenPackage gpp) -> {
      ret.add(gp);
      this.getAllGenPkgsRec(gpp, ret);
    };
    IterableExtensions.<GenPackage>filter(gp.getSubGenPackages(), _function).forEach(_function_1);
  }
  
  public EPackage getEPackage(final GenModel gm) {
    return IterableExtensions.<GenPackage>head(gm.getGenPackages()).getEcorePackage();
  }
  
  public GenPackage getGenPackage(final GenModel gm) {
    return IterableExtensions.<GenPackage>head(gm.getGenPackages());
  }
  
  public EPackage loadEPackage(final String path) {
    if ((this.rs == null)) {
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      this.rs = _resourceSetImpl;
    }
    Map<String, Object> _extensionToFactoryMap = this.rs.getResourceFactoryRegistry().getExtensionToFactoryMap();
    EcoreResourceFactoryImpl _ecoreResourceFactoryImpl = new EcoreResourceFactoryImpl();
    _extensionToFactoryMap.put("ecore", _ecoreResourceFactoryImpl);
    try {
      Resource _xifexpression = null;
      boolean _startsWith = path.startsWith("platform:/");
      if (_startsWith) {
        _xifexpression = this.rs.getResource(URI.createURI(path), true);
      } else {
        Resource _xifexpression_1 = null;
        boolean _startsWith_1 = path.startsWith("/");
        if (_startsWith_1) {
          _xifexpression_1 = this.rs.getResource(URI.createPlatformResourceURI(path, true), true);
        } else {
          _xifexpression_1 = this.rs.getResource(URI.createURI(path), true);
        }
        _xifexpression = _xifexpression_1;
      }
      final Resource resource = _xifexpression;
      this.rs.getURIConverter().getURIMap().put(URI.createURI(resource.getURI().lastSegment()), resource.getURI());
      EObject _head = IterableExtensions.<EObject>head(resource.getContents());
      return ((EPackage) _head);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public GenModel loadGenmodel(final String path) {
    GenModel _xblockexpression = null;
    {
      if ((this.rs == null)) {
        ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
        this.rs = _resourceSetImpl;
      }
      Map<String, Object> _extensionToFactoryMap = this.rs.getResourceFactoryRegistry().getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("genmodel", _xMIResourceFactoryImpl);
      GenModel _xtrycatchfinallyexpression = null;
      try {
        GenModel _xblockexpression_1 = null;
        {
          Resource _xifexpression = null;
          boolean _startsWith = path.startsWith("platform:/");
          if (_startsWith) {
            _xifexpression = this.rs.getResource(URI.createURI(path), true);
          } else {
            Resource _xifexpression_1 = null;
            boolean _startsWith_1 = path.startsWith("/");
            if (_startsWith_1) {
              _xifexpression_1 = this.rs.getResource(URI.createPlatformResourceURI(path, true), true);
            } else {
              _xifexpression_1 = this.rs.getResource(URI.createURI(path), true);
            }
            _xifexpression = _xifexpression_1;
          }
          final Resource resource = _xifexpression;
          EObject _head = IterableExtensions.<EObject>head(resource.getContents());
          _xblockexpression_1 = ((GenModel) _head);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          return null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
}
