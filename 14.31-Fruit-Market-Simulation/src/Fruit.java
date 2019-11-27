/**
 * Xulin Yang, 904904
 *
 * @create 2019-11-27 13:45
 * description:
 **/

public abstract class Fruit {
    private int quantity;

    public Fruit(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
