import java.util.Arrays;

public class Main {

    public static final int[] DEFAULT_CAPACITY = new int[]{5,5,5,5};

    public static void main(String[] args) {
        int[] capacity;

        if (args.length < 4) {
            capacity = DEFAULT_CAPACITY;
            System.out.println("Using default capacity: " + Arrays.toString(capacity));
        } else {
            capacity = new int[4];
            for (int i = 0; i < capacity.length; i++) {
                capacity[i] = Integer.parseInt(args[i]);
            }
            System.out.println("Using capacity: " + Arrays.toString(capacity));
        }

        FruitMarket fruitMarket = new FruitMarket(capacity);
        CustomerTransaction c1 = new CustomerTransaction(new Apple(1), fruitMarket);
        CustomerTransaction c2 = new CustomerTransaction(new Grape(3), fruitMarket);
        CustomerTransaction c3 = new CustomerTransaction(new Orange(3), fruitMarket);
        FarmerTransaction f1 = new FarmerTransaction(new Apple(2), fruitMarket);
        FarmerTransaction f2 = new FarmerTransaction(new Orange(1), fruitMarket);

        c1.start();
        c2.start();
        c3.start();
        f1.start();
        f2.start();

        // System.out.println("Finally, " + fruitMarket);
    }
}
