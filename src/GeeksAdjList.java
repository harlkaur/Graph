import java.util.ArrayList;

public class GeeksAdjList {

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);

		printAdjacencyList(adj,V);

	}
	
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static void printAdjacencyList(ArrayList<ArrayList<Integer>> list, int v) {
		for(int i=0;i<list.size();i++) {
			System.out.print(i);
			for(int j=0;j<list.get(i).size();j++) {
				System.out.print("-> " + list.get(i).get(j));
			}
			System.out.println();
		}
	}
}
