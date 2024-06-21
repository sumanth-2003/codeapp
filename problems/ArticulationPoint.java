//tags: graphs
// A vertex is said to be an articulation point in a graph if removal of the vertex and associated edges disconnects the graph. So, the removal of articulation points increases the number of connected components in a graph.

// The main aim here is to find out all the articulations points in a graph.

// Example 1:
// input=5
// 5
// 1 0
// 0 2
// 2 1
// 0 3
// 3 4
// output=[0, 3]

// Example 2:
// input=4
// 3
// 0 1
// 1 2
// 2 3
// output=[1, 2]
// Example 3:
// input=7
// 8
// 0 1 
// 1 2
// 2 0 
// 1 3
// 1 4
// 1 6
// 3 5
// 4 5

// output=[1]
// Example 4
// input=5
// 4
// 0 1
// 1 2
// 2 3
// 3 4
// output= [1, 2, 3]

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

    public void findAP() {
        boolean[] visited = new boolean[nodes];
        int[] disc = new int[nodes];
        int[] low = new int[nodes];
        int[] parent = new int[nodes];
        boolean[] AP = new boolean[nodes];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                APHelper(i, visited, disc, low, parent, AP);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            if (AP[i]) {
                res.add(i);
            }
        }
        int result[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        System.out.println(Arrays.toString(result));
    }

    public void APHelper(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] AP) {
        visited[u] = true;
        disc[u] = low[u] = time++;
        int children = 0;
        for (int neig : adj.get(u)) {
            if (!visited[neig]) {
                parent[neig] = u;
                children++;
                APHelper(neig, visited, disc, low, parent, AP);

                low[u] = Math.min(low[u], low[neig]);
                if (parent[u] == -1 && children > 1)
                    AP[u] = true;
                if (parent[u] != -1 && low[neig] >= disc[u]) {
                    // System.out.println(u+" "+neig);
                    AP[u] = true;
                }
            } else if (neig != parent[u]) {
                low[u] = Math.min(low[u], disc[neig]);
            }
        }
    }

}

public class ArticulationPoint {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        Graph graph = new Graph(nodes);
        for (int i = 0; i < edges; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        graph.findAP();
    }
}