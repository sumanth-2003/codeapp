//tags: dsu a1
// Mr.Ram is playing a map game, which will have n locations and routes from one
// location to another,routes is a 2D integer array of length n -1, where
// routes[i]=[ai,bi] indicates that there is an undirected edge between
// locations ai and bi in the map. And one more array is given which consists of
// restricted locations. Ram has to visit maximum number of locations from
// location 0 without visiting a restricted location. Can you write a Program to
// solve this problem.

// Note that node 0 will not be a restricted node.

// input format : an integer n
// n-1 number of integer pairs
// an integer m
// m number of integers

// Example 1:
// Input=7
// 0 1
// 1 2
// 3 1
// 4 0
// 0 5
// 5 6
// 2
// 4 5
// Output: 4
// Explanation: .
// We have that [0,1,2,3] are the only locations that can be reached from
// location 0 without visiting a restricted location.
// Example 2:

// Input= 7
// 0 1
// 0 2
// 0 5
// 0 4
// 3 2
// 6 5
// 3
// 4 2 1
// Output: 3
// Explanation:
// We have that [0,5,6] are the only locations that can be reached from location
// 0 without visiting a restricted location.

// Constraints:

// 2 <= n <= 105
// edges.length == n - 1
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// edges represents a valid tree.
// 1 <= restricted.length < n
// 1 <= restricted[i] < n
// All the values of restricted are unique.

import java.util.*;

public class Reachable {
    static class DSU {
        private int[] parent;
        private int[] rank;
        private int[] size;
        private boolean[] isRestricted;

        public DSU(int n, Set<Integer> restricted) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            isRestricted = new boolean[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
                isRestricted[i] = restricted.contains(i);
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            if (isRestricted[x] || isRestricted[y])
                return;
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                    rank[rootX]++;
                }
            }
        }

        public int getSize(int x) {
            return size[find(x)];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            edges.add(new int[] { a, b });
        }

        int m = scanner.nextInt();
        Set<Integer> restricted = new HashSet<>();
        for (int i = 0; i < m; i++) {
            restricted.add(scanner.nextInt());
        }

        DSU dsu = new DSU(n, restricted);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        int maxReachableLocations = dsu.getSize(0);
        System.out.println(maxReachableLocations);
        scanner.close();
    }
}
