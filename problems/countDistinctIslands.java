// tags: DSU
// Ibrahim is an interior designer wants to color wall of size M*N.
// He plans to color the wall and put lights of two different colors

// The designer can lit the wall using M*N lights.The lights are Blue or pink
// in color.Blue colored lights represented with digit-1 and pink colored lights
// represented with digit-0.

// The Blue colored lights forms different shapes, that are connected 4
// directonally.
// The directons are upwards, downwards, left, and right. Ibrahim got an idea to
// count the unique shapes formed by blue colored lights.

// You will be given the decorated wall as a matrix wall[][].
// Your task is to help Ibrahim to count the unique shapes by the lights.

// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the wall.
// Next M lines: N space separated integers, either 0 or 1.

// Output Format:
// --------------
// Print an integer, Number of distinct shapes formed by Blue Lights.

// Sample Input-1:
// ---------------
// 4 5
// 1 1 0 1 1
// 1 1 0 0 1
// 0 0 0 0 0
// 1 1 0 0 0

// Sample Output-1:
// ----------------
// 3

// Sample Input-2:
// ---------------
// 5 5
// 1 1 0 1 1
// 1 0 0 0 1
// 0 0 0 0 0
// 1 0 0 0 1
// 1 1 0 1 1

// Sample Output-2:
// ----------------
// 4

// Note:
// -------
// The shapes,
// 1 1 1 1
// 1 and 1
import java.util.*;

public class countDistinctIslands {
    private static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 }; // Used for 4-connected grid movement

    // Disjoint Set Union class
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DSU dsu = new DSU(m * n);

        // Connect all 1's in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    // Explore 4 directions
                    for (int d = 0; d < 4; d++) {
                        int ni = i + DIRECTIONS[d];
                        int nj = j + DIRECTIONS[d + 1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int neighborIndex = ni * n + nj;
                            dsu.union(index, neighborIndex);
                        }
                    }
                }
            }
        }

        // Mapping each root to its component's cell positions relative to the
        // top-leftmost cell
        Map<Integer, List<int[]>> components = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = dsu.find(i * n + j);
                    components.putIfAbsent(root, new ArrayList<>());
                    components.get(root).add(new int[] { i, j });
                }
            }
        }

        // Normalize and store shapes
        Set<String> uniqueShapes = new HashSet<>();
        for (List<int[]> component : components.values()) {
            String shape = normalizeShape(component);
            uniqueShapes.add(shape);
        }

        return uniqueShapes.size();
    }

    private static String normalizeShape(List<int[]> cells) {
        if (cells.isEmpty())
            return "";

        // Normalize coordinates based on the top-leftmost cell
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] cell : cells) {
            if (cell[0] < minX)
                minX = cell[0];
            if (cell[1] < minY)
                minY = cell[1];
        }
        List<String> normalized = new ArrayList<>();
        for (int[] cell : cells) {
            normalized.add((cell[0] - minX) + ":" + (cell[1] - minY));
        }
        Collections.sort(normalized); // Sort to ensure unique shape irrespective of traversal order
        return String.join(";", normalized);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int count = countDistinctIslands(grid);
        System.out.println(count);
    }
}
