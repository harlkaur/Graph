/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PathExists {


    static boolean flag = false;
    static int ROW, COL;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int matrix[][] = null;
		while(t-- > 0) {
			int n = sc.nextInt();
			ROW = n;
			COL = n;
			matrix = new int[n][n];
			for(int i= 0;i<n;i++) {
				for(int j=0;j<n;j++) {
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
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 3  || M[row][col] == 2 ) && !visited[row][col];
	}

	static void DFS(int M[][], int row, int col, boolean[][] visited) {
		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] {  0, -1, 1, 0 };

		visited[row][col] = true;

		for (int k = 0; k < 4; k++) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
			    //System.out.println((row + rowNbr[k]) + " " + (col + colNbr[k]) );
				if(M[row + rowNbr[k]][col + colNbr[k]] == 2) {
					flag =  true;
				//	break;
				}
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
			}
		}
	}

	private static void countIslands(int M[][]) {
	//	int count = 0;
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

		
	}



}