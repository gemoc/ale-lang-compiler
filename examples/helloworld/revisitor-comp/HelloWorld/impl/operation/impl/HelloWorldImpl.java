package HelloWorld.impl.operation.impl;

import HelloWorld.impl.operation.HelloWorld;
import helloworld.revisitor.HelloworldRevisitor;
import java.lang.String;

public class HelloWorldImpl implements HelloWorld {
  private HelloworldRevisitor<HelloWorld> rev;

  private helloworld.HelloWorld obj;

  public HelloWorldImpl(helloworld.HelloWorld obj, HelloworldRevisitor<HelloWorld> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public String greeting() {
    String result;
    String msg = ((String)"Hello world!");
    result = msg;
    return result;
  }

  public void entryPoint() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(rev.$(this.obj).greeting());
  }
}
