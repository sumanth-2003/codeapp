//tags: trie prefix
// The following are the options 
// 1. Insert 
// 2. Search
// 3. Delete
// 4. Display 
// 5 exit
// input format : First line of input is space separated words
//                second line onwords, options followed by concerned input(if required) 
// 			   last line of input should have 5(to exit)
// Example 1:
// input =input=abc def ghi
// 4				// display trie
// 1				// insert into trie
// pqr				// word to be inserted
// 2				// search trie
// abc				// word to be searched
// 1				// insert into trie
// mno				// word to be inserted
// 3				// delete form trie
// abc				// word to be dleted
// 5				// exit

// input =abc def ghi
// 4
// 1
// pqr
// 2
// abc
// 1
// mno
// 3
// abc
// 5

// Example 2:
// input = kmit ngit
// 4
// 1
// kmec
// 1
// kmce
// 2
// kmec
// 2
// kmit
// 3
// kmec
// 5

// Use this Java code segment to solve
// import java.util.*;
// class Trie 
// {	
// 	static final int NUM_CHARS = 26;
// 	// To handle prefix deletion
// 	static boolean isDeleted = false;	
// 	// trie node
// 	static class TrieNode
// 	{
// 		TrieNode[] children = new TrieNode[NUM_CHARS];
// 		// isEndOfWord is true if the node represents end of a word
// 		boolean isEndOfWord;
// 		TrieNode()
// 		{
// 			isEndOfWord = false;
// 			for (int i = 0; i < NUM_CHARS; i++)
// 				children[i] = null;
// 		}
// 	};
// 	static TrieNode root;
// 	// If not present, inserts key into trie
// 	// If the key is prefix of trie node, just marks leaf node
// 	static void insert(String key)
// 	{
// 		//WRITE YOUR CODE HERE
// 	}
// 	// Returns true if key (prefix or complete word) is present in trie, else false
// 	static boolean search(String key)
// 	{
// 		//WRITE YOUR CODE HERE
// 	}
// 	// Returns true if root has no children, else false
//     static boolean isEmpty(TrieNode root)
//     {
//         for (int i = 0; i < NUM_CHARS; i++)
//             if (root.children[i] != null)
//                 return false;
//         return true;
//     }
// 	// Recursive function to delete a key from given Trie
//     static TrieNode delete(TrieNode root, String key, int depth)
//     {
// 		//WRITE YOUR CODE HERE
//     }
// 	// To check if current node is leaf node or not
// 	static boolean isLeafNode(TrieNode root) 
// 	{
// 		return root.isEndOfWord == true;
// 	}
// 	// print Trie
// 	static void print(TrieNode root, char[] str, int level) 
// 	{
// 		// If node is leaf node, it indicates end of string, 
// 		// so a null character is added and string is printed
// 		if (isLeafNode(root)) 
// 		{
// 			for (int k = level; k < str.length; k++)
// 				str[k] = 0;
// 			System.out.println(str);
// 		}
// 		int i;
// 		for (i = 0; i < NUM_CHARS; i++) 
// 		{
// 			// if NON NULL child is found add parent key to str and
// 			// call the print function recursively for child node
// 			if (root.children[i] != null) 
// 			{
// 				str[level] = (char) (i + 'a');
// 				print(root.children[i], str, level + 1);
// 			}
// 		}
// 	}
// 	public static void main(String args[])
// 	{
// 		Scanner sc=new Scanner(System.in);
// 		String keys[]=sc.nextLine().split(" ");	
// 		root = new TrieNode();
// 		// Construct trie
// 		int i;
// 		for (i = 0; i < keys.length ; i++)
// 			insert(keys[i]);
// 		char[] str = new char[50];
// 		while(true)
// 		{
// 		int opt = sc.nextInt();
// 		sc.nextLine();
// 		if(opt == 4)
// 		{
// 			System.out.println("Content of Trie: ");
// 			print(root, str, 0);
// 		}
// 		if(opt == 1)
// 		{
// 			String s = sc.nextLine();
// 			insert(s);
// 			System.out.println("Content of Trie: ");
// 			print(root, str, 0);
// 		}
// 		else if(opt == 2)
// 			{
// 			//System.out.println("Enter a word to search ");
// 			String word = sc.next();
// 			if(search(word) == true)
// 				System.out.println(word + " is present ");
// 			else System.out.println(word + " is not present");
// 			}
// 		else if(opt == 3)
// 			{
// 			//System.out.println("Enter a word to delete ");
// 			String word = sc.next();
// 			if(delete(root, word, 0) != null & isDeleted == true)
// 			{
// 				System.out.println(word + " is deleted ");
// 			}
// 			else
// 				System.out.println(word + " is not present in Trie to be deleted");
// 			System.out.println("Content of Trie after deletion: ");
// 			print(root, str, 0);
// 			}
// 		else if (opt == 5)
// 		 {
// 			 break;
// 		 }

