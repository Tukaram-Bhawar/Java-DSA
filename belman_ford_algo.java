public class belman_ford_algo {
    public static void bellmanFord(int[][] edges, int V, int E, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        

        printArr(dist, V);
    }

    public static void printArr(int[] dist, int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
    
    public static void main(String[] args) {
    int V = 5; // Number of vertices in graph
    int E = 8; // Number of edges in graph

    int[][] edges = { 
        { 0, 1, -1 }, { 0, 2, 4 }, 
        { 1, 2, 3 }, { 1, 3, 2 }, 
        { 1, 4, 2 }, { 3, 2, 5 }, 
        { 3, 1, 1 }, { 4, 3, -3 } 
    };

    bellmanFord(edges, V, E, 0);
    }
}