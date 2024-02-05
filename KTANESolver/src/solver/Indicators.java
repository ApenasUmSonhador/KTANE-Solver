package solver;

/*
 * Classe responsavel por armazenas estados uteis
 * sobre a bomba para consultas futuras,
 * utilizadas nos modulos:
 * Wires, Button, Genius e Complicated.
 */
public class Indicators {
	public final String serial;
	public final boolean paralel;
	public final boolean FRK;
	public final boolean CAR;
	public final int battery;

	public Indicators(String serial, boolean paralel, boolean FRK, boolean CAR, int battery) {
		this.serial = serial;
		this.paralel = paralel;
		this.FRK = FRK;
		this.CAR = CAR;
		this.battery = battery;
	}

	// Sobre o serial
	public boolean hasVowel() {
		return serial.contains("a") || serial.contains("e") || serial.contains("i") || serial.contains("o")
				|| serial.contains("u");
	}

	public boolean lastIsEven() {
		boolean lastIsEven = false;
		String[] numbers = serial.split("\\D+");
		int lastIndex = numbers.length - 1;
		if (numbers[lastIndex].equals("2") || numbers[lastIndex].equals("4") || numbers[lastIndex].equals("6")
				|| numbers[lastIndex].equals("8") || numbers[lastIndex].equals("0")) {
			lastIsEven = true;
		}
		return lastIsEven;
	}

	// Sobre portas paralelas
	public boolean hasParalel() {
		return paralel;
	}

	// Sobre indicadores luminosos
	public boolean hasFRK() {
		return FRK;
	}

	public boolean hasCAR() {
		return CAR;
	}

	// Sobre o numero de pilhas
	public int getbattery() {
		return battery;
	}
}