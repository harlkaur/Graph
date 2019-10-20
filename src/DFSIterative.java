import java.util.ArrayList;
import java.util.Stack;

public class DFSIterative {
	private int V;
	private ArrayList<ArrayList<Integer>> adj;

	// constructor
	DFSIterative(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public static void main(String[] args) {
		DFSIterative g = new DFSIterative(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);

		g.DFS();
	}

	void DFS() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			if (!visited[i])
				DFSUtil(i, visited);
	}

	private void DFSUtil(int s,boolean[] visited) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);

		while (!stack.isEmpty()) {
			s = stack.peek();
			stack.pop();

			if (visited[s] == false) {
				System.out.print(s + " ");
				visited[s] = true;
			}

			for (int i = 0; i < adj.get(s).size(); i++) {
				int newNode = adj.get(s).get(i);
				if (!visited[newNode]) {
					stack.push(newNode);
					// visited[newNode] = true;
				}
			}
		}

	}

	private void addEdge(int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

}
