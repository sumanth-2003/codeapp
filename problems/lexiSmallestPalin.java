
//tags: string lexicographically palindrome A1
/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.
Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er
Sample Output-1:
----------------
redavader

Sample Input-2:
---------------
r#d#v#cer
Sample Output-2:
----------------
invalid

*/
import java.util.*;

public class lexiSmallestPalin {
    public static boolean ispalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (end > start) {
            if (input.charAt(end) != input.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String argsp[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String input = sc.next();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '#') {
                if (input.charAt(len - 1 - i) == '#') {
                    str.append('a');
                } else {
                    str.append(input.charAt(len - 1 - i));
                }
            } else {
                str.append(input.charAt(i));
            }
        }
        if (ispalindrome(str.toString())) {
            System.out.print(str.toString());
        } else {
            System.out.print("invalid");
        }
        sc.close();
    }
}