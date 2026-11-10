public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");        
        int numOdd = 0;
        int F_last = 1, F_second_last = 1;
        for (int i = 0; i < x; i++) {
            System.out.print(F_second_last);
            if (F_second_last % 2 != 0) {
                numOdd++;
            }
            int temp = F_second_last;
            F_second_last = F_last;
            F_last = temp + F_second_last;
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
