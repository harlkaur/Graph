import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DFSRecursive {

	private int V;
	private ArrayList<ArrayList<Integer>>  adj;

	// constructor
	DFSRecursive(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	// driver code
	public static void main(String[] args) {

		DFSRecursive g = new DFSRecursive(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(3, 4);

		g.DFS(2);
	}

	private void DFS(int i) {
		boolean visited[] = new boolean[V];
		DFSUtil(i, visited);

	}

	private void DFSUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		for (int i = 0; i < adj.get(s).size(); i++) {
			int newNode = adj.get(s).get(i);
			if(!visited[newNode]) {
				DFSUtil(newNode, visited);
			}
		}
		
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);// Add w to v's list.
	}

}
