// tags: DSU
// Vihaar is working with strings.
// He is given two strings A and B, and another string T,
// where the length of A and B is same.

// You can find the relative groups of letters from A and B,
// using the following rule set:
// - Equality rule: 'p' == 'p'
// - Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
// - Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

// Vihaar has to form the relatively smallest string of T,
// using the relative groups of letters.

// For example, if A ="pqr" and B = "rst" ,
// then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

// The relatives groups formed using above rule set are as follows:
// [p, r, t] and [q,s] and String T ="tts", then relatively smallest string is
// "ppq".

// You will be given the strings A , B and T.
// Your task is to help Vihaar to find the relatively smallest string of T.

// Input Format:
// -------------
// Three space separated strings, A , B and T

// Output Format:
// --------------
// Print a string, relatively smallest string of T.

// Sample Input-1:
// ---------------
// kmit ngit mgit

// Sample Output-1:
// ----------------
// ggit

// Explanation:
// ------------
// The relative groups using A nd B are [k, n], [m, g], [i], [t] and
// the relatively smallest string of T is "ggit"

// Sample Input-2:
// ---------------
// attitude progress apriori

// Sample Output-2:
// ----------------
// aaogoog

// Explanation:
// ------------
// The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d,
// s]
// the relatively smallest string of T is "aaogoog"

import java.io.*;
import java.util.*;

class DisjointUnionSets {
    int[] parent;

    public DisjointUnionSets(String w1, String w2) {
        parent = new int[26];
        makeSet();
        for (int i = 0; i < w1.length(); i++) {
            union(w1.charAt(i) - 'a', w2.charAt(i) - 'a');
            // System.out.println(parent[w1.charAt(i) - 'a'] + "and" + parent[w2.charAt(i) - 'a']);

        }

    }

    // Creates n sets with single item in each
    void makeSet() {
        for (int i = 0; i < 26; i++) {
            // Initially, all elements are in their own set
            parent[i] = i;
        }
    }

    // Returns representative of x's set
    int find(int x) {
        // Finds the representative of the set that x is an element of
        if (parent[x] != x) {
            // System.out.println("x " + x + " parent[x] " + parent[x]);
            // if x is not the parent of itself then x is not the representative of his set
            parent[x] = find(parent[x]);
            // so we recursively call Find on its parent and move i's node directly under
            // the
            // representative of this set
        }
        return parent[x];
    }

    // Unites the set that includes x and the set that includes x
    void union(int x, int y) {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);
        if (xRoot < yRoot) {
            parent[yRoot] = xRoot;
        } else {
            parent[xRoot] = yRoot;
        }

    }

    String change(String input) {
        StringBuilder s1 = new StringBuilder();
        for (char ch : input.toCharArray()) {
            // System.out.println(ch + " " + parent[ch - 'a'] + " " + (char) (parent[ch -
            // 'a'] + 'a'));
            s1.append((char) (find(ch - 'a') + 'a'));
        }
        return s1.toString();
    }
}

class SmallestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        String input = sc.next();
        DisjointUnionSets dus = new DisjointUnionSets(w1, w2);
        System.out.println(dus.change(input));

    }
}