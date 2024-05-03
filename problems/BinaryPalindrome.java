//tags: bitmanipulation
// Input a number N.
// Check whether its binary equivalent is Palindrome or not.

// for Example
// If N is 9
// its binary equivalent is 1001 which is palindrome.

// Return true if it is palindrome, false otherwise.

// Test Cases
// case=1
// input=9
// output=true

// case=2
// input=6
// output=false

import java.util.*;

public class BinaryPalindrome {
    public static boolean method2(int input) {
        int reverse = 0;
        int original = input;

        while (input != 0) {
            reverse = (reverse << 1) | (input & 1); // Add the rightmost bit of input to reverse
            input >>= 1; // Move to the next bit
        }

        return original == reverse;
    }

    public static boolean isPalindrome(int input) {
        int right = 1;
        int left = 1;
        int temp = input;
        if (temp != 0) {
            temp >>= 1;
        }
        while (temp != 0) {
            temp >>= 1;
            right <<= 1;
        }
        while (right >= left && (((input & right) == 0 && (input & left) == 0)
                || ((input & right) != 0 && (input & left) != 0))) {
            right = right / 2;
            left <<= 1;
        }
        if (left > right)
            return true;
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.print(isPalindrome(input));
    }
}
