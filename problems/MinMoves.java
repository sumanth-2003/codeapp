//tags: bfs elite
// Mr Suleman is given a checkerboard of size 400*400, where the indices starts
// from (-200,-200) and ends at (199,199). In one step, he can move the box from
// position (p,q) to one of the following positions in L shape like as follows:
// 	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
// 	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)

// Initially the box is at (0,0) position, and need to move the box to position (m,n).
// You will be given two integers m and n indicates the position(m,n).

// Now your task is to help by Mr Suleman to find the minimum number of steps
// required to move the box from (0,0) to (m,n).

// Note: It is allowed to move out of the board also.

// Input Format:
// -----------------
// Two space separated integers, m and n, position.

// Output Format:
// ------------------
// Print an integer, minimum number of steps to reach (m,n).

// Sample Input-1:
// ---------------
// 2 4

// Sample Output-1:
// ----------------
// 2

// Explanation:
// -------------
// Initially, you are at (0,0) position, you can reach (2,4) as follows:
// (0,0) -> (1, 2) -> (2, 4)

// Sample Input-2:
// ---------------
// 4 7

// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// Initially, you are at (0,0) position, you can reach (4,7) as follows:
// (0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)

// i dont know why while doing dfs backtracking iam not getting the answer need to look on it once

import java.util.*;

public class MinMoves {
    static int steps[][] = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
    static boolean visited[][] = new boolean[400][400];
    static int moves = Integer.MAX_VALUE;

    public static void dfs(int x, int y, int m, int n, int count) {
        if (x == m && y == n) {
            moves = Math.min(moves, count);
            return;
        }
        if (x >= 400 || y >= 400 || x < 0 || y < 0 || visited[x][y])
            return;
        visited[x][y] = true;
        for (int[] step : steps) {
            int newX = x + step[0];
            int newY = y + step[1];
            if (0 <= newX && newX < 400 && 0 <= newY && newY < 400 && !visited[newX][newY]) {
                dfs(newX, newY, m, n, count + 1);
            }

        }
        visited[x][y] = false;
    }

    public static int bfs(int x, int y, int m, int n) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { x, y });
        int count = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int temp[] = que.poll();
                int xCoord = temp[0];
                int yCoord = temp[1];
                if (xCoord == m && yCoord == n)
                    return count;
                visited[xCoord][yCoord] = true;
                for (int step[] : steps) {
                    int new_x = xCoord + step[0];
                    int new_y = yCoord + step[1];
                    if (0 <= new_x && new_x < 400 && 0 <= new_y && new_y < 400 && !visited[new_x][new_y]) {
                        que.add(new int[] { new_x, new_y });
                    }
                }
            }
            count++;
        }
        return -1; // Return -1 if the target position is not reachable
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt() + 200;
        int n = sc.nextInt() + 200;
        // dfs(200, 200, m, n, 0);
        // System.out.println(moves);
        System.out.print(bfs(200, 200, m, n));
    }
}
