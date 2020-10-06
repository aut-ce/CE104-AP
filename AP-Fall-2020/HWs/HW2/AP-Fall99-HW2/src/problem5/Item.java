package problem5;

public class Item {
    private String name;
    private String producer;
    private int price;
    private short discount = 0;
    private short amount = 0;

    public Item(String name, String producer, int price) {
        this.name = name;
        this.producer = producer;
        this.price = price;
    }

    public void increment(int amount) {
        this.amount += amount;
    }

    public void decrement(int amount) {
        this.amount -= amount;
    }

    public void print() {
        System.out.println("Product: " + name + ", Producer: " + producer + ", price: " + price + ", final price: "
                + applyDiscount() + ", amount:" + amount +
                "\n--------------------------------------------------------------------------------------\n");
    }

    public int applyDiscount() {
        return price * (100 - discount) / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    public short getAmount() {
        return amount;
    }

    public void setAmount(short amount) {
        this.amount = amount;
    }
}
