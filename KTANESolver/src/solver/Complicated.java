package solver;

/*
 * Class responsible for solving the Complicated Wires module
 * Capable of storing the wires, led and star data
 * Capable of solving the module
 * Used in Main to solve the Complicated module
 * Uses the Indicators class to set the bomb indicators
 * Uses the Main class to read user input
 */

public class Complicated implements Module {
	boolean lastIsEven;
	boolean hasParallelPort;
	int batteries;
	boolean[][] wires;
	boolean[] cutWires;
	int[] wiresValues;

	// Set the indicators for the module
	@Override
	public void setIndicators(Indicators indicators) {
		this.lastIsEven = indicators.lastIsEven();
		this.hasParallelPort = indicators.hasParallel();
		this.batteries = indicators.getBattery();
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
			if (wires[i][0]) {
				wiresValues[i] += 1;
			}
			if (wires[i][1]) {
				wiresValues[i] += 2;
			}
			if (wires[i][2]) {
				wiresValues[i] += 4;
			}
			if (wires[i][3]) {
				wiresValues[i] += 8;
			}
		}
	}

	// set the wires for the module
	private void setWires() {
		/*
		 * matrix logic:
		 * line = wire position
		 * column = wire properties
		 */
		/*
		 * wire properties logic:
		 * [i][0] = red
		 * [i][1] = blue
		 * [i][2] = star
		 * [i][3] = led
		 */
		System.out.println("Digite o numero de fios: ");
		wires = new boolean[Integer.parseInt(Main.LerEntrada())][4];
		for (int i = 0; i < wires.length; i++) {
			System.out.println("O fio " + (i + 1) + " tem vermelho? (s/n)");
			wires[i][0] = Main.LerEntrada().equals("s");
			System.out.println("O fio " + (i + 1) + " tem azul? (s/n)");
			wires[i][1] = Main.LerEntrada().equals("s");
			System.out.println("O fio " + (i + 1) + " tem estrela? (s/n)");
			wires[i][2] = Main.LerEntrada().equals("s");
			System.out.println("O fio " + (i + 1) + " tem LED? (s/n)");
			wires[i][3] = Main.LerEntrada().equals("s");
		}
	}

	// Cut the wires based on the values
	private void setCutWires() {
		cutWires = new boolean[wires.length];
		for (int i = 0; i < wires.length; i++) {
			switch (wiresValues[i]) {
				// white wire
				case 0:
					cutWires[i] = true;
					break;
				// red wire
				case 1:
					cutWires[i] = lastIsEven ? true : false;
					break;
				// blue wire
				case 2:
					cutWires[i] = lastIsEven ? true : false;
					break;
				// red and blue wire
				case 3:
					cutWires[i] = lastIsEven ? true : false;
					break;
				// star wire
				case 4:
					cutWires[i] = true;
					break;
				// red and star wire
				case 5:
					cutWires[i] = hasParallelPort ? true : false;
					break;
				// blue and star wire
				case 6:
					cutWires[i] = false;
					break;
				// red, blue and star wire
				case 7:
					cutWires[i] = hasParallelPort ? true : false;
					break;
				// led wire
				case 8:
					cutWires[i] = false;
					break;
				// red and led wire
				case 9:
					cutWires[i] = batteries > 1 ? true : false;
					break;
				// blue and led wire
				case 10:
					cutWires[i] = hasParallelPort ? true : false;
					break;
				// red, blue and led wire
				case 11:
					cutWires[i] = lastIsEven ? true : false;
					break;
				// star and led wire
				case 12:
					cutWires[i] = batteries > 1 ? true : false;
					break;
				// red, star and led wire
				case 13:
					cutWires[i] = batteries > 1 ? true : false;
					break;
				// blue, star and led wire
				case 14:
					cutWires[i] = hasParallelPort ? true : false;
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
	public void solve() {
		setWires();
		setWiresValues();
		setCutWires();
		String cut = "cut the wires: ";
		for (int i = 0; i < cutWires.length; i++) {
			if (cutWires[i]) {
				cut += (i + 1) + " ";
			}
		}
		System.out.println(cut);
	}
}
