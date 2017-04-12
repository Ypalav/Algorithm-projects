package com.cs430.AllPairShortestPath;

public class FloydWarshall {
	public int solutionMatrix[][];
	public static final int INFINITY = 9999;
	private int totalVertices;

	public FloydWarshall(int totalVertices) {
		solutionMatrix = new int[totalVertices][totalVertices];
		this.totalVertices = totalVertices;
	}
	
	public void computeShortestPath(int matrix[][]) {
		for (int i = 0; i < totalVertices; i++) {
			for (int j = 0; j < totalVertices; j++) {
				solutionMatrix[i][j] = matrix[i][j];
			}
		}

		for (int v = 0; v < totalVertices; v++) {
			for (int i = 0; i < totalVertices; i++) {
				for (int j = 0; j < totalVertices; j++) {
					if(solutionMatrix[i][v] != INFINITY
							&& solutionMatrix[v][j] != INFINITY && i!=j)
					{
					if (solutionMatrix[i][v] + solutionMatrix[v][j] < solutionMatrix[i][j])
						solutionMatrix[i][j] = solutionMatrix[i][v]
								+ solutionMatrix[v][j];
					}
				}
			}
		}

		display(solutionMatrix);
	}

	private void display(int[][] solutionMatrix2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalVertices; i++) {
			for (int j = 0; j < totalVertices; j++) {
				if (solutionMatrix2[i][j] != INFINITY) {
					System.out.println(solutionMatrix2[i][j] + " ");
				} else {
					System.out.println("INFINITY");
				}
			}
		}
	}

}
