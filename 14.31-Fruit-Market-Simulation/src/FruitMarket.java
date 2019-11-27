import java.util.HashMap;
import java.util.Map;

/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 13:43
 * description:
 **/

public class FruitMarket {

    public static final int NO_FRUIT = 0;

    private Map<String, Fruit> fruits;

    private Map<String, Integer> capacity;

    public FruitMarket(int[] capacities) {
        fruits = new HashMap<>();
        capacity = new HashMap<>();

        fruits.put(Apple.class.getSimpleName(),      new Apple(NO_FRUIT));
        fruits.put(Orange.class.getSimpleName(),     new Orange(NO_FRUIT));
        fruits.put(Grape.class.getSimpleName(),      new Grape(NO_FRUIT));
        fruits.put(Watermelon.class.getSimpleName(), new Watermelon(NO_FRUIT));

        for (int c: capacities) {
            if (c <= 0) {
                System.out.println("Invalid Capacity: " + c);
                System.exit(1);
            }
        }

        capacity.put(Apple.class.getSimpleName(), capacities[0]);
        capacity.put(Orange.class.getSimpleName(), capacities[1]);
        capacity.put(Grape.class.getSimpleName(), capacities[2]);
        capacity.put(Watermelon.class.getSimpleName(), capacities[3]);
    }

    public synchronized boolean isEnoughCapacity(Fruit fruit, int isSell) {
        String fruitName = fruit.getClass().getSimpleName();

        int fruitQuantity = fruits.get(fruitName).getQuantity();
        int fruitCapacity = capacity.get(fruitName);

        int fruitResult = fruitQuantity + isSell * fruit.getQuantity();

        return (fruitResult >= NO_FRUIT) && (fruitResult <= fruitCapacity);
    }

    public synchronized void transactFruit(Fruit fruit, int isSell) {
        try {
            while (!isEnoughCapacity(fruit, isSell)) {
                wait();
            }
        } catch (InterruptedException e) {
            //
        }

        String fruitName = fruit.getClass().getSimpleName();

        // farmer sell to market
        if (isSell > 0) {
            System.out.println(String.format("Farmer sell %s (%d)",
                    fruitName,
                    fruit.getQuantity()));
        // customer buy at market
        } else {
            System.out.println(String.format("Customer buy %s (%d)",
                    fruitName,
                    fruit.getQuantity()));
        }

        System.out.println("Before: " + this);
        Fruit marketFruit = this.fruits.get(fruitName);
        marketFruit.setQuantity(marketFruit.getQuantity() + isSell * fruit.getQuantity());
        System.out.println("After : " + this);

        notifyAll();
    }

    @Override
    public String toString() {
        return "Fruit Market::" + capacity + "::" + fruits;
    }
}
