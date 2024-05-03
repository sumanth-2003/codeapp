//tags: bitmanipulation
// Given a positive integer n, you can apply one of the following operations:

// If n is even, replace n with n / 2.
// If n is odd, replace n with either n + 1 or n-1 .
// Return the minimum number of operations needed for n to become 1.

// Example 1:
// Input:8
// Output: 3
// Explanation: 8 -> 4 -> 2 -> 1

// Example 2:
// Input:7
// Output: 4
// Explanation: 7 -> 8 -> 4 -> 2 -> 1
// or 7 -> 6 -> 3 -> 2 -> 1
import java.util.*;

public class MinstepToMake1 {
    public static int rec(int input) {
        if (input == 1)
            return 0;
        if (input % 2 == 0)
            return 1 + rec(input / 2);
        return 1 + Math.min(rec(input + 1), rec(input - 1));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.print(rec(input));

    }
}
