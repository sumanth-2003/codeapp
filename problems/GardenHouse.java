//tags: graph
// Arjun has a piece of land of size R×C. 
// He plans to build homes on rectangular portions of this land. The remaining areas will be used for gardening.

// The land is represented as a 2D array plan[][], where:

// 1 indicates land used to construct homes.
// 0 indicates garden area.

// Each home is a set of contiguous cells with value 1 in a rectangular shape (a home may consist of a single cell).

// Arjun wants to identify all the homes and store their coordinates.
//  The coordinates of each home should be represented as [x1, y1, x2, y2], where:

// (x1,y1) is the starting coordinate (top-left corner) of the home.
// (x2,y2) is the ending coordinate (bottom-right corner) of the home.

// Your task is to help Arjun find all the homes and return their coordinates in the order from the top-left corner to the bottom-right corner.

// NOTE: No two homes are adjacent to each other in 4 directions,
// (left, right, top, bottom).

// Input Format:
// -------------
// Line-1: Two integers R and C, size of the land.
// Next R lines: C space separated integers, either 0 or 1
// 0- represents garden area land and 1- represents the home.

// Output Format:
// --------------
// Print 2d array, the co-ordinates of all homes.

// Sample Input-1:
// ---------------
// 2 3
// 1 0 0
// 0 1 1

// Sample Output-1:
// ----------------
// [[0, 0, 0, 0], [1, 1, 1, 2]]
// Explanation: First home constructed on cell coordinates [0,0,0,0] (single cell	             as there are no adjacent cells with 1)
// 			 Second home constucred on cell coordinates starting at (1,1) and ending at(1,2)

// Sample Input-2:
// ---------------
// 4 4
// 1 1 0 1
// 0 0 0 0
// 1 1 0 1
// 1 1 0 1

// Sample Output-2:
// ----------------
// [[0, 0, 0, 1], [0, 3, 0, 3], [2, 0, 3, 1], [2, 3, 3, 3]]
// Explanation : total 4 houses constructed.
//               house 1 coordinates starting at (0,0) and ending at(0,1)
// 			  house 2 coordinates starting at (0,3) and ending at (0,3)
// 			  house 3 coordinates starting at (2,0) and ending at (3,1)
// 			  house 4 coordinates starting at (2,3) and ending at (3,3).

import java.util.*;

public class GardenHouse {

    static class Home {
        int x1, y1, x2, y2;

        Home(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "[" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + "]";
        }
    }

    public static List<Home> findHomes(int[][] plan) {
        int rows = plan.length;
        int cols = plan[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<Home> homes = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (plan[i][j] == 1 && !visited[i][j]) {
                    Home home = new Home(i, j, i, j);
                    dfs(plan, visited, i, j, home);
                    homes.add(home);
                }
            }
        }

        return homes;
    }

    private static void dfs(int[][] plan, boolean[][] visited, int x, int y, Home home) {
        int rows = plan.length;
        int cols = plan[0].length;

        if (x < 0 || y < 0 || x >= rows || y >= cols || visited[x][y] || plan[x][y] == 0) {
            return;
        }

        visited[x][y] = true;

        home.x2 = Math.max(home.x2, x);
        home.y2 = Math.max(home.y2, y);

        dfs(plan, visited, x - 1, y, home); // up
        dfs(plan, visited, x, y + 1, home); // right
        dfs(plan, visited, x + 1, y, home); // down
        dfs(plan, visited, x, y - 1, home); // left
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] plan = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                plan[i][j] = sc.nextInt();
            }
        }

        List<Home> homes = findHomes(plan);
        System.out.println(homes);
    }
}
