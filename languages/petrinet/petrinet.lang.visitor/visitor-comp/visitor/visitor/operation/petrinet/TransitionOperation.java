package visitor.visitor.operation.petrinet;

public interface TransitionOperation extends NodeOperation {
	boolean canFire();

	boolean hasToken();

	void fire();

	void removeToken();

	void addToken();
}
