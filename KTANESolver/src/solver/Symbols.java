package solver;

/*
 * Class responsible for solving the Symbols module
 * Capable of storing the symbols from the module
 * Capable of storing the symbols order
 * Capable of solving the module
 * Used in Main to solve the Symbols module
 * Uses the Main class to read user input
 */

public class Symbols implements Module {
	// The following are the 6 lines of symbols on the module
	private final static String[] line1 = { "baloon", "at", "lambda", "n", "alien", "x", ".c" };
	private final static String[] line2 = { "e", "baloon", ".c", "spiral", "star", "x", "?" };
	private final static String[] line3 = { "copy", "nose", "spiral", "xi", "r", "lambda", "star" };
	private final static String[] line4 = { "6", "p", "bt", "alien", "xi", "?", "emoji" };
	private final static String[] line5 = { "psi", "emoji", "bt", "c.", "p", "3", "black" };
	private final static String[] line6 = { "6", "e", "jigsaw", "ae", "psi", "h", "omega" };

	// The following are the 4 symbols on the module
	private String[] symbols = new String[4];
	// The following is the line that contains the solution
	private int[] solution = { 1, 1, 1, 1, 1, 1 };

	// Set the indicators
	@Override
	public void setIndicators(Indicators indicators) {
		// Do Nothing
	}

	private String Alias(String input) {
		switch (input) {
			case "balao":
				return "baloon";
			case "lambida":
				return "lambda";
			case "estrela":
				return "star";
			case "espiral":
				return "spiral";
			case "copyright":
				return "copy";
			case "nariz":
				return "nose";
			case "Snake":
				return "3";
			case "cobra":
				return "3";
			case "black star":
				return "black";
			case "estrela preta":
				return "black";
			case "quebra cabeça":
				return "jigsaw";
			case "quebra cabeca":
				return "jigsaw";
		}
		return input;

	}

	private void setSymbols() {
		for (int i = 0; i < 4; i++) {
			System.out.println("Digite o simbolo " + (i + 1) + ":");
			symbols[i] = Alias(Main.LerEntrada());
		}
	}

	// Check the correct line
	private int correctLine() {
		/*
		 * Function logic:
		 * 1. Iterate through all the lines and for each symbol, check if it is present.
		 * If it is, mark the line as visited and correct with the number 2.
		 * If it is not, mark the line as visited and incorrect with the number 1.
		 * If the line is already marked with 0, do nothing.
		 * 
		 * 2. Then, if the line is marked with 2, mark it with 1.
		 * If the line is marked with 1, mark it with 0.
		 * 
		 * 3. Leaving only one line with a possible value of 1.
		 * That line is the correct line.
		 */

		// 1.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (solution[0] == 1 && line1[j].equals(symbols[i])) {
					solution[0] = 2;
				}
				if (solution[1] == 1 && line2[j].equals(symbols[i])) {
					solution[1] = 2;
				}
				if (solution[2] == 1 && line3[j].equals(symbols[i])) {
					solution[2] = 2;
				}
				if (solution[3] == 1 && line4[j].equals(symbols[i])) {
					solution[3] = 2;
				}
				if (solution[4] == 1 && line5[j].equals(symbols[i])) {
					solution[4] = 2;
				}
				if (solution[5] == 1 && line6[j].equals(symbols[i])) {
					solution[5] = 2;
				}
			}
			// 2.
			if (solution[0] == 2) {
				solution[0] = 1;
			} else {
				solution[0] = 0;
			}
			if (solution[1] == 2) {
				solution[1] = 1;
			} else {
				solution[1] = 0;
			}
			if (solution[2] == 2) {
				solution[2] = 1;
			} else {
				solution[2] = 0;
			}
			if (solution[3] == 2) {
				solution[3] = 1;
			} else {
				solution[3] = 0;
			}
			if (solution[4] == 2) {
				solution[4] = 1;
			} else {
				solution[4] = 0;
			}
			if (solution[5] == 2) {
				solution[5] = 1;
			} else {
				solution[5] = 0;
			}
		}

		// 3.
		for (int i = 0; i < 6; i++) {
			if (solution[i] == 1) {
				return i;
			}
		}
		return 404;
	}

	// Show the solution
	private void showSolution(String[] line) {
		int u = 1;
		System.out.println("Aperte em ordem:");
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 4; i++) {
				if (line[j].equals(symbols[i])) {
					System.out.println(u++ + " " + symbols[i]);
					break;
				}
			}
			if (u == 5) {
				break;
			}
		}
	}

	@Override
	public void solve() {
		// For each symbol, check /docs/Symbols.md
		setSymbols();
		int line = correctLine();
		switch (line) {
			case 0:
				showSolution(line1);
				break;
			case 1:
				showSolution(line2);
				break;
			case 2:
				showSolution(line3);
				break;
			case 3:
				showSolution(line4);
				break;
			case 4:
				showSolution(line5);
				break;
			case 5:
				showSolution(line6);
				break;
		}
	}
}
