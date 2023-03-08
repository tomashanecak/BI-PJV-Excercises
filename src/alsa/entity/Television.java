package alsa.entity;

public class Television extends Product{
    public Television(String name, double price, int count) {
        super(name, price, count);
    }

    @Override
    public Product withDecreasedCount() {
        return new Television(name, price, count-1);
    }

    @Override
    public Product withIncreasedCount() {
        return new Television(name, price, count+1);
    }

    @Override
    public boolean hasSpecialGuarantee() {
        return false;
    }
}
