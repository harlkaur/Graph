import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSRevision {

	static int V;
	private static ArrayList<ArrayList<Integer>> adj;

	BFSRevision(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {

		BFSRevision bfs = new BFSRevision(7);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 4);
		addEdge(adj, 2, 5);
		addEdge(adj, 3, 5);
		addEdge(adj, 4, 5);
		addEdge(adj, 4, 6);
		addEdge(adj, 5, 6);

		bfs(adj);
	}

	private static void bfs(ArrayList<ArrayList<Integer>> list) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[V];

		int s = 1;
		queue.add(s);
		visited[s] = true;

		while (!queue.isEmpty()) {
			 s = queue.poll();
			System.out.print(s + " ");

			for (int i = 0; i < list.get(s).size(); i++) {
				int newNode = list.get(s).get(i);
				if (!visited[newNode]) {
					queue.add(newNode);
					visited[newNode] = true;
				}
			}
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j) {
		list.get(i).add(j);
		list.get(j).add(i);
	}

}
