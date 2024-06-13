/*
Pseudo-code:
DFS(graph G, start vertex v):
  create a stack S
  push v onto S
  while S is not empty:
    pop a vertex v from S
    if v is not marked:
      mark v
      for all edges from v to w in G.adjacentEdges(v) do
        push w onto S

*/

//Code:

package Graphs;
import java.util.*;

class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    void DFS(int vertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");

                Iterator<Integer> i = adjLists[v].listIterator();
                while (i.hasNext()) {
                    int adjVertex = i.next();
                    if (!visited[adjVertex]) {
                        stack.push(adjVertex);
                    }
                }
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS(2);

    }
}
