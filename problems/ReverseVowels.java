
//tags: twopinter
// reverse the vowel positoins
import java.util.*;

public class ReverseVowels {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String vowel = "aeiou";
        StringBuilder str = new StringBuilder(input);
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (vowel.indexOf(str.charAt(start)) != -1 && vowel.indexOf(str.charAt(end)) != -1) {
                char temp1 = str.charAt(start);
                char temp2 = str.charAt(end);
                System.out.println(start + "-" + temp1);
                System.out.println(end + "-" + temp2);
                str.insert(end, temp1);
                System.out.println(str);
                str.deleteCharAt(start);
                System.out.println(str);
                str.insert(start, temp2);
                System.out.println(str);
                str.deleteCharAt(end + 1);
                end--;
                start++;
            } else if (vowel.indexOf(str.charAt(start)) != -1) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(str.toString());
    }
}