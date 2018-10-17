package helloworld.revisitor;

public interface HelloworldRevisitor<Helloworld__HelloWorldT> {
	Helloworld__HelloWorldT helloworld__HelloWorld(final helloworld.HelloWorld it);

	default Helloworld__HelloWorldT $(final helloworld.HelloWorld it) {
		return helloworld__HelloWorld(it);
	}
}
