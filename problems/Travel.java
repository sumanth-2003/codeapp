//tags: HashMap travel
// Sri Vihaan Travels announced a family trip to Sri Nagar, for which they began 
// taking reservations. They are only offering 2 and 3-seater tickets for this trip.

// Each member of certain groups is identifiable by the group ID to which he or 
// she belongs. Each group is uniquely identified by its group ID.

// The travel administration decided that the ticket will only be issued to members
// of the same group. It is decided that No wasted tickets will be issued 
// (i.e., If a person is alone, then he is not allowed to get a ticket).

// You are given a list of integers person_id[], where person_id[i] is the group ID 
// of the ith person in the list. Your objective is to determine whether fewer tickets 
// should be issued to cover everyone in each group. Print -1, if it is not possible.

// Input Format:
// -------------
// Line-1: Comma separated integers, Person's group-ID

// Output Format:
// --------------
// Print an integer result.

// Sample Input-1:
// ---------------
// 1,1,3,2,2,2,1,2,2,3

// Sample Output-1:
// ----------------
// 4

// Explanation: 
// ------------
// They can book the tickets for all the people, as follows:
// - Issue the 3-seater ticket, to group with ID-1 of size 3.
// - Issue the 2-seater ticket, to group with ID-3 of size 2.
// - Issue the 3-seater ticket, to group with ID-2 of size 5.
// - Issue the 2-seater ticket, to group with ID-2 of size 5.
// So, you have issued 4 tickets in total.

// Sample Input-2:
// ---------------
// 1,1,1,2,2,3

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// ------------
// There is a group with ID-3 of size 1. 
// The administration's ruling states that a single person cannot receive a ticket.
// So, print -1.

import java.util.*;

public class Travel {
    public static int divby2(int numBoats) {
        int count = numBoats;
        while (numBoats > 2) {
            count--;
            numBoats -= 3;
        }
        return count;
    }

    public static int minTickets(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map.toString());
        int count = 0;
        for (int freq : map.values()) {

            int threeboats = freq / 3;

            // System.out.println("freq==" + freq + " " + "threeboats==" + threeboats);
            count += threeboats;
            if (freq % 3 == 1 && threeboats == 0) {
                return -1;
            }
            if (freq % 3 != 0)
                count++;

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] numbersAsStrings = input.split(",");
        int[] arr = new int[numbersAsStrings.length];
        for (int i = 0; i < numbersAsStrings.length; i++) {
            arr[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        System.out.println(minTickets(arr));
    }

}