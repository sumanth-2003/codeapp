//tags: trie
// An 8th standard student has been assigned a task as part of punishment for his mistake.

// The task is, there is an input string STR(without any space) and an array of 
// strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
// index and ending index of every string in words[] in the input string STR.

// Note: Print the pairs[s, e] in sorted order.
// (i.e., sort them by their first coordinate, and in case of ties sort them by 
// their second coordinate).

// Input Format
// ------------
// Line-1: string STR(without any space)
// Line-2: space separated strings, words[]

// Output Format
// -------------
// Print the pairs[s, e] in sorted order.

// Sample Input-1:
// ---------------
// thekmecandngitcolleges
// kmec ngit colleges

// Sample Output-1:
// ----------------
// 3 6
// 10 13
// 14 21

// Sample Input-2:
// ---------------
// xyxyx
// xyx xy

// Sample Output-2:
// ----------------
// 0 1
// 0 2
// 2 3
// 2 4

// Explanation: 
// ------------
// Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].

// Sample Input-3:
// ---------------
// kmecngitkmitarecsecolleges
// kmit ngit kmec cse

// Sample Output-3:
// ----------------
// 0 3
// 4 7
// 8 11
// 15 17

// import java.util.*;

// class IndexPairs 
// {
//     public int[][] indexPairs(String text, String[] words) 
//     {
//         //WRITE YOUR CODE HERE
//     }
// }

// class Trie
// {
//     Trie[] children;
//     boolean end;   /*indicate whether there is a word*/
//     public Trie()
//     {
//         end=false;
//         children=new Trie[26];
//     }
// }

// class Solution
// {
// 	public static void main(String args[])
// 	{
// 		Scanner sc=new Scanner(System.in);
// 		String org=sc.nextLine();
// 		String arr[]=sc.nextLine().split(" ");
// 		int res[][]=new IndexPairs().indexPairs(org,arr);
// 		for(int[] ans: res){
// 			System.out.println(ans[0]+" "+ans[1]);
// 		}
// 	}
// }

import java.util.*;

class Trie {
    static final int NUM_CHARS = 26;
    static TrieNode root = new TrieNode(); // Ensure root is initialized

    public List<int[]> indexPairs(String text, String[] words) {
        List<int[]> arr = new ArrayList<>();
        for (String str : words)
            insert(str);
        for (int i = 0; i < text.length(); i++) {
            TrieNode node = root;
            for (int j = i; j < text.length(); j++) {
                int index = text.charAt(j) - 'a';
                // Break if no child is found
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                // Check if it's the end of a word
                if (node.isEndOfWord) {
                    arr.add(new int[] { i, j });
                }
            }
        }
        return arr;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
        }
    }

    static void insert(String key) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
}

class IndexPairsMain {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String org = sc.nextLine();
        String arr[] = sc.nextLine().split(" ");
        Trie trie = new Trie();
        List<int[]> res = trie.indexPairs(org, arr);
        for (int[] ans : res) {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
