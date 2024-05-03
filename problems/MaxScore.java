//tags: gdc
// Input nums,an array of positive integers of size 2*n.You must perform n operations on this array.

// In the ith operation(1-indexed),you will:

// Choose two elements,x and y.Receive a score of i*gcd(x,y).Remove x and y from nums.Return the maximum score you can receive after performing n operations.

// The function gcd(x,y)is the greatest common divisor of x and y.

// Example 1:Input:1 2 Output:1 Explanation:The optimal choice of operations is:(1*gcd(1,2))=1

// Example 2:Input:3 4 6 8 Output:11 Explanation:The optimal choice of operations is:(1*gcd(3,6))+(2*gcd(4,8))=3+8=11

// Use the following code Python segement to solve the problem.def maxScore(nums):#WRITE YOUR CODE HERE

// nums=[int(i)for i in input().split()]print(maxScore(nums))

public class MaxScore {

}
