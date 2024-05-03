//tags: bitmanipulation

import java.util.Scanner;

public class sumUsingbitmaipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        // int carry=0;
        while (second != 0) {
            int extras = first & second;
            int singles = first ^ second;
            first = singles;
            second = extras << 1;
        }
        System.out.println(first);

    }
}
