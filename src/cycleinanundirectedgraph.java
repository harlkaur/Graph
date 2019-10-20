import java.util.ArrayList;

public class cycleinanundirectedgraph {

	private static int V;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	cycleinanundirectedgraph(int V) {
		this.V = V;
		for (int i = 0; i < V + 1; i++) {
			list.add(new ArrayList<>());
		}
	}

	public static void main(String[] args) {
		cycleinanundirectedgraph cycle = new cycleinanundirectedgraph(4);
		cycle.addEdge(0, 1);
		cycle.addEdge(0, 2);
		cycle.addEdge(1, 2);
		cycle.addEdge(2, 0);
		cycle.addEdge(2, 3);
		cycle.addEdge(3, 3);

		if (cycle.isCyclic(list, V))
			System.out.println("Graph contains cycle ");
		else
			System.out.println("Graph doesn't " + "contain cycle ");
	}

	private void addEdge(int u, int v) {
		list.get(u).add(v);
		list.get(v).add(u);
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		boolean result = false;
		boolean visited[] = new boolean[V];
		for(int src=0;src<V;src++) {
		      result = isCyclicUtil(src, visited,-1);
		}
		return result;
	}

	static boolean isCyclicUtil(int src, boolean visited[], int parent) {
		boolean result = false;
		visited[src] = true;
		int newNode ;
		for (int i = 0; i < list.get(src).size(); i++) {
			 newNode = list.get(src).get(i);
			if (!visited[newNode]) {
				result = isCyclicUtil(newNode, visited, src);
			} else if(newNode != parent){
				return true;
			}
		}
		return result ;
	}
}
