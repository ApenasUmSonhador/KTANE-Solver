package solver;

import java.util.Hashtable;
import java.util.Map;

/*
 * Class responsible for solving the Morse module
 * Capable of translating morse code to text
 * Capable of solving the module
 * Used in Main to solve the Morse module
 * Uses the Main class to read user input
 */

public class Morse implements Module {
	// Constants to store the morse code
	private static final Map<String, String> morseCode = new Hashtable<String, String>() {
		{
			put("a", ".-");
			// put("b", "-..."); // Not used
			// put("c", "-.-."); // Not used
			// put("d", "-.."); // Not used
			put("e", ".");
			put("f", "..-.");
			// put("g", "--."); // Not used
			// put("h", "...."); // Not used
			put("i", "..");
			// put("j", ".---"); // Not used
			// put("k", "-.-"); // Not used
			// put("l", ".-.."); // Not used
			put("m", "--");
			// put("n", "-."); // Not used
			put("o", "---");
			put("p", ".--.");
			// put("q", "--.-"); // Not used
			put("r", ".-.");
			put("s", "...");
			put("t", "-");
			put("u", "..-");
			// put("v", "...-"); // Not used
			// put("w", ".--"); // Not used
			// put("x", "-..-"); // Not used
			// put("y", "-.--"); // Not used
			// put("z", "--.."); // Not used
		}
	};

	// Translate morse code to text
	private String morseToText(String morse) {
		for (String key : morseCode.keySet()) {
			if (morseCode.get(key).equals(morse)) {
				return key;
			}
		}
		return "";
	}

	// Solve the Morse module
	@Override
	public void solve(Indicators indicators) {
		System.out.println("Use . para ponto e - para traço ");
		System.out.println("Anote as 2 primeiras letras");
		System.out.println("Digite a primeira letra:");
		String morse = Main.LerEntrada(), text = morseToText(morse);
		switch (text) {
			// frase - 3.515 MHz
			case "f":
				System.out.println("A frequência é 3.515 MHz");
				break;

			// Starts with m
			case "m":
				System.out.println("Digite a segunda letra:");
				morse = Main.LerEntrada();
				text += morseToText(morse);
				switch (text) {
					// malote - 3.592 MHz
					case "ma":
						System.out.println("A frequência é 3.592 MHz");
						break;

					// misto - 3.542 MHz
					case "mi":
						System.out.println("A frequência é 3.542 MHz");
						break;

					// moeda - 3.582 MHz
					case "mo":
						System.out.println("A frequência é 3.582 MHz");
						break;

					// mundo - 3.555 MHz
					case "mu":
						System.out.println("A frequência é 3.555 MHz");
						break;
				}
				break;

			// opera - 3.532 MHz
			case "o":
				System.out.println("A frequência é 3.532 MHz");
				break;

			// Starts with p
			case "p":
				System.out.println("Digite a segunda letra:");
				morse = Main.LerEntrada();
				text += morseToText(morse);
				switch (text) {
					// parar - 3.545 MHz
					case "pa":
						System.out.println("A frequência é 3.545 MHz");
						break;

					// pesca - 3.595 MHz
					case "pe":
						System.out.println("A frequência é 3.595 MHz");
						break;

					// podre - 3.505 MHz
					case "po":
						System.out.println("A frequência é 3.505 MHz");
						break;
					// pudim - 3.600 MHz
					case "pu":
						System.out.println("A frequência é 3.600 MHz");
						break;
				}
				break;

			// ritmo - 3.552 MHz
			case "r":
				System.out.println("A frequência é 3.552 MHz");
				break;

			// Starts with s
			case "s":
				System.out.println("Digite a segunda letra:");
				morse = Main.LerEntrada();
				text += morseToText(morse);
				switch (text) {
					// senado - 3.565 MHz
					case "se":
						System.out.println("A frequência é 3.565 MHz");
						break;

					// surfe - 3.572 MHz
					case "su":
						System.out.println("A frequência é 3.572 MHz");
						break;
				}
				break;

			// Starts with t
			case "t":
				System.out.println("Digite a segunda letra:");
				morse = Main.LerEntrada();
				text += morseToText(morse);
				switch (text) {
					// times - 3.575 MHz
					case "ti":
						System.out.println("A frequência é 3.575 MHz");
						break;

					// trufa - 3.535 MHz
					case "tr":
						System.out.println("A frequência é 3.535 MHz");
						break;
				}
				break;

			// unido - 3.522 MHz
			case "u":
				System.out.println("A frequência é 3.522 MHz");
				break;
		}
	}
}
