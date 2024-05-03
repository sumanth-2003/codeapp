//tags: 2pointer array A1
// Master sathya is doing his mathematics home work, in that one problem statement is as follows,
// there are list of non-decreasing temperatures values (only integers) are given he need to find the squares of each temperature and return that list in non-decreasing order. Can you help him with a program.

// input format: an integer (n)
//               n number of integers in sorted order
// output format: List of n integers in sorted order

// Example 1:

// Input:5
// -4 -1 0 3 10
// Output: [0, 1, 9, 16, 100]

// Example 2:
// input=8
// 1 2 3 4 5 6 7 8
// output =[1, 4, 9, 16, 25, 36, 49, 64]

import java.util.*;

public class SquareSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int arr[] = new int[input];
        for (int i = 0; i < input; i++)
            arr[i] = sc.nextInt();
        int result[] = new int[input];
        int start = 0;
        int end = input - 1;
        int index = input - 1;
        while (start <= end) {
            if (Math.abs(arr[start]) > Math.abs(arr[end])) {
                result[index] = arr[start] * arr[start];
                start++;
            } else {
                result[index] = arr[end] * arr[end];
                end--;
            }
            index--;
        }
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}
