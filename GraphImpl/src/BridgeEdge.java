import java.util.Iterator;
import java.util.LinkedList;

public class BridgeEdge {
	private int vertices;
	private LinkedList<Integer> adjList[];
	private int time = 0;

	public BridgeEdge(int vertices) {
		this.vertices = vertices;

		adjList = new LinkedList[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
	}

	public void bridgeEdge() {
		boolean visited[] = new boolean[this.vertices];
		int parent[] = new int[this.vertices];
		int arrival[] = new int[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			if (!visited[i])
				bridgeEdgeUtil(i, visited, parent, arrival);
		}
	}

	public int bridgeEdgeUtil(int v, boolean visited[], int parent[],
			int arrival[]) {
		visited[v] = true;
		arrival[v] = ++time;
		int deepestBackEdge = arrival[v];
		Iterator<Integer> iter = adjList[v].iterator();
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w]) {
				parent[w] = v;
				deepestBackEdge = Math.min(deepestBackEdge,
						bridgeEdgeUtil(w, visited, parent, arrival));
			} else if (w != parent[v])
				deepestBackEdge = Math.min(deepestBackEdge, arrival[w]);
		}
		if (deepestBackEdge == arrival[v]) {
			System.out.println(v);
		}
		return deepestBackEdge;
	}

	public static void main(String args[]) {
		// Create graphs given in above diagrams
		System.out.println("Bridges in first graph ");
		BridgeEdge g1 = new BridgeEdge(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.bridgeEdge();
		System.out.println();

		System.out.println("Bridges in Second graph");
		BridgeEdge g2 = new BridgeEdge(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		g2.bridgeEdge();
		System.out.println();

		System.out.println("Bridges in Third graph ");
		BridgeEdge g3 = new BridgeEdge(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		g3.bridgeEdge();
	}
}
