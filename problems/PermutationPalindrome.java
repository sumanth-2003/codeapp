//tags: bitmanipulation

//but the approch is correct for all getting wrong answer for the input abcde

import java.util.*;

public class PermutationPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int mask = 0;
        for (char ch : input.toCharArray()) {
            mask = mask ^ (1 << (ch - 'a'));
        }
        if (mask == 0 || (mask & (mask - 1)) == 0) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
        sc.close();
    }
}
