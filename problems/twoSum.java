//tags: twopinter A1
// Given a 1-indexed array of integers numbers, find two numbers such that 
// they add up to a specific target number. 
// Display 1 if there is a pair else 0.
// The tests are generated such that there is exactly one solution. 

// input format : an integer (n->length of array)
// 			   n number of integers
// 			   an Integer (k -> sum value)
// output format :either 1 or 0

// example 1:
// input=5
// 1 2 3 4 5
// 7
// output=1

// example 2:
// input=6
// 1 2 3 4 5 6
// 25
// output=0
import java.util.*;

public class twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int result = twoSumHelper(arr, target);
        System.out.println(result);
        sc.close();
    }

    public static int twoSumHelper(int[] nums, int target) {
        Arrays.sort(nums);
        // sorting because if we dont we cant say when to decrase and increase
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 1;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }
}
