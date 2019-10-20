import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

	private static int V;
	private static ArrayList<ArrayList<Integer>> adj;

	// constructor
	TopologicalSort(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(3, 4);

		int[] result = g.sort();
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	private static int[] sort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		int[] arr = new int[V + V];
		int c = 0;
		for (int k = 0; k < V; k++) {
			sortUtil(k, visited, stack);
		}
		while (!stack.isEmpty()) {
			arr[c++] = stack.pop();
		}
		return arr;
	}

	private static void sortUtil(int s, boolean[] visited, Stack<Integer> stack) {
		visited[s] = true;
		int i = 0;
		while (i < adj.get(s).size()) {
			int newNode = adj.get(s).get(i);
			if (!visited[newNode]) {
				visited[newNode] = true;
				sortUtil(newNode, visited, stack);
			}
			i++;
		}
		stack.push(s);
	}

	void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
}
