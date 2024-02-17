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

	@SuppressWarnings("resource")
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
			module.solve(indicators);
		}
	}
}