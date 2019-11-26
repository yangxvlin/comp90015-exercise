/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-26 17:05
 * description:
 **/

public class MathSin extends Thread {
    private double degree;

    private double res;

    public MathSin(int degree) {
        this.degree = degree;
    }

    @Override
    public void run() {
        super.run();

        double radian = Math.toRadians(degree);
        res = Math.sin(radian);

        System.out.println(String.format("sin(%.0f) = %f", degree, res));
    }

    public double getRes() {
        return res;
    }
}
