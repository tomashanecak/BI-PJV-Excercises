package alsa.entity;

public abstract class Product {
    final protected String name;
    final protected double price;
    final protected int count;

    public Product(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public abstract Product withDecreasedCount();
    public abstract  Product withIncreasedCount();
    public abstract boolean hasSpecialGuarantee();
}
