package fr.mleduc.lang.boa.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractBoaTest {
	protected static TimerClass timer;

	@Before
	public void init() {
		LogService.TOSDTOUT = false;
		timer.name = getName();

	}

	protected abstract String getName();

	@After
	public void finish() {
		LogService.sb.setLength(0);
	}

	@BeforeClass
	public static void beforeAll() {
		timer = new TimerClass();
	}

	@AfterClass
	public static void afterAll() {
		timer.save();
	}

	@Test
	public void test2plus2() throws IOException {
		eval("2plus2", "4\n");
	}

	@Test
	public void test2minus2() throws IOException {
		eval("2minus2", "0\n");
	}

	@Test
	public void test2times3() throws IOException {
		eval("2times3", "6\n");
	}

	@Test
	public void test2less3() throws IOException {
		eval("2less3", "true\n");
	}

	@Test
	public void ifplus() throws IOException {
		eval("ifplus", "12\n");
	}

	@Test
	public void fun0() throws IOException {
		eval("fun0", "<fun>\n");
	}

	@Test
	public void fun0app7() throws IOException {
		eval("fun0app7", "57\n");
	}

	@Test
	public void deffun0() throws IOException {
		eval("deffun0", "f = <fun>\n");
	}

	@Test
	public void deffun0app7() throws IOException {
		eval("deffun0app7", "f = <fun>\n57\n");
	}

	@Test
	public void skip() throws IOException {
		eval("skip", "{}\n");
	}

	@Test
	public void objx7y8() throws IOException {
		eval("objx7y8", "{x=7, y=8}\n");
	}

	@Test
	public void defpobjx7y8() throws IOException {
		eval("defpobjx7y8", "p = {x=7, y=8}\n");
	}

	@Test
	public void defpobjx7y8_px() throws IOException {
		eval("defpobjx7y8_px", "p = {x=7, y=8}\n7\n");
	}

	@Test
	public void defpobjx7y8_px_px10() throws IOException {
		eval("defpobjx7y8_px_px10", "p = {x=7, y=8}\n7\n10\n");
	}

	@Test
	public void defpobjx7y8_px_px10_p() throws IOException {
		eval("defpobjx7y8_px_px10_p", "p = {x=7, y=8}\n7\n10\n{x=10, y=8}\n");
	}

	@Test
	public void test3with4() throws IOException {
		eval("3with4", "{a=3, b=4}\n");
	}

	@Test
	public void test3with45() throws IOException {
		eval("3with45", "{a=4, b=5}\n");
	}

	@Test
	public void test34with56() throws IOException {
		eval("34with56", "{a=5, b=6, c=4}\n");
	}

	@Test
	public void cowpy() throws IOException {
		eval("cowpy",
				"cow = {horn=7, tail={a=5, b=6}}\n" + "bull = {tail={a=5, b=6}, horn=7}\n" + "8\n"
						+ "{tail={a=5, b=6}, horn=8}\n" + "{horn=7, tail={a=5, b=6}}\n" + "100\n"
						+ "{tail={a=100, b=6}, horn=8}\n" + "{horn=7, tail={a=100, b=6}}\n");
	}

	@Test
	public void recfun() throws IOException {
		eval("recfun", "rec = <fun>\n");
	}

	@Test
	public void list() throws IOException {
		eval("list",
				"list = {nil=<fun>, iterator=<fun>, getTail=<fun>, getHead=<fun>, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>}\n"
						+ "a = {nil=<fun>, head=1000, iterator=<fun>, getTail=<fun>, getHead=<fun>, tail={nil=<fun>, head=2000, iterator=<fun>, getTail=<fun>, getHead=<fun>, tail={nil=<fun>, head=3000, iterator=<fun>, getTail=<fun>, getHead=<fun>, tail={nil=<fun>, iterator=<fun>, getTail=<fun>, getHead=<fun>, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=true}, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=false}, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=false}, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=false}\n"
						+ "{nil=<fun>, iterator=<fun>, getTail=<fun>, getHead=<fun>, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=true}\n"
						+ "{nil=<fun>, head=42, iterator=<fun>, getTail=<fun>, getHead=<fun>, tail={nil=<fun>, iterator=<fun>, getTail=<fun>, getHead=<fun>, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=true}, get=<fun>, isEmpty=<fun>, map=<fun>, cons=<fun>, empty=false}\n"
						+ "x = 1000\n" + "x = 2000\n" + "x = 3000\n");
	}

	@Test
	public void insertSort() throws IOException {
		eval("insert_sort", "");
	}

//	@Test
//	@Ignore
//	public void testCopil() {
//		CallTarget target = Truffle.getRuntime().createCallTarget(RootNode.createConstantNode(42));
//		for (int i = 0; i < 1001; i++) {
//			target.call();
//		}
//	}

	@Test
	public void fib() throws IOException {
		eval("fib",
				"fib = {app=<fun>}\n" + "1\n" + "1\n" + "2\n" + "3\n" + "5\n" + "8\n" + "13\n" + "21\n" + "34\n"
						+ "55\n" + "89\n" + "144\n" + "233\n" + "377\n"
						+ "610\n" /*
									 * + "987\n" + "1597\n" + "2584\n" + "4181\n" + "6765\n" + "10946\n" + "17711\n"
									 * + "28657\n" + "46368\n" + "75025\n" + "121393\n" + "196418\n" + "317811\n" +
									 * "514229\n" + "832040\n" + "1346269\n" + "2178309\n" + "3524578\n" +
									 * "5702887\n" + "9227465\n" + "14930352\n" + "24157817\n" + "39088169\n" +
									 * "63245986\n" + "102334155\n"
									 */);
	}

	abstract void eval(String pathname, String expected) throws FileNotFoundException, IOException;
}
