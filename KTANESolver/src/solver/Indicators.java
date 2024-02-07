package solver;

/*
 * Class responsible to store information about the bomb's indicators
 * Capable of storing the serial, parallel ports, FRK, CAR, and the number of batteries
 * Used in Main to set the bomb indicators
 * Used in the Wire, Button, Genius, and Complicated modules
 * Uses the Main class to read user input
 */
public class Indicators {
	public final String serial;
	public final boolean parallel;
	public final boolean FRK;
	public final boolean CAR;
	public final int battery;

	public Indicators(String serial, boolean parallel, boolean FRK, boolean CAR, int battery) {
		this.serial = serial;
		this.parallel = parallel;
		this.FRK = FRK;
		this.CAR = CAR;
		this.battery = battery;
	}

	// About the serial
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

	// About parallel ports
	public boolean hasParallel() {
		return parallel;
	}

	// About indicator lights
	public boolean hasFRK() {
		return FRK;
	}

	public boolean hasCAR() {
		return CAR;
	}

	// About the number of batteries
	public int getBattery() {
		return battery;
	}
}