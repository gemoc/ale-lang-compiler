package testenums.revisitor;

public interface TestenumsRevisitor<Testenums__RootT> {
	Testenums__RootT testenums__Root(final testenums.Root it);

	default Testenums__RootT $(final testenums.Root it) {
		return testenums__Root(it);
	}
}
