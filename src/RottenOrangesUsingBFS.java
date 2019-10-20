import java.util.Scanner;

public class RottenOrangesUsingBFS {

	static int ROW, COL;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int matrix[][] = null;
		while (t-- > 0) {
			ROW = sc.nextInt();
			COL = sc.nextInt();
			matrix = new int[ROW][COL];
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
		}
		rotOranges(matrix);

	}

	private static void rotOranges(int[][] matrix) {
		boolean[][] visited = new boolean[ROW][COL];
		Queue<Integer>
	}
}
