
//tags: fixed slidingwindow hashmap A1
/*
There are N number of small cartoons and each cartoon will have a balloon of 
some color identified by a number. You are asked to select fixed number of 
P-cartoons as a subset every time and find the number of unique colored 
balloons in the number of cartoons "P" you pick everytime.

The resultant cartoons ans will be N-P+1 and return it.

The number of distinct number of balloons is:
    nums[i:i+p-1] = [nums[i], nums[i+1], ..., nums[i+p-1]].


Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, nums[]

Output Format:
--------------
Print the (N-P+1) integers as output.


Sample Input-1:
---------------
7 4
1 2 2 3 3 4 4

Sample Output-1:
----------------
3 2 3 2

Explanation: 
------------
The number of distinct elements in each subarray of size P goes as follows:
- nums[0:3] = [1,2,2,3] so ans[0] = 3
- nums[1:4] = [2,2,3,3] so ans[1] = 2
- nums[2:5] = [2,3,3,4] so ans[2] = 3
- nums[3:6] = [3,3,4,4] so ans[3] = 2


Sample Input-2:
---------------
6 3
1 1 1 1 1 1

Sample Output-2:
----------------
1 1 1 1

Explanation:
------------
The number of distinct elements in each subarray goes as follows:
- nums[0:2] = [1,1,1] so ans[0] = 1
- nums[1:3] = [1,1,1] so ans[1] = 1
- nums[2:4] = [1,1,1] so ans[2] = 1
- nums[3:5] = [1,1,1] so ans[3] = 1


Sample Input-3:
---------------
7 3
1 2 3 4 2 1 3

Sample Output-3:
----------------
3 3 3 3 3


*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DistinctCountSubarray {
    // Function to find the count of distinct elements in every subarray
    // of size `k` in the array
    public static void findDistinctCount(int[] A, int k) {
        // System.out.println("k " + k);
        // map to store the frequency of elements in the current window of size `k`
        Map<Integer, Integer> freq = new HashMap<>();

        // maintains the count of distinct elements in every subarray of size `k`
        int distinct = 0;

        // loop through the array
        for (int i = 0; i < A.length; i++) {
            // ignore the first `k` elements
            if (i >= k) {
                // remove the first element from the subarray by reducing its
                // frequency in the map
                freq.put(A[i - k], freq.getOrDefault(A[i - k], 0) - 1);

                // reduce the distinct count if we are left with 0
                if (freq.get(A[i - k]) == 0) {
                    distinct--;
                }
            }

            // add the current element to the subarray by incrementing its
            // count in the map
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);

            // increment distinct count by 1 if element occurs for the first
            // time in the current window
            if (freq.get(A[i]) == 1) {
                distinct++;
            }

            // print count of distinct elements in the current subarray
            if (i >= k - 1) {
                System.out.println(distinct);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        findDistinctCount(array, k);
        sc.close();
    }
}
/*
 * 
 * === testcases ===
 * case =1
 * input =7 3
 * 2 3 4 3 3 2 4
 * output =3 2 2 2 3
 * 
 * case =2
 * input =15 4
 * 4 1 5 3 2 3 4 2 3 1 3 3 2 4 3
 * output =4 4 3 3 3 3 4 3 2 3 3 3
 * 
 * case =3
 * input =15 4
 * 4 1 2 5 1 3 4 4 4 4 5 5 5 5 4
 * output =4 3 4 4 3 2 1 2 2 2 1 2
 * 
 * case =4
 * input =25 5
 * 1 3 5 1 2 3 3 3 2 5 3 1 5 1 5 5 1 4 2 4 1 5 5 4 2
 * output =4 4 4 3 2 3 3 4 4 3 3 2 2 3 4 4 3 4 4 3 4
 * 
 * case =5
 * input =25 5
 * 1 2 3 4 5 4 3 2 1 2 3 4 3 2 1 2 1 2 3 4 5 4 3 2 1
 * output =5 4 3 4 5 4 3 4 4 3 4 4 3 2 3 4 5 4 3 4 5
 * 
 * case =6
 * input =50 4
 * 3 3 2 2 2 1 1 2 2 3 2 1 2 1 2 1 2 1 1 1 3 1 1 1 1 1 3 1 3 2 3 1 2 2 1 3 1 1 2
 * 3 3 2 1 2 1 1 1 2 1 3
 * output =2 2 2 2 2 2 3 2 3 3 2 2 2 2 2 2 2 2 2 2 2 1 1 2 2 2 3 3 3 3 3 2 3 3 2
 * 3 3 3 2 3 3 2 2 2 2 2 3
 * 
 * case =7
 * input =500 10
 * 1 4 6 3 8 2 7 7 8 4 8 3 2 8 9 6 1 4 8 9 8 2 6 4 8 7 8 7 1 6 3 4 8 5 3 5 8 5 6
 * 5 2 7 4 6 3 4 4 7 4 1 9 7 1 9 9 4 4 8 7 7 5 8 2 6 5 6 6 9 5 5 4 3 2 9 8 1 2 8
 * 3 5 2 9 8 6 2 9 4 8 6 9 7 9 9 9 5 5 9 1 9 1 6 4 9 7 3 5 6 3 6 9 4 1 9 3 1 4 1
 * 5 5 8 1 9 1 5 8 5 4 7 8 6 2 5 2 4 4 4 3 1 1 4 8 2 2 1 2 3 9 8 2 1 8 9 4 2 1 1
 * 7 5 7 5 7 8 9 4 3 9 8 3 8 7 5 5 4 1 3 9 9 1 3 9 2 3 5 1 7 3 8 2 7 6 6 9 6 1 5
 * 5 6 7 8 2 9 1 1 9 9 9 8 1 7 8 9 2 6 5 5 6 6 4 1 3 6 8 7 7 1 7 5 3 6 5 3 3 1 6
 * 7 1 2 7 6 2 7 7 8 6 7 8 3 8 2 8 2 3 7 2 4 1 4 7 9 8 9 2 3 2 9 9 1 8 2 2 7 2 1
 * 2 9 4 2 2 9 1 2 9 2 5 9 6 8 3 8 3 7 6 7 6 7 9 2 2 2 5 1 8 9 8 1 8 7 3 4 5 3 6
 * 9 7 3 2 4 5 3 4 4 4 4 9 9 2 1 3 4 8 6 4 8 2 7 8 3 2 1 6 7 8 3 5 9 7 3 3 5 6 6
 * 7 3 5 2 4 3 2 3 2 8 1 5 4 7 9 2 5 1 9 8 2 3 1 4 7 4 4 9 7 6 5 1 9 1 9 8 6 8 8
 * 2 2 1 8 9 5 3 2 4 2 7 6 3 2 9 9 5 9 5 2 8 1 3 5 9 3 1 5 8 5 9 1 3 1 3 7 4 7 7
 * 9 5 2 7 6 8 4 2 3 1 1 9 5 6 6 4 5 2 1 5 4 9 4 8 7 6 3 9 7 9 6 3 3 9 5 1 2 4 9
 * 1 3 9 3 2 2 6 6 6 4 7 4 3 5 5 6 2 3 3 4 2 9 9 1 5 8 6 8 1 3 6 9
 * output =7 6 6 5 5 6 7 8 7 7 7 7 6 6 6 6 7 6 6 7 6 7 6 6 7 7 7 7 6 5 5 6 6 7 7
 * 7 7 6 6 6 6 6 6 6 5 4 4 4 5 5 5 6 6 6 7 6 6 5 6 6 5 6 6 6 6 7 8 7 7 7 7 6 6 6
 * 7 7 6 7 7 6 5 6 6 6 6 6 6 5 5 4 4 4 5 5 6 7 7 7 7 7 6 6 7 7 6 6 5 5 6 5 6 6 6
 * 6 5 5 4 5 6 6 7 8 7 6 6 6 6 7 7 6 5 6 5 5 5 5 5 6 6 6 5 5 5 6 6 6 5 6 7 7 7 6
 * 6 6 6 7 6 6 6 6 5 6 6 6 7 7 7 7 7 6 5 6 5 5 5 6 6 7 7 7 7 7 8 7 7 8 7 6 5 6 7
 * 7 7 7 7 7 6 5 4 5 4 4 5 6 7 7 7 7 7 7 7 6 6 7 7 6 6 7 6 6 6 6 5 5 5 5 5 6 6 6
 * 5 5 4 5 5 5 4 5 5 5 5 5 5 5 4 5 6 6 6 7 7 7 6 7 7 7 6 6 5 5 5 6 6 5 5 5 6 6 5
 * 5 5 4 4 4 5 5 5 6 7 7 6 7 7 6 5 4 5 6 6 5 5 6 7 7 6 5 5 6 7 7 7 7 8 8 8 7 7 7
 * 7 7 7 7 6 5 5 5 5 6 5 5 6 7 7 7 7 7 7 6 6 7 7 7 6 6 7 8 8 8 7 6 6 6 5 5 5 5 6
 * 6 6 6 6 6 6 6 6 7 8 8 8 7 7 7 7 8 7 7 8 8 7 7 7 7 7 6 6 6 6 7 6 6 5 6 5 5 5 5
 * 6 7 6 7 7 8 9 8 7 7 6 7 7 6 6 6 6 6 6 6 6 6 6 6 5 5 5 5 5 5 6 7 7 6 5 6 7 7 7
 * 7 7 7 8 9 8 8 9 8 8 7 7 7 6 6 6 6 6 7 7 8 9 8 7 6 6 6 5 4 5 6 7 8 7 7 6 6 6 6
 * 5 6 6 5 6 6 6 5 6 6 5 6 6 6 6 5 6 6 7 7 7 8 8 7 7 6 6
 * 
 * case =8
 * input =500 10
 * 3 10 10 5 6 4 4 1 1 7 10 9 10 2 2 4 10 9 3 5 10 5 6 1 9 6 8 3 2 5 1 10 1 8 3
 * 6 3 6 6 2 1 6 10 6 6 5 8 6 5 5 10 3 10 8 5 4 3 7 9 10 10 9 1 9 7 9 9 3 9 5 6
 * 4 7 6 2 5 2 5 7 2 4 10 2 8 1 5 8 7 9 3 7 5 1 5 5 5 6 6 1 3 1 5 6 1 5 10 4 6 4
 * 4 10 6 1 5 8 4 5 2 6 4 2 5 2 4 6 3 8 4 1 4 5 9 3 4 4 1 9 5 3 4 8 1 9 10 9 9 1
 * 1 6 2 6 2 10 10 5 3 3 4 3 10 8 8 3 2 10 2 1 4 6 3 8 3 10 2 3 7 7 1 5 8 9 3 4
 * 8 8 3 6 9 8 4 10 10 9 4 3 2 10 8 1 10 2 1 8 2 6 2 8 8 3 6 10 4 1 3 7 2 5 4 6
 * 9 7 7 6 1 1 6 3 6 1 5 8 1 9 5 8 9 5 10 8 1 8 2 4 4 10 2 4 2 4 6 7 2 2 2 2 3 4
 * 6 3 8 3 7 10 5 1 9 8 8 4 8 9 8 3 8 1 7 10 5 3 2 3 5 4 9 7 3 2 2 4 8 8 8 3 2 6
 * 7 5 3 9 10 5 3 10 8 5 10 6 2 5 5 4 4 10 10 4 8 7 5 9 4 2 7 7 10 2 5 3 10 4 4
 * 4 1 4 8 10 9 4 9 4 6 8 6 7 2 9 8 8 9 7 6 5 3 1 10 6 10 5 2 7 5 10 5 6 5 6 6 5
 * 5 5 3 4 10 4 8 4 6 4 10 1 6 6 2 6 3 7 9 2 9 3 5 4 1 6 2 2 6 10 10 9 6 8 5 6 7
 * 6 7 4 1 7 10 6 7 3 9 10 10 2 7 7 2 5 10 3 1 2 2 5 3 6 6 8 8 3 6 5 5 10 8 6 2
 * 9 5 10 5 5 1 1 3 7 1 5 4 2 9 3 8 1 5 9 5 7 1 2 4 9 4 3 3 9 6 2 3 8 10 2 1 5 4
 * 8 2 8 8 1 9 9 1 4 2 8 8 6 8 10 1 10 7 2 8 10 4
 * output =7 6 7 7 7 6 6 6 6 6 6 6 6 7 8 7 6 7 7 8 8 7 8 8 8 7 7 7 7 6 6 6 5 6 5
 * 5 6 6 6 6 5 4 5 5 5 5 6 6 6 7 7 7 7 8 7 6 5 4 5 5 6 6 7 6 6 7 7 7 6 5 5 5 6 6
 * 6 7 7 7 7 8 9 8 7 6 6 6 6 6 6 5 5 4 4 4 4 4 5 6 6 6 5 5 5 5 5 6 6 6 7 7 7 6 6
 * 5 5 4 5 6 6 7 7 7 8 7 7 6 6 5 5 5 5 6 6 6 7 7 7 7 6 6 6 5 5 5 5 6 6 6 6 6 6 6
 * 5 5 6 5 5 6 6 7 7 7 7 7 7 7 8 7 7 7 7 8 8 8 7 7 7 7 6 5 5 6 6 6 6 6 7 6 6 7 7
 * 7 7 6 5 5 5 5 5 6 5 6 6 7 7 8 8 9 8 8 9 8 8 7 7 7 6 6 5 5 5 6 5 6 6 6 6 5 5 5
 * 5 5 6 7 7 7 6 5 5 5 5 5 5 5 5 4 5 5 5 5 6 5 6 7 8 8 9 8 7 8 8 7 6 6 5 5 6 7 8
 * 7 8 7 7 8 8 7 7 6 6 6 7 7 6 6 5 5 6 7 7 7 8 8 7 7 7 6 5 6 7 6 6 7 6 6 5 5 6 6
 * 5 6 6 7 7 7 7 7 6 7 7 6 6 6 7 6 7 6 6 5 5 5 6 6 5 6 7 6 6 6 6 5 5 6 7 8 8 8 8
 * 7 7 7 7 7 6 5 5 5 5 5 4 3 4 4 5 5 6 6 6 6 6 6 5 5 6 6 6 7 8 7 6 5 6 7 8 8 8 7
 * 7 8 7 7 6 6 6 6 7 6 6 7 7 6 7 6 5 6 7 7 7 7 6 6 6 6 6 6 6 6 6 6 6 6 6 7 6 6 5
 * 5 4 5 5 5 6 7 7 6 6 6 7 7 7 7 6 5 6 6 7 7 8 8 8 7 7 8 7 7 8 7 6 7 7 7 7 6 5 6
 * 7 7 7 8 9 8 7 7 6 6 6 6 6 5 5 5 5 6 6 7 7 6 7 6 6 6 7
 */