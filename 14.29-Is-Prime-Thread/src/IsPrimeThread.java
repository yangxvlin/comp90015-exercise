import java.util.ArrayList;

/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 0:55
 * description:
 **/

public class IsPrimeThread extends Thread {
    private int number;

    public IsPrimeThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        super.run();

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
}

class RemainderThread extends Thread {
    private int number1;

    private int number2;

    private boolean isDividable;

    public RemainderThread(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public void run() {
        super.run();

        isDividable = (number1 % number2 == 0);

        interrupt();
    }

    public boolean isDividable() {
        return isDividable;
    }

    public int getNumber2() {
        return number2;
    }
}