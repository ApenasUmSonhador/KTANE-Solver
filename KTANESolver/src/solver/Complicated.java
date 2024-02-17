package solver;

import java.util.Hashtable;
import java.util.Map;

/*
 * Class responsible for solving the Complicated Wires module
 * Capable of storing the wires, led and star data
 * Capable of solving the module
 * Used in Main to solve the Complicated module
 * Uses the Indicators class to know:
 * if have FRK, CAR and Parallel port and how many batteries
 * Uses the Main class to read user input
 */

public class Complicated implements Module {
	// Variables to store the wires, led and star data
	private Map<String, Boolean> wire;
	private Map<String, Boolean>[] wires;
	private boolean[] cutWires;
	private int[] wiresValues;

	// Set the wires for the module
	@SuppressWarnings("unchecked")
	private void setWires() {
		System.out.println("Digite o numero de fios: ");
		wires = new Map[Integer.parseInt(Main.LerEntrada())];
		for (int i = 0; i < wires.length; i++) {
			wire = new Hashtable<String, Boolean>();
			System.out.println("O fio " + (i + 1) + " tem vermelho? (s/n)");
			wire.put("red", Main.LerEntrada().equals("s"));
			System.out.println("O fio " + (i + 1) + " tem azul? (s/n)");
			wire.put("blue", Main.LerEntrada().equals("s"));
			System.out.println("O fio " + (i + 1) + " tem estrela? (s/n)");
			wire.put("star", Main.LerEntrada().equals("s"));
			System.out.println("O fio " + (i + 1) + " tem LED? (s/n)");
			wire.put("led", Main.LerEntrada().equals("s"));
			wires[i] = wire;
		}
	}

	// Set values for wires
	private void setWiresValues() {
		/*
		 * values logic:
		 * +1 = red
		 * +2 = blue
		 * +4 = star
		 * +8 = led
		 */
		wiresValues = new int[wires.length];
		for (int i = 0; i < wires.length; i++) {
			wiresValues[i] = 0;
			if (wires[i].get("red")) {
				wiresValues[i] += 1;
			}
			if (wires[i].get("blue")) {
				wiresValues[i] += 2;
			}
			if (wires[i].get("star")) {
				wiresValues[i] += 4;
			}
			if (wires[i].get("led")) {
				wiresValues[i] += 8;
			}
		}
	}

	// Cut the wires based on the values
	private void setCutWires(Indicators indicators) {
		cutWires = new boolean[wires.length];
		for (int i = 0; i < wires.length; i++) {
			switch (wiresValues[i]) {
				// white wire
				case 0:
					cutWires[i] = true;
					break;
				// red wire
				case 1:
					cutWires[i] = indicators.lastIsEven() ? true : false;
					break;
				// blue wire
				case 2:
					cutWires[i] = indicators.lastIsEven() ? true : false;
					break;
				// red and blue wire
				case 3:
					cutWires[i] = indicators.lastIsEven() ? true : false;
					break;
				// star wire
				case 4:
					cutWires[i] = true;
					break;
				// red and star wire
				case 5:
					cutWires[i] = indicators.hasParallel() ? true : false;
					break;
				// blue and star wire
				case 6:
					cutWires[i] = false;
					break;
				// red, blue and star wire
				case 7:
					cutWires[i] = indicators.hasParallel() ? true : false;
					break;
				// led wire
				case 8:
					cutWires[i] = false;
					break;
				// red and led wire
				case 9:
					cutWires[i] = indicators.getBattery() > 1 ? true : false;
					break;
				// blue and led wire
				case 10:
					cutWires[i] = indicators.hasParallel() ? true : false;
					break;
				// red, blue and led wire
				case 11:
					cutWires[i] = indicators.lastIsEven() ? true : false;
					break;
				// star and led wire
				case 12:
					cutWires[i] = indicators.getBattery() > 1 ? true : false;
					break;
				// red, star and led wire
				case 13:
					cutWires[i] = indicators.getBattery() > 1 ? true : false;
					break;
				// blue, star and led wire
				case 14:
					cutWires[i] = indicators.hasParallel() ? true : false;
					break;
				// red, blue, star and led wire
				case 15:
					cutWires[i] = false;
					break;
			}
		}
	}

	// Solve the module
	@Override
	public void solve(Indicators indicators) {
		setWires();
		setWiresValues();
		setCutWires(indicators);
		String cut = "cut the wires: ";
		for (int i = 0; i < cutWires.length; i++) {
			if (cutWires[i]) {
				cut += (i + 1) + " ";
			}
		}
		System.out.println(cut);
	}
}
