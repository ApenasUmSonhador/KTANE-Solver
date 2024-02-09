package solver;

import java.util.Map;
import java.util.HashMap;

public class Sequence implements Module {
	// Variables to store the wire cutting sequence
	private int red = 0;
	private Map<Integer, String> redMap;
	private int blue = 0;
	private Map<Integer, String> blueMap;
	private int black = 0;
	private Map<Integer, String> blackMap;

	private String color = "";
	private String letter = "";

	// Method to create the maps
	private void mapCreator() {
		redMap = new HashMap<Integer, String>();
		redMap.put(1, "c");
		redMap.put(2, "b");
		redMap.put(3, "a");
		redMap.put(4, "ac");
		redMap.put(5, "b");
		redMap.put(6, "ac");
		redMap.put(7, "abc");
		redMap.put(8, "ab");
		redMap.put(9, "b");

		blueMap = new HashMap<Integer, String>();
		blueMap.put(1, "b");
		blueMap.put(2, "ac");
		blueMap.put(3, "b");
		blueMap.put(4, "a");
		blueMap.put(5, "b");
		blueMap.put(6, "bc");
		blueMap.put(7, "c");
		blueMap.put(8, "ac");
		blueMap.put(9, "a");

		blackMap = new HashMap<Integer, String>();
		blackMap.put(1, "abc");
		blackMap.put(2, "ac");
		blackMap.put(3, "b");
		blackMap.put(4, "ac");
		blackMap.put(5, "b");
		blackMap.put(6, "bc");
		blackMap.put(7, "ab");
		blackMap.put(8, "c");
		blackMap.put(9, "c");
	}

	@Override
	public void setIndicators(Indicators indicators) {
		// Do nothing
	}

	@Override
	public void solve() {
		System.out.println("Orientação de cima para baixo");
		mapCreator();
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
			if (letter.equals("fim")) {
				break;
			}
			else if (color.equals("vermelho")) {
				(redMap.get(red)).equals(letter) ? System.out.println("Corte") : System.out.println("Não corte");
			}
			else if (color.equals("azul")) {
				(blueMap.get(blue)).equals(letter) ? System.out.println("Corte") : System.out.println("Não corte");
			}
			else if (color.equals("preto")) {
				(blackMap.get(black)).equals(letter) ? System.out.println("Corte") : System.out.println("Não corte");
			}
		}
	}
}
