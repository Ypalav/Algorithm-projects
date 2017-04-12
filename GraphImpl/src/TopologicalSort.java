import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	private int vertexCount;
	private LinkedList<Integer> adjList[];

	public TopologicalSort(int vertexCount) {
		this.vertexCount = vertexCount;
		adjList = new LinkedList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int i, int j) {
		adjList[i].add(j);
	}

	public void topologicalSortUtil(int vertex, boolean visited[],
			Stack<Integer> stack) {

		visited[vertex] = true;
		Iterator<Integer> i = adjList[vertex].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				topologicalSortUtil(n, visited, stack);
			}
		}

		stack.push(vertex);
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[this.vertexCount];

		for (int i = 0; i < this.vertexCount; i++)
			visited[i] = false;

		for (int i = 0; i < this.vertexCount; i++) {
			if (visited[i] == false) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}
	}

	public static void main(String args[]) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological "
				+ "sort of the given graph");
		g.topologicalSort();
	}
}
