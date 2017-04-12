import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopKahns {
	private int vertices;
	private List<Integer> adjList[];

	public TopKahns(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	public void topologicalSort() {
		int inDegree[] = new int[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			//ArrayList<Integer> temp = (ArrayList<Integer>) adjList[i];
			for (int node : adjList[i]) {
				inDegree[node]++;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < this.vertices; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}
		int count = 0;
		ArrayList<Integer> topologicalOrder = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int node = q.poll();
			topologicalOrder.add(node);

			for (int temp : adjList[node]) {
				if (--inDegree[temp] == 0)
					q.add(temp);
			}
			count++;
		}

		if (count != this.vertices) {
			System.out.println("There is a cycle");
		}

		for (int temp : topologicalOrder) {
			System.out.print(temp+" ");
		}

	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		TopKahns g = new TopKahns(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological Sort");
		g.topologicalSort();

	}
}
