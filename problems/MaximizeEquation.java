//tags: notdone
// Given an array A, maximize value of expression (A[s] - A[r] + A[q] - A[p]), 
// where p, q, r, and s are indices of the array and s > r > q > p.

// input format : an integer n
//                n number of integers
// output format : an integer

// Example:
// Input=6
// 3 9 10 1 30 40
// Output=46 
// Explanation: The expression (40 – 1 + 10 – 3) will result in the maximum value

// Example 2:
// input=8
// 1 2 3 4 5 6 7 8
// output=6

import java.util.Scanner;

public class MaximizeEquation {

    public static int maximizeExpression(int[] A) {
        int n = A.length;
        if (n < 4)
            return 0; // Not enough elements for the expression

        int[] maxA = new int[n];
        int[] maxAminusB = new int[n];
        int[] maxAminusBplusC = new int[n];
        int[] maxAminusBplusCminusD = new int[n];

        // Initialize the arrays
        maxA[0] = -A[0];
        for (int i = 1; i < n; i++) {
            maxA[i] = Math.max(maxA[i - 1], -A[i]);
        }

        // Calculate maxAminusB from the second element
        maxAminusB[1] = maxA[0] + A[1];
        for (int i = 2; i < n; i++) {
            maxAminusB[i] = Math.max(maxAminusB[i - 1], maxA[i - 1] + A[i]);
        }
        maxAminusBplusC[2] = maxAminusB[1] - A[2];
        // Calculate maxAminusBplusC from the third element
        for (int i = 3; i < n; i++) {
            maxAminusBplusC[i] = Math.max(maxAminusBplusC[i - 1], maxAminusB[i - 1] - A[i]);
        }
        maxAminusBplusCminusD[3] = maxAminusBplusC[2] + A[3];
        // Finally, calculate maxAminusBplusCminusD from the fourth element
        for (int i = 4; i < n; i++) {
            maxAminusBplusCminusD[i] = Math.max(maxAminusBplusCminusD[i - 1], maxAminusBplusC[i - 1] + A[i]);
        }

        // The last element of maxAminusBplusCminusD contains the maximum value of the
        // expression
        return maxAminusBplusCminusD[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        System.out.println(maximizeExpression(arr)); // Output: 46

        // int[] B = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // System.out.println(maximizeExpression(B)); // Output: 6
    }
}

// see this as an example
// 1 2 3 4
// maxA -1 -1 -1 -1
// maxAminusB 0 1 2 3
// maxAminusBplusC 0 0 -2 -1
// maxAminusBplusCminusD0 0 0 0 2