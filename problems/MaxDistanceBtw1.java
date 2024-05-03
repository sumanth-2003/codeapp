
//tags: bitmanipulation
import java.util.*;

public class MaxDistanceBtw1 {
    public static void main(String[] args) {
        int input = 0, max = 0, count = 0, lastBit = input & 1;
        while (input != 0 && lastBit != 1) {
            input >>= 1;
            lastBit = input & 1;
        }
        count = 1;
        while (input != 0) {
            lastBit = input & 1;
            if (lastBit == 1) {
                max = Math.max(max, count);
                count = 1;
            } else {
                count++;
            }
            input >>= 1;
        }
        System.out.println(max);
    }
}