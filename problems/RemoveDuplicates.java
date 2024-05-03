
//tags: twopointer fastslow
import java.util.*;

//this  methods is used to remove duplicates that are greater than 2 times repeated (sorted)
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                count = 1;
                nums[index + 1] = nums[i];
                index++;
            } else if (count != 2) {
                count = 2;
                nums[index + 1] = nums[i];
                index++;
            }
        }
        return index + 1;
    }
}

public class RemoveDuplicates {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int arr[] = new int[input];
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        int index = 0, start = 1;
        for (int i = start; i < input; i++) {
            if (arr[i] != arr[index]) {
                arr[index + 1] = arr[i];
                index++;
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
