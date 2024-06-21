//tags: dp gfgks 
//question : we can delete a subsring of all character in operation tell me number of operations required to delete whole string

//appraoch : we are using a dp array of [stringsize][stringsize] which indicates number of opearations required to delte the substring i to j which are 
//the indices of that dp array . if we are adding a new character we loop from the i to j if we find the same character which we are adding we see the 
// min of i to that index-1 steps plus and  index to j we do that for all matching values and take the min and assin it to the dp[i][j] and return it

// testcases
// Input: str = “abcddcba” 
// Output: 4 
// Delete dd, then the string is “abccba” 
// Delete cc, then the string is “abba” 
// Delete bb, then the string is “aa” 
// Delete aa, then the string is null. 
// Input: str = “abc” 
// Output: 3 
import java.util.*;

public class DeleteString {
    static int findmindeletion(int l, int r, int dp[][], String s) {
        if (l > r) {
            return 0;
        }
        if (l == r)
            return 1;
        if (dp[l][r] != -1)
            return dp[l][r];
        int res = 1 + findmindeletion(l + 1, r, dp, s);
        for (int i = l + 1; i <= r; i++) {
            if (s.charAt(l) == s.charAt(i)) {
                res = Math.min(res, findmindeletion(l, i - 1, dp, s) + findmindeletion(i, r, dp, s));
            }
        }
        return dp[l][r] = res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String inputstring = sc.next();
        int inputsize = inputstring.length();
        int dp[][] = new int[inputsize][inputsize];
        for (int i = 0; i < inputsize; i++) {
            for (int j = 0; j < inputsize; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findmindeletion(0, inputsize - 1, dp, inputstring));
        sc.close();
        ;
    }
}
