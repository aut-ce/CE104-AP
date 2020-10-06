package problem6;

import java.util.ArrayList;

public class FinancialSystem {
    private ArrayList<ProductionLine> productionLines;
    private Store store;

    public FinancialSystem() {
        productionLines = new ArrayList<>();
        store = new Store();
    }

    public void printAllProductionLines() {
        for (ProductionLine productionLine : productionLines) {
            productionLine.print();
        }
    }

    public void addProductionLine(String productionLine, Product product) {
        productionLines.add(new ProductionLine(productionLine, product));
    }

    public boolean removeProductionLine(String productionLine) {
        ProductionLine temp = new ProductionLine(productionLine);
        if (productionLines.contains(temp)) {
            productionLines.remove(temp);
            return true;
        }

        return false;
    }

    public ArrayList<ProductionLine> getProductionLines() {
        return productionLines;
    }

    public void setProductionLines(ArrayList<ProductionLine> productionLines) {
        this.productionLines = productionLines;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
