//tags: segmentTree
/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.
3. find the min value in the given range
4. find the max value in the given range
Your task is to solve this problem using Segment Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
8 7
4 2 13 3 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
3 2 6       //get min value in the range
2 2 18	    //update
2 4 17	    //update
1 2 6		//sumRange
4 1 5       // get max value in the range

8 7
4 2 13 3 25 16 17 8
1 2 6
1 0 7
3 2 6
2 2 18
2 4 17
1 2 6	
4 1 5
 

Sample Output:
--------------
74
88
3
71
25


*/

import java.util.*;

class SegmentTree {
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum, min, max;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
    }

    SegmentTreeNode root = null;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);

    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        // write your code here
        if (start > end)
            return null;
        else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
                ret.min = nums[start];
                ret.max = nums[start];
            } else {
                int mid = (start + end) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
                ret.min = Math.min(ret.left.min, ret.right.min);
                ret.max = Math.max(ret.left.max, ret.right.max);
            }
            return ret;
        }

    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val) {
        // Write your code here
        if (root.start == root.end) {
            root.sum = val;
            root.min = val;
            root.max = val;
        } else {
            int mid = (root.start + root.end) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
            root.min = Math.min(root.left.min, root.right.min);
            root.max = Math.max(root.left.max, root.right.max);
        }

    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        // Write your code here
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            // System.out.println("mid " + mid);

            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            } else {
                return sumRange(root.left, start, mid) +
                        sumRange(root.right, mid + 1, end);
            }
        }
    }

    public int minRange(int i, int j) {
        return minRange(root, i, j);
    }

    public int minRange(SegmentTreeNode root, int start, int end) {
        // Write your code here
        if (root.start == start && root.end == end) {
            return root.min;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            // System.out.println("mid " + mid);

            if (end <= mid) {
                return minRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return minRange(root.right, start, end);
            } else {
                return Math.min(minRange(root.left, start, mid), minRange(root.right, mid + 1, end));
            }
        }
    }

    public int maxRange(int i, int j) {
        return maxRange(root, i, j);
    }

    public int maxRange(SegmentTreeNode root, int start, int end) {
        // Write your code here
        if (root.start == start && root.end == end) {
            return root.max;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            // System.out.println("mid " + mid);

            if (end <= mid) {
                return maxRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return maxRange(root.right, start, end);
            } else {
                return Math.max(maxRange(root.left, start, mid), maxRange(root.right, mid + 1, end));
            }
        }
    }
}

class SegmentTreeTest {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        SegmentTree st = new SegmentTree(nums);
        while (q != 0) {
            int opt = scan.nextInt();
            if (opt == 1) {
                int s1 = scan.nextInt();
                int s2 = scan.nextInt();
                System.out.println(st.sumRange(s1, s2));
            } else if (opt == 3) {
                int s1 = scan.nextInt();
                int s2 = scan.nextInt();
                System.out.println(st.minRange(s1, s2));
            } else if (opt == 4) {
                int s1 = scan.nextInt();
                int s2 = scan.nextInt();
                System.out.println(st.maxRange(s1, s2));
            }

            else {
                int ind = scan.nextInt();
                int val = scan.nextInt();
                st.update(ind, val);
            }
            q--;
        }
    }
}