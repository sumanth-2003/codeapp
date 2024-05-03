
//tags: string array A1 pattern
/*Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.

 

Example 1:


Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
Example 2:


Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
Example 3:


Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the balloons at indices 0 and 4. Each balloons takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 

Constraints:

n == colors.length == neededTime.length
1 <= n <= 105
1 <= neededTime[i] <= 104
colors contains only lowercase English letters.
*/
import java.util.*;

class minCost {
    public static int minCost1(String colors, int[] neededTime) {
        int time = 0;
        for (int i = 0; i < colors.length() - 1; i++) {
            char curr = colors.charAt(i);
            char next = colors.charAt(i + 1);
            if (curr == next) {
                time += Math.min(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String col = sc.nextLine();
        int[] time = new int[n];
        for (int i = 0; i < n; i++)
            time[i] = sc.nextInt();
        System.out.println(minCost1(col, time));
        sc.close();
    }
}
/*
 * test cases
 * case =1
 * input=6
 * abcaab
 * 1 2 3 1 2 3
 * output=1
 * case =2
 * input=8
 * abaacaab
 * 1 2 1 2 3 2 1 4
 * output=2
 * case =3
 * input=10
 * abcabcabca
 * 1 2 3 4 5 6 7 8 9 10
 * output=0
 * case =4
 * input=5
 * aaaaa
 * 1 2 3 4 5
 * output=10
 * case =6
 * input=5
 * abaac
 * 1 2 3 4 1
 * output=3
 */