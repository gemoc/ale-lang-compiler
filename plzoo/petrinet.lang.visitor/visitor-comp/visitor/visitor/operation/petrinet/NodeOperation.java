package visitor.visitor.operation.petrinet;

public interface NodeOperation {
  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
