//tags: tires
/*Mr. Balu is tasked with developing a pattern matching algorithm to determine if given strings adhere to a specific pattern. He will be Given an array of strings queries and a string pattern, and he need to return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
Can you develop a program for this task, Use Trie Approach to solve this problem.

A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.

Input format : comma seperated strings
			   String
output format: list consists of true or false

Example 1:

Input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FB
Output= [true,false,true,true,false]
Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".

Example 2=
Input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FoBa
Output= [true,false,true,false,false]
Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

Example 3:
Input=FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack
FoBaT
Output=[false,true,false,false,false]
Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 
Constraints:
1 <= pattern.length, queries.length <= 100
1 <= queries[i].length <= 100
queries[i] and pattern consist of English letters.
*/
// import java.util.*;
// class TrieNode{
//     TrieNode[] children;
//     boolean isEnd;
//     TrieNode()
//     {
//         children = new TrieNode[58];
//     }
// }
// class Solution {
//     TrieNode root;
//     public Solution() {
//         root = new TrieNode();
//     }
//     public void insert(String word) {
//         //WRITE YOUR CODE HERE
//     }
//     boolean fun(String s, int n)
//     {
//         //WRITE YOUR CODE HERE
//     }
//  public List<Boolean> camelMatch(String[] queries, String pattern) {
//     // WRITE YOUR CODE HERE
//     }
// 	public static void main(String[] args)
// 	{
// 		Scanner sc = new Scanner(System.in);
// 		String[] words = sc.nextLine().split(",");
// 		String key = sc.nextLine();
// 		System.out.println(new Solution().camelMatch(words,key));

// 	}
// }

import java.util.*;

class TrieNode {
	TrieNode[] children;
	boolean isEnd;

	TrieNode() {
		children = new TrieNode[58]; // 26 uppercase + 26 lowercase + 6 extra for ASCII gap
		isEnd = false;
	}
}

class PatternMatching {
	TrieNode root;

	public PatternMatching() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'A'] == null) { // Assuming input is only uppercase or lowercase English letters
				node.children[c - 'A'] = new TrieNode();
			}
			node = node.children[c - 'A'];
		}
		node.isEnd = true; // Mark the end of the pattern
	}

	boolean fun(String s, TrieNode node, int index) {
		if (index == s.length())
			return node.isEnd;

		char c = s.charAt(index);
		if (node.children[c - 'A'] != null) {
			return fun(s, node.children[c - 'A'], index + 1);
		}
		if (Character.isLowerCase(c)) {
			return fun(s, node, index + 1);
		}

		return false;
	}

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		insert(pattern); // Insert the pattern into the trie
		for (String query : queries) {
			result.add(fun(query, root, 0));
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] words = sc.nextLine().split(",");
		String key = sc.nextLine();
		System.out.println(new PatternMatching().camelMatch(words, key));
	}
}
