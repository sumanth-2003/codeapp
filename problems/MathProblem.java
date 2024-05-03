
//tags: slidingwindow
/*
Mr. Uday, a mathematics teacher, has assigned a task to his students. The challenge is to determine the shortest length of a contiguous subset within an array of positive integers. This subset must have a sum exceeding a specified value, denoted as "k". Students should find length of the subset,if no such subset exists, the program should output 0.
With your programming skills write a program to solve this.


input format: an integer n
             n number of integers
			 an integer (k)
output format: an integer( length of subset)

For example,
Example 1:
Input=8
1 2 3 4 5 6 7 8
20
Output=3
Explanation: The smallest subarray with sum > 20 is {6, 7, 8}  

Example 2:
Input=8
1 2 3 4 5 6 7 8
7
Output= 1
Explanation: The smallest subarray with sum > 7 is {8}

Example 3:
Input=8
1 2 3 4 5 6 7 8
21
Output= 4
Explanation: The smallest subarray with sum > 21 is {4, 5, 6, 7}

Example 4:
Input=8
1 2 3 4 5 6 7 8
40
Output=0
*/
import java.util.*;

public class MathProblem {
    public static int minSize(int size, int[] arr, int tar) {
        int sum = 0, minvalue = Integer.MAX_VALUE, start = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (sum > tar) {
                while (sum > tar) {
                    sum -= arr[start];
                    start++;
                }
                minvalue = Math.min(minvalue, i - start + 2);
            }
        }
        return minvalue == Integer.MAX_VALUE ? 0 : minvalue;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        System.out.println(minSize(size, arr, tar));
    }

}
