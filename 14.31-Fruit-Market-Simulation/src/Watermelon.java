/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 13:46
 * description:
 **/

public class Watermelon extends Fruit {
    public Watermelon(int quantity) {
        super(quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + getQuantity() + ")";
    }
}
