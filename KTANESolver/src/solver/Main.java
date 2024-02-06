package solver;

import java.util.Scanner;

/*
 * Class responsible for communicating with the user
 * Capable of collecting data from all modules and indicators
 * Capable of assigning bomb indicators
 * Used in all modules, and uses all modules
 */
public class Main {

	public static String LerEntrada() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine().trim().toLowerCase();
	}

	public static void main(String[] args) {

		// Set the bomb indicators
		Indicators indicators = BombFactory.createIndicators();

		// Set the bomb modules
		Module[] modules = BombFactory.createModules();

		// Solve the bomb modules
		for (Module module : modules) {
			module.setIndicators(indicators);
			module.solve();
		}
	}
}