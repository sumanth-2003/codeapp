//tags: graph
// Find the bridges in the given graph

// Sample Input-1:
// ---------------
// 4 
// 3
// 0 1
// 0 2
// 1 3

// Sample Output-1:
// ----------------
// 1 3
// 0 1
// 0 2

// Sample input-2
// 5 
// 5
// 1 0
// 1 2
// 0 2
// 3 0
// 3 4
// output =
// 3 4
// 0 3

import java.util.*;

class Graph {
    int nodes;
    List<List<Integer>> adj;
    int time;

    public Graph(int n) {
        nodes = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        time = 0;
    }

    public void addEdge(int u, int v) {
        adj.get(v).add(u);
        adj.get(u).add(v);
    }

    public void findBridges() {
        boolean[] visited = new boolean[nodes];
        int[] disc = new int[nodes];
        int[] low = new int[nodes];
        int[] parent = new int[nodes];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                bridgeHelper(i, visited, disc, low, parent);
            }
        }
    }

    public void bridgeHelper(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
        visited[u] = true;
        disc[u] = low[u] = time++;
        for (int neig : adj.get(u)) {
            if (!visited[neig]) {
                parent[neig] = u;
                bridgeHelper(neig, visited, disc, low, parent);

                low[u] = Math.min(low[u], low[neig]);
                if (low[neig] > disc[u]) {
                    System.out.println(u + " " + neig);
                }
            } else if (neig != parent[u]) {
                low[u] = Math.min(low[u], disc[neig]);
            }
        }
    }

}

public class BridgeInGraph {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        Graph graph = new Graph(nodes);
        for (int i = 0; i < edges; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        graph.findBridges();
    }
}