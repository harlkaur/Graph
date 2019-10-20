import java.util.Scanner;

public class RottenOranges {


    static boolean flag = false;
    static int ROW, COL, COUNT = 2;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int matrix[][] = null;
		while(t-- > 0) {
			ROW = sc.nextInt();
			COL = sc.nextInt();
			matrix = new int[ROW][COL];
			for(int i= 0;i<ROW;i++) {
				for(int j=0;j<COL;j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			countIslands(matrix);
			
			if(flag)
			    System.out.println("1");
			else
		    	System.out.println("0"); 
			flag = false;
			
		}

		//isPath(matrix, 4);
	
	}
	
	static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && !visited[row][col] && (M[row][col] == 1);
	}

	static void DFS(int M[][], int row, int col, boolean[][] visited,int count) {
		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] {  0, -1, 1, 0 };
		visited[row][col] = true;
		for (int k = 0; k < 4; k++) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
				M[ row + rowNbr[k]][col + colNbr[k]] = COUNT + count + 1;
				visited[row + rowNbr[k]][col + colNbr[k]] = true;
			}
		}
	}

	private static void countIslands(int M[][]) {
		int count = 0;
		boolean[][] visited = new boolean[ROW][COL];
	    boolean flag = false;
		
	
		
	while(!flag) {

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if ((M[i][j] == COUNT + count) ) {
					
					//M[i][j] = COUNT + count + 1;
					DFS(M, i, j, visited,count);
			
				}
			}
		}
		
		++count;
		
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if(M[i][j] !=1 )
					flag = true;
			}
			System.out.println();
		}
		
		System.out.println(count);
		
	}
		

		
	}



}
