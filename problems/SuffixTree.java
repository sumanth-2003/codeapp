//tags: tries
/*
 * Write a program to implement suffix tree concept.
 * Given a string return how many distinct subtrees are possible
 * input format : string
 * output format : integer
 * Example :
 * input=banana
 * output=15
 */// import java.util.*;
    // class Suffix
    // {
    // static class SuffixTrieNode
    // {
    // static final int MAX_CHAR = 26;
    // SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
    // SuffixTrieNode()
    // {
    // for (int i = 0; i < MAX_CHAR; i++)
    // children[i] = null;
    // }
    // void insertSuffix(String s)
    // {
    // //WRITE YOUR CODE HERE
    // }
    // }
    // static class Suffix_trie
    // {
    // static final int MAX_CHAR = 26;
    // SuffixTrieNode root;
    // Suffix_trie(String s)
    // {
    // root = new SuffixTrieNode();
    // for (int i = 0; i < s.length(); i++)
    // root.insertSuffix(s.substring(i));
    // }
    // int _countNodesInTrie(SuffixTrieNode node)
    // {
    // //WRITE YOUR CODE HERE
    // }
    // int countNodesInTrie()
    // {
    // return _countNodesInTrie(root);
    // }
    // }
    // static int countDistinctSubstring(String str)
    // {
    // Suffix_trie sTrie = new Suffix_trie(str);
    // return sTrie.countNodesInTrie();
    // }
    // public static void main(String args[])
    // {
    // Scanner sc=new Scanner(System.in);
    // System.out.println("Enter any string to construct suffix tree");
    // String str=sc.nextLine();
    // System.out.println("Count of distinct substrings is "
    // + (countDistinctSubstring(str) - 1));
    // }
    // }`
    // import java.util.*;
    // class Suffix
    // {
    // static class SuffixTrieNode
    // {
    // static final int MAX_CHAR = 26;
    // SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
    // SuffixTrieNode()
    // {
    // for (int i = 0; i < MAX_CHAR; i++)
    // children[i] = null;
    // }
    // void insertSuffix(String s)
    // {
    // //WRITE YOUR CODE HERE
    // }
    // }
    // static class Suffix_trie
    // {
    // static final int MAX_CHAR = 26;
    // SuffixTrieNode root;
    // Suffix_trie(String s)
    // {
    // root = new SuffixTrieNode();
    // for (int i = 0; i < s.length(); i++)
    // root.insertSuffix(s.substring(i));
    // }
    // int _countNodesInTrie(SuffixTrieNode node)
    // {
    // //WRITE YOUR CODE HERE
    // }
    // int countNodesInTrie()
    // {
    // return _countNodesInTrie(root);
    // }
    // }
    // static int countDistinctSubstring(String str)
    // {
    // Suffix_trie sTrie = new Suffix_trie(str);
    // return sTrie.countNodesInTrie();
    // }
    // public static void main(String args[])
    // {
    // Scanner sc=new Scanner(System.in);
    // System.out.println("Enter any string to construct suffix tree");
    // String str=sc.nextLine();
    // System.out.println("Count of distinct substrings is "
    // + (countDistinctSubstring(str) - 1));
    // }
    // }

import java.util.*;

class SuffixTree {
    static class SuffixTrieNode {
        static final int MAX_CHAR = 26;
        SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];

        SuffixTrieNode() {
            for (int i = 0; i < MAX_CHAR; i++)
                children[i] = null;
        }

        void insertSuffix(String s) {
            // WRITE YOUR CODE HERE
            SuffixTrieNode present = this;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (present.children[index] == null) {
                    present.children[index] = new SuffixTrieNode();
                }
                present = present.children[index];
            }

        }
    }

    static class Suffix_trie {
        static final int MAX_CHAR = 26;
        SuffixTrieNode root;

        Suffix_trie(String s) {
            root = new SuffixTrieNode();
            for (int i = 0; i < s.length(); i++)
                root.insertSuffix(s.substring(i));
        }

        int _countNodesInTrie(SuffixTrieNode node) {
            // WRITE YOUR CODE HERE
            int count = 1;
            for (int i = 0; i < MAX_CHAR; i++) {
                if (node.children[i] != null) {
                    count += _countNodesInTrie(node.children[i]);
                }
            }
            return count;
        }

        int countNodesInTrie() {
            return _countNodesInTrie(root);
        }
    }

    static int countDistinctSubstring(String str) {
        Suffix_trie sTrie = new Suffix_trie(str);
        return sTrie.countNodesInTrie();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string to construct suffix tree");
        String str = sc.nextLine();
        System.out.println("Count of distinct substrings is "
                + (countDistinctSubstring(str) - 1));
    }
}