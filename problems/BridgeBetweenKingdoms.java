//tags: graph
// Pandavas and Kauravas rule two different kingdoms separated by a river. The land occupied by the kingdoms is represented by 1s, and the river is represented by 0s in a 2D grid.

// The kings have decided to build a bridge across the river to connect their kingdoms for easier travel. To minimize the cost, they want to build the bridge using the minimum number of river cells. The bridge can be built on river cells that are connected by 4 directions (up, down, left, right).

// Your task is to help the kings by finding the shortest path across the river and returning the count of river cells used to build the bridge.
// Note : in the given input There are exactly two islands in grid

// Input Format:
// -------------
// Line-1: An integer N, size of the land.
// Next N lines: N space separated integers, either 0 or 1. 

// Output Format:
// --------------
// Print an integer result.

// Example 1:

// Input:2
// 0 1
// 1 0
// Output: 1
// Explanation: by flipping one '0' at either position (0,0) or (1,1) bridge will				be  built, hence the output is 1.

// Example 2:
// Input= 3
// 0 1 0
// 0 0 0
// 0 0 1
// Output: 2
// explanation : by flipping two '0s' either at positions [(0,2),(1,2)] or							[(1,1),(2,1)] bridge will complete, hence the output is 2.
// Example 3:
// Input= 5
// 1 1 1 1 1
// 1 0 0 0 1
// 1 0 1 0 1
// 1 0 0 0 1
// 1 1 1 1 1
// Output: 1
// Explanation: by flipping one '0' either at position (1,2) or (2,1) or (2,3) or				(3,2) bridge will be built, hence output is 1. 

// Sample Input-1:
// ---------------
// 4
// 1 1 1 0
// 1 0 0 0
// 1 0 0 1
// 0 0 1 1

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 5
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 0 0 1
// 0 0 0 1 1
// 0 0 1 1 1

// Sample Output-2:
// ----------------
// 3

// Constraints:

// n == grid.length == grid[i].length
// 2 <= n <= 100
// grid[i][j] is either 0 or 1.
// There are exactly two islands in grid.
import java.util.*;

class BridgeBetweenKingdoms {
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        // 1. dfs to find an island, mark it in `visited`
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, visited, q, i, j, dirs);
                    found = true;
                    break;
                }
            }
        }
        // 2. bfs to expand this island
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (A[i][j] == 1) {
                            return step;
                        }
                        q.offer(new int[] { i, j });
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int i, int j, int[][] dirs) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[] { i, j });
        for (int[] dir : dirs) {
            dfs(A, visited, q, i + dir[0], j + dir[1], dirs);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ar[i][j] = sc.nextInt();
        System.out.println(new BridgeBetweenKingdoms().shortestBridge(ar));

    }
}