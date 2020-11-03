package problem6;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> products;
    private ArrayList<Integer> amounts;

    public Store() {
        products = new ArrayList<>();
        amounts = new ArrayList<>();
    }

    public void addProduct(String name, int price, int amount) {
        products.add(new Product(name, price));
        amounts.add(amount);
    }

    public boolean removeProduct(String name, int amount) {
        Product tempProduct = new Product(name);

        if (products.contains(tempProduct)) {
            int index = products.indexOf(tempProduct);
            if (amounts.get(index) > amount) {
                amounts.set(index, amounts.get(index) - amount);
                return true;
            } else if (amounts.get(index) == amount) {
                amounts.remove(index);
                products.remove(index);
                return true;
            }
        }

        return false;
    }

    public long calcValue() {
        long result = 0;
        for (int i = 0; i < products.size(); i++) {
            result += products.get(i).getPrice() * amounts.get(i);
        }

        return result;
    }

    public void printAllStorageProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Product Name: " + products.get(i).getName() + " | Quantity: " + amounts.get(i));
        }
    }

    public Product getProduct(String name) {
        Product temp = new Product(name);
        if (products.contains(temp))
            return products.get(products.indexOf(temp));
        return null;
    }
}

