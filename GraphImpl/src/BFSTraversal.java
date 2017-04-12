import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
	private int vertices;
	private LinkedList<Integer> adjList[];

	public BFSTraversal(int v) {
		// TODO Auto-generated constructor stub
		vertices = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	public void bfs(int source) {
		boolean visited[] = new boolean[vertices];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			source = q.poll();
			System.out.println(source);
			Iterator<Integer> iter = adjList[source].listIterator();
			while (iter.hasNext()) {
				int adjNode = iter.next();
				if (!visited[adjNode]) {
					q.add(adjNode);
					visited[adjNode] = true;
				}
			}
		}

	}
	
	/*void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertices];
 
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        queue.add(s);
        visited[s]=true;
        
 
        while (!queue.isEmpty())
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {	
                	queue.add(n);
                    visited[n] = true;
                    
                }
            }
        }
    }*/

	public static void main(String args[]) {
		BFSTraversal g = new BFSTraversal(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "
				+ "(starting from vertex 2)");

		g.bfs(2);

	}

}
