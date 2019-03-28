package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class JavaPoetUtils {
  public <T extends Object> T applyIfTrue(final T t, final Boolean cond, final Function1<T, T> app) {
    T _xifexpression = null;
    if ((cond).booleanValue()) {
      _xifexpression = app.apply(t);
    } else {
      _xifexpression = t;
    }
    return _xifexpression;
  }
}
