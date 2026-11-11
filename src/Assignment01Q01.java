public class Assignment01Q01 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) % 5 == 0) { // Check if the first character of the argument is divisible by 5, if so print it
                System.out.println(args[i].charAt(0));
            }
        }
    }
}
