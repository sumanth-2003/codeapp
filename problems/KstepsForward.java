//tags: array A1 rotateArray
// Given an array, rotate the array to the right by k steps, where k is non-negative.

// Example:
// [1, 2, 3, 4, 5, 6, 7] and k is 4, then the output should be [4, 5, 6, 7, 1, 2, 3].

// input format: an integer (n)
//               n number of space seperated integers
// 			  an integer k
// output format : list of elements

// Sample test cases:
// case =1
// input=7
// 1 2 3 4 5 6 7
// 4
// output=[4, 5, 6, 7, 1, 2, 3]

// case =2
// input=9
// 1 2 3 4 5 6 7 8 9
// 4
// output=[6, 7, 8, 9, 1, 2, 3, 4, 5]

import java.util.*;

public class KstepsForward {
    public static void changeArray(int[] arr, int[] result, int k) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            result[(i + k) % size] = arr[i];
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] arr = new int[input];
        for (int i = 0; i < input; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int result[] = new int[input];
        changeArray(arr, result, k);
        System.out.println(Arrays.toString(result));
        sc.close();

    }
}