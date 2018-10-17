package HelloWorld.impl;

import HelloWorld.impl.operation.HelloWorld;
import HelloWorld.impl.operation.impl.HelloWorldImpl;
import helloworld.revisitor.HelloworldRevisitor;

public interface HelloWorldImplementation extends HelloworldRevisitor<HelloWorld> {
  default HelloWorld helloworld__HelloWorld(helloworld.HelloWorld it) {
    return new HelloWorldImpl(it, this);
  }
}
