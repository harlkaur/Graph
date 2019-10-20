import java.util.ArrayList;

public class DFSRevision {

	static int V;
	private static ArrayList<ArrayList<Integer>> adj;

	DFSRevision(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {

		DFSRevision bfs = new DFSRevision(5);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);
		bfs.addEdge(3, 4);


		dfs(adj);
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		//for(int u=0;u<V;u++) {
			DFSUtil(2,visited);
		//}
		
	}

	private static void DFSUtil(int u, boolean[] visited) {
		visited[u] = true;
		System.out.print(u + " ");
		for(int i=0;i<adj.get(u).size();i++) {
			int newNode = adj.get(u).get(i);
			if(!visited[newNode]) {
				visited[newNode] = true;
				DFSUtil(newNode,visited);
			}
		}
	}

	private static void addEdge(int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

}
