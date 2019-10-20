import java.util.ArrayList;

public class UnitAreaOfLargestRegionOf1s {

	static final int ROW = 5, COL = 5;
	
	static int max = Integer.MIN_VALUE, count = 1;
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1,0, 1 } };
		UnitAreaOfLargestRegionOf1s I = new UnitAreaOfLargestRegionOf1s();
		System.out.println(" Area is: " + I.countIslands(M));
	}

	static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && M[row][col] == 1 && !visited[row][col];
	}

	static void DFS(int M[][], int row, int col, boolean[][] visited) {
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				count++;
				System.out.println(count);
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
		
		if(count > max)
			max = count;
			
		
		
	}

	private static int countIslands(int M[][]) {
	
		boolean flag = false;
		boolean[][] visited = new boolean[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (M[i][j] == 1 && !visited[i][j]) {
					flag = true;
					DFS(M, i, j, visited);
					count = 1;
					
				}
			}
		}
		if(flag)
			return max;
		
		return 0;
	}

}
