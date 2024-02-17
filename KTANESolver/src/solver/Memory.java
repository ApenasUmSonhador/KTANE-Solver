package solver;
/*
 * Class responsible for solving the memory module
 * Capable of storing the number and position pressed
 * Capable of solving the module
 * Used in Main to solve the memory module
 * Uses the Main class to read user input
 */

public class Memory implements Module {
	/*
	 * Matrix logic:
	 * line = stage;
	 * column[0] = position pressed
	 * column[1] = number pressed
	 */
	private int[][] matrix = new int[4][2];
	private int display;

	// Shows the instructions to press a position
	private void pressByPosition(int position) {
		System.out.println("Digite o número da posição " + position + " e aperte ele:");
	}

	// Shows the instructions to press a position
	private void pressByNumber(int number) {
		System.out.println("Digite a posição do número " + number + " e aperte ele:");
	}

	// Method to solve the module
	@Override
	public void solve(Indicators indicators) {
		// Stage 1
		System.out.println("Digite o número do display:");
		display = Integer.parseInt(Main.LerEntrada());
		switch (display) {
			case 1:
				pressByPosition(2);
				matrix[0][0] = 2;
				break;
			case 2:
				pressByPosition(2);
				matrix[0][0] = 2;
				break;
			case 3:
				pressByPosition(3);
				matrix[0][0] = 3;
				break;
			case 4:
				pressByPosition(4);
				matrix[0][0] = 4;
				break;
		}
		matrix[0][1] = Integer.parseInt(Main.LerEntrada());

		// Stage 2
		System.out.println("Digite o número do display:");
		display = Integer.parseInt(Main.LerEntrada());
		switch (display) {
			case 1:
				pressByNumber(4);
				matrix[1][0] = Integer.parseInt(Main.LerEntrada());
				matrix[1][1] = 4;
				break;
			case 2:
				pressByPosition(matrix[0][0]);
				matrix[1][0] = matrix[0][0];
				matrix[1][1] = Integer.parseInt(Main.LerEntrada());
				break;
			case 3:
				pressByPosition(1);
				matrix[1][0] = 1;
				matrix[1][1] = Integer.parseInt(Main.LerEntrada());
				break;
			case 4:
				pressByPosition(matrix[0][0]);
				matrix[1][0] = matrix[0][0];
				matrix[1][1] = Integer.parseInt(Main.LerEntrada());
				break;
		}
		// Stage 3
		System.out.println("Digite o número do display:");
		display = Integer.parseInt(Main.LerEntrada());
		switch (display) {
			case 1:
				pressByNumber(matrix[1][1]);
				matrix[2][0] = Integer.parseInt(Main.LerEntrada());
				matrix[2][1] = matrix[1][1];
				break;
			case 2:
				pressByNumber(matrix[0][1]);
				matrix[2][0] = Integer.parseInt(Main.LerEntrada());
				matrix[2][1] = matrix[0][1];
				break;
			case 3:
				pressByPosition(3);
				matrix[2][0] = 3;
				matrix[2][1] = Integer.parseInt(Main.LerEntrada());
				break;
			case 4:
				pressByNumber(4);
				matrix[2][0] = Integer.parseInt(Main.LerEntrada());
				matrix[2][1] = 4;
				break;
		}
		// Stage 4
		System.out.println("Digite o número do display:");
		display = Integer.parseInt(Main.LerEntrada());
		switch (display) {
			case 1:
				pressByPosition(matrix[0][0]);
				matrix[3][0] = matrix[0][0];
				break;
			case 2:
				pressByPosition(1);
				matrix[3][0] = 1;
				break;
			case 3:
				pressByPosition(matrix[1][0]);
				matrix[3][0] = matrix[1][0];
				break;
			case 4:
				pressByPosition(matrix[1][0]);
				matrix[3][0] = matrix[1][0];
				break;
		}
		matrix[3][1] = Integer.parseInt(Main.LerEntrada());

		// Stage 5
		System.out.println("Digite o número do display:");
		display = Integer.parseInt(Main.LerEntrada());
		switch (display) {
			case 1 -> System.out.println("Pressione o número " + matrix[0][1]);
			case 2 -> System.out.println("Pressione o número " + matrix[1][1]);
			case 3 -> System.out.println("Pressione o número " + matrix[3][1]);
			case 4 -> System.out.println("Precione o número " + matrix[2][1]);
		}
	}

}
