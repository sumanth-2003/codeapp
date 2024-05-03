//tags: slidingwindow fixed A1 leetcode239 deque

// here we need to print the max element in all the subarrays of size k

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;

public class maxinsubarray {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int result[] = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.removeFirst();
            dq.addLast(i);
            if (i >= k - 1) {
                result[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.print();
        System.out.print(Arrays.toString(maxSlidingWindow(arr, k)));
        sc.close();
    }
}
