

/*

2. Write programs for finding minimum spanning tree of a given graph using
i) Kruskal’s algorithm
ii) Prim’s algorithm

*/


import java.util.*;

// Class representing an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Constructor
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Comparator to compare edges based on their weights
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

// Class representing a graph using adjacency list representation
class Graph {
    private int V; // Number of vertices
    private ArrayList<Edge> edges; // List of edges

    // Constructor
    Graph(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    // Function to add an edge to the graph
    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    // Function to find the parent of a vertex
    int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    // Function to perform union of two subsets
    void union(int parent[], int rank[], int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[xRoot] > rank[yRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    // Function to find the minimum spanning tree using Kruskal's algorithm
    void kruskalMST() {
        ArrayList<Edge> result = new ArrayList<>(); // Stores the minimum spanning tree

        // Sort the edges in non-decreasing order of their weights
        Collections.sort(edges);

        int parent[] = new int[V];
        int rank[] = new int[V];

        // Create V subsets with single elements
        for (int i = 0; i < V; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        int i = 0; // Index variable for edges
        int edgeCount = 0; // Count of edges added to the result

        while (edgeCount < V - 1) {
            Edge nextEdge = edges.get(i++);

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // If including this edge does not form a cycle, add it to the result
            if (x != y) {
                result.add(nextEdge);
                union(parent, rank, x, y);
                edgeCount++;
            }
        }

        // Print the minimum spanning tree
        System.out.println("Minimum Spanning Tree (Kruskal's algorithm):");
        for (Edge edge : result) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}

// Driver class
public class q2_i {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        Graph graph = new Graph(V);

        // Adding edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        graph.kruskalMST();
    }
}



/*
OUTPUT -


Minimum Spanning Tree (Kruskal's algorithm):
2 - 3 : 4
0 - 3 : 5
0 - 1 : 10



*/

