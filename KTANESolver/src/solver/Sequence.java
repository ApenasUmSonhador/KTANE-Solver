package solver;

import java.util.Map;
import java.util.HashMap;

/*
 * Class responsible for solving the Sequence module
 * Capable of storing the wire cutting sequence
 * Capable of solving the module
 * Used in Main to solve the Sequence module
 * Uses the Main class to read user input
 */

public class Sequence implements Module {
	// Constants to store the wire cutting sequence
	private static final Map<Integer, String> redMap = new HashMap<Integer, String>() {
		{
			put(1, "c");
			put(2, "b");
			put(3, "a");
			put(4, "ac");
			put(5, "b");
			put(6, "ac");
			put(7, "abc");
			put(8, "ab");
			put(9, "b");
		}
	};
	private static final Map<Integer, String> blueMap = new HashMap<Integer, String>() {
		{
			put(1, "b");
			put(2, "ac");
			put(3, "b");
			put(4, "a");
			put(5, "b");
			put(6, "bc");
			put(7, "c");
			put(8, "ac");
			put(9, "a");
		}
	};
	private static final Map<Integer, String> blackMap = new HashMap<Integer, String>() {
		{
			put(1, "abc");
			put(2, "ac");
			put(3, "b");
			put(4, "ac");
			put(5, "b");
			put(6, "bc");
			put(7, "ab");
			put(8, "c");
			put(9, "c");
		}
	};

	// Variables to store the wire color and letter
	private int red = 0;
	private int blue = 0;
	private int black = 0;
	private String color = "";
	private String letter = "";

	// No indicators to set
	@Override
	public void setIndicators(Indicators indicators) {
		// Do nothing
	}

	// Method to solve the module
	@Override
	public void solve() {
		System.out.println("Orientação de cima para baixo");
		while (!(color.equals("fim") || letter.equals("fim"))) {
			System.out.println("Digite a nova cor ou 'fim' para concluir:");
			color = Main.LerEntrada();
			if (color.equals("fim")) {
				break;
			} else if (color.equals("vermelho")) {
				red++;
			} else if (color.equals("azul")) {
				blue++;
			} else if (color.equals("preto")) {
				black++;
			}
			System.out.println("Digite a letra em que está conectado ou 'fim' para concluir:");
			letter = Main.LerEntrada();
			switch (color) {
				case "vermelho":
					if (redMap.get(red).contains(letter)) {
						System.out.println("Corte");
					} else {
						System.out.println("Não corte");
					}
					break;
				case "azul":
					if (blueMap.get(blue).contains(letter)) {
						System.out.println("Corte");
					} else {
						System.out.println("Não corte");
					}
					break;
				case "preto":
					if (blackMap.get(black).contains(letter)) {
						System.out.println("Corte");
					} else {
						System.out.println("Não corte");
					}
					break;
			}
		}
	}
}
