public class Main {

    public static final int DEFAULT_X = 45;
    public static final int DEFAULT_Y = 45;
    public static final int DEFAULT_Z = 45;

    public static void main(String[] args) {
        int x, y, z;
        if (args.length < 3) {
            x = DEFAULT_X;
            y = DEFAULT_Y;
            z = DEFAULT_Z;
            System.out.println(String.format("Using default x = %d, y = %d, z = %d", DEFAULT_X, DEFAULT_Y, DEFAULT_Z));
        } else {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
            z = Integer.parseInt(args[2]);
            System.out.println(String.format("Using x = %d, y = %d, z = %d", x, y, z));
        }

        MathSin sin = new MathSin(x);
        MathCos cos = new MathCos(y);
        MathTan tan = new MathTan(z);

        System.out.println("calculating...");
        sin.run();
        cos.start();
        tan.run();

        try {
            // join makes main thread wait until other threads finish their jobs
            sin.join();
            // cos.join();
            tan.join();
            System.out.println(String.format("p = sin(%d) + cos(%d) + tab(%d) = %f",
                    x, y, z, sin.getRes() + cos.getRes() + tan.getRes()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
