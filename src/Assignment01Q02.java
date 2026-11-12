public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int n = Integer.parseInt(args[0]); // get the number of iterations from the command line argument
        for (int i = 0; i < n; i++) { // use the formula: pi = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ...)
            if (i % 2 == 0) {
                approxPi += (double) 1 / (1 + 2 * i);
            }
            else {
                approxPi -= (double) 1 / (1 + 2 * i);
            }
        }  
        approxPi *= 4;
        System.out.println(approxPi + " " + actualPi);
    }
}
