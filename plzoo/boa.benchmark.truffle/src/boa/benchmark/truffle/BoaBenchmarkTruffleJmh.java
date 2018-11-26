package boa.benchmark.truffle;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.File;

@State(Scope.Thread)
public class BoaBenchmarkTruffleJmh {


	private Context context;
	public static File result;

	@Setup
	public void prepare() {

		
		System.out.println("Prepare");

		EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);

//		final int SIZE = itt;
//		final long[] times = new long[SIZE];
		context = Context.create();
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		final ResourceSetImpl resSet = new ResourceSetImpl();
		final URI createFileURI = URI.createFileURI("/home/manuel/dev/java/ale-lang/plzoo/benchmarks.scripts/fib30.xmi");
		final Resource resource = resSet.getResource(createFileURI, true);
		result = (File) resource.getContents().get(0);
//		for (int i = 0; i < SIZE; i++) {
//			times[i] = eval.asLong();
//		}
//		context.close();

//		System.out.println(Arrays.toString(times));
	}
	
	@Benchmark
    public Value test(){
		return context.eval("boa", String.valueOf(0));
		
    }
}
