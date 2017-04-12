package com.cs430.SingleSourceShortestPath;

import java.util.LinkedList;
import java.util.Scanner;

public class BellmanFord {
	final int INFINITY = 999;
	static int vertices;
	int edge;
	Edge edgeList[];
	static int distance[];
	int u, v, weight;
	private static long startTime = System.currentTimeMillis();

	public BellmanFord(int vertices, int edge) {
		this.vertices = vertices;
		this.edge = edge;
		edgeList = new Edge[edge];
		for (int i = 0; i < edge; i++) {
			edgeList[i] = new Edge();
		}
	}

	
	public void iterateToAllVertices(int source) {
		for (int i = 0; i < this.vertices; i++) {
			for (int j = 0; j < this.edge; j++) {
				u = this.edgeList[j].source;
				v = this.edgeList[j].destination;
				weight = this.edgeList[j].edgeWeight;
				if ((distance[u] + weight) < distance[v]
						&& distance[u] != INFINITY)
					distance[v] = distance[u] + weight;
			}
		}
		checkForCycle();
		display(distance, vertices);
	}

	public void checkForCycle() {

		for (int i = 0; i < this.edge; i++)
			if ((distance[this.edgeList[i].source] + this.edgeList[i].edgeWeight) < distance[this.edgeList[i].destination])
				System.out.println("Graph contains negative weight cycle");
	}

	public void init(int source) {
		distance = new int[this.vertices];

		for (int i = 0; i < this.vertices; i++) {
			distance[i] = INFINITY;
		}
		distance[source] = 0;
	}

	public void display(int distance[], int vertices) {
		for (int i = 0; i < this.vertices; i++) {
			System.out.println("Vertex " + i + " is "
					+ distance[i] + " Distance from source");
		}
	}

	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the vertices and edges");
		int totalVertices = scanner.nextInt();
		int totalEdges = scanner.nextInt();
		System.out.println("Enter the edges source, destination and weight data");
		BellmanFord bellmanFord = new BellmanFord(totalVertices, totalEdges);
		for (int i = 0; i < totalEdges; i++) {
			bellmanFord.edgeList[i].source = scanner.nextInt();
			bellmanFord.edgeList[i].destination = scanner.nextInt();
			bellmanFord.edgeList[i].edgeWeight = scanner.nextInt();
		}

		bellmanFord.init(0);
		bellmanFord.iterateToAllVertices(0);
		scanner.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Running time of algorithm is for " + totalVertices
				+ " vertices is " + (endTime - startTime) + " milliseconds");
	}

}
