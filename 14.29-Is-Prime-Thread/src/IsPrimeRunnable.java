import java.util.ArrayList;

/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 1:46
 * description:
 **/

public class IsPrimeRunnable implements Runnable {
    private int number;

    public IsPrimeRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        ArrayList<RemainderThread> threads = new ArrayList<>();
        for (int i = 2; i <= this.number-1; i++) {
            RemainderThread t = new RemainderThread(number, i);
            t.start();
            threads.add(t);
        }

        boolean isPrime = true;
        for (RemainderThread thread: threads) {
            // thread.join();

            if (thread.isDividable()) {
                System.out.println(String.format("%d is divisible by %d",
                        this.number, thread.getNumber2()));

                isPrime = false;

                break;
            }
        }

        System.out.print(this.getClass().getSimpleName() + " ");
        if (isPrime) {
            System.out.println(this.number + " is prime.");
        } else {
            System.out.println(this.number + " is not prime.");
        }
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
