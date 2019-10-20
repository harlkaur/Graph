//import java.util.Scanner;
//
//public class FindwhetherpathexistWithoutBFS {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		int matrix[][] = null;
//		while(t-- > 0) {
//			int n = sc.nextInt();
//			 matrix = new int[n][n];
//			for(int i= 0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					matrix[i][j] = sc.nextInt();
//				}
//			}
//			isPath(matrix, 4);
//			System.out.println();
//		}
//
//		
//	}
//
//	private static void isPath(int[][] matrix, int n) {
//		boolean[][] visited = new boolean[n][n];
//		boolean flag = false;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (!visited[i][j] && matrix[i][j] == 1)
//					if (isPath(matrix, i, j, visited)) {
//						flag = true;
//						break;
//					}
//			}
//		}
//		if (flag)
//			System.out.print("1");
//		else
//			System.out.print("0");
//
//	}
//
//	private static boolean isPath(int[][] matrix, int i, int j, boolean[][] visited) {
//		if (isSafe(matrix, i, j) && matrix[i][j] != 0 && !visited[i][j]) {
//			visited[i][j] = true;
//			if (matrix[i][j] == 2)
//				return true;
//			boolean up = isPath(matrix, i - 1, j, visited);
//			if (up)
//				return true;
//			boolean down = isPath(matrix, i + 1, j, visited);
//			if (down)
//				return true;
//			boolean left = isPath(matrix, i, j - 1, visited);
//			if (left)
//				return true;
//			boolean right = isPath(matrix, i, j + 1, visited);
//			if (right)
//				return true;
//		}
//		return false;
//	}
//
//	private static boolean isSafe(int[][] matrix, int i, int j) {
//		if (i >= 0 && j >= 0 && i < matrix.length && j < matrix.length)
//			return true;
//		return false;
//	}
//
//}
//


import java.util.ArrayList;

public class FindwhetherpathexistWithoutBFS {

	static final int ROW = 5, COL = 5;

	static boolean flag = false;
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
				FindwhetherpathexistWithoutBFS I = new FindwhetherpathexistWithoutBFS();
		System.out.println(" Number of islands is: " + I.countIslands(M));
	}

	static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && M[row][col] == 3 && !visited[row][col]  && M[row][col] == 2;
	}

	static void DFS(int M[][], int row, int col, boolean[][] visited) {
		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] {  0, -1, 1, 0 };

		visited[row][col] = true;

		for (int k = 0; k < 4; k++) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				if(M[row][col] == 2)
					flag =  true;
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}

	private static int countIslands(int M[][]) {
		int count = 0;
		boolean[][] visited = new boolean[ROW][COL];
		int start = - 1 , end  = -1;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (M[i][j] == 1) {
					start = i;
					end = j;
					break;
				}
			}
		}

		DFS(M, start, end, visited);

		return count;
	}

}
