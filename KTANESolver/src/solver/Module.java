package solver;

public interface Module {
	// Set the bomb usefull indicators
	public abstract void setIndicators(Indicators indicators);

	// Solve the bomb module
	public abstract void solve();
}
