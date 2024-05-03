//tags: 3pointer arrays 
// Mr. Varun is an accountant in a shop,daily turnover of shop is in lakhs, some times it is negetive also when purchses by the shop are more than sales of shop.One day shop owner called Varun and asked him to give the sum of three days turnover which is near to given target.Help Varun with a your program skills.

// input format : integer (n)
//                n number of integers
// 			   integer (target)
// output format : integer

// You may assume that each input would have exactly one solution.

// Example 1:

// Input:4
// -1 2 1 -4
// 1
// Output: 2

// Example 2:
// Input:3
// 0 0 0 
// 1
// Output: 0
import java.util.*;

public class ClosetSum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int arr[] = new int[input];
        int near = Integer.MAX_VALUE;
        for (int i = 0; i < input; i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();
        for (int i = 0; i < input - 2; i++) {
            int start = i + 1, end = input - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                near = Math.min(near, Math.abs(target - sum));
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(near);
        sc.close();
    }
}
