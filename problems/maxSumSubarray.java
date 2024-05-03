//tags: fixed slidingwindow maxsum A1
// Java code for
// O(n) solution for finding
// maximum sum of a subarray
// of size k
/*

input format : number of elements n
                          n number of integers
			              size of the ranges  k(i.e size of subarray)
output format : integer sum

Example 1:
input = 9
1 2 3 4 5 6 7 8 9
2
output=17

Example 2:
input=9
9 1 2 8 7 4 5 6 3
2
output=15

*/

import java.util.*;

class maxSumSubarray {

    // Returns maximum sum in
    // a subarray of size k.
    static int maxSum(int arr[], int n, int k) {
        // n must be greater
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();
        System.out.println(maxSum(arr, n, k));
        sc.close();
    }
}
/*
 * Test cases
 * ==========
 * case=1
 * input=4
 * 2 3 4 5
 * 2
 * output=9
 * 
 * case=2
 * input=9
 * 1 4 2 10 2 3 1 0 20
 * 4
 * output=24
 * 
 * case=3
 * input=7
 * 6 4 3 8 2 1 9
 * 2
 * output=11
 */