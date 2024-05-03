//tags: oca
// take a var arg function which given opeater performs the operation on all other arguments

// - means subration 
public class Program {
    public static int vararg(String... args) {

        int result = Integer.parseInt(args[1]);
        switch (args[0]) {
            case "+":
                for (int i = 2; i < args.length; i++)
                    result += Integer.parseInt(args[i]);
                break;
            case "-":
                for (int i = 2; i < args.length; i++)
                    result -= Integer.parseInt(args[i]);
                break;
            case "*":
                for (int i = 2; i < args.length; i++)
                    result *= Integer.parseInt(args[i]);
                break;
            case "/":
                for (int i = 2; i < args.length; i++)
                    result /= Integer.parseInt(args[i]);
                break;

            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(vararg("*", "10"));
    }
}
