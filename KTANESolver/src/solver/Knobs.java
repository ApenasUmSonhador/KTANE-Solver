package solver;

/*
 * Class responsible for solving the knobs module
 * Capable of storing the knobs sequence pattern
 * Capable of solving the module
 * Used in Main to solve the knobs module
 * Uses the Main class to read user input
 */

public class Knobs implements Module {
	// Constants to store the knob patterns
	private static final boolean[][] up = { { false, false, true, true, true, true },
			{ true, false, false, true, true, true } },
			down = { { false, true, true, true, true, true },
					{ true, false, false, true, true, false } },
			left = { { false, true, false, false, false, false },
					{ false, false, false, false, false, false } },
			right = { { true, true, false, true, true, true },
					{ true, true, false, true, true, true } };

	// Variable to store the knob sequence
	private boolean[] sequence = new boolean[6];

	// Method to solve the module
	@Override
	public void solve(Indicators indicators) {
		System.out.println("Orientação de cima para baixo e esquerda para a direita.");
		for (int i = 0; i < 6; i++) {
			System.out.println("A luz " + (i + 1) + " está acesa (s/n)?");
			if (Main.LerEntrada().startsWith("s")) {
				sequence[i] = true;
			} else {
				sequence[i] = false;
			}
		}
		for (int i = 0; i < 2; i++) {
			if (up[i].equals(sequence)) {
				System.out.println("Aponte para cima");
				break;
			} else if (down[i].equals(sequence)) {
				System.out.println("Aponte para baixo");
				break;
			} else if (left[i].equals(sequence)) {
				System.out.println("Aponte para esquerda");
				break;
			} else if (right[i].equals(sequence)) {
				System.out.println("Aponte para direita");
				break;
			}
		}
	}
}
