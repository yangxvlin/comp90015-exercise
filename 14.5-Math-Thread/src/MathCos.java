/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-26 17:21
 * description:
 **/

public class MathCos implements Runnable {
    private double degree;

    private double res;

    private Thread t;

    public MathCos(int degree) {
        this.degree = degree;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        double radian = Math.toRadians(degree);
        res = Math.cos(radian);

        System.out.println(String.format("cos(%.0f) = %f", degree, res));
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public double getRes() {
        return res;
    }
}
