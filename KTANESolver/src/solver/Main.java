package solver;

import java.util.Scanner;

/*
 * Class responsible for communicating with the user
 * Capable of collecting data from all modules and indicators
 * Capable of assigning bomb indicators
 * Used in all modules to read user input
 * Uses the bombFactory to create bomb indicators and modules
 * Uses the Module interface to solve bomb modules
 */

public class Main {
	// Scanner to read user input
	private static final Scanner sc = new Scanner(System.in);

	// Method to read user input
	public static String LerEntrada() {
		return sc.nextLine().trim().toLowerCase();
	}

	// Main method to solve the bomb
	public static void main(String[] args) {

		// Set the bomb indicators
		Indicators indicators = BombFactory.setIndicators();

		// Set the bomb modules
		Module[] modules = BombFactory.setModules();

		// Solve the bomb modules
		for (Module module : modules) {
			module.solve(indicators);
		}
	}
}