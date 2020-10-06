package problem6;

public class ProductionLine {
    private String name;
    private Product type;

    public ProductionLine(String name, Product type) {
        this.name = name;
        this.type = type;
    }

    public ProductionLine(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Name: " + name + " | Product: " + type.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductionLine)
            return ((ProductionLine) obj).name.equals(name);
        return false;
    }
}
