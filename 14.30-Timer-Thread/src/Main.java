public class Main {
    public static final int DEFAULT_TIMRER_PERIOD = 5000;

    public static void main(String[] args) {
        int ms;

        if (args.length < 1) {
            ms = DEFAULT_TIMRER_PERIOD;
            System.out.println(String.format("Timer period = %d (ms)", ms));
        } else {
            ms = Integer.parseInt(args[0]);
            System.out.println(String.format("Timer period = %d (ms)", ms));
        }

        TimerThread timerThread = new TimerThread(ms);
        timerThread.start();
    }
}
