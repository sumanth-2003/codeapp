
//tags: bitmanipulation
import java.util.*;

public class OneNumMissing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int result = 0;
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            result ^= arr[i];
        }
        for (int i = 0; i <= size; i++) {
            result ^= i;
        }
        System.out.print(result);

    }
}
