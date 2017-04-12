public class GraphWithMatrix {
	int[][] adjList;
	int vertexCount;

	public GraphWithMatrix(int vertexCount) {
		this.vertexCount = vertexCount;
		adjList = new int[vertexCount][vertexCount];
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			adjList[i][j] = 1;
		}
	}

	public void removeEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			adjList[i][j] = 0;
		}
	}

	public int isEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount)
			return adjList[i][j];
		else
			return -1;
	}

	public void printMatrix() {
		for (int i = 0; i < adjList.length; i++) {
			for (int j = 0; j < adjList.length; j++) {
				System.out.print(adjList[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		GraphWithMatrix matrix = new GraphWithMatrix(5);
		matrix.addEdge(0, 1);
		matrix.addEdge(0, 4);
		matrix.addEdge(1, 2);
		matrix.addEdge(1, 3);
		matrix.addEdge(1, 4);
		matrix.addEdge(2, 3);
		matrix.addEdge(3, 4);

		matrix.printMatrix();
		matrix.removeEdge(0, 4);
		System.out.println();
		System.out.println();
		matrix.printMatrix();
		System.out.println();
		System.out.println(matrix.isEdge(0, 6));
	}

}
