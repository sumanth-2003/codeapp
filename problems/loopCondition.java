//tags: arrays circle loop A1 prefixsum
// Given an array of integers which is a secret Code which is an array of integers.
// You will be provided with a key K.

// To decrypt the Code, you must replace every number. 

// If K > 0, replace the ith number with the sum of the next K numbers.
// If K < 0, replace the ith number with the sum of the previous K numbers.
// If K == 0, replace the ith number with 0.

// The next element of Code[N-1] is Code[0], and the previous element of Code[0] is Code[N-1] (N is Length of array).

// Given the circular array Code and an integer key K, return the decrypted Code.

// Example 1:
// Input: 5 7 1 4
// 3
// Output: 12 10 16 13
// Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted Code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

// Example 2:
// Input: 1 2 3 4
// 0
// Output: 0 0 0 0
// Explanation: When k is zero, the numbers are replaced by 0. 

// Example 3:
// Input: 2 4 9 3
// -2
// Output: 12 5 6 13
// Explanation: The decrypted Code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.

// Constraints:
// N == Code.length
// 1 <= N <= 100
// 1 <= Code[i] <= 100
// -(N - 1) <= K <= N - 1

// here than doing a loop inside for sum we can keep a prefix sum array so that we can direcly assign the sum value
import java.util.*;

public class loopCondition {
    public static int[] decrypt(int arr[], int size, int k) {
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            if (k > 0) {
                for (int j = i + 1; j <= i + k; j++)
                    result[i] += arr[j % size];
            } else if (k < 0) {
                for (int j = i - 1; j >= i + k; j--)
                    result[i] += arr[(j + size) % size];
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static int[] decryptPrefix(int arr[], int size, int k) {
        int[] result = new int[size];
        int[] prefixSum = new int[size + 1];

        // Calculate prefix sum to optimize sum calculation
        for (int i = 1; i <= size; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < size; i++) {
            if (k > 0) {
                // To handle wrap-around, we use modular arithmetic
                result[i] = prefixSum[(i + k + 1) % size + 1] - prefixSum[i + 1];
            } else if (k < 0) {
                // To handle wrap-around and negative indices, we use modular arithmetic and
                // size adjustment
                result[i] = prefixSum[i] - prefixSum[(i - k) % size];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        int k = sc.nextInt();
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(Arrays.toString(decrypt(arr, size, k)));
        sc.close();
    }
}

// '''
// Given an array of integers which is a secret Code which is an array of
// integers.
// You will be provided with a key K.

// To decrypt the Code, you must replace every number.

// If K > 0, replace the ith number with the sum of the next K numbers.
// If K < 0, replace the ith number with the sum of the previous K numbers.
// If K == 0, replace the ith number with 0.

// The next element of Code[N-1] is Code[0], and the previous element of Code[0]
// is Code[N-1] (N is Length of array).

// Given the circular array Code and an integer key K, return the decrypted
// Code.

// Example 1:
// Input: 5 7 1 4
// 3
// Output: 12 10 16 13
// Explanation: Each number is replaced by the sum of the next 3 numbers. The
// decrypted Code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap
// around.

// Example 2:
// Input: 1 2 3 4
// 0
// Output: 0 0 0 0
// Explanation: When k is zero, the numbers are replaced by 0.

// Example 3:
// Input: 2 4 9 3
// -2
// Output: 12 5 6 13
// Explanation: The decrypted Code is [3+9, 2+3, 4+2, 9+4]. Notice that the
// numbers wrap around again. If k is negative, the sum is of the previous
// numbers.

// Constraints:
// N == Code.length
// 1 <= N <= 100
// 1 <= Code[i] <= 100
// -(N - 1) <= K <= N - 1
// '''

// l = list(map(int,input().split()))
// n = len(l)
// k = int(input())
// a=[]
// if(k>0):
// sum=0
// for i in range(1,k+1):
// sum=sum+l[i%n]
// a.append(sum)
// for i in range(0,n-1):
// sum+=l[(i+k+1)%n]
// sum-=l[(i+1)%n]
// a.append(sum)
// elif(k<0):
// sum=0
// for i in range(0,k,-1):
// sum=sum+l[(i-1)%n]
// a.append(sum)
// for i in range(0,n-1):
// sum+=l[i]
// sum-=l[k]
// k+=1
// if k==0:
// k=n*-1;
// a.append(sum)
// else:
// for i in range(0,n):
// a.append(0)
// print(a)