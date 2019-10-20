import java.util.ArrayList;

public class CycleinDirectedGraphUsingColors {

	private static int V;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	static int WHITE = 0, GRAY = 1, BLACK = 2;

	CycleinDirectedGraphUsingColors(int V) {
		this.V = V;
		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<>());
		}
	}

	public static void main(String[] args) {

		CycleinDirectedGraphUsingColors g = new CycleinDirectedGraphUsingColors(4);
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

	private static boolean isCyclic(CycleinDirectedGraphUsingColors g) {
		boolean result = false;
		int[] color = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = WHITE;
		}
		for (int i = 0; i < V; i++) {
			if(color[i] == WHITE) {
				result = isCyclicUtil(i,color);
			}
		}
		return result;
	}

	private static boolean isCyclicUtil(int u, int[] color) {
		color[u] = GRAY;
		for(int i = 0; i<list.get(u).size(); i++) {
			int newNode = list.get(u).get(i);
			if(color[newNode] == GRAY) {
				return true;
			}
			if(color[newNode] == WHITE && isCyclicUtil(newNode,color))
				return true;
			
		}
		color[u] = BLACK;
		
		return false;
	}

	private static void addEdge(CycleinDirectedGraphUsingColors g, int i, int j) {
		list.get(i).add(j);
		list.get(j).add(i);
	}

}
