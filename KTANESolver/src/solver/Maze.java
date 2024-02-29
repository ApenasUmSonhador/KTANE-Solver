package solver;

public class Maze implements Module {

	// TODO: Represent the maze as a adjacency matrix
	private int[][] maze1 = {
			{ 2, 7 }, { 1, 3 }, { 2, 9 }, { 5, 10 }, { 4, 6 }, { 5 },
			{ 1, 13 }, { 9, 14 }, { 3, 8 }, { 4, 11 }, { 10, 12 }, { 11, 18 },
			{ 7, 14 }, { 8, 15 }, { 14, 21 }, { 17, 22 }, { 16, 18 }, { 17, 24 },
			{ 13, 25 }, { 21 }, { 15, 20, 22 }, { 16, 21 }, { 24 }, { 18, 30 },
			{ 19, 26, 31 }, { 25, 27 }, { 26, 33 }, { 29, 34 }, { 28 }, { 24, 36 },
			{ 25, 32 }, { 31 }, { 27, 34 }, { 28, 33 }, { 36 }, { 30, 35 }
	},
			maze2 = {
					{ 2 }, { 1, 3 }, { 2 }, { 5, 10 }, { 4, 6, 11 }, { 5 },
					{ 8, 13 }, { 7, 2 }, { 10, 15 }, { 4, 9 }, { 5, 12 }, { 11, 18 },
					{ 7, 19 }, { 15, 20 }, { 14, 8 }, { 17, 22 }, { 16, 18 }, { 12, 17, 24 },
					{ 13, 20, 25 }, { 19, 14 }, { 22, 27 }, { 16, 21 }, { 29 }, { 18, 23, 30 },
					{ 19, 31 }, { 32 }, { 21, 33 }, { 29, 34 }, { 23, 28 }, { 24, 36 },
					{ 25 }, { 26, 33 }, { 27, 32 }, { 28, 35 }, { 34, 36 }, { 30, 35 }
			},
			maze3 = {
					{ 2, 7 }, { 1, 3 }, { 2, 9 }, { 10 }, { 6, 11 }, { 5, 12 },
					{ 1 }, { 14 }, { 3, 15 }, { 4 }, { 5, 10 }, { 6, 18 },
					{ 14, 19 }, { 13, 20 }, { 9, 21 }, { 17, 22 }, { 16, 23 }, { 12, 24 },
					{ 13, 25 }, { 14, 26 }, { 15, 27 }, { 16, 28 }, { 17, 29 }, { 18, 30 },
					{ 19, 31 }, { 20, 27 }, { 21 }, { 22, 34 }, { 23, 35 }, { 24, 36 },
					{ 25, 32 }, { 31, 33 }, { 32, 34 }, { 28, 33 }, { 29, 36 }, { 30, 35 }
			},
			maze4 = {
					{ 2, 7 }, { 1, 8 }, { 4 }, { 3, 5 }, { 4, 6 }, { 5, 12 },
					{ 1, 13 }, { 2, 14 }, { 10, 15 }, { 9, 11 }, { 10, 12 }, { 6, 11, 18 },
					{ 7, 19 }, { 8, 15 }, { 8, 14 }, { 17, 22 }, { 16 }, { 12, 24 },
					{ 13, 25 }, { 21 }, { 20, 22 }, { 14, 21, 23 }, { 22, 24 }, { 18, 23, 30 },
					{ 19, 26, 31 }, { 25, 27 }, { 26, 28 }, { 27, 29 }, { 28, 35 }, { 24, 36 },
					{ 25, 32 }, { 31, 33 }, { 32 }, { 35 }, { 29, 34 }, { 30 }
			},
			maze5 = {
					{ 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6, 11 }, { 5, 12 },

			},
			maze6,
			maze7,
			maze8,
			maze9;

	// TODO: BFS algorithm to solve the maze

	@Override
	public void solve(Indicators indicators) {
		// TODO: Implement
	}
}
