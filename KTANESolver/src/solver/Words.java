package solver;
/*
 * Class responsible for solving the Words module
 * Capable of storing the Words sequence pattern
 * Capable of solving the module
 * Used in Main to solve the Words module
 * Uses the Main class to read user input
 */

public class Words implements Module {
	// The following are the order of the words on the module
	private final static String[] pronto = { "SIM", "OK", "O QUE", "MEIO", "ESQUERDA", "APERTA", "CERTO", "ASSENTO" },
			primeiro = { "ESQUERDA", "OK", "SIM", "MEIO", "NAO", "CERTO", "NADA", "HMMMMM", "ACENTO", "PRONTO",
					"ASSENTO", "O QUE", "APERTA" },
			nao = { "ASSENTO", "HMMMMM", "ACENTO", "PRIMEIRO", "O QUE", "PRONTO", "CERTO", "SIM",
					"NADA", "ESQUERDA", "APERTA", "OK" },
			assento = { "ACENTO", "CERTO", "OK", "MEIO" },
			nada = { "HMMMMM", "CERTO", "OK", "MEIO", "SIM", "ASSENTO", "NAO", "APERTA",
					"ESQUERDA", "O QUE", "ACENTO", "PRIMEIRO" },
			sim = { "OK", "CERTO", "HMMMMM", "MEIO", "PRIMEIRO", "O QUE", "APERTA", "PRONTO",
					"NADA" },
			oQue = { "HMMMMM" },
			hmmmmm = { "PRONTO", "NADA", "ESQUERDA", "O QUE", "OK", "SIM", "CERTO", "NAO",
					"APERTA", "ASSENTO" },
			esquerda = { "CERTO" },
			certo = { "SIM", "NADA", "PRONTO", "APERTA", "NAO", "ACENTO", "O QUE" },
			meio = { "ASSENTO", "PRONTO", "OK", "O QUE", "NADA", "APERTA", "NAO", "ACENTO",
					"ESQUERDA" },
			ok = { "MEIO", "NAO", "PRIMEIRO", "SIM", "HMMMMM", "NADA", "ACENTO" },
			acento = { "HMMMMM", "NAO", "ASSENTO", "OK", "SIM", "ESQUERDA", "PRIMEIRO", "APERTA",
					"O QUE" },
			aperta = { "CERTO", "MEIO", "SIM", "PRONTO", "APERTA" },
			voce = { "CLARO", "VOCE E", "OCE", "CE E", "PROXIMO", "AHA", "C E", "CENSO", "QUE" },
			voceE = { "OCE", "PROXIMO", "SENSO", "AHA", "QUE", "BORA", "NAO SEI", "CENSO",
					"VOCE", "REPETE", "CE E", "CLARO", "C E" },
			oce = { "NAO SEI", "VOCE E", "AHA" }, cEEh = { "VOCE", "CE E" },
			cEh = { "BORA", "REPETE", "C E", "AHA", "QUE", "CLARO", "OCE", "CENSO" },
			repete = { "AHA", "CLARO", "PROXIMO", "QUE", "CE E", "C E", "NAO SEI", "BORA" },
			naoSei = { "C E", "REPETE", "VOCE E", "CE E", "PROXIMO" },
			que = { "VOCE", "CENSO", "CE E", "OCE", "REPETE", "BORA", "NAO SEI", "SENSO",
					"VOCE E", "AHA", "C E", "PROXIMO" },
			bora = { "CLARO", "AHA", "PROXIMO", "QUE", "OCE", "C E", "CE E", "CENSO", "SENSO",
					"VOCE", "REPETE", "VOCE E", "NAO SEI" },
			proximo = { "QUE", "AHA", "NAO SEI", "OCE", "CENSO", "CLARO" },
			censo = { "VOCE E", "REPETE", "BORA", "NAO SEI", "VOCE", "C E", "CLARO", "QUE",
					"CE E", "PROXIMO" },
			claro = { "VOCE E", "BORA", "SENSO", "CE E", "VOCE", "CENSO", "AHA", "C E" },
			senso = { "CE E", "PROXIMO", "REPETE", "C E", "CENSO", "BORA", "NAO SEI", "QUE",
					"AHA", "VOCE" };

	// The following are the words on the module
	private String display, button;
	private String[] words;

