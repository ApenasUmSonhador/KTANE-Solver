package solver;

/*
 * Class responsible for solving the Genius module
 * Capable of selecting the pattern based on the bomb indicators
 * Capable of solving the module
 * Used in Main to solve the Genius module
 * Uses the Indicators class to set the bomb indicators
 * Uses the Main class to read user input
 */

public class Genius implements Module {
	// Variables to store the bomb indicators
	private boolean hasVowel;
	private int errors;
	// Constants to store the color patterns
	/*
	 * Sequence logic:
	 * i = number of errors
	 * [i][0] = red
	 * [i][1] = blue
	 * [i][2] = green
	 * [i][3] = yellow
	 */
	private static final String[][] patternWithVowel = { { "azul", "vermelho", "amarelo", "verde" },
			{ "amarelo", "verde", "azul", "vermelho" },
			{ "verde", "amarelo", "vermelho", "azul" } };
	private static final String[][] patternWithoutVowel = { { "azul", "amarelo", "verde", "vermelho" },
			{ "vermelho", "azul", "amarelo", "verde" },
			{ "amarelo", "verde", "azul", "vermelho" } };
	// Variable to select the correct pattern
	private String[] pattern;
	private String sequence = "Aperte: ";
	private String input;

	// Set the indicators for the module
	@Override
	public void setIndicators(Indicators indicators) {
		hasVowel = indicators.hasVowel();
	}

	// Method to solve the module
	@Override
	public void solve() {
		System.out.println("Digite o numero de erros: ");
		errors = Integer.parseInt(System.console().readLine());
		pattern = hasVowel ? patternWithVowel[errors] : patternWithoutVowel[errors];
		System.out.println("Digite a cor:");
		input = Main.LerEntrada();
		while (!input.equals("fim")) {
			if (input.equals("vermelho")) {
				sequence += pattern[0];
			} else if (input.equals("azul")) {
				sequence += pattern[1];
			} else if (input.equals("verde")) {
				sequence += pattern[2];
			} else if (input.equals("amarelo")) {
				sequence += pattern[3];
			}
			System.out.println(sequence);
			System.out.println("Digite a nova cor ou 'fim' para concluir:");
			input = Main.LerEntrada();
		}
	}
}
