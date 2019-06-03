package visitor.visitor.operation.petrinet;

public interface ArcOperation {
	boolean canFire();

	void removeToken();

	void addToken();
}
