import java.util.Iterator;
import java.util.LinkedList;

public class CycleUndirected {
	private int vertices;
	private LinkedList<Integer> adjList[];
	static int time = 0;

	public CycleUndirected(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
		//adjList[w].add(v);
	}

	public boolean dfsUtil() {
		boolean visited[] = new boolean[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			if (!visited[i])
				if (dfs(i, visited, -1))
					return true;
		}
		return false;
	}

	public boolean dfs(int v, boolean visited[], int parent) {
		visited[v] = true;
		Iterator<Integer> iter = adjList[v].listIterator();
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w]) {
				if (dfs(w, visited, v))
					return true;
			} else if (w != parent)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		/*CycleUndirected g1 = new CycleUndirected(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.dfsUtil())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		CycleUndirected g2 = new CycleUndirected(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.dfsUtil())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");*/
		
		CycleUndirected g = new CycleUndirected(4);
	    g.addEdge(1, 2);
	    g.addEdge(2, 3);
	    //g.addEdge(1, 2);
	    //g.addEdge(2, 0);
	    g.addEdge(1, 3);
	    //g.addEdge(3, 3);
	    if (g.dfsUtil())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
