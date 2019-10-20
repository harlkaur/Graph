import java.util.ArrayList;

public class CycleinDirectedGraph {

	private static int V;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	CycleinDirectedGraph(int V) {
		this.V = V;
		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<>());
		}
	}

	private void addEdge(int u, int v) {
		list.get(u).add(v);
		list.get(v).add(u);
	}

	public static void main(String[] args) {
		CycleinDirectedGraph graph = new CycleinDirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle ");
		else
			System.out.println("Graph doesn't " + "contain cycle ");
	}

	private boolean isCyclic() {
		boolean result = false;
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int u = 0; u < V; u++) {
			result = isCyclicUtil(u, visited, recStack);
		}

		return result;
	}

	private boolean isCyclicUtil(int u, boolean[] visited, boolean[] recStack) {
		if (recStack[u])
			return true;
		if (visited[u])
			return false;
		visited[u] = true;
		recStack[u] = true;

		for (int i = 0; i < list.get(u).size(); i++) {
			int newNode = list.get(u).get(i);
			if (!visited[newNode] && isCyclicUtil(newNode, visited, recStack)) {
				return true;
			}
		}
		recStack[u] = false;
		return false;
	}

}
