//tags: tries frequency
/*
Sridhar brought his latest Apple iPhone 15 pro. He started his conversation 
with one of his friend on WhatsApp with list of words.

Now it’s our task to find and return what are the most common words 
in the list of words he used in sorted order based on occurrence from 
largest to smallest. If any of words he used are having same occurrence 
then consider the lexicographic order.

You will be given a list of words, you need to print top P number of 
most common used words as described in the statement. 

Input Format:
-------------
Line-1: comma separated line of words, list of words.
Line-2: An integer P, number of words to display. 

Output Format:
--------------
Print P number of most common used words.


Sample Input-1:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
3

Sample Output-1:
----------------
[are, case, egg]



Sample Input-2:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
3

Sample Output-2:
----------------
[are, egg, case]


*/

// import java.util.*;

// class Node{
//     public char c;
//     public boolean isWord;
//     public int count;
//     public Node[] children;
//     public String str;
//     public Node(char c){
//         this.c = c;
//         this.isWord = false;
//         this.count = 0;
//         children = new Node[26];
//         str = "";
//     }
// }

// class Trie{
//     public Node root;
//     public Trie(){
//         this.root = new Node('\0');
//     }
//     public void insert(String word){
//         //WRITE YOUR CODE

//     }
//     public void traverse(Node root, PriorityQueue<Node> pq){
//         //WRITE YOUR CODE HERE
//     }
// }

// public class FrequentWord {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String line1 = sc.nextLine();
//         int p = sc.nextInt();
//         String[] words = line1.split(",");
//         Trie t = new Trie();
//         PriorityQueue<Node> pq = new PriorityQueue<>();
//         //make Priority work as required
//         for(int i = 0;i<words.length;i++){
//            t.insert(words[i]);
//         }
//         t.traverse(t.root, pq);
//         List<String> res = new ArrayList<>();
//         int k = 0;
//         while(k++<p)
//             res.add(pq.poll().str);

//         System.out.println(res);
//     }
// }

import java.util.*;

class Node {
    public char c;
    public boolean isWord;
    public int count;
    public Node[] children;
    public String word;

    public Node(char c) {
        this.c = c;
        this.isWord = false;
        this.count = 0;
        children = new Node[26];
        word = "";
    }
}

class Trie {
    public Node root;

    public Trie() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        // WRITE YOUR CODE
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node(c);
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
        curr.count++;
        curr.word = word;

    }

    public void traverse(Node root, PriorityQueue<Node> pq) {
        // WRITE YOUR CODE HERE
        if (root == null)
            return;
        if (root.isWord) {
            pq.offer(root);
        }
        for (Node child : root.children) {
            traverse(child, pq);
        }
    }
}

public class FrequntWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int p = sc.nextInt();
        String[] words = line1.split(",");
        Trie t = new Trie();
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count);
        // make Priority work as required
        for (int i = 0; i < words.length; i++) {
            t.insert(words[i]);
        }
        t.traverse(t.root, pq);
        List<String> res = new ArrayList<>();
        int k = 0;
        while (k++ < p)
            res.add(pq.poll().word);

        System.out.println(res);
    }
}