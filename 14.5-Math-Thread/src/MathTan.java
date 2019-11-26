/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-26 17:22
 * description:
 **/

public class MathTan extends Thread {
    private double degree;

    private double res;

    public MathTan(int degree) {
        this.degree = degree;
    }

    @Override
    public void run() {
        super.run();

        double radian = Math.toRadians(degree);
        res = Math.tan(radian);

        System.out.println(String.format("tan(%.0f) = %f", degree, res));
    }

    public double getRes() {
        return res;
    }
}
