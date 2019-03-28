package org.eclipse.emf.ecoretools.ale.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobFunction;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.ALERevisitorImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.ALEVisitorImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ALEImplementationCompiler {
  /**
   * @param dslStr absolute path to the dsl file
   * @param projectRoot absolute path to the project root
   * @param projectName project name
   */
  public void compile(final String dslStr, final File projectRoot, final String projectName, final Map<String, Class<?>> services) throws FileNotFoundException {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ALE Compilation");
    final IJobFunction _function = (IProgressMonitor monitor) -> {
      try {
        IStatus _xblockexpression = null;
        {
          final WorkbenchDsl dsl = new WorkbenchDsl(dslStr);
          String _property = dsl.getDslProp().getProperty("compilationType");
          String _lowerCase = null;
          if (_property!=null) {
            _lowerCase=_property.toLowerCase();
          }
          final String compilationType = _lowerCase;
          IStatus _xifexpression = null;
          if ((compilationType != null)) {
            IStatus _switchResult = null;
            if (compilationType != null) {
              switch (compilationType) {
                case "revisitor":
                  _switchResult = new ALERevisitorImplementationCompiler().compile(projectName, projectRoot, dsl);
                  break;
                case "interpreter":
                  _switchResult = new ALEInterpreterImplementationCompiler().compile(projectName, projectRoot, dsl, services);
                  break;
                case "visitor":
                  _switchResult = new ALEVisitorImplementationCompiler().compile(projectName, projectRoot, dsl);
                  break;
                case "switch":
                  _switchResult = new ALESwitchImplementationCompiler().compile(projectName, projectRoot, dsl);
                  break;
                default:
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("value ");
                  _builder_1.append(compilationType);
                  _builder_1.append(" unknown for \"compilationType\" key in ");
                  String _sourceFileName = dsl.getSourceFileName();
                  _builder_1.append(_sourceFileName);
                  _builder_1.append(".");
                  throw new RuntimeException(_builder_1.toString());
              }
            } else {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("value ");
              _builder_1.append(compilationType);
              _builder_1.append(" unknown for \"compilationType\" key in ");
              String _sourceFileName = dsl.getSourceFileName();
              _builder_1.append(_sourceFileName);
              _builder_1.append(".");
              throw new RuntimeException(_builder_1.toString());
            }
            _xifexpression = _switchResult;
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("\"compilationType\" key not defined in ");
            String _sourceFileName_1 = dsl.getSourceFileName();
            _builder_2.append(_sourceFileName_1);
            _builder_2.append(".");
            throw new RuntimeException(_builder_2.toString());
          }
          _xblockexpression = _xifexpression;
        }
        return _xblockexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final Job a = Job.create(_builder.toString(), _function);
    a.setRule(ResourcesPlugin.getWorkspace().getRoot());
    a.schedule();
  }
}
