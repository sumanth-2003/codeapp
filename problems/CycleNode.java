//tags: linkedlist cycle leetcode142

//the main code is not written correctly you can refer leetcode and modify the main code accordingly
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null || slow == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}

public class CycleNode {
    public ListNode head = null;
    public ListNode tail = null;

    public void addNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list2[] = sc.nextLine().split(" ");
        CycleNode list = new CycleNode();
        for (int i = 0; i < list2.length; i++)
            list.addNode(Integer.parseInt(list2[i]));
        Solution sl = new Solution();
        System.out.println(sl.detectCycle(list.head));
        sc.close();
    }
}
