package visitor.operation.kmLogo;

public interface TurtleOperation {
	void move(double dx, double dy);

	void forward(double steps);

	void rotate(double angle);
}
