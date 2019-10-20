import java.util.ArrayList;
import java.util.Stack;

public class DetechcyelinDIrectedgraph {

	private static int V;
	private static ArrayList<ArrayList<Integer>> adj;

	// constructor
	DetechcyelinDIrectedgraph(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public static void main(String[] args) {
		DetechcyelinDIrectedgraph g = new DetechcyelinDIrectedgraph(4);
		addEdge(g, 0, 1);
		addEdge(g, 0, 2);
		addEdge(g, 1, 2);
		addEdge(g, 2, 0);
		addEdge(g, 2, 3);
		addEdge(g, 3, 3);
		if (isCyclic(g))
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

	private static boolean isCyclic(DetechcyelinDIrectedgraph g) {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++)
			if (cyclicUtil(i, visited, recStack,adj))
				return true;

		return false;
	}

	private static boolean cyclicUtil(int i, boolean[] visited, boolean[] recStack,ArrayList<ArrayList<Integer>> adj) {

		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;

		recStack[i] = true;
		for (int k = 0; k < adj.get(i).size(); k++)
			if (cyclicUtil(k, visited, recStack,adj))
				return true;

		recStack[i] = false;

		return false;
	}

	private static void addEdge(DetechcyelinDIrectedgraph g, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

}
