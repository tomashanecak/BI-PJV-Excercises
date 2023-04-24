package alsa.common.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Product implements Comparable<Product>, Serializable {
    final protected int id;
    final protected String name;
    final protected double price;
    final protected int count;

    public Product(int id, String name, double price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract Product withDecreasedCount();
    public abstract  Product withIncreasedCount();
    public abstract boolean hasSpecialGuarantee();

    @Override
    public int compareTo(Product o) {
        return Integer.compare(id, o.id);
    }
}
