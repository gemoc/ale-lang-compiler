package testaccessors.revisitor;

public interface TestaccessorsRevisitor<Testaccessors__EAccT> {
	Testaccessors__EAccT testaccessors__EAcc(final testaccessors.EAcc it);

	default Testaccessors__EAccT $(final testaccessors.EAcc it) {
		return testaccessors__EAcc(it);
	}
}
