public class Main {

//    public static final int DEFAULT_NUMBER = 13;
//    public static final int DEFAULT_NUMBER = 39;
//    public static final int DEFAULT_NUMBER = 5;
    public static final int DEFAULT_NUMBER = 101;

    public static void main(String[] args) {
        int number;
        if (args.length < 1) {
            number = DEFAULT_NUMBER;
            System.out.println("Using default number " + number);
        } else {
            number = Integer.parseInt(args[0]);
            System.out.println("Using number " + number);
        }

        IsPrimeThread isPrimeThread = new IsPrimeThread(number);
        IsPrimeRunnable isPrimeRunnable = new IsPrimeRunnable(number);

        isPrimeThread.start();
        isPrimeRunnable.start();

//        boolean isPrime = true;
//        for (int i = 2; i < number; i++) {
//            if (number % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }
//        if (isPrime) {
//            System.out.println(number + " is prime.");
//        } else {
//            System.out.println(number + " is not prime.");
//        }
    }
}
