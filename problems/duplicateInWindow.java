
//tags: slidingwindow hashset fixed
/* Given an integer array of nums and an integer window size, 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j) where i and j are two distinct indices of array.

Sample Input/output
------------------
input:
--------------
array size
array elements
X   
output:
-----------
true

Example 1:
Input: 4            
1 2 3 1  
3       
Output: false

case 2:
Input: 6
1 2 3 3 2 3
2
Output: true
*/
import java.util.*;

public class duplicateInWindow {
    public static boolean foundDuplicate(int[] arr, int size, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (set.contains(arr[i]))
                return true;
            set.add(arr[i]);
            if (i >= k - 1) {
                set.remove(arr[i - k + 1]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(foundDuplicate(arr, size, k));
        sc.close();
    }
}
