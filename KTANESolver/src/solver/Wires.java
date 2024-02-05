package solver;

public class Wires implements Module {
	private Indicators indicators;
	private Dictionary wires = new Hashtable();
	private String lastWire;

	public void setWires(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Digite a cor do fio " + (i + 1) + ":");
			String cor = Main.LerEntrada();

			// Count the number of wires of each color
			if (wires.containsKey(cor)) {
				int count = wires.get(cor);
				wires.put(cor, count + 1);
			} else {
				wires.put(cor, 1);
			}

			// Save the last wire
			if (i == n - 1) {
				lastWire = cor;
			}
		}
	}

	@Override
	public void setIndicators(Indicators indicators) {
		this.indicators = indicators;
	}

	@Override
	public void solve() {
		System.out.println("Digite o numero de fios:");
		int n = Integer.parseInt(Main.LerEntrada());
		if (n == 3) {
			// Check the colors of the wires
			for (int i = 0; i < n; i++) {
				System.out.println("Digite a cor do fio " + (i + 1) + ":");
				String cor = Main.LerEntrada();

				if (cor.equals("vermelho")) {
				} else if (cor.equals("azul")) {
				} else if (cor.equals("branco")) {
				}
			}

			// Wire cutting logic
			if (!hasRedWire) {
				System.out.println("Corte o segundo fio.");
			} else if (lastWire.equals("branco")) {
				System.out.println("Corte o último fio.");
			} else if (wires.get("azul") > 1) {
				System.out.println("Corte o último fio azul.");
			} else {
				System.out.println("Corte o último fio.");
			}
		} else if (n == 4) {
		} else if (n == 5) {
		} else if (n == 6) {
		}
	}
}