/*
Pseudo-code:
MST_Prim(graph G, start vertex v):
  create a priority queue Q
  for each vertex v in G:
    distance[v] = infinity
    parent[v] = null
    add v to Q
  distance[start] = 0

  while Q is not empty:
    remove vertex u with smallest distance from Q
    for each neighbor v of u:
      if v is in Q and weight(u, v) < distance[v]:
        parent[v] = u
        distance[v] = weight(u, v)

*/

//Code:

package Graphs;

import java.util.*;
import java.lang.*;

class Graph {
    private int numVertices;
    private int adjMatrix[][];

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
        adjMatrix[j][i] = weight;
    }

    public void primMST() {
        boolean visited[] = new boolean[numVertices];
        int edgeCount = 0, min = Integer.MAX_VALUE;
        visited[0] = true;

        while (edgeCount < numVertices - 1) {
            min = Integer.MAX_VALUE;
            int x = 0, y = 0;

            for (int i = 0; i < numVertices; i++) {
                if (visited[i]) {
                    for (int j = 0; j < numVertices; j++) {
                        if (!visited[j] && adjMatrix[i][j] != 0) {
                            if (min > adjMatrix[i][j]) {
                                min = adjMatrix[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println("Edge: " + x + "-" + y + " Weight: " + min);
            visited[y] = true;
            edgeCount++;
        }
    }
}

public class PrimMST {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.primMST();

    }
}
