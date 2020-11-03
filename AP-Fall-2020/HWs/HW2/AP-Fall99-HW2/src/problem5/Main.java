package problem5;

public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[2];
        items[0] = new Item("Chocolate", "Kinder", 5000);
        items[1] = new Item("Chips", "Lays", 7000);

        items[0].increment((short) 5);
        items[1].increment((short) 3);
        items[0].setDiscount((short) 30);

        for (Item item : items) {
            item.print();
        }
    }
}
