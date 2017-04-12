package com.cs430.AllPairShortestPath;

import java.util.Scanner;

public class RunAlgorithm {
	private static long startTime = System.currentTimeMillis();

	public static void main(String args[]) {
		int totalVertices;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Total Number of Vertices?");
		totalVertices = scanner.nextInt();
		FloydWarshall floydWarshall = new FloydWarshall(totalVertices);

		System.out.println("Enter the matrix for the graph");
		for (int i = 0; i < totalVertices; i++) {
			for (int j = 0; j < totalVertices; j++) {
				floydWarshall.solutionMatrix[i][j] = scanner.nextInt();
				if (i == j) {
					floydWarshall.solutionMatrix[i][j] = 0;
				} else if (floydWarshall.solutionMatrix[i][j] == 0) {
					floydWarshall.solutionMatrix[i][j] = FloydWarshall.INFINITY;
				}
			}
		}

		floydWarshall.computeShortestPath(floydWarshall.solutionMatrix);

		scanner.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Running time of algorithm for " + totalVertices
				+ " vertices is " + (endTime - startTime) + " milliseconds");
	}
}
