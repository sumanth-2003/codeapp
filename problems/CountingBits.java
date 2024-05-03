
//tags: bitmanipulation
import java.util.*;

public class CountingBits {
    public static int[] allOnes(int input) {
        int[] result = new int[input + 1];
        for (int i = 1; i <= input; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int arr[] = allOnes(input);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
