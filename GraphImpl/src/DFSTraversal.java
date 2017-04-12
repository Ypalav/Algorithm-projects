import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSTraversal {
	int verticesCount;
	LinkedList<Integer> linkedList[];

	public DFSTraversal(int verticesCount) {
		this.verticesCount = verticesCount;
		linkedList = new LinkedList[verticesCount];
		for (int i = 0; i < verticesCount; ++i) {
			linkedList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int i, int j) {
		linkedList[i].add(j);
	}

	public void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> i = linkedList[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	public void DFSIterative(int v, boolean visited[]) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		while (!stack.isEmpty()) {
			v = stack.pop();
			if (!visited[v]) {
				visited[v] = true;
				System.out.print(v + " ");
				Iterator<Integer> iter = linkedList[v].listIterator();
				while (iter.hasNext()) {
					stack.push(iter.next());
				}
			}
		}

	}

	public void DFS() {
		boolean visited[] = new boolean[this.verticesCount];

		for (int i = 0; i < this.verticesCount; ++i) {
			if (!visited[i])
				DFSIterative(i, visited);
		}
	}

	public static void main(String args[]) {
		DFSTraversal traversal = new DFSTraversal(4);
		traversal.addEdge(0, 1);
		traversal.addEdge(0, 2);
		traversal.addEdge(1, 2);
		traversal.addEdge(2, 0);
		traversal.addEdge(2, 3);
		traversal.addEdge(3, 3);

		traversal.DFS();
	}

}
