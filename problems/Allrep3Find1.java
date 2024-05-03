
//tags: bitmanipulation leetcode
// basically we need to find a number that which dont repeats thrice and repeats exactly onces
import java.util.*;

public class Allrep3Find1 {
    public static int RepeatOnce(int[] nums, int size) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 1 << i;
            int onecount = 0;
            for (int ele : nums) {
                if ((temp & ele) != 0) {
                    onecount++;
                }
            }
            if (onecount % 3 != 0) {
                result = (result | temp);
            }
        }
        return result;
    }

    public static int method2(int[] nums, int size) {
        int rep_onces = 0, rep_twices = 0;
        for (int ele : nums) {
            rep_onces ^= ele & (~rep_twices);
            rep_twices ^= ele & (~rep_onces);
            ;
        }
        return rep_onces;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int arr[] = new int[input];
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(RepeatOnce(arr, input));
        System.out.println(method2(arr, input));
    }
}
