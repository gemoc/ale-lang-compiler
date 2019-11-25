package visitor.visitor.operation.petrinet;

public interface PlaceOperation extends NodeOperation {
  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
