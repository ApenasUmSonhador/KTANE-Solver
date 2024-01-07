package solver;
/*
 * Classe responsavel por armazenas estados uteis
 * sobre a bomba para consultas futuras,
 * utilizadas nos modulos:
 * Wires, Button, Genius e Complicated.
 */
public class Indicators {
	private final String serial;
	private final boolean paralel;
	private final boolean FRK;
	private final boolean CAR;
	private final int battery;
	
	public Indicators(String serial, boolean paralel, boolean FRK, boolean CAR, int battery) {
		this.serial = serial;
		this.paralel = paralel;
		this.FRK = FRK;
		this.CAR = CAR;
		this.battery = battery;
	}
	
	// Sobre o serial
	public boolean hasVowel() {
		// TODO: Logica que retorne se ha ou nao vogal no serial
		return true;
	}
	
	public boolean lastIsEven() {
		// TODO: Logica que retorne se o ultimos dos digitos e ou nao par
		return true;
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