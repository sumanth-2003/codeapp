//tags: bitmanipulation
//given three -a and b,c makes flips in a and b so that a|b==c min flips is the answer

// apprach 1 see the last bit in c if it is zero means both the a and b last bit should be zero so check the last bit and increament
// if the last bit of c is 1 then altest one of the last bit a or b should be one else incerament the flip 

//appraoch 2 fist caculate a|b and see the difference in bits using xor operater but when c bit is 1 and a|b is zero u know both a and b bits are zero so increment by 1
// but when c bit is zero and a|b is 1 you cant decide that 1 is because of one 1 or two 1 for that we need a&b 
import java.util.*;

public class FlipstoMakeC {
    public static int method2(int a, int b, int c) {
        int result = (a | b) ^ c;
        int result1 = a & b;
        int result2 = result1 ^ result;
        int flip = 0;
        while (result != 0) {
            flip += result & 1;
            result >>= 1;
        }
        while (result2 != 0) {
            flip += result2 & 1;
            result2 >>= 1;
        }
        return flip;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 5;
        System.out.println(method2(a, b, c));
    }
}
