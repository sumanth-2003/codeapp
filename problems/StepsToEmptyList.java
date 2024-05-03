//tags: array
// Input an array of distinct numbers, and you can perform the following
// operations until the array is empty:

// If the first element has the smallest value, remove it
// Otherwise, put the first element at the end of the array.

// Return an integer denoting the number of operations it takes to make nums
// empty.

// Example 1:
// Input: 3 4 -1
// Output: 5
// Operation Array
// 1 [4, -1, 3]
// 2 [-1, 3, 4]
// 3 [3, 4]
// 4 [4]
// 5 []

// Example 2:
// Input: 1 2 4 3
// Output: 5
// Operation Array
// 1 [2, 4, 3]
// 2 [4, 3]
// 3 [3, 4]
// 4 [4]
// 5 []

// Example 3:
// Input: 1 2 3
// Output: 3
// Operation Array
// 1 [2, 3]
// 2 [3]
// 3 []

// Constraints:
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// All values in nums are distinct.

import java.util.*;

public class StepsToEmptyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String arr[] = input.split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for (String i : arr) {
            int tem = Integer.parseInt(i);
            list.add(tem);
            que.add(tem);
        }
        Collections.sort(list);
        int cnt = 0;
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x != list.get(0))
                que.add(x);
            else
                list.remove(0);
            cnt++;
        }
        System.out.println(cnt);
    }
}