// 		}

// 		}
// }

import java.util.*;

class Trie {
    static final int NUM_CHARS = 26;
    // To handle prefix deletion
    static boolean isDeleted = false;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        // isEndOfWord is true if the node represents end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
        }
    };

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
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

    // Returns true if key (prefix or complete word) is present in trie, else false
    static boolean search(String key) {
        // WRITE YOUR CODE HERE
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }

        return true;

    }

    // Returns true if root has no children, else false
    static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < NUM_CHARS; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    // Recursive function to delete a key from given Trie
    static TrieNode delete(TrieNode root, String key, int depth) {
        // WRITE YOUR CODE HERE
        if (depth == key.length()) {
            isDeleted = root.isEndOfWord;
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }
            if (isEmpty(root))
                return null;
            return root;
        }
        int index = key.charAt(depth) - 'a';
        if (root.children[index] == null)
            return null;
        root.children[index] = delete(root.children[index], key, depth + 1);
        if (isEmpty(root) && root.isEndOfWord == false) {
            return null;
        }
        return root;

    }

    // To check if current node is leaf node or not
    static boolean isLeafNode(TrieNode root) {
        return root.isEndOfWord == true;
    }

    // print Trie
    static void print(TrieNode root, char[] str, int level) {
        // If node is leaf node, it indicates end of string,
        // so a null character is added and string is printed
        if (isLeafNode(root)) {
            for (int k = level; k < str.length; k++)
                str[k] = 0;
            System.out.println(str);
        }
        int i;
        for (i = 0; i < NUM_CHARS; i++) {
            // if NON NULL child is found add parent key to str and
            // call the print function recursively for child node
            if (root.children[i] != null) {
                str[level] = (char) (i + 'a');
                print(root.children[i], str, level + 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String keys[] = sc.nextLine().split(" ");
        root = new TrieNode();
        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);
        char[] str = new char[50];
        while (true) {
            int opt = sc.nextInt();
            sc.nextLine();
            if (opt == 4) {
                System.out.println("Content of Trie: ");
                print(root, str, 0);
            }
            if (opt == 1) {
                String s = sc.nextLine();
                insert(s);
                System.out.println("Content of Trie: ");
                print(root, str, 0);
            } else if (opt == 2) {
                // System.out.println("Enter a word to search ");
                String word = sc.next();
                if (search(word) == true)
                    System.out.println(word + " is present ");
                else
                    System.out.println(word + " is not present");
            } else if (opt == 3) {
                // System.out.println("Enter a word to delete ");
                String word = sc.next();
                if (delete(root, word, 0) != null & isDeleted == true) {
                    System.out.println(word + " is deleted ");
                } else
                    System.out.println(word + " is not present in Trie to be deleted");
                System.out.println("Content of Trie after deletion: ");
                print(root, str, 0);
            } else if (opt == 5) {
                break;
            }

        }
        sc.close();
    }
}