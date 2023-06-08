

/*

3. Write a program to implement Dijkstra’s algorithm for finding shortest distances from a given 
vertex to all other vertices of a given graph.

*/


import java.util.*;

public class q3 {

    private static List<Integer>[] adjList;
    private static int[] distances;

    public static void main(String[] args) {

        // Create a graph
        adjList = new ArrayList[5];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Add edges to the graph
        adjList[0].add(1);
        adjList[0].add(2);
        adjList[1].add(3);
        adjList[2].add(4);

        // Initialize distances array
        distances = new int[adjList.length];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Find shortest distances from vertex 0 to all other vertices
        dijkstra(0);

        // Print the shortest distances
        for (int i = 0; i < distances.length; i++) {
            System.out.println("The shortest distance from vertex 0 to vertex " + i + " is " + distances[i]);
        }
    }

    private static void dijkstra(int src) {

        // Create a priority queue of vertices
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> distances[v1] - distances[v2]);

        // Initialize distances array for the source vertex
        distances[src] = 0;

        // Add the source vertex to the priority queue
        pq.add(src);

        // Iterate over the priority queue
        while (!pq.isEmpty()) {

            // Remove the vertex with the minimum distance from the priority queue
            int u = pq.poll();

            // Update the distances of all the neighbors of the vertex
            for (int v : adjList[u]) {
                int newDistance = distances[u] + 1;
                if (newDistance < distances[v]) {
                    distances[v] = newDistance;
                    pq.add(v);
                }
            }
        }
    }
}


/*
OUTPUT -


The shortest distance from vertex 0 to vertex 0 is 0
The shortest distance from vertex 0 to vertex 1 is 1
The shortest distance from vertex 0 to vertex 2 is 1
The shortest distance from vertex 0 to vertex 3 is 2
The shortest distance from vertex 0 to vertex 4 is 2


*/

