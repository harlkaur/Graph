import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindwhetherpathexistWithBFS {

	static int V;
	private static ArrayList<ArrayList<Integer>> adj;

	FindwhetherpathexistWithBFS(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	private static void addEdge(int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int matrix[][] = null;
		while (t-- > 0) {
			int n = sc.nextInt();
			matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			isPath(matrix, 4);
			System.out.println();
		}

	}

	static boolean isSafe(int i, int j, int M[][],  int N) 
	{ 
	    if ((i < 0 || i >= N) || 
	        (j < 0 || j >= N ) || M[i][j] == 0) 
	        return false; 
	    return true; 
	} 
	
	private static void isPath(int[][] matrix, int n) {
		boolean[][] visited = new boolean[n][n];
		Queue<Integer> queue = new LinkedList<Integer>();
		// int source, distination;
		int s, d;
		V = n * n + 2;
		FindwhetherpathexistWithBFS g = new FindwhetherpathexistWithBFS(7);
		// start with initial vertex and traverse to see if path exist
		int k = 1; // Number of current vertex
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0) {
					// connect all 4 adjacent cell to
					// current cell
					if (isSafe(i, j + 1, matrix,n))
						g.addEdge(k, k + 1);
					if (isSafe(i, j - 1, matrix,n))
						g.addEdge(k, k - 1);
					if (j < n - 1 && isSafe(i + 1, j, matrix,n))
						g.addEdge(k, k + n);
					if (i > 0 && isSafe(i - 1, j, matrix,n))
						g.addEdge(k, k - n);
				}

				// source index
				if (matrix[i][j] == 1)
					s = k;

				// destination index
				if (matrix[i][j] == 2)
					d = k;
				k++;
			}
		}
	}

}
