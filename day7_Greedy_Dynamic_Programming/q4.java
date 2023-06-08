

/*

4. Write a program to implement Floyed Warshall algorithm for finding all pair shortest distances.

*/


import java.util.Arrays;

public class q4 {
    static final int INF = 99999; // Infinity value for unreachable nodes

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };
        
        int[][] shortestDistances = floydWarshall(graph);
        
        System.out.println("Shortest distances between all pairs of vertices:");
        for (int i = 0; i < shortestDistances.length; i++) {
            for (int j = 0; j < shortestDistances.length; j++) {
                if (shortestDistances[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(shortestDistances[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] dist = new int[vertices][vertices];

        // Initialize the dist matrix with the graph values
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    // If vertex k is on the shortest path from i to j,
                    // then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}


/*
OUTPUT -


Shortest distances between all pairs of vertices:
0 5 8 9 
INF 0 3 4
INF INF 0 1
INF INF INF 0


*/

