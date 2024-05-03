//tags: bitmanipulation swap
public class SwapXor {
    public static void main(String[] args) {
        int x = 10, y = 20;
        x = x ^ y; // x=x^y
        y = x ^ y; // y=(x^y)^y --> x
        x = x ^ y; // x=(x^y)^x -->y
        System.out.println(x + "  " + y);

    }
}
