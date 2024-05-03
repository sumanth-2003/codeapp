
//tags: bitmanipulation
import java.util.*;

public class Minsteps {
    public static int rec(int input) {
        if (input == 1)
            return 0;
        if (input % 2 == 0)
            return 1 + rec(input / 2);
        return 1 + Math.min(rec(input + 1), rec(input - 1));

    }

    public static int zerocheck(int input) {
        int count = 0;
        while (input != 1) {
            if (input % 2 == 0)
                input /= 2;
            else if ((input + 1) / 4 == 0)
                input++;
            else
                input--;

            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        // System.out.print(rec(input));
        System.out.println(zerocheck(input));

    }
}


