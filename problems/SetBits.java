
//tags: bitmanipulation A1
import java.util.*;

public class SetBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int input = sc.nextInt();
        while (input > 0) {
            count += input & 1;
            input >>= 1;
        }
        System.out.println(count);

    }
}