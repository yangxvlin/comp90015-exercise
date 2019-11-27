/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 13:51
 * description:
 **/

public class FarmerTransaction extends Thread {
    private Fruit fruit;

    private FruitMarket fruitMarket;

    public static final int SELL = 1;

    public FarmerTransaction(Fruit fruit, FruitMarket fruitMarket) {
        this.fruit = fruit;
        this.fruitMarket = fruitMarket;
    }

    @Override
    public void run() {
        super.run();
        fruitMarket.transactFruit(fruit, SELL);
    }
}
