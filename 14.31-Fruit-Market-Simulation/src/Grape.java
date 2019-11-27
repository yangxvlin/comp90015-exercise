/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 13:46
 * description:
 **/

public class Grape extends Fruit {
    public Grape(int quantity) {
        super(quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + getQuantity() + ")";
    }
}
