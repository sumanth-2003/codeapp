
//tags: bitmanipulation xor
import java.util.*;

public class FindOrginal {
    public static int[] orginal(int arr[]) {
        int result[] = new int[arr.length];
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = arr[i - 1] ^ arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        System.out.print(Arrays.toString(orginal(arr)));

    }
}
