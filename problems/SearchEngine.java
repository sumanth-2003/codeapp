
//tags: tires
/*You are working as a software engineer. Your company is developing software for a hypermarket. As part of this, you are tasked with creating a program that provides suggestions based on the search term entered by the user and a list of product names. After each character of the search term is inputted, the system should suggest up to three product names at most that share a common prefix with the search term. If there are more than three products that share a common prefix, the system should prioritize suggesting the three products listed first in lexicographical order.

Return a list of lists of the suggested products after each character of searchWord is typed.

input format: list of comma seperated strings
			  string
output format : list
 

Example 1:

Input:=mobile,mouse,moneypot,monitor,mousepad
       mouse
Output= [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

Example 2:
Input=havana
      havana
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
 

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
*/

import java.util.*;

class SearchEngine {
      class Node {
            Node[] child;
            int[] count;
            boolean isEnd;

            public Node() {
                  child = new Node[26];
                  count = new int[26];
                  isEnd = false;
                  Arrays.fill(child, null);
            }

      }

      public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            // WRITE YOUR CODE HERE

      }

      void DFS(Node node, String s, int[] count, List<String> list) {
            // WRITE YOUR CODE HERE
      }

      public void insert(String word, Node root) {
            // WRITE YOUR CODE HERE
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] words = sc.nextLine().split(",");
            String key = sc.nextLine();
            System.out.println(new Solution().suggestedProducts(words, key));
      }
}