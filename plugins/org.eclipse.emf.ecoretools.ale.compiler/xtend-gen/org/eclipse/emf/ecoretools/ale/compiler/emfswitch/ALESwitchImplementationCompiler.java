package org.eclipse.emf.ecoretools.ale.compiler.emfswitch;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.SwitchImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.SwitchOperationCompiler;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class ALESwitchImplementationCompiler {
  @Data
  public static class ResolvedClass {
    private final ExtendedClass aleCls;
    
    public final EClassifier eCls;
    
    private final GenClass genCls;
    
    public ResolvedClass(final ExtendedClass aleCls, final EClassifier eCls, final GenClass genCls) {
      super();
      this.aleCls = aleCls;
      this.eCls = eCls;
      this.genCls = genCls;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.aleCls== null) ? 0 : this.aleCls.hashCode());
      result = prime * result + ((this.eCls== null) ? 0 : this.eCls.hashCode());
      return prime * result + ((this.genCls== null) ? 0 : this.genCls.hashCode());
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
      ALESwitchImplementationCompiler.ResolvedClass other = (ALESwitchImplementationCompiler.ResolvedClass) obj;
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
      if (this.genCls == null) {
        if (other.genCls != null)
          return false;
      } else if (!this.genCls.equals(other.genCls))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("aleCls", this.aleCls);
      b.add("eCls", this.eCls);
      b.add("genCls", this.genCls);
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
    
    @Pure
    public GenClass getGenCls() {
      return this.genCls;
    }
  }
  
  @Extension
  private EcoreUtils _ecoreUtils = new EcoreUtils();
  
  private Dsl dsl;
  
  private List<ParseResult<ModelUnit>> parsedSemantics;
  
  private final IQueryEnvironment queryEnvironment;
  
  private final Map<String, Class<?>> registeredServices = CollectionLiterals.<String, Class<?>>newHashMap();
  
  private final JavaExtensionsManager javaExtensions;
  
  private Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private List<ALESwitchImplementationCompiler.ResolvedClass> resolved;
  
  public ALESwitchImplementationCompiler() {
    this.queryEnvironment = this.createQueryEnvironment(false, null);
    this.queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
    this.queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
    this.javaExtensions = JavaExtensionsManager.createManagerWithOverride();
    this.javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {
      @Override
      public void loaded(final String arg0, final Class<?> arg1) {
        ALESwitchImplementationCompiler.this.registeredServices.put(arg0, arg1);
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
        ALESwitchImplementationCompiler.this.registeredServices.remove(arg0);
      }
    });
    InputOutput.<String>println("YOLO");
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
  
  public IStatus compile(final String projectName, final File projectRoot, final Dsl dsl) {
    IStatus _xblockexpression = null;
    {
      this.dsl = dsl;
      this.parsedSemantics = new DslBuilder(this.queryEnvironment).parse(dsl);
      final ArrayList<ExtendedClass> aleClasses = CollectionLiterals.<ExtendedClass>newArrayList();
      for (final ParseResult<ModelUnit> pr : this.parsedSemantics) {
        {
          ModelUnit root = pr.getRoot();
          EList<ExtendedClass> _classExtensions = root.getClassExtensions();
          Iterables.<ExtendedClass>addAll(aleClasses, _classExtensions);
        }
      }
      final Function1<String, String> _function = (String it) -> {
        return it;
      };
      final Function1<String, Pair<EPackage, GenModel>> _function_1 = (String it) -> {
        EPackage _loadEPackage = this._ecoreUtils.loadEPackage(it);
        GenModel _loadGenmodel = this._ecoreUtils.loadGenmodel(it.replaceAll(".ecore$", ".genmodel"));
        return Pair.<EPackage, GenModel>of(_loadEPackage, _loadGenmodel);
      };
      this.syntaxes = IterableExtensions.<String, String, Pair<EPackage, GenModel>>toMap(dsl.getAllSyntaxes(), _function, _function_1);
      final EPackage syntax = this.syntaxes.get(IterableExtensions.<String>head(dsl.getAllSyntaxes())).getKey();
      this.resolved = this.resolve(aleClasses, syntax);
      this.registerServices(projectName);
      this.compile(projectRoot, projectName);
      _xblockexpression = Status.OK_STATUS;
    }
    return _xblockexpression;
  }
  
  private void compile(final File projectRoot, final String projectName) {
    try {
      final File compileDirectory = new File(projectRoot, "switch-comp");
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
      Object _get = this.dsl.getDslProp().get("rootPackage");
      final String packageRoot = ((String) _get);
      final SwitchImplementationCompiler sic = new SwitchImplementationCompiler(compileDirectory, this.syntaxes, packageRoot, this.resolved);
      sic.compile();
      final SwitchOperationCompiler soc = new SwitchOperationCompiler(packageRoot, compileDirectory, this.syntaxes, this.queryEnvironment, 
        this.parsedSemantics, this.resolved, this.registeredServices, this.dsl);
      final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function_2 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
        String _instanceClassName = it.eCls.getInstanceClassName();
        return Boolean.valueOf((!Objects.equal(_instanceClassName, "java.util.Map$Entry")));
      };
      final Consumer<ALESwitchImplementationCompiler.ResolvedClass> _function_3 = (ALESwitchImplementationCompiler.ResolvedClass resolved) -> {
        soc.compile(resolved);
      };
      IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function_2).forEach(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<ALESwitchImplementationCompiler.ResolvedClass> resolve(final List<ExtendedClass> aleClasses, final EPackage syntax) {
    final Function1<EClass, ALESwitchImplementationCompiler.ResolvedClass> _function = (EClass eClass) -> {
      ALESwitchImplementationCompiler.ResolvedClass _xblockexpression = null;
      {
        final Function1<ExtendedClass, Boolean> _function_1 = (ExtendedClass it) -> {
          return Boolean.valueOf((Objects.equal(it.getName(), eClass.getName()) || Objects.equal(it.getName(), ((eClass.getEPackage().getName() + ".") + eClass.getName()))));
        };
        final ExtendedClass aleClass = IterableExtensions.<ExtendedClass>head(IterableExtensions.<ExtendedClass>filter(aleClasses, _function_1));
        final Function2<String, Pair<EPackage, GenModel>, Boolean> _function_2 = (String k, Pair<EPackage, GenModel> v) -> {
          return Boolean.valueOf(this._ecoreUtils.getAllClasses(v.getKey()).contains(eClass));
        };
        final Function1<Pair<EPackage, GenModel>, GenModel> _function_3 = (Pair<EPackage, GenModel> it) -> {
          return it.getValue();
        };
        final Function1<GenModel, Iterable<GenClass>> _function_4 = (GenModel it) -> {
          final Function1<GenPackage, EList<GenClass>> _function_5 = (GenPackage it_1) -> {
            return it_1.getGenClasses();
          };
          return Iterables.<GenClass>concat(ListExtensions.<GenPackage, EList<GenClass>>map(it.getGenPackages(), _function_5));
        };
        final Function1<GenClass, Boolean> _function_5 = (GenClass it) -> {
          EClass _ecoreClass = it.getEcoreClass();
          return Boolean.valueOf(Objects.equal(_ecoreClass, eClass));
        };
        final GenClass gl = IterableExtensions.<GenClass>head(IterableExtensions.<GenClass>filter(Iterables.<GenClass>concat(IterableExtensions.<GenModel, Iterable<GenClass>>map(IterableExtensions.<Pair<EPackage, GenModel>, GenModel>map(MapExtensions.<String, Pair<EPackage, GenModel>>filter(this.syntaxes, _function_2).values(), _function_3), _function_4)), _function_5));
        if ((gl == null)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("gl is null");
          throw new RuntimeException(_builder.toString());
        }
        _xblockexpression = new ALESwitchImplementationCompiler.ResolvedClass(aleClass, eClass, gl);
      }
      return _xblockexpression;
    };
    return ListExtensions.<EClass, ALESwitchImplementationCompiler.ResolvedClass>map(this._ecoreUtils.getAllClasses(syntax), _function);
  }
}
