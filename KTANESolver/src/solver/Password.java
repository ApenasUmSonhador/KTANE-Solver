package solver;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/*
 * Class responsible for solving the Password module
 * Capable of storing the passwords from the module
 * Capable of storing the letters per position
 * Capable of solving the module
 * Used in Main to solve the Passsword module
 * Uses the Main class to read user input
 */

public class Password implements Module {
	// List of possible words
	Map<String, Boolean> word = new HashMap<String, Boolean>() {
		{
			word.put("acesa", false);
			word.put("ajuda", false);
			word.put("amigo", false);
			word.put("antes", false);
			word.put("arcos", false);
			word.put("baile", false);
			word.put("balas", false);
			word.put("bispo", false);
			word.put("chefe", false);
			word.put("cheio", false);
			word.put("cinto", false);
			word.put("cravo", false);
			word.put("etapa", false);
			word.put("etnia", false);
			word.put("flora", false);
			word.put("lazer", false);
			word.put("legal", false);
			word.put("lugar", false);
			word.put("parte", false);
			word.put("parto", false);
			word.put("perto", false);
			word.put("porta", false);
			word.put("regra", false);
			word.put("resto", false);
			word.put("salve", false);
			word.put("sente", false);
			word.put("setor", false);
			word.put("sexta", false);
			word.put("tecla", false);
			word.put("tinta", false);
			word.put("torta", false);
			word.put("touro", false);
			word.put("trato", false);
			word.put("valer", false);
			word.put("veado", false);
		}
	};

	// Set letters per position
	private List<String> letter;

	// setIndicators is not used in this module
	@Override
	public void setIndicators(Indicators indicators) {
		// Do nothing
	}

	// Solve the module
	@Override
	public void solve() {
		// Collect the last Letter
		System.out.println("Digite as ultimas letras da palavra: ");
		System.out.println("Quando acabar digite 'fim'");
		letter = new ArrayList<>();
		String input = Main.LerEntrada();
		while (!input.equals("fim")) {
			input = Main.LerEntrada();
			letter.add(input);
		}
		// Check the words
		for (String l : letter) {
			for (String w : word.keySet()) {
				if (w.endsWith(l)) {
					word.put(w, true);
				}
			}
		}
		// Remove the words that are not possible
		for (String w : word.keySet()) {
			if (word.get(w) == false) {
				word.remove(w);
			}
		}
		// Print the word
		if (word.size() == 1) {
			System.out.println("A palavra é: " + word.keySet().toArray()[0]);
			return;
		}

		// Collect the first Letter
		System.out.println("Digite as primeiras letras da palavra: ");
		System.out.println("Quando acabar digite 'fim'");
		input = Main.LerEntrada();
		letter = new ArrayList<>();
		while (!input.equals("fim")) {
			input = Main.LerEntrada();
			letter.add(input);
		}
		// Check the words
		for (String l : letter) {
			for (String w : word.keySet()) {
				if (w.startsWith(l)) {
					word.put(w, true);
				}
			}
		}
		// Remove the words that are not possible
		for (String w : word.keySet()) {
			if (word.get(w) == false) {
				word.remove(w);
			}
		}
		// Print the word
		if (word.size() == 1) {
			System.out.println("A palavra é: " + word.keySet().toArray()[0]);
			return;
		}

		// Collect the second Letter
		System.out.println("Digite as segundas letras da palavra: ");
		System.out.println("Quando acabar digite 'fim'");
		input = Main.LerEntrada();
		letter = new ArrayList<>();
		while (!input.equals("fim")) {
			input = Main.LerEntrada();
			letter.add(input);
		}
		// Check the words
		for (String l : letter) {
			for (String w : word.keySet()) {
				if (w.substring(1, 2).equals(l)) {
					word.put(w, true);
				}
			}
		}
		// Remove the words that are not possible
		for (String w : word.keySet()) {
			if (word.get(w) == false) {
				word.remove(w);
			}
		}
		// Print the word
		if (word.size() == 1) {
			System.out.println("A palavra é: " + word.keySet().toArray()[0]);
			return;
		}

		// Collect the third Letter
		System.out.println("Digite as terceiras letras da palavra: ");
		System.out.println("Quando acabar digite 'fim'");
		input = Main.LerEntrada();
		letter = new ArrayList<>();
		while (!input.equals("fim")) {
			input = Main.LerEntrada();
			letter.add(input);
		}
		// Check the words
		for (String l : letter) {
			for (String w : word.keySet()) {
				if (w.substring(2, 3).equals(l)) {
					word.put(w, true);
				}
			}
		}
		// Remove the words that are not possible
		for (String w : word.keySet()) {
			if (word.get(w) == false) {
				word.remove(w);
			}
		}
		// Print the word
		if (word.size() == 1) {
			System.out.println("A palavra é: " + word.keySet().toArray()[0]);
			return;
		}

		// Collect the fourth Letter
		System.out.println("Digite as quartas letras da palavra: ");
		System.out.println("Quando acabar digite 'fim'");
		input = Main.LerEntrada();
		letter = new ArrayList<>();
		while (!input.equals("fim")) {
			input = Main.LerEntrada();
			letter.add(input);
		}
		// Check the words
		for (String l : letter) {
			for (String w : word.keySet()) {
				if (w.substring(3, 4).equals(l)) {
					word.put(w, true);
				}
			}
		}
		// Remove the words that are not possible
		for (String w : word.keySet()) {
			if (word.get(w) == false) {
				word.remove(w);
			}
		}
		// Print the word
		if (word.size() == 1) {
			System.out.println("A palavra é: " + word.keySet().toArray()[0]);
			return;
		}
	}
}
