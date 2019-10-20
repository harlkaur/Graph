import java.util.ArrayList;
import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		boolean visited[] = new boolean[V + 1];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

//		addEdge(adj, 1, 2);
//		addEdge(adj, 1, 3);
//		addEdge(adj, 2, 4);
//		addEdge(adj, 2, 5);
//		addEdge(adj, 3, 5);
//		addEdge(adj, 4, 5);
//		addEdge(adj, 4, 6);
//		addEdge(adj, 5, 6);

//		addEdge(adj, 0, 1);
//		addEdge(adj, 0, 2);
//		addEdge(adj, 1, 2);
//		addEdge(adj, 2, 0);
//		addEdge(adj, 2, 3);
//		addEdge(adj, 3, 3);

		addEdge(adj, 1, 0);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 1);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 4);

		dfs(0, adj, visited);
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(src);
		//visited[src] = true;

		while (!stack.isEmpty()) {
			src = stack.peek();
			
			stack.pop();
			if (visited[src] == false) {
				System.out.print(src + " ");
				visited[src] = true;
			}
			for (int i = 0; i < adj.get(src).size(); i++) {
				int newNode = adj.get(src).get(i);
				if (!visited[newNode]) {
					stack.push(newNode);
					visited[newNode] = true;
				}
			}

		}
	}
}
