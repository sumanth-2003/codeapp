//tags: bitmanipulation

// Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

// I	f(I)
// -------
// 0	""
// 1	"0"
// 2	"1"
// 3	"00"
// 4	"01"
// 5	"10"
// 6	"11"
// 7	"000"

// You are given an integer value I, where I is positive number.
// Your task is to find BBC representation of  the given number I.

// Input Format:
// -------------
// An integer I

// Output Format:
// --------------
// Print the BBC representation of I.

// Sample Input-1:
// ---------------
// 23

// Sample Output-1:
// ----------------
// 1000

// Sample Input-2:
// ---------------
// 45

// Sample Output-2:
// ----------------
// 01110
import java.util.*;

public class EncodeNumber {
    public static String findBBCRepresentation(int num) {
        if (num == 0)
            return "";

        StringBuilder bbc = new StringBuilder();

        while (num > 0) {
            if ((num - 1) % 2 == 1) {
                bbc.insert(0, '1');
            } else {
                bbc.insert(0, '0');
            }
            num = (num - 1) / 2;
        }

        return bbc.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        String bbcRepresentation = findBBCRepresentation(num);
        System.out.println(bbcRepresentation);
    }
}
