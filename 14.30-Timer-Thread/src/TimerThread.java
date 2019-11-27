/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 13:31
 * description:
 **/

public class TimerThread extends Thread {
    private int ms;

    public TimerThread(int ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        super.run();

        try {
            while (true) {
                sleep(ms);
                System.out.println(String.format("%d(ms) passed! timeout!", ms));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
