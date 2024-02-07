package solver;

import java.util.Map;
import java.util.HashMap;

/*
 * Class responsible for solving the wires module
 * Capable of storing the number of wires and their colors
 * Capable of solving the module
 * Used in Main to solve the wires module
 * Uses the Indicators class to set the bomb indicators
 * Uses the Main class to read user input
 */

public class Wires implements Module {
	// indicator who gonna use in the wire module
	private boolean lastIsOdd;

	// variables to store the number of wires and their colors
	private int numberOfWires;
	private Map<String, Integer> wires = new HashMap<>();
	private String lastWire;

	private void setWires() {
		// Store the number of wires
		System.out.println("Digite o numero de fios:");
		this.numberOfWires = Integer.parseInt(Main.LerEntrada());

		for (int i = 0; i < numberOfWires; i++) {
			// Store the color of the wire
			System.out.println("Digite a cor do fio " + (i + 1) + ":");
			String color = Main.LerEntrada();

			// Count the number of wires of each color
			if (wires.containsKey(color)) {
				int count = wires.get(color);
				wires.put(color, count + 1);
			} else {
				wires.put(color, 1);
			}

			// Save the last wire
			if (i == numberOfWires - 1) {
				lastWire = color;
			}
		}
	}

	@Override
	public void setIndicators(Indicators indicators) {
		this.lastIsOdd = !indicators.lastIsEven();
	}

	@Override
	public void solve() {
		setWires();
		// 1. Check the number of wires
		// 2. Check the colors of the wires
		// 3. Wire cutting logic
		// 4. Print the result
		switch (numberOfWires) {
			case 3:
				if (!wires.containsKey("vermelho")) {
					System.out.println("Corte o segundo fio.");
				} else if (lastWire.equals("branco")) {
					System.out.println("Corte o último fio.");
				} else if (wires.get("azul") > 1) {
					System.out.println("Corte o último fio azul.");
				} else {
					System.out.println("Corte o último fio.");
				}
				break;
			case 4:
				if (wires.get("vermelho") > 1 && lastIsOdd) {
					System.out.println("Corte o último fio vermelho.");
				} else if (lastWire.equals("amarelo") && !wires.containsKey("vermelho")) {
					System.out.println("Corte o primeiro fio.");
				} else if (wires.get("azul") == 1) {
					System.out.println("Corte o primeiro fio.");
				} else if (wires.get("amarelo") > 1) {
					System.out.println("Corte o último fio.");
				} else {
					System.out.println("Corte o segundo fio.");
				}
				break;
			case 5:
				if (lastWire.equals("preto") && lastIsOdd) {
					System.out.println("Corte o quarto fio.");
				} else if (wires.get("vermelho") == 1 && wires.get("amarelo") > 1) {
					System.out.println("Corte o primeiro fio.");
				} else if (!wires.containsKey("preto")) {
					System.out.println("Corte o segundo fio.");
				} else {
					System.out.println("Corte o primeiro fio.");
				}
				break;
			case 6:
				if (!wires.containsKey("amarelo") && lastIsOdd) {
					System.out.println("Corte o terceiro fio.");
				} else if (wires.get("amarelo") == 1 && wires.get("branco") > 1) {
					System.out.println("Corte o quarto fio.");
				} else if (!wires.containsKey("vermelho")) {
					System.out.println("Corte o último fio.");
				} else {
					System.out.println("Corte o quarto fio.");
				}
				break;
		}
	}
}