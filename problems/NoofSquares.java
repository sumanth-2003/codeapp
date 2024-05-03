//tags: dp A1 tabular

/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:
Input: matrix =
0 1 1 1
1 1 1 1
0 1 1 1
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:
Input: matrix = 
1 0 1
1 1 0
1 1 0
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
*/
import java.util.*;

class Solution {
    public int countSquares(int[][] matrix) {
        int result = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                result += matrix[i][j];

            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] ar = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                ar[i][j] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.countSquares(ar));
        sc.close();

    }
}
/*
 * test cases
 * case =1
 * input=3 4
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 1 1
 * output=20
 * case =2
 * input=4 4
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 * output=0
 * case =3
 * input=3 4
 * 1 0 0 1
 * 1 0 0 1
 * 1 0 0 1
 * output=6
 * case =4
 * Input: 3 4
 * 0 1 1 1
 * 1 1 1 1
 * 0 1 1 1
 * Output: 15
 * case =5
 * Input: 3 3
 * 1 0 1
 * 1 1 0
 * 1 1 0
 * Output: 7
 * 
 */