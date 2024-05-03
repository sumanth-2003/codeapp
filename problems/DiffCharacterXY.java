//tags: dp stringbuilder
// Mr. Balu is working in a lingustic company as part of his job he need to design an tool called diff utility tool.

// The diff utility is a data comparison tool that calculates and displays the differences between the two texts. It tries to determine the smallest set of deletions and insertions and create one text from the other. Diff is line-oriented rather than character-oriented, unlike edit distance.

// input format : two strings
// output format : string which consists of alphabets and '+' and '-'

//  For example,

// Input=XMJYAUZ 
//       XMJAATZ
// Output= X M J -Y A -U +A +T Z
// (- indicates that character is deleted from Y but it was present in X)
// (+ indicates that character is inserted in Y but it was not present in X)

// Example 2:
// input = hellokmit
// ngit
//  output=-h -e -l -l -o -k -m +n +g i t

// here first we calculate the longest common subsequcnes like dp[i][j] = upto ith index in first stirng and upto jth index in second string the common sub sequnce length
//  and then we come back of both the string if both are same no need to do any thing if both are not same  we cal the sub seq length by including the ith and by including jth in string2 when have higher value
// we listen according to them
import java.util.*;

public class DiffCharacterXY {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.next();
        String y = sc.next();
        printDiff(x, y);
    }

    private static void printDiff(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result.insert(0, " " + x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.insert(0, " -" + x.charAt(i - 1));
                i--;
            } else {
                result.insert(0, " +" + y.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            result.insert(0, " -" + x.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.insert(0, " +" + y.charAt(j - 1));
            j--;
        }

        System.out.println(result.toString());
    }
}
