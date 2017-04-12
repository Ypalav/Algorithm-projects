package com.cs430.SingleSourceShortestPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSP {
	private static long startTime = System.currentTimeMillis();

	public static void main(String[] args) {

		Scanner on = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		int source = 0;

		System.out.println("Input Graph file: ");
		String fileName = in.nextLine();

		List<List<Integer>> matrix;
		List<Integer> removedNodes = new ArrayList<Integer>();

		matrix = readFileIntoMatrix(fileName);

		while (true) {

			List<Object[]> resultList = extractShortestPath(matrix,
					removedNodes);

			System.out.println("Enter the source:");
			for (;;) {
				source = on.nextInt(); // read source node
				// make sure source node is within the network and is not
				// removed
				if (removedNodes.contains(source) || source > matrix.size()) {
					System.out.println(" node dosent exist in graph\n "
							+ "Enter new source");
				} else {
					break;
				}
			}
			performSourceNodeOperations(source, resultList);
			break;

		}
		long endTime = System.currentTimeMillis();
		System.out.println("Running time of algorithm is "
				+ (endTime - startTime) + " milliseconds");

	}

	private static List<List<Integer>> readFileIntoMatrix(String fileName) {

		List<List<Integer>> matrix = null;
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			matrix = new ArrayList<List<Integer>>();
			String curLineString = br.readLine(); // reading first line of the
													// file

			while (null != curLineString) {

				// Splitting curLineString by space into array of distances
				String[] distanceArray = curLineString.split(" ");

				List<Integer> row = new ArrayList<>();
				for (String value : distanceArray) {
					row.add(Integer.valueOf(value)); // reading values into row
														// list
				}
				matrix.add(row); // reading rows into matrix
				curLineString = br.readLine();// reading second to last line of
												// file
			}
			br.close();// close reader

		} catch (FileNotFoundException e) {
			// if file is invalid execption is given
			System.out.println("File not found");
		} catch (IOException e) {
			// if file cannot be read execption is given
			System.out.println("Cannot read file");
		} catch (NumberFormatException e) {
			// if file contents are string invalid execption is given
			System.out.println("File contents invalid");
		}

		return matrix;
	}

	private static void performSourceNodeOperations(int source,
			List<Object[]> resultList) {
		Object[] resultObj = resultList.get(source - 1);
		// read path from object
		int[] distance = (int[]) resultObj[0];
		String[] path = (String[]) resultObj[1];
		System.out.println("Source: " + source);
		for (int i = 1; i <= path.length; i++) {

			if (distance[i - 1] == -1) {
				distance[i - 1] = 0;
			}

			System.out.println(source + "-->" + i + ":   Cost is   "
					+ distance[i - 1] + ",   Path is   "
					+ path[i - 1].replaceAll(",", "-->"));
		}
	}

	// dijistras algorithm used
	private static Object[] findShortestPathForGivenSource(int[][] arr,
			int size, int source, int maxVal, List<Integer> removedNodes) {

		boolean[] visited = new boolean[size];

		int[] distance = new int[size];
		String[] path = new String[size];
		int min;
		int nextNode = 0;
		String prevPath;
		source--;

		for (int i = 0; i < size; i++) {
			visited[i] = false; // vsited nodes are set to false
			distance[i] = arr[source][i]; // distance array is source row of
											// array
		}
		distance[source] = 0;

		for (int i = 0; i < size; i++) {
			// set inital values for path
			path[i] = String.valueOf(source + 1) + "," + String.valueOf(i + 1);
			if (distance[i] == maxVal) {
				path[i] = String.valueOf(source + 1);
			}
		}
		path[source] = "-";
		// visitid of source is set to false and it is not visited
		visited[source] = true;

		for (int i = 0; i < size; i++) {
			// visitid of removed nodes are set to false and are not visited
			if (removedNodes.contains(i + 1)) {
				path[i] = "-";
				visited[i] = true;
			}
		}

		for (int i = 0; i < size; i++) {
			min = maxVal;

			for (int j = 0; j < size; j++)
				// for all unvisited nodes find minimum distance with src
				// and the node is noted as nextNode
				if (min > distance[j] && visited[j] != true) {
					min = distance[j];
					nextNode = j;
				}

			visited[nextNode] = true; // This node is set to visited = true
			prevPath = path[nextNode]; // prevPath is the path of the nod with
										// min dist

			for (int k = 0; k < size; k++) {
				if (visited[k] != true) {
					// for each unvisited node k
					// if minimum dist + cost(nextNode,k) < current distance of
					// k with source
					if (min + arr[nextNode][k] < distance[k]) {
						// distance is minvalue
						// path is minvalue node path,node k
						distance[k] = min + arr[nextNode][k];
						path[k] = prevPath + "," + String.valueOf(k + 1);
					}
				}
			}
		}
		for (int i = 0; i < path.length; i++) {
			if (distance[i] == 999) {
				path[i] = "-";
				distance[i] = -1;
			}
		}
		Object[] obj = new Object[2];
		obj[0] = distance;
		obj[1] = path;
		// return distance and path array as object
		return obj;
	}

	private static List<Object[]> extractShortestPath(
			List<List<Integer>> matrix, List<Integer> removedNodes) {
		List<Object[]> resultList = new ArrayList<Object[]>();
		int size = matrix.size();
		int[][] arr = new int[size][size];
		int maxVal = 999;

		// converting list matrix to two Dimension array
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = matrix.get(i).get(j);
				// When no connection, assigning high value to ignore
				if (arr[i][j] <= -1)
					arr[i][j] = maxVal;
			}
		}
		for (int i = 0; i < matrix.size(); i++) {
			Object[] resultObj = findShortestPathForGivenSource(arr, size,
					i + 1, maxVal, removedNodes);
			resultList.add(resultObj);
		}
		return resultList;
	}

}
