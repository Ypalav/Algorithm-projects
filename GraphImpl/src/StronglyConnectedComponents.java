import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponents {
	private int vertices;
	private LinkedList<Integer> adjList[];
	static int time = 0;

	public StronglyConnectedComponents(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	public void dfs(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> iter = adjList[v].listIterator();
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w])
				dfs(w, visited);
		}
	}

	public void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
		visited[v] = true;
		Iterator<Integer> iter = adjList[v].listIterator();
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w])
				dfs(w, visited);
		}
		stack.push(v);
	}

	StronglyConnectedComponents getReverseOfGraph() {
		StronglyConnectedComponents comp = new StronglyConnectedComponents(
				this.vertices);
		for (int i = 0; i < this.vertices; i++) {
			Iterator<Integer> iter = adjList[i].listIterator();
			while (iter.hasNext()) {
				comp.adjList[iter.next()].add(i);
			}
		}
		return comp;
	}

	public void printStronglyConnectedComp() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			if (!visited[i])
				fillOrder(i, visited, stack);
		}

		StronglyConnectedComponents comp = getReverseOfGraph();

		for (int i = 0; i < this.vertices; i++) {
			visited[i] = false;
		}

		while (!stack.isEmpty()) {
			int v = stack.pop();
			if (!visited[v]) {
				comp.dfs(v, visited);
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		StronglyConnectedComponents g = new StronglyConnectedComponents(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		System.out.println("Following are strongly connected components "
				+ "in given graph ");
		//g.printStronglyConnectedComp();
		g.printStronglyConnectedComp2();
	}

	private void printStronglyConnectedComp2() {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[this.vertices];
		int arrival[] = new int[this.vertices];
		int deepestBackEdge = 0;

		for (int i = 0; i < this.vertices; i++) {
			if (!visited[i])
				dfsUtil(i, visited, arrival, deepestBackEdge);
		}
	}

	private int dfsUtil(int v, boolean[] visited, int[] arrival, int dBE) {
		// TODO Auto-generated method stub
		visited[v] = true;
		arrival[v] = ++time;
		dBE = arrival[v];

		Iterator<Integer> iter = adjList[v].listIterator();
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w])
				dBE = Math.min(dBE, dfsUtil(w, visited, arrival, dBE));
			else
				dBE = Math.min(dBE, arrival[w]);
		}
		if (dBE == arrival[v])
			
			System.out.println(v);

		return dBE;
	}

}
