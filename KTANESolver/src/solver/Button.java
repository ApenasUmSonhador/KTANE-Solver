package solver;

/*
 * Class responsible for solving the button module
 * Capable of storing the button data
 * Capable of solving the module
 * Used in Main to solve the button module
 * Uses the Indicators class to know:
 * if have FRK, CAR and Parallel port and how many batteries
 * Uses the Main class to read user input
 */

public class Button implements Module {
	// variables to store the button data
	private String color, text;

	// method to store the button data
	private void setButton() {
		System.out.println("Digite a cor do botão:");
		this.color = Main.LerEntrada();
		System.out.println("Digite o texto do botão:");
		this.text = Main.LerEntrada();
	}

	// method to show the hold button instructions
	private void holdButton() {
		System.out.println("Segure o botão e veja a cor da faixa.");
		System.out.println("Azul: solte o botão quando o temporizador tiver um 4 em qualquer posição.");
		System.out.println("Amarelo: solte o botão quando o temporizador tiver um 5 em qualquer posição.");
		System.out.println("Outra cor: solte o botão quando o temporizador tiver um 1 em qualquer posição.");
	}

	// method to solve the module
	@Override
	public void solve(Indicators indicators) {
		setButton();
		if (color.equals("azul") && text.equals("abortar")) {
			holdButton();
		} else if (indicators.getBattery() > 1 && text.equals("detonar")) {
			System.out.println("Pressione e solte o botão.");
		} else if (color.equals("branco") && indicators.hasCAR()) {
			holdButton();
		} else if (indicators.getBattery() > 2 && indicators.hasFRK()) {
			System.out.println("Pressione e solte o botão.");
		} else if (color.equals("amarelo")) {
			holdButton();
		} else if (color.equals("vermelho") && text.equals("segure")) {
			System.out.println("Pressione e solte o botão.");
		} else {
			holdButton();
		}
	}
}
