
//tags: dp arrays A1
/*
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

 

Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 
Example 2:

Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.
Example 3:

Input: rating = [1,2,3,4]
Output: 4
 

Constraints:

n == rating.length
3 <= n <= 1000
1 <= rating[i] <= 105
All the integers in rating are unique.
*/
import java.util.*;

class teamsWithPattern {
    public static int numTeams(int[] rating) {
        int n = rating.length;
        int ascDP[] = new int[n]; // ascDP[i] denotes number of js such that j < i && rating[j] < rating[i]
        int descDP[] = new int[n]; // descDP[i] denotes number of js such that j < i && rating[j] > rating[i]
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    ascDP[i]++;
                    ans += ascDP[j];
                } else if (rating[j] > rating[i]) {
                    descDP[i]++;
                    ans += descDP[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println(numTeams(ar));
        sc.close();
    }
}
/*
 * test cases
 * case =1
 * input=
 * 5
 * 10 20 30 40 50
 * output=10
 * case =2
 * input=5
 * 20 50 30 40 10
 * output=3
 * case =3
 * input=9
 * 1 2 3 4 5 6 7 8 9
 * output=84
 * case =4
 * input=5
 * 2 5 3 4 1
 * output=3
 * case =5
 * input= 3
 * 2 1 3
 * output=0
 * case =6
 * input=3
 * 1 2 3
 * output=1
 */
