
//tags: array A1 replace
/*
Naveen manages pipe warehouse.There are n number of pipes placed vertically 
along a wall. Given l[i] is the length of the ith pipe placed on the wall from 
left to right(0-indexed). Naveen's task is to check if the pipes are in 
non-decreasing order of lengths on the wall from left to right.
If not,he can choose only 1 pipe on the wall and replace it with another pipe 
from warehouse to make it non-decreasing order.

There are all integer type of lengths are provided from warehouse.
Help Naveen whether he can can make the pipes in non-decreasing order.

Input Format:
-------------
Line-1: An integer n, number of pipes on the wall.
Line-2: n space separated integers represents length of each pipe.


Output Format:
--------------
return boolean value

Sample Input-1:
---------------
5
3 4 7 6 8

Sample Output-1:
----------------
true

Explanation:
------------
Replace 7 with 5 will become non decreasing array.

Sample Input-2:
---------------
4
2 5 4 1

Sample Output-2:
----------------
false

Explanation:
------------
Inorder to make it non-decreasing array we have to replace 2 elements which is not allowed.

*/
import java.util.*;

class Test {
	public boolean checkPossibility(int[] nums) {
		int numViolations = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				if (numViolations == 1) {
					return false;
				}
				numViolations++;
				if (i < 2 || nums[i - 2] <= nums[i]) {
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}
			}
		}

		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		System.out.println(new Test().checkPossibility(ar));
		sc.close();

	}
}
/*
 * 
 * 
 * ==== testcases ====
 * case =1
 * input =5
 * 7 1 4 3 2
 * Output =false
 * 
 * case =2
 * input =8
 * 5 10 12 14 17 18 19 1
 * Output =true
 * 
 * case =3
 * input =6
 * 0 3 1 2 4 5
 * Output =true
 * 
 * case =4
 * input =3
 * 1 3 0
 * Output =true
 * 
 * case =5
 * input =6
 * 3 5 9 10 11 12
 * Output =true
 * 
 * case =6
 * input =6
 * 100 110 125 111 167 153
 * Output =false
 * 
 * case =7
 * input =4
 * 120 125 99 151
 * Output =true
 * 
 * case =8
 * input =5
 * 12 17 13 15 16
 * Output =true
 */
