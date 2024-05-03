//tags: tires
/*
you are given a binary matrix of size nxn .Your task is to find duplicate rows present in a given matrix by traversing the matrix only once.

For example,

Input=5
1  0  0  1  0
0  1  1  0  0
1  0  0  1  0
0  0  1  1  0
0  1  1  0  0
Output=3 5 
Explanation: Row #3 is duplicate of row #1 and row #5 is duplicate of row #2
*/
// A class to store a Trie node
// import java.util.*;
// class Trie
// {
// 	boolean isLeaf;	// set when the node is a leaf node
// 	Trie[] character = new Trie[2];
// 	// Constructor
// 	Trie() {
// 		isLeaf = false;
// 	}
// }

// class Main
// {
// 	// Iterative function to insert each array element into a Trie
// 	public static boolean insert(Trie head, int[] A)
// 	{
// 	    // WRITE YOUR CODE HERE
// 	}

// 	public static void main (String[] args)
// 	{
// 		Scanner sc = new Scanner(System.in);
// 		int n= sc.nextInt();
// 		Trie head = new Trie();
// 		int[][] mat = new int[n][n];
// 		for(int i=0;i<n;i++)
// 			for(int j=0;j<n;j++)
// 				mat[i][j]=sc.nextInt();
// 		// insert all rows of the matrix into a Trie
// 		for (int i = 0; i < n; i++)
// 		{
// 			if (!insert(head, mat[i])) {
// 				System.out.print(" "+(i + 1));
// 			}
// 		}
// 	}
// }

import java.util.*;

class Trie {
    boolean isLeaf; // set when the node is a leaf node
    Trie[] character = new Trie[2];

    // Constructor
    Trie() {
        isLeaf = false;
    }
}

class DuplicateRows {
    // Iterative function to insert each array element into a Trie
    public static boolean insert(Trie head, int[] A) {
        // WRITE YOUR CODE HERE
        Trie r = head;
        for (int i : A) {
            if (r.character[i] == null) {
                break;
            }
            r = r.character[i];
        }
        if (r.isLeaf)
            return false;

        r = head;
        for (int i : A) {
            if (r.character[i] == null) {
                r.character[i] = new Trie();
            }
            r = r.character[i];
        }
        r.isLeaf = true;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie head = new Trie();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        // insert all rows of the matrix into a Trie
        for (int i = 0; i < n; i++) {
            if (!insert(head, mat[i])) {
                System.out.print(" " + (i + 1));
            }
        }
    }
}