package alsa.entity;

import alsa.entity.part.ComputerPart;

import java.util.Arrays;

public class Notebook extends Product{
    private final NotebookCategory category;
    private final ComputerPart[] computerParts;

    public Notebook(int id, String name, double price, int count, NotebookCategory category, ComputerPart[] computerParts) {
        super(id, name, price, count);
        this.category = category;
        this.computerParts = computerParts;
    }

    public NotebookCategory getCategory() {
        return category;
    }

    public ComputerPart[] getComputerParts() {
        return computerParts;
    }

    @Override
    public Product withDecreasedCount() {
        return new Notebook(id, name, price, count-1, category, computerParts);
    }

    @Override
    public Product withIncreasedCount() {
        return new Notebook(id, name, price, count+1, category, computerParts);
    }

    @Override
    public boolean hasSpecialGuarantee() {
        return true;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "category=" + category +
                ", computerParts=" + Arrays.toString(computerParts) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
