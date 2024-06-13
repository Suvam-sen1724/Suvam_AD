/*
Pseudo-code:
BFS(graph G, start vertex s):
  create a queue Q
  enqueue s onto Q
  mark s
  while Q is not empty:
    dequeue a vertex v from Q
    for all edges from v to w in G.adjacentEdges(v) do
      if w is not marked:
        mark w
        enqueue w onto Q
 */

//code:
package Graphs;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);


    }
}

class Graph {
    @SuppressWarnings("unused")
    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    void BFS(int vertex) {
        Queue<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            System.out.print(v + " ");

            Iterator<Integer> i = adjLists[v].listIterator();
            while (i.hasNext()) {
                int adjVertex = i.next();
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }
}
