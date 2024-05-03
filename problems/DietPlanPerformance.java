
//tags: slidingwindow fixed A1
/*A dieter consumes calories[i] calories on the i-th day. 
Given an integer k, for every consecutive sequence of k days (calories[i], 
calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T, 
the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):

•	If T < lower, they performed poorly on their diet and lose 1 point; 
•	If T > upper, they performed well on their diet and gain 1 point;
•	Otherwise, they performed normally and there is no change in points.

Initially, the dieter has zero points. 
Return the total number of points the dieter has after dieting for calories.length days.
Note that the total points can be negative.

input format :  an integer n
                            n number of integers
						    3 integers (k,lower,upper)
 
Example 1:
Input:
5
1 2 3 4 5
1 3 3
Output: 0
(claorie size calorie[5],calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3)

Explanation: Since k = 1, we consider each element of the array separately and compare it to lower and upper.
calories[0] and calories[1] are less than lower so 2 points are lost.
calories[3] and calories[4] are greater than upper so 2 points are gained.

Example 2:
Input:
2
3 2
2 0 1
Output: 1
(calorie[2],calories = [3,2], k = 2, lower = 0, upper = 1)


Explanation: Since k = 2, we consider subarrays of length 2.
calories[0] + calories[1] > upper so 1 point is gained.

Example 3:
Input: 
calorie[4],calories = [6,5,0,0], k = 2, lower = 1, upper = 5
Output: 0

Explanation:
calories[0] + calories[1] > upper so 1 point is gained.
lower <= calories[1] + calories[2] <= upper so no change in points.
calories[2] + calories[3] < lower so 1 point is lost.
 
Sample input=3
1 2 3
1 3 3
Sample output =-2

Constraints:
•	1 <= k <= calories.length <= 10^5
•	0 <= calories[i] <= 20000
•	0 <= lower <= upper

*/
import java.util.*;

class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += calories[i];
        if (sum > upper)
            points++;
        else if (sum < lower)
            points--;
        int length = calories.length;
        for (int i = k; i < length; i++) {
            sum += calories[i];
            sum -= calories[i - k];
            if (sum > upper)
                points++;
            else if (sum < lower)
                points--;
        }
        return points;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // System.out.println("enter calories size");
        int n = sc.nextInt();
        int calories[] = new int[n];

        // System.out.println("enter the calories");
        for (int i = 0; i < n; i++) {
            calories[i] = sc.nextInt();
        }
        // System.out.println("enter the days");
        int k = sc.nextInt();
        // System.out.println("enter the Lower value");
        int l = sc.nextInt();
        // System.out.println("enter the Upper value");
        int u = sc.nextInt();
        System.out.println(new DietPlanPerformance().dietPlanPerformance(calories, k, l, u));
        sc.close();
    }
}

/*
 * Test Cases
 * ===============
 * case=1
 * input=6
 * 6 5 4 3 2 1
 * 4 1 6
 * output=3
 * 
 * case=2
 * input=10
 * 9 18 27 36 45 54 63 72 81 90
 * 5 72 81
 * output=6
 * 
 * case=3
 * input=10
 * 1 2 3 4 5 6 7 8 9 10
 * 3 1 15
 * output=4
 * 
 * case=4
 * input=20
 * 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40
 * 4 11 18
 * output=17
 * 
 * case=5
 * input=12
 * 45 64 76 33 88 99 26 12 34 55 64 77
 * 2 -1 1
 * output=11
 * 
 * case=6
 * input=6
 * -1 1 0 -2 4 -3
 * 3 2 3
 * output=-3
 * 
 * case=7
 * input=3
 * 1 2 3
 * 1 3 1
 * output=1
 * 
 */
