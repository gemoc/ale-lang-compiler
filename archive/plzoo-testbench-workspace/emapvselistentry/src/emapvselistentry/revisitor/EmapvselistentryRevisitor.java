package emapvselistentry.revisitor;

public interface EmapvselistentryRevisitor<Emapvselistentry__NewEClass1T> {
	Emapvselistentry__NewEClass1T emapvselistentry__NewEClass1(final emapvselistentry.NewEClass1 it);

	default Emapvselistentry__NewEClass1T $(final emapvselistentry.NewEClass1 it) {
		return emapvselistentry__NewEClass1(it);
	}
}
