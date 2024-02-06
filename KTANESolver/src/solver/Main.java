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
		return sc.nextLine().strip().toLowerCase();
	}

	public static void main(String[] args) {

		// Set the bomb indicators
		System.out.println("Digite o serial da bomba:");

		String serial = LerEntrada();

		System.out.println("A bomba possui portas paralelas? (s/n)");
		boolean paralel = LerEntrada().equals("s");

		System.out.println("A bomba possui o indicador FRK aceso? (s/n)");
		boolean FRK = LerEntrada().equals("s");

		System.out.println("A bomba possui o indicador CAR aceso? (s/n)");
		boolean CAR = LerEntrada().equals("s");

		System.out.println("Digite o numero de pilhas da bomba:");
		int battery = Integer.parseInt(LerEntrada());

		Indicators indicators = new Indicators(serial, paralel, FRK, CAR, battery);

		// set the bomb modules
		System.out.println("Digite o numero de modulos:");
		int n = Integer.parseInt(LerEntrada());
		Module[] modules = new Module[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Digite o nome do modulo " + (i + 1) + ":");
			String moduleName = LerEntrada();
			if (moduleName.equals("button")) {
				modules[i] = new Button();
			} else if (moduleName.equals("complicated")) {
				modules[i] = new Complicated();
			} else if (moduleName.equals("genius")) {
				modules[i] = new Genius();
			} else if (moduleName.equals("Knobs")) {
				modules[i] = new Knobs();
			} else if (moduleName.equals("maze")) {
				modules[i] = new Maze();
			} else if (moduleName.equals("memory")) {
				modules[i] = new Memory();
			} else if (moduleName.equals("morse")) {
				modules[i] = new Morse();
			} else if (moduleName.equals("password")) {
				modules[i] = new Password();
			} else if (moduleName.equals("sequence")) {
				modules[i] = new Sequence();
			} else if (moduleName.equals("wires")) {
				modules[i] = new Wires();
			} else if (moduleName.equals("words")) {
				modules[i] = new Words();
			}
		}

		// TODO: Solve the bomb modules
	}
}