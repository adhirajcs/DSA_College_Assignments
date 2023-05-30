

/*

2. Write programs for finding minimum spanning tree of a given graph using
i) Kruskal’s algorithm
ii) Prim’s algorithm

*/


import java.util.*;

// Class representing a graph using adjacency list representation
class Graph {
    private int V; // Number of vertices
    private LinkedList<Edge>[] adjList; // Adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList<>();
    }

    // Class representing an edge in the graph
    class Edge {
        int dest, weight;

        // Constructor
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Function to add an edge to the graph
    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        adjList[src].add(edge);

        // Undirected graph, so add an edge from dest to src as well
        edge = new Edge(src, weight);
        adjList[dest].add(edge);
    }

    // Function to find the vertex with the minimum key value
    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to print the minimum spanning tree using Prim's algorithm
    void primMST() {
        int parent[] = new int[V]; // Array to store the constructed MST
        int key[] = new int[V]; // Key values used to pick the minimum weight edge
        boolean mstSet[] = new boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Start from the first vertex
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST set
            mstSet[u] = true;

            // Update key values and parent index of the adjacent vertices
            for (Edge edge : adjList[u]) {
                int v = edge.dest;
                int weight = edge.weight;

                if (!mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
            }
        }

        // Print the minimum spanning tree
        System.out.println("Minimum Spanning Tree (Prim's algorithm):");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " : " + key[i]);
        }
    }
}

// Driver class
public class q2_ii {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        Graph graph = new Graph(V);

        // Adding edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.primMST();
    }
}



/*
OUTPUT -


Minimum Spanning Tree (Prim's algorithm):
0 - 1 : 10
3 - 2 : 4
0 - 3 : 5



*/

