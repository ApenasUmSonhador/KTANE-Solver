package solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze implements Module {
	private List path;
	private int flag, start, end;
	private Map<Integer,int[]> maze;
	// Representation of the maze as a graph
	private Map<Integer, int[]> maze1 = new HashMap<>() {
		{
			put(1, new int[] { 2, 7 });
			put(2, new int[] { 1, 3 });
			put(3, new int[] { 2, 9 });
			put(4, new int[] { 5, 11 });
			put(5, new int[] { 4, 6 });
			put(6, new int[] { 5 });
			put(7, new int[] { 1, 13 });
			put(8, new int[] { 9, 14 });
			put(9, new int[] { 3, 8 });
			put(10, new int[] { 4, 11 });
			put(11, new int[] { 10, 12 });
			put(12, new int[] { 11, 18 });
			put(13, new int[] { 7, 19 });
			put(14, new int[] { 8, 15 });
			put(15, new int[] { 14, 21 });
			put(16, new int[] { 17, 22 });
			put(17, new int[] { 16, 18 });
			put(18, new int[] { 12, 17, 24 });
			put(19, new int[] { 13, 25 });
			put(20, new int[] { 21 });
			put(21, new int[] { 15, 20, 22 });
			put(22, new int[] { 16, 21 });
			put(23, new int[] { 24 });
			put(24, new int[] { 18, 23, 30 });
			put(25, new int[] { 19, 26, 31 });
			put(26, new int[] { 25, 27 });
			put(27, new int[] { 26, 33 });
			put(28, new int[] { 29, 34 });
			put(29, new int[] { 28 });
			put(30, new int[] { 24, 36 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 31 });
			put(33, new int[] { 27, 34 });
			put(34, new int[] { 28, 33 });
			put(35, new int[] { 36 });
			put(36, new int[] { 30, 35 });
		}
	};
	private Map<Integer, int[]> maze2 = new HashMap<>() {
		{
			put(1, new int[] { 2 });
			put(2, new int[] { 1, 3, 8 });
			put(3, new int[] { 2 });
			put(4, new int[] { 5, 10 });
			put(5, new int[] { 4, 6, 11 });
			put(6, new int[] { 5 });
			put(7, new int[] { 8, 13 });
			put(8, new int[] { 2, 7 });
			put(9, new int[] { 10, 15 });
			put(10, new int[] { 4, 9 });
			put(11, new int[] { 5, 12 });
			put(12, new int[] { 11, 18 });
			put(13, new int[] { 7, 19 });
			put(14, new int[] { 15, 20 });
			put(15, new int[] { 9, 14 });
			put(16, new int[] { 17, 22 });
			put(17, new int[] { 16, 18 });
			put(18, new int[] { 12, 17, 24 });
			put(19, new int[] { 13, 20, 25 });
			put(20, new int[] { 14, 19 });
			put(21, new int[] { 22, 27 });
			put(22, new int[] { 16, 21 });
			put(23, new int[] { 29 });
			put(24, new int[] { 18, 30 });
			put(25, new int[] { 19, 31 });
			put(26, new int[] { 32 });
			put(27, new int[] { 21, 33 });
			put(28, new int[] { 29, 34 });
			put(29, new int[] { 23, 28 });
			put(30, new int[] { 24, 36 });
			put(31, new int[] { 25 });
			put(32, new int[] { 26, 33 });
			put(33, new int[] { 27, 32 });
			put(34, new int[] { 28, 35 });
			put(35, new int[] { 34, 36 });
			put(36, new int[] { 30, 35 });
		}
	};
	private Map<Integer, int[]> maze3 = new HashMap<>() {
		{
			put(1, new int[] { 2, 7 });
			put(2, new int[] { 1, 3 });
			put(3, new int[] { 2, 9 });
			put(4, new int[] { 10 });
			put(5, new int[] { 6, 11 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 1 });
			put(8, new int[] { 14 });
			put(9, new int[] { 3, 15 });
			put(10, new int[] { 4, 11 });
			put(11, new int[] { 5, 10 });
			put(12, new int[] { 6, 18 });
			put(13, new int[] { 14, 19 });
			put(14, new int[] { 8, 13, 20 });
			put(15, new int[] { 9, 21 });
			put(16, new int[] { 17, 22 });
			put(17, new int[] { 16, 23 });
			put(18, new int[] { 12, 24 });
			put(19, new int[] { 13, 25 });
			put(20, new int[] { 14, 26 });
			put(21, new int[] { 15, 27 });
			put(22, new int[] { 16, 28 });
			put(23, new int[] { 17, 29 });
			put(24, new int[] { 18, 30 });
			put(25, new int[] { 19, 31 });
			put(26, new int[] { 20, 27 });
			put(27, new int[] { 21, 26 });
			put(28, new int[] { 22, 34 });
			put(29, new int[] { 23, 35 });
			put(30, new int[] { 24, 36 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 31, 33 });
			put(33, new int[] { 32, 34 });
			put(34, new int[] { 28, 33 });
			put(35, new int[] { 29, 36 });
			put(36, new int[] { 30, 35 });
		}
	};
	private Map<Integer, int[]> maze4 = new HashMap<>() {
		{
			put(1, new int[] { 2, 7 });
			put(2, new int[] { 1, 8 });
			put(3, new int[] { 4 });
			put(4, new int[] { 3, 5 });
			put(5, new int[] { 4, 6 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 1, 13 });
			put(8, new int[] { 2, 14 });
			put(9, new int[] { 10, 15 });
			put(10, new int[] { 9, 11 });
			put(11, new int[] { 10, 12 });
			put(12, new int[] { 6, 11, 18 });
			put(13, new int[] { 7, 19 });
			put(14, new int[] { 8, 15 });
			put(15, new int[] { 9, 14 });
			put(16, new int[] { 17, 22 });
			put(17, new int[] { 16 });
			put(18, new int[] { 12, 24 });
			put(19, new int[] { 13, 25 });
			put(20, new int[] { 21 });
			put(21, new int[] { 20, 22 });
			put(22, new int[] { 16, 21, 23 });
			put(23, new int[] { 22, 24 });
			put(24, new int[] { 18, 30 });
			put(25, new int[] { 19, 26, 31 });
			put(26, new int[] { 25, 27 });
			put(27, new int[] { 26, 28 });
			put(28, new int[] { 27, 29 });
			put(29, new int[] { 28, 35 });
			put(30, new int[] { 24, 36 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 31, 33 });
			put(33, new int[] { 32 });
			put(34, new int[] { 35 });
			put(35, new int[] { 29, 34 });
			put(36, new int[] { 30 });
		}
	};
	private Map<Integer, int[]> maze5 = new HashMap<>() {
		{
			put(1, new int[] { 2 });
			put(2, new int[] { 1, 3 });
			put(3, new int[] { 2, 4 });
			put(4, new int[] { 3, 5 });
			put(5, new int[] { 4, 6, 11 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 8, 13 });
			put(8, new int[] { 7, 9 });
			put(9, new int[] { 8, 10 });
			put(10, new int[] { 9, 11, 16 });
			put(11, new int[] { 5, 10 });
			put(12, new int[] { 6 });
			put(13, new int[] { 7, 14, 19 });
			put(14, new int[] { 13, 20 });
			put(15, new int[] { 16 });
			put(16, new int[] { 10, 15 });
			put(17, new int[] { 18, 23 });
			put(18, new int[] { 17, 24 });
			put(19, new int[] { 13, 25 });
			put(20, new int[] { 14, 21 });
			put(21, new int[] { 20, 22 });
			put(22, new int[] { 21, 28 });
			put(23, new int[] { 17 });
			put(24, new int[] { 18, 30 });
			put(25, new int[] { 19, 31 });
			put(26, new int[] { 27, 32 });
			put(27, new int[] { 26, 28 });
			put(28, new int[] { 22, 27, 29 });
			put(29, new int[] { 28 });
			put(30, new int[] { 24, 36 });
			put(31, new int[] { 25 });
			put(32, new int[] { 26, 33 });
			put(33, new int[] { 32, 34 });
			put(34, new int[] { 33, 35 });
			put(35, new int[] { 34, 36 });
			put(36, new int[] { 30, 35 });
		}
	};
	private Map<Integer, int[]> maze6 = new HashMap<>() {
		{
			put(1, new int[] { 7 });
			put(2, new int[] { 3, 8 });
			put(3, new int[] { 2, 9 });
			put(4, new int[] { 5 });
			put(5, new int[] { 4, 6, 11 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 1, 13 });
			put(8, new int[] { 2, 14 });
			put(9, new int[] { 3, 15 });
			put(10, new int[] { 11, 16 });
			put(11, new int[] { 5, 10 });
			put(12, new int[] { 6, 18 });
			put(13, new int[] { 7, 14, 19 });
			put(14, new int[] { 8, 13 });
			put(15, new int[] { 9 });
			put(16, new int[] { 10, 22 });
			put(17, new int[] { 18, 23 });
			put(18, new int[] { 12, 17 });
			put(19, new int[] { 13, 20 });
			put(20, new int[] { 19, 26 });
			put(21, new int[] { 22, 27 });
			put(22, new int[] { 16, 21, 28 });
			put(23, new int[] { 17, 29 });
			put(24, new int[] { 30 });
			put(25, new int[] { 26, 31 });
			put(26, new int[] { 20, 25 });
			put(27, new int[] { 21 });
			put(28, new int[] { 22, 34 });
			put(29, new int[] { 23, 30 });
			put(30, new int[] { 24, 29, 36 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 31, 33 });
			put(33, new int[] { 32, 34 });
			put(34, new int[] { 28, 33 });
			put(35, new int[] { 36 });
			put(36, new int[] { 30, 35 });
		}
	};
	private Map<Integer, int[]> maze7 = new HashMap<>() {
		{
			put(1, new int[] { 2, 7 });
			put(2, new int[] { 1, 3 });
			put(3, new int[] { 2, 4 });
			put(4, new int[] { 3, 10 });
			put(5, new int[] { 6, 11 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 1, 13 });
			put(8, new int[] { 9, 14 });
			put(9, new int[] { 8 });
			put(10, new int[] { 4, 11 });
			put(11, new int[] { 5, 10 });
			put(12, new int[] { 6, 18 });
			put(13, new int[] { 7, 14 });
			put(14, new int[] { 8, 14 });
			put(15, new int[] { 16, 21 });
			put(16, new int[] { 15 });
			put(17, new int[] { 18, 23 });
			put(18, new int[] { 12, 17 });
			put(19, new int[] { 20, 25 });
			put(20, new int[] { 19, 26 });
			put(21, new int[] { 15, 22, 27 });
			put(22, new int[] { 21, 23 });
			put(23, new int[] { 17, 22 });
			put(24, new int[] { 30 });
			put(25, new int[] { 19, 31 });
			put(26, new int[] { 20 });
			put(27, new int[] { 21, 28 });
			put(28, new int[] { 27, 29 });
			put(29, new int[] { 28, 35 });
			put(30, new int[] { 24, 36 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 31, 33 });
			put(33, new int[] { 32, 34 });
			put(34, new int[] { 33, 35 });
			put(35, new int[] { 29, 34, 36 });
			put(36, new int[] { 30, 35 });
		}
	};
	private Map<Integer, int[]> maze8 = new HashMap<>() {
		{
			put(1, new int[] { 7 });
			put(2, new int[] { 3, 8 });
			put(3, new int[] { 2, 4 });
			put(4, new int[] { 3, 10 });
			put(5, new int[] { 6, 11 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 1, 8, 13 });
			put(8, new int[] { 2, 7, 9 });
			put(9, new int[] { 8 });
			put(10, new int[] { 4, 11 });
			put(11, new int[] { 5, 10 });
			put(12, new int[] { 6, 18 });
			put(13, new int[] { 7, 19 });
			put(14, new int[] { 15, 20 });
			put(15, new int[] { 14, 16 });
			put(16, new int[] { 15, 17 });
			put(17, new int[] { 16, 23 });
			put(18, new int[] { 12, 24 });
			put(19, new int[] { 13, 25 });
			put(20, new int[] { 14, 21 });
			put(21, new int[] { 20, 27 });
			put(22, new int[] { 23 });
			put(23, new int[] { 17, 22, 24 });
			put(24, new int[] { 18, 23 });
			put(25, new int[] { 19, 31 });
			put(26, new int[] { 32 });
			put(27, new int[] { 21, 28 });
			put(28, new int[] { 27, 29 });
			put(29, new int[] { 28, 30 });
			put(30, new int[] { 29 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 26, 31, 33 });
			put(33, new int[] { 32, 34 });
			put(34, new int[] { 33, 35 });
			put(35, new int[] { 34, 36 });
			put(36, new int[] { 35 });
		}
	};
	private Map<Integer, int[]> maze9 = new HashMap<>() {
		{
			put(1, new int[] { 7 });
			put(2, new int[] { 3, 8 });
			put(3, new int[] { 2, 4 });
			put(4, new int[] { 3, 5 });
			put(5, new int[] { 4, 6, 11 });
			put(6, new int[] { 5, 12 });
			put(7, new int[] { 1, 13 });
			put(8, new int[] { 2, 14 });
			put(9, new int[] { 10, 15 });
			put(10, new int[] { 9 });
			put(11, new int[] { 5, 17 });
			put(12, new int[] { 6, 18 });
			put(13, new int[] { 7, 14, 19 });
			put(14, new int[] { 8, 13, 15 });
			put(15, new int[] { 9, 14 });
			put(16, new int[] { 17, 22 });
			put(17, new int[] { 11, 16 });
			put(18, new int[] { 12, 24 });
			put(19, new int[] { 13, 25 });
			put(20, new int[] { 26 });
			put(21, new int[] { 22, 27 });
			put(22, new int[] { 16, 21 });
			put(23, new int[] { 24 });
			put(24, new int[] { 18, 23, 30 });
			put(25, new int[] { 19, 31 });
			put(26, new int[] { 20, 32 });
			put(27, new int[] { 21, 33 });
			put(28, new int[] { 29, 34 });
			put(29, new int[] { 28, 35 });
			put(30, new int[] { 24 });
			put(31, new int[] { 25, 32 });
			put(32, new int[] { 31, 26 });
			put(33, new int[] { 27, 33 });
			put(34, new int[] { 28, 33 });
			put(35, new int[] { 29, 36 });
			put(36, new int[] { 35 });
		}
	};

	private void setMaze(){
		System.out.println("Digite a linha de um indicador (1-6):");
		flag = (Integer.parseInt(Main.LerEntrada())-1) * 6;
		System.out.println("Digite a coluna desse indicador (1-6):");
		flag += Integer.parseInt(Main.LerEntrada());
		
		switch (flag) {
			case 7 -> this.maze = maze1;
			case 18 -> this.maze = maze1;
			case 11 -> this.maze = maze2;
			case 20 -> this.maze = maze2;
			case 22 -> this.maze = maze3;
			case 24 -> this.maze = maze3;
			case 1 -> this.maze = maze4;
			case 19 -> this.maze = maze4;
			case 17 -> this.maze = maze5;
			case 34 -> this.maze = maze5;
			case 5 -> this.maze = maze6;
			case 27 -> this.maze = maze6;
			case 2 -> this.maze = maze7;
			case 32 -> this.maze = maze7;
			case 4 -> this.maze = maze8;
			case 21 -> this.maze = maze8;
			case 9 -> this.maze = maze9;
			case 25 -> this.maze = maze9;
		}
	}

	private List pathFinder(int start, int end, Map<Integer, int[]> maze, ) {
		// TODO: Implement algorithm to solve the maze
		return List;
	}

	@Override
	public void solve(Indicators indicators) {
		setMaze();
		
		System.out.println("Digite a linha de início (1-6):");
		start = (Integer.parseInt(Main.LerEntrada()) - 1) * 6;
		System.out.println("Digite a coluna de início (1-6):");
		start += Integer.parseInt(Main.LerEntrada()); 
		System.out.println("Digite a linha de fim (1-6):");
		end = (Integer.parseInt(Main.LerEntrada()) - 1) * 6;
		System.out.println("Digite a coluna de fim (1-6):");
		end += Integer.parseInt(Main.LerEntrada()); 

		path = pathFinder(start,end, maze);
		System.out.println("O caminho é:");
		// TODO: Show to user the path
	}
}
