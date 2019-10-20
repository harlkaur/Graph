import java.util.ArrayList;

public class AdjListPrint {

	static int V;
	private static ArrayList<ArrayList<Integer>> list;

	AdjListPrint(int V) {
		this.V = V;
		list = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {

		AdjListPrint adj = new AdjListPrint(5);
		addEdge(list, 0, 1);
		addEdge(list, 0, 4);
		addEdge(list, 1, 2);
		addEdge(list, 1, 3);
		addEdge(list, 1, 4);
		addEdge(list, 2, 3);
		addEdge(list, 3, 4);

		printGraph(list);
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> list) {
		for(int i=0;i<list.size();i++) {
			System.out.print(i + " -> ");
			for(int j=0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> list, int i, int j) {
		list.get(i).add(j);
		list.get(j).add(i);
	}

}