	// Set the button based on the display
	private void setButton(String display) {
		String top = "Digite o botão no topo ", mid = "Digite o botão no meio ", bot = "Digite o botão no fundo ",
				left = "esquerdo:", right = "direito:";

		// Perform the corresponding action based on the display
		switch (display) {
			case "sim":
				System.out.println(mid + left);
				break;
			case "voce e":
				System.out.println(top + right);
				break;
			case "display":
				System.out.println(bot + right);
				break;
			case "ok":
				System.out.println(top + right);
				break;
			case "ta falando":
				System.out.println(bot + right);
				break;
			case "nada":
				System.out.println(mid + left);
				break;
			case "":
				System.out.println(bot + left);
				break;
			case "vazio":
				System.out.println(mid + right);
				break;
			case "nao":
				System.out.println(bot + right);
				break;
			case "cela":
				System.out.println(mid + left);
				break;
			case "sela":
				System.out.println(bot + right);
				break;
			case "cem":
				System.out.println(mid + right);
				break;
			case "sexta":
				System.out.println(mid + right);
				break;
			case "cesta":
				System.out.println(bot + left);
				break;
			case "sem":
				System.out.println(bot + left);
				break;
			case "calma ai":
				System.out.println(bot + right);
				break;
			case "de novo":
				System.out.println(mid + right);
				break;
			case "cauda":
				System.out.println(bot + right);
				break;
			case "calda":
				System.out.println(mid + right);
				break;
			case "vc e":
				System.out.println(mid + right);
				break;
			case "boom":
				System.out.println(top + left);
				break;
			case "errou":
				System.out.println(bot + right);
				break;
			case "mas":
				System.out.println(bot + left);
				break;
			case "mais":
				System.out.println(mid + right);
				break;
			case "nunca":
				System.out.println(mid + left);
				break;
			case "se":
				System.out.println(bot + right);
				break;
			case "c":
				System.out.println(top + right);
				break;
			case "ser":
				System.out.println(bot + right);
				break;
		}
		this.button = Main.LerEntrada();
	}

	// Set the words on the module
	private void setWords() {
		words = new String[5];
		System.out.println("Digite a palavra no display:");
		display = Main.LerEntrada();
		setButton(display);
		for (int i = 0; i < 5; i++) {
			System.out.println("Digite as outras palvras: ");
			words[i] = Main.LerEntrada();
		}
	}

	// Set the solution based on the word on the button selected
	private String setSolution(String word) {
		// Perform the corresponding action based on the word
		switch (word) {
			case "pronto":
				// Perform action for "pronto"
				return seekInArray(word, pronto);
			case "primeiro":
				// Perform action for "primeiro"
				return seekInArray(word, primeiro);
			case "nao":
				// Perform action for "não"
				return seekInArray(word, nao);
			case "assento":
				// Perform action for "assento"
				return seekInArray(word, assento);
			case "nada":
				// Perform action for "nada"
				return seekInArray(word, nada);
			case "sim":
				// Perform action for "sim"
				return seekInArray(word, sim);
			case "o que":
				// Perform action for "O QUE"
				return seekInArray(word, oQue);
			case "hmmmmm":
				// Perform action for "hmmmmm"
				return seekInArray(word, hmmmmm);
			case "esquerda":
				// Perform action for "esquerda"
				return seekInArray(word, esquerda);
			case "certo":
				// Perform action for "certo"
				return seekInArray(word, certo);
			case "meio":
				// Perform action for "meio"
				return seekInArray(word, meio);
			case "ok":
				// Perform action for "ok"
				return seekInArray(word, ok);
			case "acento":
				// Perform action for "acento"
				return seekInArray(word, acento);
			case "aperta":
				// Perform action for "aperta"
				return seekInArray(word, aperta);
			case "voce":
				// Perform action for "voce"
				return seekInArray(word, voce);
			case "voce e":
				// Perform action for "voce e"
				return seekInArray(word, voceE);
			case "oce":
				// Perform action for "oce"
				return seekInArray(word, oce);
			case "ce e":
				// Perform action for "ce e"
				return seekInArray(word, cEEh);
			case "c e":
				// Perform action for "c e"
				return seekInArray(word, cEh);
			case "repete":
				// Perform action for "repete"
				return seekInArray(word, repete);
			case "aha":
				// Perform action for "aha"
				return "aha";
			case "nao sei":
				// Perform action for "nao sei"
				return seekInArray(word, naoSei);
			case "que":
				// Perform action for "que"
				return seekInArray(word, que);
			case "bora":
				// Perform action for "bora"
				return seekInArray(word, bora);
			case "proximo":
				// Perform action for "proximo"
				return seekInArray(word, proximo);
			case "censo":
				// Perform action for "censo"
				return seekInArray(word, censo);
			case "claro":
				// Perform action for "claro"
				return seekInArray(word, claro);
			case "senso":
				// Perform action for "senso"
				return seekInArray(word, senso);
		}
		return null;
	}

	// Seek the word in the array
	private String seekInArray(String word, String[] array) {
		for (String s1 : array) {
			for (String s2 : words) {
				if (s1.equals(s2.toUpperCase())) {
					return s1;
				}
			}
		}
		return word.toUpperCase();
	}

	// Solve the module
	@Override
	public void solve(Indicators indicators) {
		System.out.println("Digite sem utilizar acentuacoes e caracteres especiais.");
		setWords();
		String solution = setSolution(button);
		System.out.println("A palavra correta é: " + solution);
		System.out.println("Módulo resolvido? (s/n)");
		if (Main.LerEntrada().startsWith("n")) {
			solve(indicators);
		}
	}
}
