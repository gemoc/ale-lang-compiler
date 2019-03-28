package org.eclipse.emf.ecoretools.ale.compiler;

@SuppressWarnings("all")
public class AlexException extends Exception {
  public AlexException() {
    super();
  }
  
  public AlexException(final String s) {
    super(s);
  }
  
  public AlexException(final Throwable t) {
    super(t);
  }
  
  public AlexException(final String s, final Throwable t) {
    super(s, t);
  }
}
