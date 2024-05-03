
//tags: bitmanipulation xor
import java.util.*;

public class Decode {
    public static int[] orginal(int first, int[] arr) {
        int[] result = new int[arr.length + 1];
        result[0] = first;
        for (int i = 1; i <= arr.length; i++) {
            result[i] = result[i - 1] ^ arr[i - 1];

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        int first = sc.nextInt();
        System.out.print(Arrays.toString(orginal(first, arr)));
    }
}
