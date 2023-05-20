
/*

1. Write programs to traverse a given graph using
i) Depth First Search (DFS)
ii) Breadth First Search (BFS) 

*/


import java.util.*;

// Class representing a directed graph using adjacency list representation
class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS traversal starting from a given vertex v
    void BFS(int v) {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[v] = true;
        queue.add(v);

        while (queue.size() != 0) {
            // Dequeue a vertex from the queue and print it
            v = queue.poll();
            System.out.print(v + " ");

            // Get all adjacent vertices of the dequeued vertex v
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            Iterator<Integer> it = adjList[v].iterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

// Driver class
public class q1_ii {
    public static void main(String args[]) {
        Graph graph = new Graph(4);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Breadth First Traversal (starting from vertex 2): ");
        graph.BFS(2);
    }
}




/*
OUTPUT -


Breadth First Traversal (starting from vertex 2): 
2 0 3 1 


*/

