
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

    // DFS traversal of the vertices reachable from v
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adjList[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // DFS traversal starting from a given vertex v
    void DFS(int v) {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
}

// Driver class
public class q1_i {
    public static void main(String args[]) {
        Graph graph = new Graph(4);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2): ");
        graph.DFS(2);
    }
}




/*
OUTPUT -


Depth First Traversal (starting from vertex 2): 
2 0 1 3 


*/

