/*
Pseudo-code:
Dijkstra(Graph G, start vertex v):
  create a priority queue Q
  for each vertex v in G:
    distance[v] = infinity
    parent[v] = null
    add v to Q
  distance[start] = 0

  while Q is not empty:
    remove vertex u with smallest distance from Q
    for each neighbor v of u:
      alt = distance[u] + weight(u, v)
      if alt < distance[v]:
        distance[v] = alt
        parent[v] = u

*/

//Code:

package Graphs;

import java.util.*;

class Graph {
    private int numVertices;
    private int[][] adjMatrix;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
        adjMatrix[j][i] = weight;
    }

    public void dijkstra(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        for (int i = 0; i < numVertices; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newKey = adjMatrix[minVertex][j] + distance[minVertex];
                    if (newKey < distance[j]) {
                        distance[j] = newKey;
                    }
                }
            }
        }

        printDijkstra(distance, startVertex);
    }

    public int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public void printDijkstra(int[] distance, int startVertex) {
        System.out.println("Dijkstra Algorithm: (Start Vertex: " + startVertex + ")");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " min distance: " + distance[i]);
        }
    }
}

public class ShortestPath {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 9);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 4, 3);
        g.addEdge(2, 1, 2);
        g.addEdge(2, 3, 4);

        g.dijkstra(0);

    }
}
