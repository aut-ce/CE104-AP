package problem6;

import java.util.Scanner;

public class Main {
    private static Scanner input;
    private static FinancialSystem financialSystem;

    //this is a minimal version of what you implement can using prepared methods and classes
    public static void main(String[] args) {
        input = new Scanner(System.in);
        financialSystem = new FinancialSystem();

        while (true) {
            printOptions();
            int operation = input.nextInt();

            switch (operation) {
                case 1:
                    newProduct();
                    break;
                case 2:
                    newProductionLine();
                    break;
                case 3:
                    financialSystem.getStore().printAllStorageProducts();
                    break;
                case 4:
                    System.out.println(financialSystem.getStore().calcValue());
                    break;
                case 5:
                    financialSystem.printAllProductionLines();
                    break;
                default:
                    return;
            }
        }
    }

    private static void printOptions() {
        System.out.println("1)New Product\n2)New ProductionLine\n3)Show Storage\n4)Calculate Value\n" +
                "5)Show ProductLines");
    }

    private static void newProduct() {
        System.out.println("Please enter product name: ");
        String name = input.next();
        System.out.println("Please enter product price: ");
        int price = input.nextInt();
        System.out.println("Please enter product amount: ");
        int amount = input.nextInt();

        financialSystem.getStore().addProduct(name, price, amount);
    }

    private static void newProductionLine() {
        System.out.println("Please enter production lines name: ");
        String name = input.next();
        input.nextLine();
        System.out.println("Please enter product name: ");
        String productName = input.next();


        Product product = financialSystem.getStore().getProduct(productName);
        if (product != null)
            financialSystem.addProductionLine(name, product);
        else
            System.out.println("Invalid product");
    }
}