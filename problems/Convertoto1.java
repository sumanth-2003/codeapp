//tags: twopinter array A1 slidingwindow

import java.util.*;

public class Convertoto1 {
    public static int maxLength(int[] arr, int size) {
        int zero_count = 0, index = -1, start = 0, MaxSubArryLength = Integer.MAX_VALUE, reqIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                if (zero_count != 0) {
                    if (i - start > MaxSubArryLength) {
                        MaxSubArryLength = i - start;
                        reqIndex = index;
                        start = index + 1;
                        zero_count = 0;
                    }
                }
                index = i;
                zero_count++;
            }
        }
        if (size - start > MaxSubArryLength)
            reqIndex = index;
        if (reqIndex == -1)
            return index;
        return reqIndex;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        System.out.print(maxLength(arr, size));
        sc.close();
    }
}
